package Database;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;


public class Trip {
    private String link;
    private String body;
    private String[] resources;


    public Trip(String link){
        this.link = link;
        this.resources = new String[10];
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
        Trip yale = new Trip("https://www.tripdatabase.com/search?criteria=breast+cancer");
        System.out.println(yale.intialRun());

    }


    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebDriver browser = new HtmlUnitDriver();
        browser.get(this.link);
        System.out.println(browser.getPageSource());
        return "";

    }


}

