package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.RelatorioDTO;
import br.com.dbccompany.sevice.PessoaService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PessoaAceitacaoTest {

    PessoaService sevice = new PessoaService();

    @Test
    public void deveRetornarRelatorioPessoa(){

        RelatorioDTO[] resultService = sevice.buscarRealatorio();

        Assert.assertEquals(resultService[0].getNomePessoa().toUpperCase(), "Maicon Machado Gerardi".toUpperCase());
    }
}
