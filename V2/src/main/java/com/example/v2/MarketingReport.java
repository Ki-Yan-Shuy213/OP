package com.example.v2;
class MarketingReport implements Report {
    @Override
    public void generate() {
        System.out.println("Генерация маркетингового отчета");
    }
}