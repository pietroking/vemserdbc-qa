package br.com.aula.steps;

import br.com.aula.pages.HomePage;
import cucumber.api.java.pt.Dado;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Dado("que acecesso a tela de login")
    public void clicarNoLink() {

    }
}
