package com.example.v2;

class FinanceReport implements Report {
    @Override
    public void generate() {
        System.out.println("Генерация финансового отчета");
    }
}
