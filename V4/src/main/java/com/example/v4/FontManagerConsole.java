package com.example.v4;
import java.awt.Font;
import java.util.Scanner;
public class FontManagerConsole {
    public static void main(String[] args) {
        Font baseFont = new Font("Arial", Font.PLAIN, 12);
        FontAdapter fontAdapter = new NormalFontAdapter(baseFont);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите шрифт:");
            System.out.println("1. Обычный");
            System.out.println("2. Жирный");
            System.out.println("3. Увеличить размер шрифта");
            System.out.println("4. Уменьшить размер шрифта");
            System.out.println("5. Рендеринг текста");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    fontAdapter = new NormalFontAdapter(baseFont);
                    break;
                case 2:
                    fontAdapter = new BoldFontAdapter(baseFont);
                    break;
                case 3:
                    fontAdapter.increaseSize();
                    break;
                case 4:
                    fontAdapter.decreaseSize();
                    break;
                case 5:
                    fontAdapter.renderFont();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}