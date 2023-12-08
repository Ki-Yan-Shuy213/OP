package com.example.v1;

class TableFactory implements FurnitureFactory {
    @Override
    public Furniture createFurniture() {
        return new Table();
    }
}