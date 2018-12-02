package org.ipam.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner {
    WebDriver driver;

    @BeforeClass

    public void initWebdriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver121.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    @BeforeClass
    public void startUp() {
        driver.get("https://www.booking.com");

    }

    @AfterClass
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
// Я могу найти места на первом этаже, для двоих с ребенком
    public void Chek1() {

        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        field.sendKeys("Минск");
        Assert.assertTrue(field.isDisplayed(), "Нет поля ввода города");

        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/button"));
        field2.click();

           WebElement field3 =
                   driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[4]/td[2]"));
        field3.click();

        WebElement field4 =
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[4]/td[6]"));
        field4.click();

        WebElement fieldCl =
                driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]"));
        fieldCl.click();


        WebElement field5 =
                driver.findElement(By.xpath("//*[@id=\"no_rooms\"]"));
        field5.click();


        WebElement field51 =
                driver.findElement(By.xpath("//*[@id=\"no_rooms\"]/option[1]"));
        field51.click();
     ;


        WebElement field6 =
                driver.findElement(By.xpath("//*[@id=\"group_adults\"]"));
        field6.click();
        Assert.assertTrue(field6.isDisplayed(), "Нет поля выбора количества взрослых");

        WebElement field61 =
                driver.findElement(By.xpath("//*[@id=\"group_adults\"]/option[2]"));
        field61.click();
        Assert.assertTrue(field61.isDisplayed(), "Нет поля выбора числа взрослых");

        WebElement field7 =
                driver.findElement(By.xpath("//*[@id=\"group_children\"]"));
        field7.click();
        Assert.assertTrue(field7.isDisplayed(), "Нет поля выбора количества детей");

        WebElement field71 =
                driver.findElement(By.xpath("//*[@id=\"group_children\"]/option[2]"));
        field71.click();
        Assert.assertTrue(field71.isDisplayed(), "Нет поля выбора числа детей");

        WebElement field8 =
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[4]/select"));
        field8.click();
        Assert.assertTrue(field8.isDisplayed(), "Нет поля выбора возраста одного ребенка");

        WebElement field81 =
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[4]/select/option[4]"));
        field81.click();
        Assert.assertTrue(field81.isDisplayed(), "Нет поля выбора числа лет одного ребенка");

        WebElement field9 =
                driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]"));
        field9.click();
        Assert.assertFalse(field6.isDisplayed(), "Меню выбора состава для поездки не исчезает после нажатия");

        WebElement field10 =
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]"));
        field10.click();


        WebElement field11 =
                driver.findElement(By.xpath("//*[@id=\"filter_price\"]/div[2]/a[1]"));
        field11.click();

        WebElement field12 =
                driver.findElement(By.xpath("//*[@id=\"filter_price\"]/div[2]/a[3]"));
        field12.click();

        WebElement field13 =
                driver.findElement(By.xpath("//*[@id=\"filter_accessible_room_facilities\"]/div[2]/div[1]"));
        field13.click();

        WebElement field14 =
                driver.findElement(By.xpath("//*[@id=\"filter_accessible_room_facilities\"]/div[2]/a[2]/div/span[1]"));
        field14.click();



    }
    // Проверяю как работает строка ввода города, что она пожет перевести в Т9
    @Test(dataProvider = "ss",
            dataProviderClass = Tester.class)
    public void Chek2(String value) {
        driver.get("https://www.booking.com");

        WebElement start =
                driver.findElement(By.name("ss"));
        start.sendKeys("");

        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        field.sendKeys(value);
        WebElement button =
                driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]"));
        button.click();


    }
// Работоспособность распознавания текста в поиске такси
    @Test
    public void Chek3 () {
        driver.get("https://taxi.booking.com/ru-ru/services/chauffeur");

        WebElement fiel =
                driver.findElement(By.xpath("//*[@id=\"pickupLocation\"]"));
        fiel.sendKeys("sdf");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement fiel1 =
                driver.findElement(By.xpath("//*[@id=\"pickupLocation-items\"]/li[2]/a/div"));
        fiel1.click();

        WebElement fiel2 =
                driver.findElement(By.xpath("//*[@id=\"dropoffLocation\"]"));
        fiel2.sendKeys("gfgdf");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement fiel3 =
                driver.findElement(By.xpath("//*[@id=\"dropoffLocation-items\"]/li[2]/a/div"));
        fiel3.click();



        WebElement fiel4 =
                driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[2]/div/form/span/button"));
        fiel4.click();



    }

    @Test //  Проверка наличия элементов при выборе уникальной поездки.
    public void Chek4 () {
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"footer_links\"]/div[3]/ul/li[1]/a"));
                field.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement explicitWait = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[3]/div/div[2]/a/div/header/p")));

        WebElement explicitWait1 = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[3]/div/div[2]/a/div/header")));

        WebElement explicitWait12 = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[3]/div/div[9]")));

        WebElement explicitWait13 = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cross-product-bar\"]/div/span/span")));

        WebElement explicitWait14 = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cross-product-bar\"]/div/a[1]/span")));

        WebElement explicitWait15 = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cross-product-bar\"]/div/a[2]/span")));

        WebElement explicitWait16 = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cross-product-bar\"]/div/a[3]/span")));

        WebElement explicitWait7 = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"add_property_topbar\"]/a/div/span")));

        WebElement explicitWait8 = (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_tt_holder_3\"]/div/span")));

        WebElement explicitWait9 = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_tt_holder_4\"]/div/span")));

        WebElement explicitWait10 = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_tt_holder_2\"]/img")));

        WebElement explicitWait11 = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_tt_holder_1\"]")));

        WebElement explicitWait18 = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"logo_no_globe_new_logo\"]")));
    }
    @Test //Узнать как работает перевод на другой язык
    public void Chek5 (){

        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"b_tt_holder_1\"]/img"));
        field.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement explicitWait = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_tt_holder_1\"]/img")));

    }
    @Test //Узнать как работает кнопка с валютами
    public void Chek6 (){
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"b_tt_holder_2\"]"));
        field.click();

        WebElement explicitWait = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_tt_holder_2\"]")));

    }

    @Test //Посмотреть условия договора, а в нем поплыли строки, но я не знаю как это зафиксировать.
    public void Chek7 () {
            WebElement field =
                    driver.findElement(By.xpath("//*[@id=\"footer_links\"]/div[5]/ul/li[8]/a"));
            field.click();

        WebElement field1 =
                driver.findElement(By.xpath("//*[@id=\"b2contentPage\"]/div[4]/div/a[1]"));
        field1.click();

    }



}
