import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TourDeLaGloire extends HentaiHeroesPage {

    public TourDeLaGloire(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"leagues_right\"]/div/div[6]/button")
    private WebElement defi;

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/button[1]")
    private WebElement affronter;

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/button[2]")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"battle_win\"]/button")
    private WebElement ok;

    @FindBy(xpath = "//*[@id=\"leagues_left\"]/div/div[6]/div/div[2]/span[1]")
    private WebElement ptdeDefi;

    public boolean defiNecessaire(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(ptdeDefi));
        if (ptdeDefi.getText().equals("0")) {
            return false;
        } else {
            return true;
        }
    }

    public void lancerDefi(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(defi));
        if (defi.isDisplayed())
        {
            boolean defiAFaire = defiNecessaire(driver);
            if (defiAFaire == true) {
                defi.click();
                WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
                webDriverWait2.until(ExpectedConditions.visibilityOf(affronter));
                affronter.click();
                WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
                webDriverWait3.until(ExpectedConditions.visibilityOf(passer));
                passer.click();
                WebDriverWait webDriverWait4 = new WebDriverWait(driver, 5);
                webDriverWait4.until(ExpectedConditions.visibilityOf(ok));
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ok.click();
                lancerDefi(driver);
            }
        }
    }


}