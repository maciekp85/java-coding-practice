package com.barteczkobook.object_oriented_programming.initiations_and_singletons.initiation_static_block;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class InitiationStaticBlockTest {

    private Person person;
    private Vehicle vehicle;
    private Locale defLoc;

    private Locale [] locArr = {Locale.UK, Locale.US, Locale.JAPAN, Locale.ITALY};
    private int [] currNums = {1, 100, 1000, 10000};

    @Before
    public void setUp() {
        person = new Person("Karol", "91230454323");
        vehicle = new Vehicle(person, 4, 5, 6, 400);
        defLoc = Locale.getDefault();
    }

    @Test
    public void initiationStaticBlock_CheckingOfVehicleNumberBasedOnSystemLocale_returnsVehicleNumber() {
        assertNotNull(person);
        assertNotNull(vehicle);

        for(int i=0; i<locArr.length; i++) {
            if(defLoc.equals(locArr[i])) {
                assertEquals(currNums[i], vehicle.getCurrNr());
                break;
            } else if(i==locArr.length-1) {
                assertEquals(200, vehicle.getCurrNr());
                break;
            }
        }
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + this.getClass().getSimpleName());
    }

}
