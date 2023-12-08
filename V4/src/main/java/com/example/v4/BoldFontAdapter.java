package com.example.v4;
import java.awt.Font;
class BoldFontAdapter implements FontAdapter {
    private Font font;

    BoldFontAdapter(Font font) {
        this.font = font.deriveFont(Font.BOLD);
    }

    public void increaseSize() {
        font = font.deriveFont(font.getSize() + 2.0f);
    }

    public void decreaseSize() {
        font = font.deriveFont(font.getSize() - 2.0f);
    }

    public void renderFont() {
        System.out.println("Rendering text with bold font: " + font);
    }
}
