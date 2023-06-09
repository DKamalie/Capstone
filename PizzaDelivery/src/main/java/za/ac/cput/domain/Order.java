package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/* Order.java
 Entity for the Order
 Author: Timothy Lombard (220154856)
 Date: 8th April (last updated) 2023
*/

    public class Order {

        private String orderId;

        private LocalDate createDate;
        private LocalTime time;
        private Customer customer;

        private Order(){

        }

        private Order(Builder builder){
            this.orderId = builder.orderId;
            this.createDate = builder.createDate;
            this.time = builder.time;
            this.customer = builder.customer;
        }

        public String getOrderId() {
            return orderId;
        }

        public LocalDate getCreateDate() {
            return createDate;
        }

        public LocalTime getTime() {
            return time;
        }

        public Customer getCustomer() {
            return customer;
        }

        public static class Builder {
            private String orderId;
            private LocalDate createDate;
            private LocalTime time;
            private Customer customer;


            public za.ac.cput.domain.Order.Builder setOrderId(String orderId) {
                this.orderId = orderId;
                return this;
            }

            public za.ac.cput.domain.Order.Builder setCreateDate(LocalDate createDate){
                this.createDate = createDate;
                return this;
            }

            public Builder setTime(LocalTime time) {
                this.time = time;
                return this;
            }

            public Order.Builder setCustomer(Customer customer){
                this.customer = customer;
                return this;
            }


            public za.ac.cput.domain.Order.Builder copy(za.ac.cput.domain.Order order) {
                this.orderId = order.orderId;
                this.createDate = order.createDate;
                this.time = order.time;
                this.customer = order.customer;
                return this;
            }




            public za.ac.cput.domain.Order build() {
                return new za.ac.cput.domain.Order(this);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return Objects.equals(orderId, order.orderId) && Objects.equals(createDate, order.createDate) && Objects.equals(time, order.time) && Objects.equals(customer, order.customer);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId, createDate, time, customer);
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId='" + orderId + '\'' +
                    ", createDate=" + createDate +
                    ", time=" + time +
                    ", customer=" + customer +
                    '}';
        }
    }


