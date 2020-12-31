package com.adisava;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class SecuredGreetingResourceTest {

    @Test
    public void testSecuredHelloEndpoint() {
        given()
                .auth().basic("Adi", "supertester")
                .when()
                .get("/secured/hello")
                .then()
                .statusCode(200)
                .body(is("Hello Tester-san"));
    }
}