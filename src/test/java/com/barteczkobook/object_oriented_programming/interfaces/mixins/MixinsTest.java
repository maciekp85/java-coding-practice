package com.barteczkobook.object_oriented_programming.interfaces.mixins;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MixinsTest {

    private Bintorung bintorung;

    @Before
    public void setUp() {
        bintorung = new Bintorung("rex");
    }

    @Test
    public void bintorungClass_CheckingOfSendingCorrectMessageFromClassUsingTwoInterfacesBearAndCat_NothingReturnsOnlyAsserts() {
        assertNotNull(bintorung);
        String message = bintorung.toString();
        assertEquals("My name is rex and I am Bintorung, or BearCat", message);
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + MixinsTest.class.getSimpleName());
    }

}
