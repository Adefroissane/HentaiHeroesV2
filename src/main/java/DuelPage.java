import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuelPage extends HentaiHeroesPage {
    public DuelPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"arena\"]/div[1]/div[2]/div[3]")
    private WebElement mesPV;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(3) > div.opponents_ego")
    private WebElement PVAdversaire2;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(2) > div.opponents_ego")
    private WebElement PVAdversaire1;

    @FindBy(css = "#arena > div.base_block.opponents_arena > div:nth-child(4) > div.opponents_ego")
    private WebElement PVAdversaire3;

    public boolean victoirePossible(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(PVAdversaire2));
        String plouf = mesPV.getText();
        System.out.println("le texte = " + plouf );
        return true;

    }
}
