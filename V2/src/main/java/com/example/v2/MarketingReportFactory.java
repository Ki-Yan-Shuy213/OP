package com.example.v2;
class MarketingReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new MarketingReport();
    }
}