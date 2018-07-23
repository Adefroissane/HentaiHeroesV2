import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuelPage extends HentaiHeroesPage {
    public DuelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"arena\"]/div[1]/div[2]/div[3]")
    private WebElement mesPV;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[1]/div[2]")
    private WebElement PVAdversaire1;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[2]/div[2]")
    private WebElement PVAdversaire2;


    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[3]/div[2]")
    private WebElement PVAdversaire3;

    public CombatPage duel(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(mesPV));
        String plif = mesPV.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        plouf.delete(0, 3);
        String plof = plouf.toString();
        int pvDuHeros = Integer.parseInt(plof);
        System.out.println("PV = " + pvDuHeros);

        String plif2 = PVAdversaire1.getText();
        String plaf2 = plif2.replaceAll("\\s", "");
        StringBuffer plouf2 = new StringBuffer(plaf2);
        plouf2.delete(0, 3);
        String plof2 = plouf2.toString();
        int pvDuMechant1 = Integer.parseInt(plof2);
        System.out.println("PV = " + pvDuMechant1);

        String plif3 = PVAdversaire2.getText();
        String plaf3 = plif3.replaceAll("\\s", "");
        StringBuffer plouf3 = new StringBuffer(plaf3);
        plouf3.delete(0, 3);
        String plof3 = plouf3.toString();
        int pvDuMechant2 = Integer.parseInt(plof3);
        System.out.println("PV = " + pvDuMechant2);

        String plif4 = PVAdversaire3.getText();
        String plaf4 = plif3.replaceAll("\\s", "");
        StringBuffer plouf4 = new StringBuffer(plaf4);
        plouf4.delete(0, 3);
        String plof4 = plouf4.toString();
        int pvDuMechant3 = Integer.parseInt(plof4);
        System.out.println("PV = " + pvDuMechant3);
        try {
            if (PVAdversaire1.isDisplayed()) {
                if (pvDuHeros >= pvDuMechant1) {
                    PVAdversaire1.click();
                    return new CombatPage(driver);
                }
            } else if (PVAdversaire2.isDisplayed()) {
                if (pvDuHeros >= pvDuMechant2) {
                    PVAdversaire2.click();
                    return new CombatPage(driver);
                }
            } else if (PVAdversaire3.isDisplayed()) {
                if (pvDuHeros >= pvDuMechant3) {
                    PVAdversaire3.click();
                    return new CombatPage(driver);
                }
            }
            return null;
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }
}
