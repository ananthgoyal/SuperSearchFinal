package Database;


import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.SyncFailedException;
import java.util.List;
import com.gargoylesoftware.htmlunit.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
public class Medscape {
    private String link;
    private String body;
    private String[] resources;


    public Medscape(String link) {
        this.link = link;
        resources = new String[10];
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLink() {
        return link;
    }

    public String getBody() {
        return body;
    }

    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        Medscape yale = new Medscape("https://search.medscape.com/search/?q=breast%20cancer&");
        System.out.println(yale.intialRun());

    }

    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebDriver browser = new HtmlUnitDriver();
        browser.get(link);
        this.body = browser.getPageSource();
        System.out.println(this.body);
        for(int i=0; i < 10; i++){
            this.resources[i] = this.body.substring(this.body.indexOf("clientUrl\":\"")-200, this.body.indexOf("clientUrl\":\"")+100);
            // if(!this.resources[i].contains("Similar articles")){
            this.resources[i] = this.resources[i].substring(this.resources[i].indexOf("\"],\"clientUrl\":\"") + 16, this.resources[i].indexOf(",\"content")-1);
            System.out.println(this.resources[i]);
            // }
            this.body = this.body.replaceFirst("clientUrl\":\"", "");
        }

        return secondRun();
    }

    public String secondRun() throws  FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        WebDriver browser = new HtmlUnitDriver();
        String rV = "";
        for(int i = 0; i < 10; i++){
            browser.get("www.medscape.org" + resources[i]);

            Page out = new Page(browser.findElement(By.tagName("body")).getText());
            rV+=out.getText();
            rV+="-------------------------------------------------------------------------------------------------------";
        }
        return rV;
    }
}
