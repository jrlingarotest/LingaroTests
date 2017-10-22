import Pages.DropdownGrid;
import Pages.TileSort;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class Test2 extends BaseTest {
    @Test
    public void lingaroTest2() throws Exception{
        DropdownGrid dropdownGrid = new DropdownGrid(driver);
        driver.get("https://www.smartclient.com/smartgwt/showcase/#featured_dropdown_grid_category");
        dropdownGrid.clickDropdown();
        dropdownGrid.selectFromGrid("exercise","Ea",1.1);
        //Added just to be able to see the result:
        Thread.sleep(5000);
    }

}
