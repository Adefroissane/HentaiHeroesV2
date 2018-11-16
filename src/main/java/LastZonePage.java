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

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[16]")
    private WebElement affronter1;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterEdwarda;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterDonatien;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[7]")
    private WebElement affronterDarkLord;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[7]")
    private WebElement affronterNinja;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[10]")
    private WebElement affronterFinalmecia;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[9]")
    private WebElement affronterGrunt;

    public CombatPage openCombatPage(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(affronter1));
        affronter1.click();
        return new CombatPage(driver);
    }

}
