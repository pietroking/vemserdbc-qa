package br.com.dbccompany.sevice;

import br.com.dbccompany.dto.RelatorioDTO;
import br.com.dbccompany.utils.Login;

import static io.restassured.RestAssured.*;

public class PessoaService {

    String baseUri = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";

//    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU1VBUklPIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjY3NDk3MjQ4LCJleHAiOjE2Njc1ODM2NDh9.ZLGqMoPnEnNs5q51yTKhq1eBYEd7V20FPqExq3Y-wl0";

    String tokenAdm = new Login().authenticationAdmin();
    public RelatorioDTO[] buscarRealatorio(){

        RelatorioDTO[] result =
            given()
                    .header("Authorization", tokenAdm)
            .when()
                    .get(baseUri + "/pessoa/relatorio")

            .then()
                    .log().all()
                    .statusCode(200)
                    .extract().as(RelatorioDTO[].class)
            ;
        return result;
    }
}
