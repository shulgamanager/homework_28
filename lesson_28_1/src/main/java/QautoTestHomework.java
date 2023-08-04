import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QautoTestHomework {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions driverOptions = new ChromeOptions();
        driverOptions.setBinary("/Applications/Chrome.app/Contents/MacOS/Google Chrome");
        driverOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(driverOptions);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //    // Тут будет описание тест кейса
//    @Test
//    public void test1() {
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().setSize(new Dimension(1200, 757));
//
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
//        driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
//        assertThat(driver.findElement(By.cssSelector(".inventory_details_desc")).getText(), is("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."));
//        driver.findElement(By.id("react-burger-menu-btn")).click();
//    }
    @Test
    public void login() throws InterruptedException {
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        driver.manage().window().setSize(new Dimension(1200, 757));
        driver.findElement(By.cssSelector(".btn-outline-white")).click();
        driver.findElement(By.id("signinEmail")).sendKeys("shulgamanager@gmail.com");
        driver.findElement(By.id("signinPassword")).sendKeys("Fkz12051988");
        driver.findElement(By.cssSelector(".btn-primary:nth-child(2)")).click();
        Thread.sleep(2000);

    }

    @Test
    public void profile() throws InterruptedException {
        this.login();
        driver.findElement(By.cssSelector(".-profile")).click();
        Thread.sleep(350);
        assertThat(driver.findElement(By.cssSelector(".profile_name")).getText(), is("Alyona Shulga"));

    }
    @Test
    public void addAuto() throws InterruptedException{
        this.login();

        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.id("addCarBrand")).click();
        driver.findElement(By.cssSelector("#addCarBrand > :nth-child(2)")).click();
        driver.findElement(By.id("addCarModel")).click();
        driver.findElement(By.cssSelector("#addCarModel > :nth-child(3)")).click();
        driver.findElement(By.id("addCarMileage")).sendKeys("50");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        Thread.sleep(2000);
        assertThat(driver.findElement(By.cssSelector(".car-group")).getText(), is("BMW X5"));
    }
    @Test
    public void addExpenses() throws InterruptedException {
        this.addAuto();

        driver.findElement(By.cssSelector(".car_add-expense")).click();
        driver.findElement(By.id("addExpenseMileage")).sendKeys("150");
        driver.findElement(By.id("addExpenseLiters")).sendKeys("130");
        driver.findElement(By.id("addExpenseTotalCost")).sendKeys("120");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        Thread.sleep(2000);
    }

    @Test
    public void logout() throws InterruptedException {
        this.login();
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
        driver.findElement(By.xpath("//*[text()='Logout']")).click();

    }
}
