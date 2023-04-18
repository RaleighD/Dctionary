public class WordInfo {
    public String word;
    public String definition;


    public WordInfo(String word){
        this.word = word;
        definition = "Undefined word";
    }

    public WordInfo(String word, String definition){
        this.word = word;
        this.definition = definition;
    }
}

