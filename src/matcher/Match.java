package matcher;


import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

public class Match {
    public static void matching(String phrase, String regEx){
        List<Integer> matchingList = indexMatching(phrase, regEx);

        for (int matchingListIndexPosition = 0; matchingListIndexPosition < matchingList.size(); matchingListIndexPosition++) {
            System.out.print(phrase.substring(matchingList.get(matchingListIndexPosition), matchingList.get(matchingListIndexPosition)+regEx.length())+"; ");
        }

    }

    public static List<Integer> indexMatching(String phrase, String regEx){
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

    public static int operandCounter(char operand, String regEx){
        char[] phraseArray = regEx.toCharArray();
        int counter=0;

        for (Character wildcardOperator:phraseArray
        ) {
            if (wildcardOperator.equals(operand)){
                counter++;
            }
        }
        System.out.println("counter ist gleich: "+counter);

        return counter;
    }

    public static int lengthOfNotEmptySide(String leftSide, String rightSide){
        if (rightSide.isEmpty()){
            return leftSide.length();
        }
        else {
            return rightSide.length();
        }
    }
}
