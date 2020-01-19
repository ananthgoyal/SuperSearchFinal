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


public class EyeWitness {

    private String link;
    private String body;
    private String[] resources;

    public EyeWitness(String link){
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
        EyeWitness e = new EyeWitness("https://www.google.com/search?q=slave+trade&sa=Search&domains=eyewitnesstohistory.com&sitesearch=eyewitnesstohistory.com");
        System.out.println(e.intialRun());
    }

    public String intialRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException {//initial run
        WebClient webClient = new WebClient(BrowserVersion.CHROME);//initialize web-crawler
        webClient.getOptions().setJavaScriptEnabled(true);
        HtmlPage firstPage = webClient.getPage(link);
        String firstPageContent = firstPage.asText();
        this.body = firstPageContent;
        System.out.println(body);
        for(int i = 0; i < 5; i++){
            resources[i] = this.body.substring(body.indexOf("eyewitnesstohistory.com › "), body.indexOf("1.\n2."));
            this.body = this.body.replaceFirst("eyewitnesstohistory.com › ", "");
            this.body = this.body.replaceFirst("1.\n2.",  "");
            resources[i] = resources[i].replaceFirst("eyewitnesstohistory.com › ", "");
            resources[i] = resources[i].replaceFirst("\n", "");
            resources[i] = resources[i].substring(0, firstIndexOfUCL(resources[i]));
            //resources[i] = resources[i] + ".htm";
            //System.out.println(this.body);
            System.out.println("Source " + resources[i]);

        }
        return secondRun();
    }

    public String secondRun() throws FailingHttpStatusCodeException, MalformedURLException, IOException, JavaScriptException { //second run
        WebClient webClient = new WebClient(BrowserVersion.CHROME); //initialize web-crawler
        webClient.getOptions().setJavaScriptEnabled(true);
        WebDriver browser = new HtmlUnitDriver();
        String rV="";
        for(int i = 0; i < 5; i++){
            resources[i] = "http://www.eyewitnesstohistory.com/" + resources[i] + ".htm";//search resource links
            System.out.println(resources[i]);
            browser.get(resources[i]);//extraction
            Page out = new Page("");
            System.out.println(resources[i]);//failsafe page 404 error
            if(browser.getPageSource().contains("404")){
                if(browser.getPageSource().contains("not found")){
                }
            }
            else
                out = new Page(browser.findElement(By.tagName("body")).getText());//text extraction
            rV += out.seperate();
            rV+="\n\n";
            rV+="--------------------------------------------------------------------------------------------------------------";
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
    public static int firstIndexOfUCL(String str) {
        for(int i=0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }



}

