package com.example.v3;
class SqlDatabase implements DatabaseImpl {
    @Override
    public void connect() {
        System.out.println("Подключение к SQL базе данных");
    }

    @Override
    public void disconnect() {
        System.out.println("Отключение от SQL базы данных");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Выполнение SQL запроса: " + query);
    }
}