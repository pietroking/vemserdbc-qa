package br.com.dbcompany.service;

import br.com.dbcompany.dto.PetPayloadDTO;
import br.com.dbcompany.dto.ResponseDTO;
import br.com.dbcompany.dto.UserPayloadDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PetService {

    //Especificar a baseUri
    String baseUri = "https://petstore.swagger.io/v2";

    public PetPayloadDTO addPet(String requstBody){
        PetPayloadDTO result =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requstBody)
        .when()
                .post(baseUri + "/pet")
        .then()
                .log().all()
                .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public PetPayloadDTO consultarPerPorId(Integer idPet){
        PetPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("idPet", idPet)
                .when()
                        .get(baseUri + "/pet/{idPet}")
                .then()
                        .statusCode(200)
                        .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public PetPayloadDTO atualizarPet(String requstBody){
        PetPayloadDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requstBody)
                .when()
                        .put(baseUri + "/pet")
                .then()
                        .log().all()
                        .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO deletarPet(Integer idPet){

        ResponseDTO result =
        given()
                .pathParam("idPet", idPet)
        .when()
                .delete(baseUri + "/pet/{idPet}")
        .then()
                .log().all()
                .extract().as(ResponseDTO.class)
        ;

        return result;
    }

    public UserPayloadDTO addUser(String requstBody){
        UserPayloadDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requstBody)
                .when()
                        .post(baseUri + "/user")
                .then()
                        .log().all()
                        .extract().as(UserPayloadDTO.class)
                ;
        return result;
    }
}
