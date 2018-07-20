import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.html.HTMLInputElement;

public class test {

    WebDriver driver;


    public void test(){

    driver = new ChromeDriver();
    driver.manage().window().fullscreen();
    driver.get("https://www.hentaiheroes.com/");
    driver.findElement(By.id("submitButton")).click();
    driver.switchTo().alert().accept();

    /*selenium.click("//input[@id=\"accepted-emails\"]"); // Confirmation box after this line
if (selenium.isConfirmationPresent())
    String confirmationString = selenium.getConfirmation(); // this line is needed
selenium.keyPressNative("10"); // to press the OK key
selenium.waitForPageToLoad("30000");
System.out.println(confirmationString); // this is not really needed, but used it to simply show the confirmation box message*/
}}
