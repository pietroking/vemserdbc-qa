package br.pe.pietro.rest;

import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTeste {

    @Test
    public void estruturaDoTeste(){}

    @Test
    public void testeDeveConsultarUsuarioComId2(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", Matchers.is(2))
        ;
    }
}
