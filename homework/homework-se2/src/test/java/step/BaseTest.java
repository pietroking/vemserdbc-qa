package step;

import org.junit.After;
import org.junit.Before;
import utils.Browser;

public class BaseTest extends Browser {

    @Before
    public void abrirNavegador(){
        browserUp("https://practice.automationtesting.in/");
    }

    @After
    public void fecharNavegador(){
        browserDown();
    }
}