package com.kodilla.spring.intro.shape;

import com.kodilla.spring.intro.Circle;
import com.kodilla.spring.intro.Drawer;
import com.kodilla.spring.intro.Shape;
import com.kodilla.spring.intro.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle() {
        //Given
        Shape circle = new Circle();

        //When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a circle", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Shape triangle = new Triangle();

        //When
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a triangle", result);
    }
}
