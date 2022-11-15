package br.com.automacaoComBatista.steps;

import br.com.automacaoComBatista.utils.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {

    @Before
    public void abrirNavegador(){
        browserUp("https://automacaocombatista.herokuapp.com/treinamento/home/");
    }

    @After
    public void fecharNavegador(){
        browserDown();
    }
}
