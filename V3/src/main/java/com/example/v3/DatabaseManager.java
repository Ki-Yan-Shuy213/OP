package com.example.v3;
import java.util.Scanner;
public class DatabaseManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип базы данных:");
        System.out.println("1. SQL");
        System.out.println("2. NoSQL");
        int choice = scanner.nextInt();

        Database database = null;
        switch (choice) {
            case 1:
                database = new MyDatabase(new SqlDatabase());
                break;
            case 2:
                database = new MyDatabase(new NoSqlDatabase());
                break;
            default:
                System.out.println("Неверный выбор. Программа завершена.");
                System.exit(0);
        }

        database.connect();
        System.out.println("Введите запрос:");
        scanner.nextLine(); // Consume the newline
        String query = scanner.nextLine();
        database.executeQuery(query);
        database.disconnect();
    }
}