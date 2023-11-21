package com.barteczkobook.object_oriented_programming.overriding_methods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverridingMethodsTest {

    private Car audi, mazda;
    private Person jan, robert;

    @Before
    public void setUp() {
        jan = new Person("Jan", "Rogalski");
        robert = new Person("Robert", "Górski");
        audi = new Car("1506", jan,  4, 3, 6, 400, 40);
        mazda = new Car("3456", robert, 4, 3, 6, 350, 50);
    }

    @Test
    public void car_CheckingOverridingStartMethodForCars_NothingReturnsOnlyAsserts() {
        assertNotNull(audi);
        assertNotNull(mazda);

        assertFalse(startCar(audi));
        audi.fill(40);
        assertTrue(startCar(audi));
        mazda.fill(20);
        assertTrue(startCar(mazda));
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + OverridingMethodsTest.class.getSimpleName());
    }

    /**
     * Subsidiary method who calls overriding start method from vehicle class
     * @param car
     * @return boolean value
     */

    private Boolean startCar(Car car) {
        try {
            car.start();
            assertEquals("Car with registration number " + car.getNrRej() + " - JEDZIE" ,car.toString());
            System.out.println(car);
            return true;
        } catch (Exception exc) {
            assertEquals("Car with registration number " + car.getNrRej() + " - STOI" + " - No fuel" ,(car + " - " + exc.getMessage()));
            System.out.println(car + " - " + exc.getMessage());
            return false;
        }
    }

}
