import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LastZonePage extends HentaiHeroesPage {

    public LastZonePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[11]")
    private WebElement affronter1;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterEdwarda;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterDonatien;

    public CombatPage openCombatPage(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(affronterDonatien));
        affronterDonatien.click();
        return new CombatPage(driver);
    }

}
