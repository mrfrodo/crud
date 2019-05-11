package no.frode.cruddemo.controller;

import no.frode.cruddemo.service.ReportService;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.model.FinancialReport;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class ReportControllrerTest {

    @InjectMocks
    private ReportController reportController;

    @Mock
    private ReportService reportService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generateEmptyReport() {

        FinancialReport financialReport = reportController.getFinancialReport();
        assertEquals(null, financialReport);

    }

    @Test
    @Ignore
    public void generateInterestingReport() {

        FinancialReport financialReport = reportController.getFinancialReport();
        Product highestMargin = financialReport.getHighestMarginProduct();

        assertEquals("banankake", highestMargin.getProductName());

    }
}
