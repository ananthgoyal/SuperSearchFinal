package Database;

public class Phrase {
    private String phrase;


    public Phrase(String phrase){
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public void parse(){
        int location = 0;
        if(phrase.contains(" ")) {
            this.phrase = phrase.replaceAll(" ", "+");
        }
    }

    public void print(){
        System.out.println(this.phrase);
    }
}
