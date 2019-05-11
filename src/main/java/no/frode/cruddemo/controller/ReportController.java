package no.frode.cruddemo.controller;

import no.frode.cruddemo.service.ReportService;
import no.frode.cruddemo.model.FinancialReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *  RestController for the new report endpoint in exercise 2
 *
 */

@RestController
@RequestMapping(name = "Report", value = "reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    /**
     * Todo Create implementation for Financial report
     * as stated in exercise 2.
     *
     * @return
     */
    @GetMapping(name = "/financial")
    public FinancialReport getFinancialReport(){

        FinancialReport report = reportService.generateReport();

        return report;
    }
}
