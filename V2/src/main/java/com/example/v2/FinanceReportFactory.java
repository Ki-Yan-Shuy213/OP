package com.example.v2;
class FinanceReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new FinanceReport();
    }
}