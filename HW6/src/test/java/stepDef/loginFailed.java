package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginFailed {
    WebDriver driver;
    String url = "https://www.saucedemo.com";
    @Given("user navigates to website {string}")
    public void user_navigates_to_website(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(url);

        String title = driver.getTitle();
        System.out.println();
        Thread.sleep(500);
        //throw new io.cucumber.java.PendingException();
    }
    @When("the user enters the invalid username and password")
    public void the_user_enters_the_invalid_username_and_password() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String password = "secret_sauce";

        // Inisialisasi variabel untuk username dan password
        String username = "SQL";

        driver.findElement(By.id("user-name")).sendKeys( username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(500);
        //throw new io.cucumber.java.PendingException();
    }
    @When("clicks the {string} button at home page")
    public void clicks_the_button_at_home_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login-button")).click();
        // throw new io.cucumber.java.PendingException();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());

        // throw new io.cucumber.java.PendingException();
    }
}
