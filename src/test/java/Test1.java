import Pages.TileSort;
import org.junit.Test;


import static junit.framework.TestCase.assertTrue;


public class Test1 extends BaseTest {
    @Test
    public void lingaroTest1() throws Exception{
        TileSort tileSort = new TileSort(driver);
        driver.get("https://www.smartclient.com/smartgwt/showcase/#featured_tile_filtering");
        tileSort.setAnimal("a");
        tileSort.setMaxLifeSpan(40);
        tileSort.setSorting(1);
        tileSort.ascendingSelect();
        assertTrue(tileSort.countAnimalsDisplayed()>12);
    }

}
