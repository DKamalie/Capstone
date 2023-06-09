package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.PizzaFactory;

import static org.junit.jupiter.api.Assertions.*;
/* PizzaControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaControllerTest {

    private static Base b = PizzaFactory.createBase();
    private static Pizza pizza = PizzaFactory.buildPizza(b, "Vegetariana pizza", "Thin crust with high quality flour and fresh tomato sauce base and with high quality fresh vegetables.", Pizza.Size.SMALL, true, 40);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/pizza";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Pizza> postResponse = restTemplate.postForEntity(url ,pizza, Pizza.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Pizza createPizza = postResponse.getBody();
        System.out.println("Saved data: " + createPizza);
    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + pizza.getPizzaId();
        System.out.println("URL " + url);
        ResponseEntity<Pizza> response = restTemplate.getForEntity(url, Pizza.class);
        assertEquals(pizza.getPizzaId(), response.getBody().getPizzaId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update(){
        Pizza updated = new Pizza.Builder().copy(pizza).setPrice(60).build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Pizza> response = restTemplate.postForEntity(url, updated, Pizza.class);
        assertNotNull(response.getBody());

    }


    @Test
    public void d_delete(){
        String url = baseURL + "/delete/" + pizza.getPizzaId();
        System.out.println("URL " + url);
        restTemplate.delete(url);

    }

    @Test
    public void e_getAll(){
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all ");
        System.out.println(response);
        System.out.println(response.getBody());

    }

}