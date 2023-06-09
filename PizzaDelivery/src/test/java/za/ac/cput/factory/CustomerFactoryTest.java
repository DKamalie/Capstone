package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerFactoryTest {
    public static Address address = AddressFactory.buildAddress(
            "7",
            "Seafox Street",
            "",
            "Delft",
            "Cape Town",
            "Western Cape",
            "South Africa",
            "2134",
            Address.AddressType.RESIDENTIAL_HOME);
    @Test
    void buildCustomer() {
        Customer customer = CustomerFactory.buildCustomer(
                "Keenan",
                "Meyer",
                "082 738 2590");

        System.out.println(customer.toString());
        assertNotNull(customer);
    }

}
