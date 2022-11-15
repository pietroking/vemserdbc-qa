package br.com.aula.steps;


import br.com.aula.pages.LoginPage;
import br.com.aula.utils.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Test;

public class BaseSteps extends Browser {


    @Before
    public void abrirNavegador(){
        browserUp("https://itera-qa.azurewebsites.net/login/");
    }

    @After
    public void fecharNavegador(){
        browserDown();
    }

}
