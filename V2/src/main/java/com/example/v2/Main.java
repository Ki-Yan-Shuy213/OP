package com.example.v2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportGenerator reportGenerator = new ReportGenerator();

        while (true) {
            System.out.println("Выберите тип отчета:");
            System.out.println("1. Финансовый отчет");
            System.out.println("2. Маркетинговый отчет");
            System.out.println("3. Отчет о производстве");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reportGenerator.setReportFactory(new FinanceReportFactory());
                    reportGenerator.generateReport();
                    break;
                case 2:
                    reportGenerator.setReportFactory(new MarketingReportFactory());
                    reportGenerator.generateReport();
                    break;
                case 3:
                    reportGenerator.setReportFactory(new ProductionReportFactory());
                    reportGenerator.generateReport();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }
}