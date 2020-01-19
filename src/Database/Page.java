package Database;

public class Page {

    private String text;

    public Page(String text){
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String seperate() throws StringIndexOutOfBoundsException {
        int j = 0;
        String s = "";
        for(int i = 0; i < (text.length()-1); i++){
            s+=(text.substring(i,i+1));
            j++;
            if(j>95){
                if(text.substring(i,i+1).compareTo(" ") == 0) {
                    s+="\n";
                    j = 0;
                }

            }

        }
        return s;
    }
}
