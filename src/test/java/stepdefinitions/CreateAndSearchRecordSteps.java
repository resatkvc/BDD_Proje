package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.EditorPage;
import org.junit.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateAndSearchRecordSteps {
    private WebDriver driver;
    private EditorPage editorPage;
    private String firstName;
    private String lastName;
    private String position;
    private String office;
    private String extn;
    private String startDate;
    private String salary;
    private String baseUrl;
    private Properties props;

    public CreateAndSearchRecordSteps() {
        props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/config.properties"));
            baseUrl = props.getProperty("baseUrl");
            firstName = props.getProperty("firstName");
            lastName = props.getProperty("lastName");
            position = props.getProperty("position");
            office = props.getProperty("office");
            extn = props.getProperty("extn");
            startDate = props.getProperty("startDate");
            salary = props.getProperty("salary");
        } catch (IOException e) {
            throw new RuntimeException("Config dosyası okunamadı!", e);
        }
    }

    @Given("Kullanıcı ana sayfaya gider")
    public void kullanici_ana_sayfaya_gider() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        editorPage = new EditorPage(driver);
    }

    @When("Kullanıcı yeni bir kayıt oluşturur")
    public void kullanici_yeni_bir_kayit_olusturur() {
        editorPage.clickNewButton();
        editorPage.fillForm(firstName, lastName, position, office, extn, startDate, salary);
        editorPage.clickCreateButton();
    }

    @When("Kullanıcı oluşturduğu kaydı arar")
    public void kullanici_olusturdugu_kaydi_arar() {
        editorPage.searchRecord(firstName);
    }

    @Then("Oluşturulan kaydın listede olduğunu doğrular")
    public void olusturulan_kaydin_listede_oldugunu_dogrular() {
        boolean isDisplayed = editorPage.isRecordDisplayed(firstName, lastName);
        Assert.assertTrue("Kayıt listede bulunamadı!", isDisplayed);
        driver.quit();
    }
} 