package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("ShapeCollector tests")
public class ShapeCollectorTestSuite {
    @BeforeAll
    public static void before(){
        System.out.println("Test cases are prepared");
    }
    @AfterAll
    public static void after(){
        System.out.println("All tests were done");
    }
    @Nested
    @DisplayName("Tests of adding and removing shapes")
    class AddAndRemoveShapes{
        @Test
        public void testAddFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle1 = new Circle(12);
            //When
            shapeCollector.addFigure(circle1);
            //Then
            Assertions.assertTrue(shapeCollector.shapes.contains(circle1));
            Assertions.assertEquals(1, shapeCollector.shapes.size());
            Assertions.assertEquals(circle1, shapeCollector.shapes.get(0));
        }
        @Test
        public void testRemoveFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle1 = new Circle(12);
            shapeCollector.addFigure(circle1);
            //When
            shapeCollector.removeFigure(circle1);
            //Then
            Assertions.assertTrue(shapeCollector.shapes.isEmpty());
        }
    }
    @Nested
    @DisplayName("Tests of shapes getters")
    class ShapeGetters{
        @Test
        public void testGetFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle1 = new Triangle(12);
            shapeCollector.addFigure(triangle1);
            //When
            Shape result = shapeCollector.shapes.get(0);
            //Then
            Assertions.assertEquals(triangle1, result);
        }
        @Test
        public void testShowFigures(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle1 = new Triangle(12);
            Shape square1 = new Square(22);
            Shape circle1 = new Circle(6);
            shapeCollector.addFigure(triangle1);
            shapeCollector.addFigure(square1);
            shapeCollector.addFigure(circle1);
            //When
            String testResult = triangle1.getShapeName() + " " + square1.getShapeName() +" " + circle1.getShapeName() + " ";
            String result = "";
            for(Shape shape : shapeCollector.shapes){result+=shape.getShapeName(); result+=" ";}
            //Then
            Assertions.assertEquals(testResult, result);
        }
    }
}
