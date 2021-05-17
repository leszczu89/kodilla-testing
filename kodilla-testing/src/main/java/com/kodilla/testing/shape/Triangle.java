package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private String shapeName = "triangle";
    private int field;

    public Triangle(int field) {
        this.field = field;
    }

    public String getShapeName() {
        return shapeName;
    }

    @Override
    public int getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (field != triangle.field) return false;
        return shapeName.equals(triangle.shapeName);
    }

    @Override
    public int hashCode() {
        int result = shapeName.hashCode();
        result = 31 * result + field;
        return result;
    }
}
