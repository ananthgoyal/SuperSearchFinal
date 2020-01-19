package Database;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.jsoup.Jsoup;
//Links:
//https://jar-download.com/artifacts/org.seleniumhq.selenium/htmlunit-driver/2.32.1/source-code
//https://jsoup.org/download
public class TestDatabase {

    private String link;
    private String body;
    private String[] resources;

    public TestDatabase(String link){
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


    public static void main(String[] args)  throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        TestDatabase yale = new TestDatabase("https://www.google.com/search?domains=yale.edu&sitesearch=avalon.law.yale.edu%2F&q=slave+trade&x=0&y=0");
        System.out.println(yale.intialRun());

    }
    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        HtmlPage firstPage = webClient.getPage(link);
        String firstPageContent = firstPage.asXml();
        this.body = firstPageContent;
        this.body = this.body.substring(this.body.indexOf("Search Results"));
        for(int i = 0; i < 9; i++){
            if((body.contains("<a href=")) && (body.contains(".asp\""))) {
                resources[i] = this.body.substring(body.indexOf("<a href="), body.indexOf(".asp\""));
                this.body = this.body.replaceFirst("<a href=", "");
                this.body = this.body.replaceFirst(".asp\"", "");
                resources[i] = resources[i].replaceFirst("<a href=", "");
                resources[i] = resources[i].replaceFirst("\"", "");
            }
            else
                resources[i] = "none";
            System.out.println(resources[i]);
        }
        return secondRun();
    }

    public String secondRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        HtmlPage firstPage = webClient.getPage(link);
        WebDriver browser = new HtmlUnitDriver();
        String rV="";
        for(int i = 0; i < 9; i++){
            System.out.println(resources[i]);
            if(!resources[i].equals("none")) {
                resources[i] += ".asp";
                browser.get(resources[i]);
                Page out = new Page(browser.findElement(By.tagName("body")).getText());
                rV += out.seperate();
            }
            rV+="\n\n";
            rV+="-----------------------------------------------------------------" +
                    "---------------------------------------------";
            rV+="\n";
            rV+="\n";
        }
        browser.close();
        return rV;
    }

    public String  html2text(String html) {
        Page a = new Page( Jsoup.parse(html).text());
        if(html.contains("<p>"))
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
