import java.util.HashSet;
import java.util.Scanner;

public class InputReader
{
    private Scanner reader;
    public InputReader()
    {
        reader = new Scanner(System.in);
    }
    public HashSet<String> getInput()
    {
        System.out.print("> ");                  // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase();
        String[] wordArray = inputLine.split(" ");
        
        // add words from array into hashset
        HashSet<String> words = new HashSet<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}