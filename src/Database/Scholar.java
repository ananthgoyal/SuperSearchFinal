package Database;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class Scholar {

    private String link;
    private String body;
    public String[] resources;
    public String[] citations;
    public ArrayList<String> citImages;
    public ArrayList<String> images;

    public Scholar(String link) {
        this.link = link;
        resources = new String[10];
        citations = new String[10];
        images = new ArrayList<>();
        citImages = new ArrayList<>();
    }

    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        Scholar scholar = new Scholar("https://scholar.google.com/scholar?q=slave&hl=en&as_sdt=2006");
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
        this.body = browser.getPageSource();
        String temp = "";
        System.out.println(this.body);
        return "";
    }

}
