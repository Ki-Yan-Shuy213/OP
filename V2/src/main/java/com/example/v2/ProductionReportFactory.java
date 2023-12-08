package com.example.v2;
class ProductionReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new ProductionReport();
    }
}