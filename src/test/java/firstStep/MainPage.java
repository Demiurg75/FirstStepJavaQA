package firstStep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //Локатор пользователя
    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td/div/a[2]/span/img")
    private WebElement user;

    //Локатор кнопки Выход
    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td/div/a[3]")
    private WebElement logOut;

    //Локатор имени
    @FindBy(xpath = "/html/body/div[2]/div/div/table[2]/tbody/tr/td[2]/div/strong/a")
    private WebElement userName;



    /**
     * клик по картинке пользователя (для того чтоб перейти в окно пользователя)
     */
    public void clickOnUserAfterLogin() {
        user.click(); }

    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/table[2]/tbody/tr/td[2]/div/strong/a")));
        String UserName = userName.getText();
        return UserName; }

    /**
     * метод для выхода
     */
    public void ClickLogout(){
        logOut.click();
    }

}
