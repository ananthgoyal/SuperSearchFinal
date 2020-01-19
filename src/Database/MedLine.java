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


public class MedLine {
    private String link;
    private String body;
    private String[] resources;

    public MedLine(String link){
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

    public static void main(String[] args)  throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        MedLine medLine = new MedLine("https://vsearch.nlm.nih.gov/vivisimo/cgi-bin/query-meta?query=skin+cancer&v%3Aproject=nlm-main-website");
        System.out.println(medLine.intialRun());
    }


    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {//initial run
        WebDriver browser = new HtmlUnitDriver();
        browser.get(this.link);
        this.body = browser.getPageSource();
        String finalTag = ".htm";
        System.out.println(browser.getPageSource());
        for(int i = 0; i < 5; i++){
            resources[i] = this.body.substring(this.body.indexOf("span class=\"url\">"),this.body.indexOf("span class=\"url\">")+200);
            if(resources[i].contains("html")){
                finalTag  = ".html";
            }
            if(!resources[i].contains(".htm")){
                System.out.println("not");
            }
            else {
                resources[i] = this.resources[i].substring(this.resources[i].indexOf("https"), this.resources[i].indexOf(finalTag));
                resources[i] = this.resources[i] + finalTag;
                this.body = this.body.replaceFirst("span class=\"url\">", "");
                this.body = this.body.replaceFirst("</span>", "");
                System.out.println(resources[i]);
                finalTag = ".htm";
            }
        }

       //System.out.println(firstPageContent);
        return secondRun();
    }

    public String secondRun() throws  FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException {
        WebDriver browser = new HtmlUnitDriver();
        String rV = "";
        for(int i = 0; i < 5; i++){
            if(resources[i].contains(".htm")) {
                browser.get(resources[i]);
                Page out = new Page(browser.findElement(By.tagName("body")).getText());
                rV += out.getText();
                rV += "-------------------------------------------------------------------------------------------------------";
            }
        }
        return rV;
    }
}
