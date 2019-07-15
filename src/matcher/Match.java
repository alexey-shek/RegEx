package matcher;


import java.util.ArrayList;
import java.util.List;

public class Match {
    public static void matching(String phrase, String regEx){
        List<Integer> matchingList = new ArrayList<>();
        matchingList= firstIndexMatching(phrase, regEx);

        for (int matchingListIndexPosition = 0; matchingListIndexPosition < matchingList.size(); matchingListIndexPosition++) {
            System.out.print(phrase.substring(matchingList.get(matchingListIndexPosition), matchingList.get(matchingListIndexPosition)+regEx.length())+"; ");
        }

    }

    public static List<Integer> firstIndexMatching(String phrase, String regEx){
        List<Integer> matchingList = new ArrayList<>();

        for (int letterInPhrase = 0; letterInPhrase < phrase.length(); letterInPhrase++) {
            if (letterInPhrase+regEx.length()>phrase.length()){
                break;
            }
            else if (phrase.substring(letterInPhrase,letterInPhrase+regEx.length()).equals(regEx)){
                matchingList.add((letterInPhrase));
            }
        }
        return matchingList;
    }

}
