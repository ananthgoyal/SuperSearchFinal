package Database;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import com.gargoylesoftware.htmlunit.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class PubMed {
    private String link;
    private String body;
    private String[] resources;

    public PubMed(String link){
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

    public static void main(String[] args)  throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        PubMed yale = new PubMed("https://www.ncbi.nlm.nih.gov/pubmed/?term=breast+cancer");
        System.out.println(yale.intialRun());

    }

    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebDriver browser = new HtmlUnitDriver();
        browser.get(link);
        this.body = browser.getPageSource();
        //System.out.println(this.body);
        for(int i=0; i < 10; i++){
            this.resources[i] = this.body.substring(this.body.indexOf("ref=\"ordinalpos")-200, this.body.indexOf("ref=\"ordinalpos")+100);
            if(!this.resources[i].contains("Similar articles")){
                this.resources[i] = this.resources[i].substring(this.resources[i].indexOf("<a href=\"") +9, this.resources[i].indexOf("<a href=\"")+25);
                this.resources[i] = this.resources[i].substring(0, 16);
            }
            this.body = this.body.replaceFirst("ref=\"ordinalpos", "");

        }

        return secondRun();
    }

    public String secondRun() throws  FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        WebDriver browser = new HtmlUnitDriver();
        String rV = "";
        for(int i = 0; i< 10; i++){
            if(!this.resources[i].contains("Similar articles")) {
                browser.get("https://www.ncbi.nlm.nih.gov" + resources[i]);
                Page out = new Page(browser.findElement(By.tagName("body")).getText());
                rV += out.getText();
                rV += "-------------------------------------------------------------------------------------------------------";
            }

        }
        return rV;
    }


}


