package com.example.v3;
abstract class Database {
    protected DatabaseImpl impl;

    public Database(DatabaseImpl impl) {
        this.impl = impl;
    }

    public void connect() {
        impl.connect();
    }

    public void disconnect() {
        impl.disconnect();
    }

    public abstract void executeQuery(String query);
}