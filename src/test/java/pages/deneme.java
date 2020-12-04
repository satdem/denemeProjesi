package pages;

import org.openqa.selenium.WebDriver;
import utilities.Driver;


public class deneme {
    public static void main(String[] args) {
        WebDriver d;
        d= Driver.getDriver();
        d.get("http://www.google.com");

       /* By searchInput=By.cssSelector("input[id='search_query_top'");
        By searchButton=By.cssSelector("button[name='submit_input'");
        ElementClass ec2=new ElementClass(searchInput);

        ec2.getURL("http://automationpractice.com/index.php");
        ec2.clickTo();*/
    }
}
