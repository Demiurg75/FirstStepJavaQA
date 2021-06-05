package firstStep;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //Локатор логина
    @FindBy(id = "navbar_username")
    private WebElement loginField;

    //Локатор пароля
    @FindBy(id = "navbar_password")
    private WebElement passwordField;

    //Локатор кнопки входа
    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td/form/table/tbody/tr/td[3]/input")
    private WebElement submitButton;

    //Ввод логина
    public void inputLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbar_username")));
        loginField.sendKeys(login);
    loginField.sendKeys(Keys.TAB);}

    //Ввод пароля
    public void inputPasswd(String passwd) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbar_password")));
        passwordField.sendKeys(passwd);
    }

    //клик по кнопке "Вход"
    public void clickLoginBtn() {
        submitButton.click(); }
}
