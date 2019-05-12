package no.frode.cruddemo.service;

import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.model.FinancialReport;
import no.frode.cruddemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReportService {

    @Autowired
    ProductRepository productRepository;

    public FinancialReport generateReport() {

        FinancialReport report = new FinancialReport();

        List<Product> allProducts = productRepository.findAll();

        Double totalRevenue = calcTotalRevenue(allProducts);
        Double totalCost = calcTotalCost(allProducts);

        report.setTotalTurnover(totalRevenue);
        report.setTotalCost(totalCost);
        report.setTotalMargin(totalRevenue - totalCost);
        report.setMostSoldProduct(mostSoldProduct(allProducts));
        report.setLeastSoldProduct(leastSoldProduct(allProducts));
        report.setHighestMarginProduct(highestMarginProduct(allProducts));
        report.setLowestMarginProduct(lowestMarginProduct2(allProducts));

        return report;
    }

    private Double calcTotalRevenue(List<Product> allProducts) {
        Double revenue = new Double(0);

        //Total revenue – sum of units sold multiplied by unit price.
        for (Product p : allProducts) {
            BigInteger numbersSold = p.getNumberSold();
            Double unitPrice = p.getUnitPrice();

            double d = numbersSold.doubleValue() * unitPrice;

            revenue += d;
        }

        return revenue;

    }

    private Double calcTotalCost(List<Product> allProducts) {
        Double totalCost = new Double(0);

        //Total cost – sum of units sold multiplied by unit cost.
        for (Product p : allProducts) {
            BigInteger numbersSold = p.getNumberSold();
            Double unitCost = p.getUnitCost();

            double d = numbersSold.doubleValue() * unitCost;

            totalCost += d;
        }

        return totalCost;
    }

    private Product mostSoldProduct(List<Product> allProducts) {

        Product mostSoldProduct = allProducts.stream().max(Comparator.comparing(Product::getNumberSold)).get();

        return mostSoldProduct;
    }

    private Product leastSoldProduct(List<Product> allProducts) {

        Product leastSoldProduct = allProducts.stream().min(Comparator.comparing(Product::getNumberSold)).get();

        return leastSoldProduct;
    }

    private Product highestMarginProduct(List<Product> allProducts) {

        Product highestMarginProduct = new Product();
        Double highestMargin = new Double(-1);

        for (Product p : allProducts) {
            BigInteger numbersSold = p.getNumberSold();
            Double unitPrice = p.getUnitPrice();
            Double rev = numbersSold.doubleValue() * unitPrice;
            Double unitCost = numbersSold.doubleValue() * p.getUnitCost();

            Double margin = rev - unitCost ;
            if (margin > highestMargin) {
                highestMarginProduct = p;
                highestMargin = margin;
            }
        }

        //Aternativt bruk av streams som i lowestMarginProduct
        Product highestMarginProduct2 = allProducts.stream().max(Comparator.comparing(Product::getMargin)).get();

        return highestMarginProduct;
    }

    protected Product lowestMarginProduct(List<Product> allProducts) {

        Product lowestMarginProduct = allProducts.stream().min(Comparator.comparing(Product::getMargin)).get();

        return lowestMarginProduct;
    }

    private Product lowestMarginProduct2(List<Product> allProducts) {
        Product lowestMarginProduct = new Product();
        Double highestMargin = highestMarginProduct(allProducts).getMargin();
        Double lowestMargin = highestMargin;

        // gå gjennom alle produktene for å finne lowest margin
        for (Product p : allProducts) {
            BigInteger numbersSold = p.getNumberSold();
            Double unitPrice = p.getUnitPrice();
            Double rev = numbersSold.doubleValue() * unitPrice;
            Double unitCost = numbersSold.doubleValue() * p.getUnitCost();

            Double margin = rev - unitCost;
            if (margin < lowestMargin) {
                lowestMarginProduct = p;
                lowestMargin = margin;
            }
        }

        return lowestMarginProduct;

    }
}


























