package com.example.v2;
class ProductionReport implements Report {
    @Override
    public void generate() {
        System.out.println("Генерация отчета о производстве");
    }
}