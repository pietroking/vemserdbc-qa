package step;

import org.junit.After;
import org.junit.Before;
import utils.Browser;

public class BaseTest extends Browser {

    @Before
    public void abrirNavegador(){
        browserUp("https://itera-qa.azurewebsites.net/");
    }

    @After
    public void fecharNavegador(){
        browserDown();
    }
}
