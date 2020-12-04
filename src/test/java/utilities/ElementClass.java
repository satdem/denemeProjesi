package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElementClass {
    WebDriver driver;
    WebElement element;
    WebDriverWait wait;
    By by;
    By options=By.cssSelector("mat_option[role='option'");

    public static void open(String url){
        new ElementClass().getURL(url);

    }

    public static ElementClass $(WebElement by){
        return new ElementClass();
    }


    public static ElementClass $(By by){
        return new ElementClass();
    }


    public List<WebElement> $$(By by){
       return new ElementClass(by).findsElements();
    }


    private ElementClass(){
        driver=Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,5);
    }
     public ElementClass(By by){
        this();
        this.by=by;
        element= driver.findElement(by);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        element= driver.findElements(by).get(0);
/*
wait.until(ExpectedConditions.presenceOfAllElementsLocated(by));
        element= driver.findElement(by);
*/


    }
    public void getURL(String url){

        driver.get(url);
    }

    public void click(){
        element.click();
    }

    public void presEnter(){
        element.sendKeys(Keys.ENTER);
    }

    public ElementClass presEscape(){
        element.sendKeys(Keys.ESCAPE);
        return this;
    }

    public ElementClass waitUntil(Condition cons, int seconds){
        WebDriverWait w=new WebDriverWait(driver,seconds);
        switch (cons){
            case exist:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                break;
            case appear:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case eneble:
            case visible:
                wait.until(ExpectedConditions.elementToBeClickable(by));
                break;
        }

        return this;

    }

    public ElementClass setValue(String text){
        element.sendKeys(text);
        return this;
    }

    public ElementClass clear(){
        element.clear();
        return this;
    }
    public ElementClass scrollIntoView(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        return this;
    }

    public ElementClass shoulBe(Condition cons){
        switch (cons){
            case exist:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                break;
            case visible:
            case appear:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case eneble:
                wait.until(ExpectedConditions.elementToBeClickable(by));
                break;
        }

        return this;
    }

    public List<WebElement> findsElements(){
        List<WebElement> elements=new ArrayList<WebElement>();
        return driver.findElements(by);
    }

    public WebElement getElement(By by){
       return element;
    }

    public ElementClass selectOption(String text){
        element.click();
        List<WebElement> list=driver.findElements(options);
        for (WebElement e:list) {

            if (e.getText().toLowerCase().contains(text.toLowerCase())){
                e.click();
                break;
            }

        }
        return this;
    }
    public ElementClass selectOption(int option){
        element.click();
        List<WebElement> list=driver.findElements(options);

        if (option<0) option=0;
        if (option>=list.size())  option=list.size()-1;

        $(list.get(option)).click();
        return this;
    }
    public ElementClass selectOption(){
        element.click();
        List<WebElement> list=driver.findElements(options);

        int option=new Random().nextInt(list.size());

        $(list.get(option)).click();
        return this;
    }
}
