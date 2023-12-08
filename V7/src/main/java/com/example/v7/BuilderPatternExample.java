package com.example.v7;


interface ShapeBuilder {
    void setColor(String color);
    void setCoordinates(int x, int y);
    void setSize(int width, int height);
    Object build();
}


class Circle {
    private String color;
    private int x, y;
    private int radius;

    public Circle(String color, int x, int y, int radius) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}


class Rectangle {
    private String color;
    private int x, y;
    private int width, height;

    public Rectangle(String color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}


class Line {
    private String color;
    private int x1, y1, x2, y2;

    public Line(String color, int x1, int y1, int x2, int y2) {
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String getColor() {
        return color;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}


class CircleBuilder implements ShapeBuilder {
    private String color;
    private int x, y;
    private int radius;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSize(int width, int height) {

        this.radius = Math.min(width, height) / 2;
    }

    @Override
    public Circle build() {
        return new Circle(color, x, y, radius);
    }
}


class RectangleBuilder implements ShapeBuilder {
    private String color;
    private int x, y;
    private int width, height;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Rectangle build() {
        return new Rectangle(color, x, y, width, height);
    }
}


class LineBuilder implements ShapeBuilder {
    private String color;
    private int x1, y1, x2, y2;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.x1 = x;
        this.y1 = y;
    }

    @Override
    public void setSize(int width, int height) {

    }

    @Override
    public Line build() {

        return new Line(color, x1, y1, x2, y2);
    }


    public void setEndCoordinates(int x, int y) {
        this.x2 = x;
        this.y2 = y;
    }
}


public class BuilderPatternExample {
    public static void main(String[] args) {

        CircleBuilder circleBuilder = new CircleBuilder();
        circleBuilder.setColor("Red");
        circleBuilder.setCoordinates(10, 20);
        circleBuilder.setSize(30, 30);
        Circle circle = circleBuilder.build();
        System.out.println("Circle created: " + circle.getColor() + ", X: " + circle.getX() + ", Y: " + circle.getY() + ", Radius: " + circle.getRadius());


        RectangleBuilder rectangleBuilder = new RectangleBuilder();
        rectangleBuilder.setColor("Blue");
        rectangleBuilder.setCoordinates(50, 60);
        rectangleBuilder.setSize(40, 50);
        Rectangle rectangle = rectangleBuilder.build();
        System.out.println("Rectangle created: " + rectangle.getColor() + ", X: " + rectangle.getX() + ", Y: " + rectangle.getY() + ", Width: " + rectangle.getWidth() + ", Height: " + rectangle.getHeight());


        LineBuilder lineBuilder = new LineBuilder();
        lineBuilder.setColor("Green");
        lineBuilder.setCoordinates(5, 5);
        lineBuilder.setEndCoordinates(80, 90);
        Line line = lineBuilder.build();
        System.out.println("Line created: " + line.getColor() + ", X1: " + line.getX1() + ", Y1: " + line.getY1() + ", X2: " + line.getX2() + ", Y2: " + line.getY2());
    }
}
