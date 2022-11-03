package br.com.dbccompany.aceitacao;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.dbccompany.dto.UserPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.service.UserService;

public class UserAceitacaoTest {

    UserService service = new UserService();

    public UserAceitacaoTest() throws IOException {
    }

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    String jsonBody = lerJson("src/test/resources/data/user1.json");
    String jsonBodyTeste = lerJson("src/test/resources/data/userTeste.json");

    @Test
    public void testeDeveAddUser() {

        ResponseDTO resultSevice = service.addUser(jsonBody);

        Assert.assertEquals(resultSevice.getCode(), "200");
        Assert.assertEquals(resultSevice.getMessage(), "10");

        service.deleteUser("pietroking");
    }

    @Test
    public void testeDeveConsultarUser() {

        service.addUser(jsonBody);
        UserPayloadDTO resultSevice = service.getUser("pietroking");

        Assert.assertEquals(resultSevice.getUsername(), "pietroking");
        Assert.assertEquals(resultSevice.getFirstName(), "Pietro");

        service.deleteUser("pietroking");
    }

    @Test
    public void testeDeveConsultarUserInexistente() {

        service.addUser(jsonBody);
        UserPayloadDTO resultSevice = service.getUser("pietro");

        Assert.assertEquals(resultSevice.getCode(), "1");
        Assert.assertEquals(resultSevice.getType(), "error");
        Assert.assertEquals(resultSevice.getMessage(), "User not found");

        service.deleteUser("pietroking");
    }

    @Test
    public void testeDeveAtualizarUser() {

        service.addUser(jsonBody);
        ResponseDTO resultSevice = service.putUser(jsonBodyTeste, "pietroking");

        Assert.assertEquals(resultSevice.getCode(), "200");
        Assert.assertEquals(resultSevice.getMessage(), "10");

        service.deleteUser("pietroking");
    }

    @Test
    public void testeDeveAtualizarUserInexistente() {

        service.addUser(jsonBody);
        ResponseDTO resultSevice = service.putUser(jsonBodyTeste, "hahahaha");

        Assert.assertEquals(resultSevice.getCode(), "404");
        Assert.assertEquals(resultSevice.getMessage(), "User not found");

        service.deleteUser("pietroking");
    }//bug api teste passou !!

    @Test
    public void testeDeveDeletarUserInexistente() {

        service.addUser(jsonBody);

        ResponseDTO resultSevice =  service.deleteUser("pietroking");

        Assert.assertEquals(resultSevice.getCode(), "200");
    }
}
