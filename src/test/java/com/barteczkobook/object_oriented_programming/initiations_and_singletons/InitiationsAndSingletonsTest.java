package com.barteczkobook.object_oriented_programming.initiations_and_singletons;

import com.barteczkobook.object_oriented_programming.abstraction_and_encapsulation.hermet.VehState;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InitiationsAndSingletonsTest {

    private Person personNumber1, personNumber2;
    private List<Vehicle> vehicles;
    private Vehicle vehicleNumber1, vehicleNumber2;
    private int dayOfWeek;

    @Before
    public void setUp() {
        personNumber1 = new Person("Marek", "89040512345");
        personNumber2 = new Person("Maciek", "87040612890");
        vehicles = new ArrayList<Vehicle>();
        vehicleNumber1 = new Vehicle(personNumber1, 4, 3, 6, 400);
        vehicleNumber2 = new Vehicle(personNumber2, 4, 3, 6, 400);
        vehicles.add(vehicleNumber1);
        vehicles.add(vehicleNumber2);
        dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }

    @Test
    public void initialBlockNonStatic_CheckingVehiclesStateForCurrentDayOfWeek_ReturnsProperState() {
        assertNotNull(personNumber1);
        assertNotNull(vehicleNumber1);
        assertNotNull(personNumber2);
        assertNotNull(vehicleNumber2);

        checkVehicleStateIfDayOfWeekIs(dayOfWeek);
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + this.getClass().getSimpleName());
    }

    private void checkVehicleStateIfDayOfWeekIs(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY: for(Vehicle v: vehicles) Assert.assertEquals(VehState.STOPPED, v.getState()); break;
            case Calendar.MONDAY: for (Vehicle v: vehicles) {
                if(v.getCurrNr() % 2 == 0)
                    Assert.assertEquals(VehState.MOVING, v.getState());
                else
                    Assert.assertEquals(VehState.STOPPED, v.getState());
            }  break;
            default: for(Vehicle v: vehicles) Assert.assertEquals(VehState.MOVING, v.getState()); break;
        }
    }

}
