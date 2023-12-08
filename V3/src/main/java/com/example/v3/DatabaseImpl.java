package com.example.v3;
interface DatabaseImpl {
    void connect();
    void disconnect();
    void executeQuery(String query);
}