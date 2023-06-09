package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.PizzeriaFactory;

import static org.junit.jupiter.api.Assertions.*;
/*
 * PizzeriaServiceImplTest.java
 * Service Test for the Pizzeria
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PizzeriaServiceImplTest {
    private static Pizzeria pizzeria = PizzeriaFactory.buildRestaurant(
            "Grancho",
            25,
            true);

    private static Pizzeria pizzeria2 = PizzeriaFactory.buildRestaurant(
            "Grancho & Sons",
            22,
            true);

    private static Pizzeria pizzeria3 = PizzeriaFactory.buildRestaurant(
            "GrangerBay",
            15,
            false);
    //private static PizzeriaServiceImpl service = PizzeriaServiceImpl.getService();
    @Autowired
    private PizzeriaServiceImpl service;
    @Test
    void a_create() {
        Pizzeria created = service.create(pizzeria);
        Pizzeria created1 = service.create(pizzeria2);

        System.out.println(created);
        System.out.println(created1);

        assertNotNull(created);
        assertNotNull(created1);
    }

    @Test
    void b_read() {
        Pizzeria read = service.read(pizzeria.getRestaurantID());
        Pizzeria read2 = service.read(pizzeria2.getRestaurantID());

        System.out.println(pizzeria);
        System.out.println(pizzeria2);

        assertNotNull(pizzeria);
        assertNotNull(pizzeria2);
    }



    @Test
    void c_update() {
        Pizzeria newPizzeria = new Pizzeria
                .Builder()
                .copy(pizzeria2)
                .setRestaurantName("Tigers and sons")
                .setNoOfEmp(17)
                .setIsOpen(false)
                .build();
        Pizzeria updated = service.update(newPizzeria);

        assertEquals(newPizzeria.getRestaurantName(),newPizzeria.getRestaurantName());
        assertNotNull(service.update(newPizzeria));
        System.out.println(newPizzeria);
    }
    }
/*   @TesAt
    void d_delete() {
        boolean deleted = service.delete(pizzeria.getRestaurantID());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
 */
