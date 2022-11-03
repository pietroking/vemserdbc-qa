package br.com.dbccompany.service;

import br.com.dbccompany.dto.UserPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class UserService {

    String baseUri = "https://petstore.swagger.io/v2";

    public ResponseDTO deleteUser(String userName){

        ResponseDTO result =
                given()
                        .pathParam("userName", userName)
                .when()
                        .delete(baseUri + "/user/{userName}")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;

        return result;
    }

    public ResponseDTO deleteUserError(String userName){

        ResponseDTO result =
                given()
                        .pathParam("userName", userName)
                        .when()
                        .delete(baseUri + "/user/{userName}")
                        .then()
                        .log().all()
                        .statusCode(404)
                        .extract().as(ResponseDTO.class)
                ;

        return result;
    }

    public ResponseDTO addUser(String requstBody){
        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requstBody)
                .when()
                        .post(baseUri + "/user")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public UserPayloadDTO getUser(String username){
        UserPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("username", username)
                .when()
                        .get(baseUri + "/user/{username}")
                .then()
                        .log().all()
                        .extract().as(UserPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO putUser(String requstBody, String username){
        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requstBody)
                        .pathParam("username", username)
                .when()
                        .put(baseUri + "/user/{username}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }
}
