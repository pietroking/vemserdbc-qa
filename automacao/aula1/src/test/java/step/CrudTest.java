package step;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class CrudTest extends Util{

    @Before
    public void loginPage(){
        login();
    }

    Faker faker = new Faker();
    String nome = faker.name().fullName();
    String company = faker.company().name();
    String address = faker.address().streetAddress();
    String city = faker.address().city();
    String phone = faker.phoneNumber().cellPhone();
    String email = faker.internet().emailAddress();

    String urlDash = "https://itera-qa.azurewebsites.net/Dashboard";
    @Test
    public void testSearch() throws InterruptedException {
        search("teste123");

        String result = driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td")).getText();
        Assert.assertEquals(result, "No Match");
    }

    @Test
    public void testCreatNew() throws InterruptedException {
        botaoCreateNew();
        create(nome, company, address, city, phone, email);

        search(nome);
        String result = driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1)")).getText();

        Assert.assertEquals(nome,result);
        delete();
    }

    @Test
    public void testDetails() throws InterruptedException {
        botaoCreateNew();
        create(nome, company, address, city, phone, email);
        search(nome);
        botaoDetails();

        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(2)")).getText(), nome);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(4)")).getText(), company);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(6)")).getText(), address);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(8)")).getText(), city);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(10)")).getText(), phone);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(12)")).getText(), email);

        driver.findElement(By.cssSelector("body > div > p > a.btn.btn-link")).click();
        search(nome);
        delete();
    }

    @Test
    public void testDelete() throws InterruptedException {
        botaoCreateNew();
        create(nome, company, address, city, phone, email);
        search(nome);
        delete();
        search(nome);

        String result = driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td")).getText();
        Assert.assertEquals(result, "No Match");
    }

    @Test
    public void testDeleteVoltar() throws InterruptedException {
        botaoCreateNew();
        create(nome, company, address, city, phone, email);
        search(nome);
        botaoDelete();
        driver.findElement(By.cssSelector("body > div > div > form > div > a")).click();
        search(nome);
        delete();
    }

    @Test
    public void testEdit() throws InterruptedException {
        botaoCreateNew();
        create(nome, company, address, city, phone, email);
        search(nome);
        botaoEdit();
        driver.findElement(By.cssSelector("[id=\"Name\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Company\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Address\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"City\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Phone\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).clear();

        String nomeEditado = "Teste edicao";

        driver.findElement(By.cssSelector("[id=\"Name\"]")).sendKeys(nomeEditado);
        driver.findElement(By.cssSelector("[id=\"Company\"]")).sendKeys(nomeEditado);
        driver.findElement(By.cssSelector("[id=\"Address\"]")).sendKeys(nomeEditado);
        driver.findElement(By.cssSelector("[id=\"City\"]")).sendKeys(nomeEditado);
        driver.findElement(By.cssSelector("[id=\"Phone\"]")).sendKeys(nomeEditado);
        driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys(nomeEditado);
        driver.findElement(By.cssSelector("[value=\"Save\"]")).click();

        search(nomeEditado);
        botaoDetails();

        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(2)")).getText(), nomeEditado);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(4)")).getText(), nomeEditado);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(6)")).getText(), nomeEditado);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(8)")).getText(), nomeEditado);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(10)")).getText(), nomeEditado);
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(12)")).getText(), nomeEditado);

        driver.findElement(By.cssSelector("body > div > p > a.btn.btn-link")).click();
        search(nomeEditado);
        delete();
    }

    @Test
    public void testEditVoltar() throws InterruptedException {
        botaoCreateNew();
        create(nome, company, address, city, phone, email);
        search(nome);
        botaoEdit();
        driver.findElement(By.cssSelector("body > div > div > a")).click();
        Assert.assertEquals(urlDash, driver.getCurrentUrl());
        search(nome);
        delete();
    }
}
