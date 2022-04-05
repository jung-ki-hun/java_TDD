package com.nhnacdemy.kihunjung.tdd;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class OrderedTest {

}
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTest2 {
    @Test
    @Order(1)
    void nullValues() {
    }

    @Test
    @Order(2)
    void emptyValues() {
    }

    @Test
    @Order(3)
    void validValues() {
    }
}
