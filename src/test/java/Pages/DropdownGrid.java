package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class DropdownGrid extends PageObject {
    @FindBys(@FindBy (css = "label"))
    private List<WebElement> labels;

    private static final String selectionsCss = "[id*=\"isc_PickListMenu_0_row_\"]";

    @FindBys(@FindBy (css = selectionsCss))
    private List<WebElement> selections;

    @FindBy(css = "[eventproxy=\"isc_PickListMenu_0_body_vscroll_thumb\"]")
    private WebElement scrollBar;

    private String unitsCSS="td:nth-child(2)>div";

    private String unitCostCSS = "td:nth-child(3)>div";


    public DropdownGrid(WebDriver driver) {
        super(driver);
    }

    public void selectFromGrid(String nameContent, String unitContent, double unitCostMin){
        Boolean found = Boolean.FALSE;
        while (Boolean.TRUE) {
            for (WebElement e : selections) {
                if (e.getText().toLowerCase().contains(nameContent)) {
                    if (e.findElement(By.cssSelector(unitsCSS)).getText().contains(unitContent)) {
                        if (Double.valueOf(e.findElement(By.cssSelector(unitCostCSS)).getText()) > unitCostMin) {
                            System.out.println("Selected: "+e.getText());
                            e.click();
                            found = Boolean.TRUE;
                            break;
                        }
                    }
                }

            }
            if(found)break;
            Actions actions = new Actions(driver);
            actions.dragAndDropBy(scrollBar, 0, 5).build().perform();
            selections = driver.findElements(By.cssSelector(selectionsCss));

        }
    }

    public void clickDropdown(){

        for(WebElement e:labels){
            if(e.getText().equals("Item")){
                e.findElement(By.xpath("../..")).click();
                break;
            }
        }
    }

}
