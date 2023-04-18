import java.util.Objects;

public class Dictionary {
    public WordInfo[] wordList;
    public int maxWords;
    public int numWords;

    public Dictionary()
    {
        numWords = 0;
        maxWords = 1500;
        wordList = new WordInfo[maxWords];
    }

    public int search(String key)
    {
        int low = 0;
        int high = numWords-1;
        while(low <= high) {
            int mid = (high + low) / 2;
            if (Objects.equals(wordList[mid].word, key)) return mid;
            if (wordList[mid].word.compareTo(key) > 0){high = mid-1;} // mid comes later in alphabet
            if (wordList[mid].word.compareTo(key) < 0){low = mid+1;}  // mid comes earlier in alphabet
        }
        return -1;
    }

    public void sort(){ // Selection Sort
        for(int x = 0; x < numWords; x++){
            int min = x;
            for(int current = min; current < numWords; current++){
                if(wordList[current].word.compareTo(wordList[min].word) < 0){
                    min = current;
                }
            }
            WordInfo temp = wordList[min];
            wordList[min] = wordList[x];
            wordList[x] = temp;
        }
    }

    public void add(String word)
    {
        if(numWords < maxWords && search(word) == -1){
            WordInfo temp = new WordInfo(word.toLowerCase());
            wordList[numWords] = temp;
            numWords++;
            sort();
        }
    }

    public Boolean add(String word, String definition)
    {
        if(numWords < maxWords && search(word) == -1){
            WordInfo temp = new WordInfo(word.toLowerCase(), definition);
            wordList[numWords] = temp;
            numWords++;
            sort();
            return true;
        }
        return false;
    }

    public Boolean delete(String word){
        if(search(word) != -1){
            wordList[search(word)] = wordList[numWords];
            sort();
            return true;
        }
        return false;
    }

    public Boolean exists(String word){
        return search(word) != -1;
    }

    public String getMeaning(String word){
        if(exists(word)) {
            return wordList[search(word)].definition;
        }
        return "The word you entered doesn't exist.";
    }

    public int getCount(){
        return numWords;
    }

    public String printWordList(){
        String s = "";
        for(int x = 0; x < numWords; x++) {
            s += wordList[x].word + "\n";
        }
        return s;
    }

    public void printDictionary(){
        String s = "";
        for(int x = 0; x < numWords; x++) {
            System.out.println(s += wordList[x].word + ": " + wordList[x].definition + "\n");
        }
    }
} // end of class
