package br.com.aula.steps;

import br.com.aula.pages.DashboardPage;
import br.com.aula.pages.HomePage;
import br.com.aula.pages.LoginPage;
import cucumber.api.java.it.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();


    @E("que preencho o username valido")
    public void escreverNoCampoLogin() {
        loginPage.escreverNoCompoLogin();
    }

    @E("que preencho a senha valida")
    public void escreverNoCampoSenha() {
        loginPage.escreverNoCompoSenha();
    }

    @Quando("clico em Login")
    public void clicarNoBotaoLogin() {
        loginPage.clicarNoBotaoLogin();
    }
    @Entao("devo vizualizar uma mensagem de boas vindas")
    public void acessarTelaLogin() {
        loginPage.clicarNoBotaoLogin();
    }




//    @Test
//    @Epic("Login")
//    @DisplayName("validar Login Com Username E Senha Valida")
//    public void validarLoginComUsernameESenhaValidos() {
//        loginPage.escreverNoCompoLogin();
//        loginPage.escreverNoCompoSenha();
//        loginPage.clicarNoBotaoLogin();
//
//        Assert.assertEquals("Welcome teste123", dashboardPage.validarTextLogadoNaTela());
//    }

}
