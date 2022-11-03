package br.com.dbccompany.aceitacao;

import br.com.dbcompany.dto.PetPayloadDTO;
import br.com.dbcompany.dto.ResponseDTO;
import br.com.dbcompany.dto.UserPayloadDTO;
import br.com.dbcompany.service.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetAceitacaoTest {

    PetService service = new PetService();

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testeDeveAddPet() throws IOException {

        //Massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet1.json");

        //Chamada para o servico
        PetPayloadDTO resultService = service.addPet(jsonBody);

        //Validar os rasultados obtidos
        Assert.assertEquals(resultService.getId(), "10051995");
        Assert.assertEquals(resultService.getName(), "Frank");
    }

    @Test
    public void testeDeveConsultarPetPorId(){

        Integer idPet = 10051995;

        PetPayloadDTO resultService = service.consultarPerPorId(idPet);

        Assert.assertEquals(resultService.getName(), "Frank");
        Assert.assertEquals(resultService.getId(), "10051995");
    }

    @Test
    public void testeDeveAtualizarPet() throws IOException {
        //Massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet1.json");

        //Chamada para o servico
        PetPayloadDTO resultService = service.atualizarPet(jsonBody);

        //Validar os rasultados obtidos
        Assert.assertEquals(resultService.getId(), "10051995");
        Assert.assertEquals(resultService.getName(), "Harley");
    }

    @Test
    public void testeDeveDeletarPet(){
        Integer idPet = 10051995;

        ResponseDTO resultService = service.deletarPet(idPet);

        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getMessage(), "10051995");
    }

    @Test
    public void testeDeveSerIndependente() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/pet1.json");

        PetPayloadDTO resultServiceAdd = service.addPet(jsonBody);

        Assert.assertEquals(resultServiceAdd.getId(), "10");
        Assert.assertEquals(resultServiceAdd.getName(), "Harley");

        PetPayloadDTO resultServiceGet = service.consultarPerPorId(10);

        Assert.assertEquals(resultServiceGet.getName(), "Harley");
        Assert.assertEquals(resultServiceGet.getId(), "10");

        ResponseDTO resultServiceDelete = service.deletarPet(10);

        Assert.assertEquals(resultServiceDelete.getCode(), "200");
        Assert.assertEquals(resultServiceDelete.getMessage(), "10");
    }

    @Test
    public void testeDeveAddUser() throws IOException {

        //Massa de dados
        String jsonBody = lerJson("src/test/resources/data/user1.json");

        //Chamada para o servico
        UserPayloadDTO resultService = service.addUser(jsonBody);

        //Validar os rasultados obtidos
//        Assert.assertEquals(resultService.getId(), "10");
        Assert.assertEquals(resultService.getUsername(), "pietroking");
    }
}

