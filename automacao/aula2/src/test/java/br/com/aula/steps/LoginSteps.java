package br.com.aula.steps;

import br.com.aula.pages.DashboardPage;
import br.com.aula.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Test
    @Epic("Login")
    @DisplayName("validar Login Com Username E Senha Valida")
    public void validarLoginComUsernameESenhaValidos() {
        loginPage.escreverNoCompoLogin();
        loginPage.escreverNoCompoSenha();
        loginPage.clicarNoBotaoLogin();

        Assert.assertEquals("Welcome teste123", dashboardPage.validarTextLogadoNaTela());
    }

}
