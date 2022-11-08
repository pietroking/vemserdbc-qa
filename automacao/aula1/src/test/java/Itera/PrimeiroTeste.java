package Itera;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PrimeiroTeste {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void abrirNavegador() {
        // Informando a automação qual app vai utilizar
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);

        // Abrir navegador = .get
        driver.get("https://itera-qa.azurewebsites.net/");
        // Maximar
        driver.manage().window().maximize();
        // daley
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @After
    public void fecharNavegador() {
        // Informando a automaçãoal app vai utilizar
        driver.quit();
    }

    @Test
    public void validarLoginComUsernameSenhaValidos() {

        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys("teste123");
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();

        String resp = driver.findElement(By.cssSelector("body > div > div > h3")).getText();

        Assert.assertEquals(resp, "Welcome teste123");
    }

    @Test
    public void validarLoginComUsernameSenhaInvalidos() {

        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys("");
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();

        String teste = driver.findElement(By.cssSelector("body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(5) > td > label")).getText();

        Assert.assertEquals(teste, "Wrong username or password");
    }

    @Test
    public void validarCriarUsuario(){

        Faker faker = new Faker();
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("[id=\"FirstName\"]")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("[id=\"Surname\"]")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("[id=\"E_post\"]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("[id=\"Mobile\"]")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys(faker.name().username());
        String senha = faker.internet().password();
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[id=\"submit\"]")).click();


        String resp = driver.findElement(By.cssSelector("body > div > form > div > div:nth-child(11) > div > label")).getText();

        Assert.assertEquals(resp, "Registration Successful");
    }

    @Test
    public void validarCriarUsuarioSemNome(){

        Faker faker = new Faker();
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("[id=\"Surname\"]")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("[id=\"E_post\"]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("[id=\"Mobile\"]")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys(faker.name().username());
        String senha = faker.internet().password();
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[id=\"submit\"]")).click();


        String resp = driver.findElement(By.cssSelector("body > div > form > div > div:nth-child(2) > div > span")).getText();

        Assert.assertEquals(resp, "Please enter first name");
    }

    @Test
    public void validarCriarUsuarioSemPreencher(){

        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("[id=\"submit\"]")).click();


        String resp1 = driver.findElement(By.cssSelector("body > div > form > div > div:nth-child(2) > div > span")).getText();
        String resp2 = driver.findElement(By.cssSelector("#Surname-error")).getText();
        String resp3 = driver.findElement(By.cssSelector("#Username-error")).getText();
        String resp4 = driver.findElement(By.cssSelector("#Password-error")).getText();

        Assert.assertEquals(resp1, "Please enter first name");
        Assert.assertEquals(resp2, "Please enter surname");
        Assert.assertEquals(resp3, "Please enter username");
        Assert.assertEquals(resp4, "Please enter password");
    }

    @Test
    public void validarCriarUsuarioConfirmarSenhaErrada(){

        Faker faker = new Faker();
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("[id=\"FirstName\"]")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("[id=\"Surname\"]")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys(faker.name().username());
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys(faker.internet().password());
        driver.findElement(By.cssSelector("[id=\"ConfirmPassword\"]")).sendKeys(faker.internet().password());
        driver.findElement(By.cssSelector("[id=\"submit\"]")).click();

        String resp = driver.findElement(By.cssSelector("body > div > form > div > div:nth-child(9) > div > span")).getText();

        Assert.assertEquals(resp, "'Confirm password' and 'Password' do not match.");
    }

    @Test
    public void validarTextareaPratice(){

        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String address = faker.address().fullAddress();
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("[id=\"name\"]")).sendKeys(name);
        String nomeTest = driver.findElement(By.cssSelector("[id=\"name\"]")).getText();
        driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(phone);
        String phoneTest = driver.findElement(By.cssSelector("[id=\"phone\"]")).getText();
        driver.findElement(By.cssSelector("[id=\"email\"]")).sendKeys(email);
        String emailTest = driver.findElement(By.cssSelector("[id=\"email\"]")).getText();
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys(password);
        String passwordTest = driver.findElement(By.cssSelector("[id=\"password\"]")).getText();
        driver.findElement(By.cssSelector("[id=\"address\"]")).sendKeys(address);
        String addressTest = driver.findElement(By.cssSelector("[id=\"address\"]")).getText();
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();

//        Assert.assertEquals(name, nomeTest);
//        Assert.assertEquals(phone, phoneTest);
//        Assert.assertEquals(email, emailTest);
//        Assert.assertEquals(password, passwordTest);
//        Assert.assertEquals(address, addressTest);
    }
    //nao tem resposta, nem se deixar algum campo em branco

    @Test
    public void validarCheckBoxRadioButtonPratice() {

        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("[id=\"male\"]")).click();
        driver.findElement(By.cssSelector("[id=\"monday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"sunday\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"male\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"female\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"monday\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"tuesday\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"wednesday\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"thursday\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"friday\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"saturday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"sunday\"]")).isSelected());
    }
    
    @Test
    public void validarDropDownPratice() {

        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("body > div > div:nth-child(5) > div.card-body > div > select > option:nth-child(7)")).click();

        String result = driver.findElement(By.cssSelector("body > div > div:nth-child(5) > div.card-body > div > select > option:nth-child(7)")).getText();

        Assert.assertEquals(result, "Italy");
        Assert.assertNotEquals(result, "Spain");
    }

    @Test
    public void validarCheckBoxRadioButtonPraticeXpath() {

        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("[for=\"3years\"]")).click();
        driver.findElement(By.cssSelector("[for=\"selenium\"]")).click();
        driver.findElement(By.cssSelector("[for=\"cucumber\"]")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"1year\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"2years\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[for=\"3years\"]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"4years\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[for=\"selenium\"]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("[for=\"cucumber\"]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"testng\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"serenity\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"testim\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"mabl\"]")).isSelected());
    }

}