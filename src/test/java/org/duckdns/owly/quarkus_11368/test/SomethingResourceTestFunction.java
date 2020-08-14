package org.duckdns.owly.quarkus_11368.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.duckdns.owly.quarkus_11368.Something;
import org.junit.jupiter.api.Assertions;

public class SomethingResourceTestFunction {
    public static void main(String[] args) {
        final Something created = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(new Something("someName"))
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .extract().as(Something.class);
        RestAssured.delete("/{id}", created.id);

        final Something deleted = RestAssured.get("/del/{id}", created.id)
                .then()
                .statusCode(200)
                .extract().as(Something.class);
        Assertions.assertEquals(deleted.getName(), created.getName());
    }
}
