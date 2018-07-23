import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CombatPage extends HentaiHeroesPage{

    public CombatPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#battle_middle > button.green_text_button.redesign")
    private WebElement affronterx1;

    @FindBy(css = "#battle_middle > button.blue_text_button")
    private WebElement passer;

    @FindBy(css = "#battle_win > button")
    private WebElement oki;

    public LastZonePage combattreBoss(WebDriver driver)
    {
        combattre(driver);
        return new LastZonePage(driver);
    }

    public DuelPage combattreDuel(WebDriver driver)
    {
        combattre(driver);
        return new DuelPage(driver);
    }

    public void combattre(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(affronterx1));
        affronterx1.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(passer));
        passer.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(oki));

        try{
        Thread.sleep(750);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }

        oki.click();
    }
}
