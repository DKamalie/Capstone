package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;


/* OrderFactory.java
 Author: Timothy Lombard (220154856)
 Date: 8th April (last updated) 2023
*/

    public class OrderFactory {

        public static Order buildOrder(LocalDate createDate, LocalTime time, Customer customer) {
            if (Helper.isNullOrEmpty(String.valueOf(Helper.isNullOrEmpty(String.valueOf(createDate)))) || Helper.isNullOrEmpty(String.valueOf(time))  || Helper.isNullOrEmpty(String.valueOf(customer))) {
                return null;
            }

            String orderId = Helper.generateId();

            Order order = new Order.Builder().setOrderId(orderId).setCreateDate(createDate).setTime(time).setCustomer(customer).build();
            return order;

        }

    }

