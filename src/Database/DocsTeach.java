package Database;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

import java.io.IOException;
import java.net.MalformedURLException;

public class DocsTeach {
    private String link;
    private String body;
    public static String phrase;
    public static String isUS;
    public static String isGeneral;
    public static String isImage;
    public static String isEuro;
    public static String isCartoon;



    public DocsTeach(String link){
        this.link = link;
        isUS = "";
        isGeneral = "";
        isImage = "";
        isEuro = "";
        isCartoon  = "";
    }

    public String getLink() {
        return this.link;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, StringIndexOutOfBoundsException, JavaScriptException {
        //Database.Phrase keyPhrase = new Database.Phrase("Civil war");
        phrase = "civil+war";

        DocsTeach initial = new DocsTeach("https://www.docsteach.org/documents/?filter_searchterm=" + phrase + "&searchType=1&filterEras=&filterDocTypes=&filter_order=&filter_order_Dir=&rt=a5dsCEaYNpQD");
        initial.intialRun();
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < 8; i++) {
            System.out.println("Searching for Document " + (i + 1));
            System.out.println();
            //System.out.println(initial.getBody());
            String temp = initial.getBody().substring(initial.getBody().indexOf("/documents/document/"), initial.getBody().indexOf("/documents/document/") + 100);
            temp = temp.substring(0, temp.indexOf("\""));
            //temp = temp.substring(0, temp.indexOf(".asp"));
            //System.out.println(temp);
            initial.secondRun(temp);
            initial.setBody(initial.getBody().replaceFirst(temp, ""));
            System.out.println("End of Document" + (i + 1));
            System.out.println("---------------------------------------------------------------------");


        }
    }

    public void intialRun() throws  FailingHttpStatusCodeException, MalformedURLException, IOException, StringIndexOutOfBoundsException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        HtmlPage firstPage = webClient.getPage(link);
        String firstPageContent = firstPage.asXml();
        this.body = firstPageContent;
    }

    public String secondRun(String indentifier) throws  FailingHttpStatusCodeException, MalformedURLException, IOException  {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage page = webClient.getPage("https://www.docsteach.org" + indentifier);
        try
        {
            page.executeJavaScript("javascript:animatedcollapse.toggle('doc_transcript')");
            String pageContent = page.asText();

            //String pagePrint = pageContent.substring(pageContent.indexOf("Transcript"), pageContent.indexOf("legal page."));
            Page pagePrint = new Page(pageContent.substring(pageContent.indexOf("Transcript"), pageContent.indexOf("Return to Results")));
            return pagePrint.seperate();

        }
        catch (Throwable JavaScriptException){
            String pageContent = page.asText();
            Page pagePrint = new Page(pageContent.substring(pageContent.indexOf("Archives"), pageContent.indexOf("Return to Results")));
            return pagePrint.seperate();
        }


        //String pagePrint = pageContent.substring(pageContent.indexOf("Transcript"), pageContent.indexOf("legal page."));

        //System.out.println(pagePrint.getText());
    }

}
