package com.example.v1;
import java.util.Scanner;
public class FurnitureManager {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите тип мебели для создания:");
            System.out.println("1. Стул");
            System.out.println("2. Стол");
            System.out.println("3. Шкаф");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    furnitureFactory = new ChairFactory();
                    break;
                case 2:
                    furnitureFactory = new TableFactory();
                    break;
                case 3:
                    furnitureFactory = new WardrobeFactory();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    continue;
            }

            Furniture furniture = furnitureFactory.createFurniture();
            furniture.create();
        }
    }
}