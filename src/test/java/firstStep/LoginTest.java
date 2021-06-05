package firstStep;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import  org.openqa.selenium.WebDriver;

import  org.openqa.selenium.chrome.ChromeDriver;

/**
Автотест авторизации
 */
public class LoginTest {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;

    /**
     Настройка драйвера для автотеста
     */
    @BeforeClass
    public static void setup()
    {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        //Создание экземпляра драйвера
        driver = new ChromeDriver();
        //Инициализация страницы авторизации
        loginPage = new LoginPage(driver);
        //Инициализация основной страницы
        mainPage = new MainPage(driver);
        //Развернуть на полный экран
        driver.manage().window().maximize();
        //Задержка на выполнение 10 сек
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.PROPERTIES.getProperty("loginPage"));
    }

    @Test
    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = mainPage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user); }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        mainPage.ClickLogout();
        driver.quit(); }
}
