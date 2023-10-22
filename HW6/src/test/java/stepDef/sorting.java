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

public class sorting {
    WebDriver driver;
    String url = "https://www.saucedemo.com";
    @Given("success login to saucdemo")
    public void success_login_to_saucdemo() throws InterruptedException {
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
    @When("user clik Name \\(A to Z) in top right")
    public void user_clik_name_a_to_z_in_top_right() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(500);
        // throw new io.cucumber.java.PendingException();
    }
    @When("user choose price \\(high to low)")
    public void user_choose_price_high_to_low() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        Thread.sleep(500);
        // throw new io.cucumber.java.PendingException();
    }
    @Then("will display list product in home page will sorting based on price high to low")
    public void will_display_list_product_in_home_page_will_sorting_based_on_price_high_to_low() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("$49.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.quit();
        // throw new io.cucumber.java.PendingException();
    }
}
