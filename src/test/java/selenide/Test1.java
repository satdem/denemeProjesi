package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.*;

import java.util.concurrent.locks.Condition;

public class Test1 {
    public static void main(String[] args) {
        Configuration.startMaximized=true;
        Configuration.browserSize="800x730";

        open("");


    }
}
