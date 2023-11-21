package com.barteczkobook.object_oriented_programming.interfaces;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterfacesTest {

    private Dog dog;
    private Cat cat;
    private Car car;
    private Bicycle bicycle;

    @Before
    public void setUp() {
        dog = new Dog("Reksio");
        cat = new Cat("Mruczek");
        car = new Car("WB12345", new Person("Jan", "22334455"), 100, 100, 100, 100, 100);
        car.fill(10);
        bicycle = new Bicycle(new Person("Marek", "111111"), 15, 15, 15, 15);
    }

    @Test
    public void speakableAndMoveableInterfaces_CheckingCorrectOfWorkingInterfacesMethods_TypingMessagesOnConsole() {
        assertNotNull(dog);
        assertNotNull(cat);
        assertNotNull(car);
        assertNotNull(bicycle);
        race(dog, cat, car, bicycle);
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + InterfacesTest.class.getSimpleName());
    }

    public static void race(Moveable ... moveables) {
        for (Moveable m: moveables) {
            m.start();
            if(m instanceof Vehicle) System.out.println(m);
        }
    }
}
