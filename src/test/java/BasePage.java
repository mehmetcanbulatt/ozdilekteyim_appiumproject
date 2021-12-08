import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;



import java.util.List;
import java.util.Random;


import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class BasePage extends BaseTest {

    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        System.out.println(wait + "saniye bekledi !!!!");
        logger.info("5 saniye bekledi");
    }

    @Step("<selectorid> id'li elemente tıkla")
    public void clickByid(String selectorid) {
        appiumDriver.findElement(By.id(selectorid)).click();
        System.out.println(selectorid + "Elementine tıklandı !!!");
        logger.info("Elemente tiklandi");
    }

    @Step("<xpathid> xpath'li elemente tıkla")
    public void clickByXpathid(String id) {
        appiumDriver.findElement(By.xpath(id)).click();
        System.out.println(id + "Elementine tıklandı !!!");
        logger.info("Elemente tiklandi");
    }

    @Step("<id> id'li elemente <text> text değerini yaz")
    public void sendKeysbyid(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(text + "Değeri yazıldı !!!");
        logger.info("Text degeri yazdirildi");
    }

    @Step("<key> id'li element <keyword> text değerini içerdiğni kontrol et")
    public void textContol(String key, String keyword) {

        Assert.assertTrue("Elementi iceriyor", appiumDriver.findElement(By.id(key)).getText().contains(keyword));
        System.out.println("Text degeri kontrol edildi!!!");
    }

    @Step("Sayfa kaydırılır")
    public void scrollByPixel() {
        TouchAction swipe = new TouchAction(appiumDriver).press(PointOption.point(540, 1824)).waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(540, 672)).release().perform();
        logger.info("Sayfa kaydirildi");
    }

    @Step("<selectorXpath> selectorXpath'li elemente random tıkla")
    public void randomSelectProduct(String selectorXpath) {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(selectorXpath));
        Random rnd = new Random();
        int rndInt = rnd.nextInt(elements.size());
        System.out.println("Rasgele urun: " + rnd);
        if (elements.size() > 0) {
            elements.get(rndInt).click();
        }
        else {
            System.out.println("Urun bulunamadi");
        }
        logger.info("Rastgele urun secildi");
    }
    @Step("<key> id'li element <keyword> text değerini içerdiğni doğrula")
    public void getTextControl(String key, String keyword) {
        MobileElement element = appiumDriver.findElement(By.id(key));
        String pageInfo = element.getText();
        System.out.println("Sayfanin text degeri: " + pageInfo);
        Assert.assertEquals("Sayfa acilamadi!!!", pageInfo, keyword);
        System.out.println("Dogru sayfadasiniz!!!");
    }

    @Step("<key> xpathkey'li element <keyword> text değerini içerdiğni doğrula")
    public void getKeyControl(String key, String keyword) {
        MobileElement element = appiumDriver.findElement(By.xpath(key));
        String pageInfo = element.getText();
        System.out.println("Sayfanin text degeri: " + pageInfo);
        Assert.assertEquals("Sayfa acilamadi!!!", pageInfo, keyword);
        System.out.println("Dogru sayfadasiniz!!!");
    }
}




