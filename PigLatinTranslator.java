
import java.util.*;
import java.util.stream.*;

public class PigLatinTranslator {
    private static List<String> vowels = Arrays.asList("a","e","i","o","u","xr","yt");
    private static List<String> special_consenants = Arrays.asList("qu","squ");

    private static String convertConsenant(String word) {
        int end = endOfConsenant(word);
        return word.substring(end, word.length()) + word.substring(0, end) + "ay";
    }

    private static boolean startsWithVowel(String word) {
        for (int i = 0; i < vowels.size(); i++) {
            if (word.startsWith(vowels.get(i))) {
                return true;
            }
        } 
        return false;
    }

    private static boolean isConsenant(char letter) {
        String str_letter = Character.toString(letter);
        return !vowels.contains(str_letter) && !str_letter.equals("y");
    }

    private static int endOfConsenant(String word) {
        for (int i = 0; i < special_consenants.size(); i++) {
            if (word.startsWith(special_consenants.get(i))) {
                return special_consenants.get(i).length();
            }
        }
        int i = 0;
        while (i < word.length() && isConsenant(word.charAt(i))) {
            i++;
        }
        return i;        
    }

    private static String translate(String phrase) {
        String[] word_array = phrase.split(" ");
        String translated = Arrays.asList(word_array).stream()
        .map(word -> startsWithVowel(word) ? word + "ay" : convertConsenant(word))
        .reduce("", (result, i) -> result + " " + i);
        return translated.substring(1, translated.length());
    }
    public static void main(String[] args) {
        System.out.println(translate(String.join(" ",args)));
    }

}