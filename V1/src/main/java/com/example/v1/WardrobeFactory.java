package com.example.v1;
class WardrobeFactory implements FurnitureFactory {
    @Override
    public Furniture createFurniture() {
        return new Wardrobe();
    }
}