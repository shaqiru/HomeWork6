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

public class product {
    WebDriver driver;
    String url = "https://www.saucedemo.com";
    @Given("success login to saucedemo")
    public void success_login_to_saucedemo() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(500);
        // throw new io.cucumber.java.PendingException();
    }
    @When("user click name of a product in list")
    public void user_click_name_of_a_product_in_list() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).click();
        Thread.sleep(500);
        // throw new io.cucumber.java.PendingException();
    }
    @Then("will show the page of product detail")
    public void will_show_the_page_of_product_detail() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Sauce Labs Bike Light",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        // throw new io.cucumber.java.PendingException();
    }
}
