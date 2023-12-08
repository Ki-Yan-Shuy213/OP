package com.example.v1;

class Chair implements Furniture {
    @Override
    public void create() {
        System.out.println("Стул создан");
    }
}