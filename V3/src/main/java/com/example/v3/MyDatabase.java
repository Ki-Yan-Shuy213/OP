package com.example.v3;
class MyDatabase extends Database {
    public MyDatabase(DatabaseImpl impl) {
        super(impl);
    }

    @Override
    public void executeQuery(String query) {
        impl.executeQuery(query);
    }
}