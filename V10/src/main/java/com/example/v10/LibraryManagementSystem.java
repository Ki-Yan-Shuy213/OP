package com.example.v10;


class BookSubsystem {
    public boolean checkAvailability(String bookTitle) {

        return Math.random() < 0.5;
    }
}


class OrderSubsystem {
    public void placeOrder(String bookTitle) {

        System.out.println("Заказ на книгу '" + bookTitle + "' оформлен.");
    }
}


class SearchSubsystem {
    public String searchBook(String keyword) {

        return "Найдена книга по ключевому слову '" + keyword + "'";
    }
}


class LibraryFacade {
    private BookSubsystem bookSubsystem;
    private OrderSubsystem orderSubsystem;
    private SearchSubsystem searchSubsystem;

    public LibraryFacade() {
        this.bookSubsystem = new BookSubsystem();
        this.orderSubsystem = new OrderSubsystem();
        this.searchSubsystem = new SearchSubsystem();
    }

    public void processLibraryRequest(String bookTitle, String keyword) {
        if (bookSubsystem.checkAvailability(bookTitle)) {
            System.out.println("Книга '" + bookTitle + "' доступна.");
        } else {
            System.out.println("Книга '" + bookTitle + "' отсутствует в наличии.");
            orderSubsystem.placeOrder(bookTitle);
        }

        String searchResult = searchSubsystem.searchBook(keyword);
        System.out.println(searchResult);
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryFacade libraryFacade = new LibraryFacade();

        String bookTitle = "Java: The Complete Reference";
        String searchKeyword = "Java Programming";


        libraryFacade.processLibraryRequest(bookTitle, searchKeyword);
    }
}
