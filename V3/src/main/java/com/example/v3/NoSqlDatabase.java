package com.example.v3;
class NoSqlDatabase implements DatabaseImpl {
    @Override
    public void connect() {
        System.out.println("Подключение к NoSQL базе данных");
    }

    @Override
    public void disconnect() {
        System.out.println("Отключение от NoSQL базы данных");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Выполнение NoSQL запроса: " + query);
    }
}