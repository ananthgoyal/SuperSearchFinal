package Database;

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


public class Ancient {

    private String link;
    private String body;
    public String[] resources;
    public String[] citations;
    public ArrayList<String> citImages;
    public ArrayList<String> images;

    public Ancient(String link) {
        this.link = link;
        resources = new String[10];
        citations = new String[10];
        images = new ArrayList<>();
        citImages = new ArrayList<>();
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
        Ancient ancient = new Ancient("https://www.ancient.eu/search/?q=Slave+Trade&s=Search");
        System.out.println(ancient.intialRun());
        for (int i = 0; i < ancient.images.size(); i++) {
            System.out.println(ancient.images.get(i));
        }
    }

    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebDriver browser = new HtmlUnitDriver();
        browser.get(link);
        this.body = browser.getPageSource();
        String temp = "";

        for (int i = 0; i < 10; i++) {
            temp = this.body.substring(body.indexOf("class=\"content_item") - 100, body.indexOf("class=\"content_item"));
            if (i == 0) {
                temp = temp.replaceFirst("\"", "");
                temp = temp.replaceFirst("\"", "");
                temp = temp.replaceFirst("\"", "");
            }
            temp = temp.substring(temp.indexOf("<a href=\"/") + 10, temp.indexOf("/\""));
            this.body = this.body.replaceFirst("class=\"content_item", "");
            resources[i] = temp;
        }
        return secondRun();
    }

    public String secondRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {

        WebDriver browser = new HtmlUnitDriver();
        String rV = "";
        List<WebElement> holder = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            resources[i] = "http://www.ancient.eu/" + resources[i] + "/";
            String temp = "";
            browser.get(resources[i]);
            String citPart = browser.findElement(By.tagName("body")).getText();
            System.out.println(citPart);
            if (citPart.contains("MLA Style")) {
                citPart = citPart.substring(citPart.indexOf("MLA Style"));
                citPart = citPart.replaceFirst("\n", "");
                citPart = citPart.replaceFirst("\n", "");
                citPart = citPart.substring(9, citPart.indexOf("\n"));
            } else
                citPart = "No Citation";
            citations[i] = citPart;
            if (!resources[i].contains("image")) {
                holder = browser.findElements(By.tagName("blockquote"));
                for (WebElement text : holder) {
                    rV += "\"" + text.getText() + "\"";
                    rV += "\n";
                    rV += "\n";
                    rV += citations[i];
                    rV += "\n";
                    rV += "------------------------------------------------------------------------------------------------------------";
                    rV += "\n";
                }
            } else {
                temp = browser.getPageSource();

                temp = temp.substring(temp.indexOf("<a href=\"/uploads/") + 9, temp.indexOf("<a href=\"/uploads/") + 100);
                temp = temp.substring(0, temp.indexOf("\" t"));
                images.add("http://www.ancient.eu" + temp);
                citImages.add(citations[i]);
            }
        }
        Page page = new Page(rV);
        browser.close();
        return page.seperate();
    }

    public String html2text(String html) {
        Page a = new Page(Jsoup.parse(html).text());
        if (html.contains("<p>"))
            return a.seperate();
        return "";
    }

    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
}