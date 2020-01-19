package Database;

import Database.Ancient;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import com.gargoylesoftware.htmlunit.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class FindLaw {

    private String link;
    private String body;
    public String[] resources;
    public String[] citations;
    public ArrayList<String> citImages;
    public ArrayList<String> images;

    public FindLaw(String link) {
        this.link = link;
        resources = new String[10];
        citations = new String[10];
        images = new ArrayList<>();
        citImages = new ArrayList<>();
    }

    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        FindLaw scholar = new FindLaw("https://codes.findlaw.com/LCsearch.html#?cludoquery=" +
                "slave&cludoCategory=Codes&cludopage=1&cludorefurl=https%3A%2F%2Fc" +
                "aselaw.findlaw.com%2F&cludorefpt=Caselaw%3A%20Cases%20and%20Codes%20-%20FindLaw%20" +
                "Caselaw&cludorefact=slave&cludorefaci=1");
        System.out.println(scholar.intialRun());
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


    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebDriver browser = new HtmlUnitDriver();
        browser.get(link);
        this.body = browser.getCurrentUrl();
        String temp = "";
        Page out = new Page(browser.getCurrentUrl());
        System.out.println(out.seperate());
        return out.seperate();
    }

}
