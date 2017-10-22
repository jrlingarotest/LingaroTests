package Pages;

import net.sourceforge.htmlunit.corejs.javascript.EcmaError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TileSort extends PageObject {
    @FindBy(name="commonName")
    private WebElement animalName;

    @FindBy(css = ".normal[eventproxy=\"isc_SliderItem_3_slider_thumb\"]")
    private WebElement maxLifespanScroll;

    @FindBy(className = "hSliderValue")
    private WebElement maxLifeSpanVisibleValue;

    @FindBy(css = "[eventproxy=\"sortForm\"] .selectItemLiteText")
    private WebElement sortBy;

    @FindBy(css = "[eventpart=\"valueicon\"]")
    private WebElement ascendingCheckBox;


    @FindBys(@FindBy(css=".simpleTile"))
    private List<WebElement> animalsTiles;

    @FindBys(@FindBy(css = ".simpleTile[style*=\"visibility: hidden;\"]"))
    private List<WebElement> animalTilesHidden;

    private String sortingStableID = "#isc_PickListMenu_0_row_";

    public TileSort(WebDriver driver) {
        super(driver);
    }

    public void setAnimal(String text){
        animalName.sendKeys(text);
    }

    public void setMaxLifeSpan(int maxLifeSpan)throws Exception {
        if (Integer.parseInt(maxLifeSpanVisibleValue.getText()) < maxLifeSpan) throw new Exception("Lifespan to large");
        if (Integer.parseInt(maxLifeSpanVisibleValue.getText()) > maxLifeSpan) {
            Actions actions = new Actions(driver);
            while (Integer.parseInt(maxLifeSpanVisibleValue.getText()) > maxLifeSpan) {
                actions.dragAndDropBy(maxLifespanScroll, -5, 0).build().perform();
            }
        }
    }

    public void setSorting(int index){
        sortBy.click();
        driver.findElement(By.cssSelector(sortingStableID+index)).click();

    }

    public void ascendingSelect(){
        ascendingCheckBox.click();
    }

    public int countAnimalsDisplayed(){
        return animalsTiles.size()-animalTilesHidden.size();
    }

}

