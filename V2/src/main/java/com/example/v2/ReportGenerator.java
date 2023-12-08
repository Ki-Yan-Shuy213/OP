package com.example.v2;
class ReportGenerator {
    private ReportFactory reportFactory;

    public void setReportFactory(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    public void generateReport() {
        Report report = reportFactory.createReport();
        report.generate();
    }
}