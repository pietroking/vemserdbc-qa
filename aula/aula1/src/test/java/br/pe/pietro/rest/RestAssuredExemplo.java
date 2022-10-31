package br.pe.pietro.rest;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredExemplo {

    private String baseUri = "https://reqres.in/api";

    @Test
    public void testeDeveConsultarPagina2(){

        given()
                .log().all()
                .queryParam("page","2")
        .when()
                .get(baseUri + "/users")
        .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(6))
                .body("data.first_name", hasItem("Byron"))
                .body("data[1].id", is(8))
        ;
    }

    @Test
    public void testeDeveConsultarUsuarioInexistente(){

        given()
                .log().all()
        .when()
                .get(baseUri + "/users/23")
        .then()
                .log().all()
                .statusCode(404)
        ;
    }

    @Test
    public void testeDeveSalvarUsuario(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Pietro\", \"job\" : \"QA\"}")
        .when()
                .post(baseUri + "/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("name", is("Pietro"))
                .body("job", is("QA"))
                .body("id", not(nullValue()))
                .body(containsString("createdAt"))
        ;
    }

    @Test
    public void testeDeveSerializarMapEObjAoSalvarUsuario(){

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name","Pietro");
        params.put("job","QA");

        UserTeste user = new UserTeste("Pietro com obj", "QA com obj");

        given()
                .log().all()
                //.body(params)
                .body(user)
                .contentType(ContentType.JSON)
                //.body("{\"name\" : \"Pietro\", \"job\" : \"QA\"}")
        .when()
                .post(baseUri + "/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("name", is("Pietro com obj"))
                .body("job", is("QA com obj"))
                .body("id", not(nullValue()))
                .body(containsString("createdAt"))
        ;
    }

    @Test
    public void testeDeveDesserializarObjAoSalvarUsuario(){

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name","Pietro");
        params.put("job","QA");

        UserTeste user =
                given()
                    .log().all()
                    .body(params)
                    //.body(user)
                    .contentType(ContentType.JSON)
                    //.body("{\"name\" : \"Pietro\", \"job\" : \"QA\"}")
                .when()
                    .post(baseUri + "/users")
                .then()
                    .log().all()
                    .statusCode(201)
                    .extract().body().as(UserTeste.class);
        Assert.assertEquals("Pietro", user.getName());
        Assert.assertEquals("QA", user.getJob());
        Assert.assertThat(user.getCreatedAt(), Matchers.notNullValue());
        Assert.assertThat(user.getId(), Matchers.notNullValue());
    }

    @Test
    public void testeDeveAtualizarUsuario(){
        Integer idUser = 2;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Pietro\", \"job\" : \"QA Senior\"}")
                .pathParam("id", idUser)
        .when()
                .put(baseUri + "/users/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Pietro"))
                .body("job", is("QA Senior"))
                .body(containsString("updatedAt"))
        ;
    }

    @Test
    public void testeDeveAtualizarUsuarioComPatch(){
        Integer idUser = 2;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Pietro\", \"job\" : \"QA Senior\"}")
                .pathParam("id", idUser)
        .when()
                .patch(baseUri + "/users/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Pietro"))
                .body("job", is("QA Senior"))
                .body(containsString("updatedAt"))
        ;
    }

    @Test
    public void testeDeveDeletarUsuario(){
        Integer idUser = 2;

        given()
                .log().all()
                .pathParam("id", idUser)
        .when()
                .delete(baseUri + "/users/{id}")
        .then()
                .log().all()
                .statusCode(204)
        ;
    }

    @Test
    public void testeDeveDeletarUsuarioInexistente(){
        Integer idUser = 23;

        given()
                .log().all()
                .pathParam("id", idUser)
        .when()
                .delete(baseUri + "/users/{id}")
        .then()
                .log().all()
                .statusCode(204)
        ;
    }

    @Test
    public void testeDeveVerificarRegistroDeUsuario(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}")
        .when()
                .post(baseUri + "/register")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue())
        ;
    }

    @Test
    public void testeDeveVerificarRegistroDeUsuarioInexistente(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"pietro@teste.com\", \"password\" : \"123456\"}")
        .when()
                .post(baseUri + "/register")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))

        ;
    }

    @Test
    public void testeDeveVerificarRegistroDeUsuarioSemSenha(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\"}")
        .when()
                .post(baseUri + "/register")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))

        ;
    }

    @Test
    public void testeDeveVerificarRegistroDeUsuarioSemEmail(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"password\" : \"pistol\"}")
        .when()
                .post(baseUri + "/register")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))
        ;
    }

    @Test
    public void testeDeveVerificarRegistroDeUsuarioEmailErrado(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt1@reqres.in\", \"password\" : \"pistol1\"}")
        .when()
                .post(baseUri + "/register")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))
        ;
    }

    @Test
    public void testeDeveVerificarRegistroDeUsuarioSenhaErrada(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol1\"}")
        .when()
                .post(baseUri + "/register")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))
        ;
    }//bug api o teste passa mesmo com a senha errada

    @Test
    public void testeDeveVerificarLoginDeUsuario(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}")
        .when()
                .post(baseUri + "/login")
        .then()
                .log().all()
                .statusCode(200)
                .body("token", notNullValue())
        ;
    }

    @Test
    public void testeDeveVerificarLoginDeUsuarioSenhaErrada(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka1\"}")
        .when()
                .post(baseUri + "/login")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))
        ;
    }//bug api o teste passa mesmo com a senha errada

    @Test
    public void testeDeveVerificarLoginDeUsuarioErrado(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt1@reqres.in\", \"password\" : \"cityslicka\"}")
        .when()
                .post(baseUri + "/login")
        .then()
                .log().all()
                .statusCode(400)
                .body(containsString("error"))
        ;
    }

    @Test
    public void testeDelayUsuario(){

        given()
                .log().all()
                .queryParam("delay","3")
        .when()
                .get(baseUri + "/users")
        .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(1))
                .body("data", hasSize(6))
                .body("data.first_name", hasItem("Janet"))
                .body("data[0].id", is(1))
        ;
    }
}
