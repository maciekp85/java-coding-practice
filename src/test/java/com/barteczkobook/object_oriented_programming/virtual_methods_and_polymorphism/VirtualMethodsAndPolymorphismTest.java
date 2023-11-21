package com.barteczkobook.object_oriented_programming.virtual_methods_and_polymorphism;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VirtualMethodsAndPolymorphismTest {

    private Animal a1, a2;
    private Dog dog, reksio, kuba;
    private Cat cat;

    @Before
    public void setUp() {
        a1 = new Animal(); a2 = new Animal();
        dog = new Dog(); reksio = new Dog("Reksio"); kuba = new Dog("kuba");
        cat = new Cat();
    }

    @Test
    public void virtualSpeakMethod_CheckingCorrectOfSendingMessages_NothingReturnsOnlyAsserts() {
        assertNotNull(a1); assertNotNull(a2); assertNotNull(dog); assertNotNull(reksio); assertNotNull(kuba); assertNotNull(cat);

        animalDialog(a1, a2);
        animalDialog(reksio, kuba);
        animalDialog(cat, cat);
        animalDialog(a1, dog);
        animalDialog(a2, cat);
        animalDialog(dog, cat);
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + VirtualMethodsAndPolymorphismTest.class.getSimpleName());
    }

    /**
     * Method compares voices of two animals based on polymorphism type of speak method
     * @param a1 - class type of first animal
     * @param a2 - class type of second animal
     */

    private void animalDialog(Animal a1, Animal a2) {

         if (a1 instanceof Dog && a2 instanceof Dog) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks HAU, HAU!", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks HAU, HAU!", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        } else if (a1 instanceof Dog && a2 instanceof Cat) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks HAU, HAU!", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks Miauuuu...", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        } else if (a1 instanceof Dog && a2 instanceof Animal) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks HAU, HAU!", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks ?", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        }  else if (a1 instanceof Cat && a2 instanceof Dog) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks Miauuuu...", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks HAU, HAU!", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        } else if (a1 instanceof Cat && a2 instanceof Cat) {
             assertEquals(a1.getType() + " " + a1.getName() + " speaks Miauuuu...", a1.speak());
             assertEquals(a2.getType() + " " + a2.getName() + " speaks Miauuuu...", a2.speak());
             System.out.println(a1.speak());
             System.out.println(a2.speak());
             System.out.println("----------------------------------------------");
         } else if (a1 instanceof Cat && a2 instanceof Animal) {
             assertEquals(a1.getType() + " " + a1.getName() + " speaks Miauuuu...", a1.speak());
             assertEquals(a2.getType() + " " + a2.getName() + " speaks ?", a2.speak());
             System.out.println(a1.speak());
             System.out.println(a2.speak());
             System.out.println("----------------------------------------------");
        } else if (a1 instanceof Animal && a2 instanceof Dog) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks ?", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks HAU, HAU!", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        } else if (a1 instanceof Animal && a2 instanceof Cat) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks ?", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks Miauuuu...", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        } else if (a1 instanceof Animal && a2 instanceof Animal) {
            assertEquals(a1.getType() + " " + a1.getName() + " speaks ?", a1.speak());
            assertEquals(a2.getType() + " " + a2.getName() + " speaks ?", a2.speak());
            System.out.println(a1.speak());
            System.out.println(a2.speak());
            System.out.println("----------------------------------------------");
        }
    } // end of method

} // end of class
