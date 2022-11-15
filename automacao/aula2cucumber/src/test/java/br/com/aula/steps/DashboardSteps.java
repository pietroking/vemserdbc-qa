package br.com.aula.steps;

import br.com.aula.pages.DashboardPage;
import cucumber.api.java.pt.Entao;

public class DashboardSteps {

    DashboardPage dashboardPage = new DashboardPage();

    Assert.assertEquals("Welcome teste123", dashboardPage.validarTextLogadoNaTela());
}
