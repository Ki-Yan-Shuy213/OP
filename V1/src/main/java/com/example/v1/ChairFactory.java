package com.example.v1;
class ChairFactory implements FurnitureFactory {
    @Override
    public Furniture createFurniture() {
        return new Chair();
    }
}