package br.com.automacaoComBatista.steps;

import br.com.automacaoComBatista.pages.FormularioPage;
import br.com.automacaoComBatista.pages.UserPage;
import org.junit.Assert;
import org.junit.Test;

public class FormularioSteps extends BaseSteps{
    FormularioPage formularioPage = new FormularioPage();
    UserPage userPage = new UserPage();

    @Test
    public void validarCriarUsuarioCorretamente() throws InterruptedException {
        formularioPage.clicarNoBotaoFormulario();
        formularioPage.clicarNoBotaoCriarUsuario();
        formularioPage.escreverNoCompoNome();
        formularioPage.escreverNoCompoUltimoNome();
        formularioPage.escreverNoCompoEmail();
        formularioPage.clicarNoBotaoCriar();

        Assert.assertEquals("Usuário Criado com sucesso", userPage.validarTextLogadoNaTela());

        formularioPage.clicarNoBotaoVoltar();
        formularioPage.clicarNoBotaoDelete();
        formularioPage.clicarAlert();
    }
}
