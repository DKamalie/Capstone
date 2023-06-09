package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/*
OrderLineFactoryTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 14 June 2023
 */

public class OrderLineFactoryTest {
    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static LocalTime time = LocalTime.now();
    private static Address address = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", Address.AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Rickon", "Stark","076 675 8090");
    private static Order order = OrderFactory.buildOrder(date,time, customer);

    private static Base b = PizzaFactory.createBase();
    private static Pizza pizza = PizzaFactory.buildPizza(b, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 35);

    @Test
    public void orderLine_test_pass() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza);
        System.out.println(orderLine.toString());
        assertNotNull(orderLine);
    }

    @Test
    public void orderLine_test_fail() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(0, order, pizza);
        System.out.println(orderLine.toString());
        assertNull(orderLine);
    }

    @Test
    public void orderLine_test_equality_pass() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(10, order, pizza);
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(10, order, pizza);
        if(orderLine.equals(orderLine)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void orderLine_test_equality_fail() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(10, order, pizza);
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(10, order, pizza);
        if(orderLine.equals(orderLine1)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void orderLine_test_timeout_pass() {      //pass because test takes less than 2 seconds
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> {
            Thread.sleep(1000);
        });

        int quantity = 5;
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza);
        assertEquals(quantity, orderLine.getQuantity());
        System.out.println(orderLine.toString());
    }

    @Test
    public void orderLine_test_timeout_fail() {         //fail because test takes longer than 1 second
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(2000);
        });

        int quantity = 5;
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza);
        assertEquals(quantity, orderLine.getQuantity());
        System.out.println(orderLine.toString());
    }

    @Disabled("Disabled test.")
    @Test
    public void orderLine_test_disabled() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(15, order, pizza);
        System.out.println(orderLine.toString());
        assertNotNull(orderLine);
    }
}
