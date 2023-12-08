package com.example.v4;
import java.awt.Font;


class NormalFontAdapter implements FontAdapter {
    private Font font;

    NormalFontAdapter(Font font) {
        this.font = font;
    }

    public void increaseSize() {
        font = font.deriveFont(font.getSize() + 2.0f);
    }

    public void decreaseSize() {
        font = font.deriveFont(font.getSize() - 2.0f);
    }

    public void renderFont() {
        System.out.println("Rendering text with normal font: " + font);
    }
}