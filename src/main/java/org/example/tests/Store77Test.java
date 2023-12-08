package org.example.tests;

import org.example.config.properties.configForProperties.StoreConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Store77Test {
    public static void RegistrationAndSelectionItemTest() throws InterruptedException {
        //Данный класс подтягивает нужную инфу из пропертиес
        StoreConfig config = new StoreConfig();
        String chromeDriverPathStr = config.getChromeDriverPath();
        String specialBrowserPathStr = config.getSpecialBrowserPath();
        String emailStr = config.getEmail();
        String passwordStr = config.getPassword();
        String phoneStr = config.getPhone();

        // Установка пути к драйверу браузера
        System.setProperty("webdriver.chrome.driver", chromeDriverPathStr);

        // Указываем путь к исполняемому файлу специальной версии браузера

        // Создаем объект ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Указываем путь к специальной версии браузера в ChromeOptions
        options.setBinary(specialBrowserPathStr);

        // Установка user-agent
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.9999.999 Safari/537.36");

        // Инициализация экземпляра WebDriver с использованием опций ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

// Установка неявного ожидания на 10 секунд
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

// Открытие страницы
        driver.get("https://store77.net/");

        // Получение заголовка страницы


        // Найти кнопку "Вход" по XPath
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='link_srav']/span[text()='Вход']"));

// Выполнить клик по найденной кнопке
        loginButton.click();
        Thread.sleep(1000);

        // Ввод номера телефона
        WebElement phoneNumberField = driver.findElement(By.name("USER_LOGIN"));
        phoneNumberField.sendKeys(phoneStr);
        Thread.sleep(1000);

// Ввод пароля
        WebElement passwordField = driver.findElement(By.name("USER_PASSWORD"));
        passwordField.sendKeys(passwordStr);
        Thread.sleep(1000);

// Нажатие на кнопку "Войти"
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("form[name='frm_login'] input[name='Login']"));
        loginSubmitButton.click();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://store77.net/");

        // Найти ссылку для открытия модального окна поиска и кликнуть по ней
        WebElement searchLink = driver.findElement(By.xpath("//a[@class='header_multisearch_link']"));
        searchLink.click();
// Ждем, пока модальное окно полностью загрузится (задержка на примере)
        Thread.sleep(2000);

// Найти поле ввода текста в модальном окне поиска
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='ModalMultisearchInput']"));
        searchInput.sendKeys("iPhone 12 128");

// Нажать Enter для выполнения поиска (или используйте кнопку поиска, если она есть)
        searchInput.submit();


        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstSearchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blocks_product']/div[@class='blocks_product_fix_w']/a")));


        firstSearchResult.click();
        Thread.sleep(5000);

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.pages_card__sticky_wrap_content > a")));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToCartButton);

        // Закрытие браузера
        String pageTitle = driver.getTitle();
        System.out.println("Заголовок страницы: " + pageTitle);
        Thread.sleep(5000);
        driver.quit();
    }
}
