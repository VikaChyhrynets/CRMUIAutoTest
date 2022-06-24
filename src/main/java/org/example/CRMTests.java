package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMTests {
    private WebDriver driver;

    public CRMTests() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().setSize(new Dimension(746, 824));
    }

    public String authorizationTest() {
        System.out.println("Authorization test has been started...");
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("PRODUCTS")) {
            System.out.println("Target page PRODUCTS is correct");
        } else {
            System.out.println("Target page name is not PRODUCTS");
        }
        return "Authorization test result: Success!";
    }

    public String orderingItemsTest() {
        System.out.println("Items ordering test has been started...");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("YOUR CART")) {
            System.out.println("Target page YOUR CART is correct");
        } else {
            System.out.println("Target page name is not YOUR CART");
        }
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("PRODUCTS")) {
            System.out.println("Target page PRODUCTS is correct");
        } else {
            System.out.println("Target page name is not PRODUCTS");
        }
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("CHECKOUT: YOUR INFORMATION")) {
            System.out.println("Target page CHECKOUT: YOUR INFORMATION is correct");
        } else {
            System.out.println("Target page name is not CHECKOUT: YOUR INFORMATION");
        }
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Vika");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Chyhrynets");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("15-500");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("CHECKOUT: OVERVIEW")) {
            System.out.println("Target page CHECKOUT: OVERVIEW is correct");
        } else {
            System.out.println("Target page name is not CHECKOUT: OVERVIEW");
        }
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("CHECKOUT: COMPLETE!")) {
            System.out.println("Target page CHECKOUT: COMPLETE! is correct");
        } else {
            System.out.println("Target page name is not CHECKOUT: COMPLETE!");
        }
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText().equals("PRODUCTS")) {
            System.out.println("Target page PRODUCTS is correct");
        } else {
            System.out.println("Target page name is not PRODUCTS");
        }
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
        return "Items ordering test result: success";
    }

    public void closeChromeTab() {
        driver.close();
    }

}
