package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditorPage {
    private WebDriver driver;

    public EditorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Yeni kayıt oluşturma butonu
    private By newButton = By.cssSelector("button.buttons-create");
    // Form alanları
    private By firstNameInput = By.id("DTE_Field_first_name");
    private By lastNameInput = By.id("DTE_Field_last_name");
    private By positionInput = By.id("DTE_Field_position");
    private By officeInput = By.id("DTE_Field_office");
    private By extnInput = By.id("DTE_Field_extn");
    private By startDateInput = By.id("DTE_Field_start_date");
    private By salaryInput = By.id("DTE_Field_salary");
    // Create butonu (daha sağlam ve spesifik locator)
    private By createButton = By.xpath("//div[@data-dte-e='form_buttons']//button[normalize-space()='Create']");
    // Search alanı
    private By searchBox = By.cssSelector("input[type='search']");
    // Tablo satırları
    private By tableRows = By.cssSelector("#example tbody tr");

    public void clickNewButton() {
        driver.findElement(newButton).click();
    }

    public void fillForm(String firstName, String lastName, String position, String office, String extn, String startDate, String salary) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(positionInput).sendKeys(position);
        driver.findElement(officeInput).sendKeys(office);
        driver.findElement(extnInput).sendKeys(extn);
        driver.findElement(startDateInput).sendKeys(startDate);
        driver.findElement(salaryInput).sendKeys(salary);
    }

    public void clickCreateButton() {
        driver.findElement(createButton).click();
    }

    public void searchRecord(String keyword) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public boolean isRecordDisplayed(String firstName, String lastName) {
        for (WebElement row : driver.findElements(tableRows)) {
            if (row.getText().contains(firstName) && row.getText().contains(lastName)) {
                return true;
            }
        }
        return false;
    }
} 