package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

/*
* ChefFactoryTest.java
* Author: Dawood Kamalie  (220147760)
* Date: 8/4/2023
* */
class ChefFactoryTest {

    @Test
    void createChef() {
        Chef chef = ChefFactory.createChef("001", "Dawood", "Kamalie", "01", "South African", "Pastry, baking, pizza, italina cuisine");
        System.out.println(chef);
        assertNotNull(chef);
    }
}