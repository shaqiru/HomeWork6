package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class login {
    WebDriver driver;
    String url = "https://www.saucedemo.com";

    @Given("user navigates to website")
    public void user_navigates_to_website() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(url);

        String title = driver.getTitle();
        System.out.println();
        //throw new io.cucumber.java.PendingException();
        Thread.sleep(500);

    }
    @When("the user enters the correct username and password")
    public void the_user_enters_the_correct_username_and_password() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String password = "secret_sauce";

        // Inisialisasi variabel untuk username dan password
        String username = "standard_user";

        driver.findElement(By.id("user-name")).sendKeys( username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(500);

        //throw new io.cucumber.java.PendingException();
    }
    @When("clicks the {string} button")
    public void clicks_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login-button")).click();
        // throw new io.cucumber.java.PendingException();
    }
    @Then("he can see the page of products {string}")
    public void he_can_see_the_page_of_products(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login with valid username and password");
        //driver.quit();
        // throw new io.cucumber.java.PendingException();
    }
}
