package page_objects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class AddStudentPage {

    private final WebDriver driver = DriverManager.getInstance();
    private final WebDriverWait webDriverWait;
    private final Faker faker = new Faker();

    public AddStudentPage() {
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "name")
    WebElement nameField;

    @FindBy(how = How.ID, using = "gender")
    WebElement genderDropDown;

    @FindBy(how = How.ID, using = "email")
    WebElement emailField;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-form-item-control-input-content']//button")
    WebElement submitButton;

    public String waitAndSetValueForNameField(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
        return name;
    }

    public void waitAndSetGender(String gender) {
        genderDropDown.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='" + gender.toUpperCase() + "']")));
        driver.findElement(By.xpath("//div[@title='" + gender.toUpperCase() + "']")).click();
    }

    public void waitAndSetValueForEmailField() {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(faker.internet().emailAddress());
    }

    public void clickOnSubmitButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }
}