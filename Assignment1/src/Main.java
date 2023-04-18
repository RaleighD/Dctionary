import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        int UserSelection = 0;


        try {
            File wordList = new File("/Users/raleighdesmond/Documents/GBC/Winter 2023/Data Structuresw/Assignment1/src/wordList.txt");
            Scanner myReader = new Scanner(wordList);
            while (myReader.hasNextLine()) {
                String words = myReader.nextLine();
                dictionary.add(words);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Welcome to the Abridged English Dictionary.\n" +
                    "The only dictionary that contains some words you might want to use.\n" +
                    "Please select an option below.\n" +
                    "1. Add a New Word\n" +
                    "2. Delete a Word\n" +
                    "3. Get a Definition\n" +
                    "4. Dictionary List\n" +
                    "5. Spell Check a text File\n" +
                    "6. Exit\n");
            UserSelection = scanner.nextInt();
            scanner.nextLine();

            switch (UserSelection) {
                case 1:
                    System.out.println("Please enter the word:");
                    String newWord = scanner.nextLine();
                    System.out.println("Please enter the definition:");
                    String newDef = scanner.nextLine();
                    if (dictionary.add(newWord, newDef) == true) {
                        System.out.println(newWord + " successfully added.\n");
                    }
                    break;

                case 2:
                    System.out.println("Please enter the word you would like to delete:");
                    String delWord = scanner.nextLine();
                    if (dictionary.delete(delWord) == true) {
                        System.out.println(delWord + " successfully deleted.");
                    }
                    break;

                case 3:
                    System.out.println("Please enter a word:");
                    String defWord = scanner.nextLine();
                    System.out.println(dictionary.getMeaning(defWord));
                    break;

                case 4:
                    System.out.println(dictionary.printWordList());
                    break;

                case 5:
                    String text = "";
                    System.out.println("Please enter the absolute path of file.");
                    String userFile = scanner.nextLine();
                    try {
                        File file = new File(userFile);
                        Scanner inputFile = new Scanner(file);
                        while (inputFile.hasNextLine()) {
                            text += inputFile.nextLine();
                        }
                        inputFile.close();
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    System.out.println("The following words were spelled incorrectly:");
                    String[] substrings = text.split("\s");
                    for(int i = 0; i < substrings.length; i++ ){
                        if(dictionary.exists(substrings[i]) == false)
                        {
                            System.out.println(substrings[i]);
                        }
                    }
                    System.out.println();
                    break;


                case 6:
                    break;

            } // end of switch
        } // end of main args
    } // end of program
}
