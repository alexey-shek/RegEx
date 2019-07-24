package matcher;


import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

public class Match {

    public static List<Integer> matchWithDots(String phrase,String regex){
        String[] textSections = regex.split("\\.");
        List<Integer> result = new ArrayList<>();

        for (int section = 0; section < textSections.length; section++) {
            result.add(findStringInOtherString(textSections[section], phrase));
        }
        return result;
    }


    public static List<String> match(String phrase,String regex){
        List<String> result = new ArrayList<>();
        String text = phrase;
        int stringposition;
        do {
            stringposition = findStringInOtherString(regex,text);
            if (stringposition < 0){
                break;
            }
            result.add(regex);
            text = text.substring(stringposition + regex.length());
        } while ( true);
        return result;
    }



    private static int findStringInOtherString(String string,String otherString){
        if (string == null || otherString == null){
            return -1;
        }
        return otherString.indexOf(string);
    }

    //----------------------------------------------------------------

    public static void matching(String phrase, String regEx){
        List<Integer> matchingList = indexMatching(phrase, regEx);

        for (int matchingListIndexPosition = 0; matchingListIndexPosition < matchingList.size(); matchingListIndexPosition++) {
            if (regEx.contains("(") || regEx.contains(")")){
                System.out.print(phrase.substring(matchingList.get(matchingListIndexPosition),matchingList.get(matchingListIndexPosition)+1)+"; ");
            }
            else
            System.out.print(phrase.substring(matchingList.get(matchingListIndexPosition), matchingList.get(matchingListIndexPosition)+regEx.length())+"; ");
        }

    }

    public static List<Integer> indexMatching(String phrase, String regEx){
        List<Integer> matchingList = new ArrayList<>();

        if (phrase.contains(regEx)){
            for (int indexInPhrase = 0; indexInPhrase < phrase.length(); indexInPhrase++) {
                if (indexInPhrase+regEx.length()>phrase.length()){
                    break;
                }
                else if (phrase.substring(indexInPhrase,indexInPhrase+regEx.length()).equals(regEx)){
                    matchingList.add(indexInPhrase);
                }
            }
        }
        else if (regEx.contains(".") && !regEx.contains("(")){
            System.out.println("Wildcard . found");
            int counter = operandCounter('.',regEx);
            String leftSideOfRegEx = substringBefore(regEx, ".");
            String rightSideOfRegEx = substringAfter(regEx, ".").replaceAll("\\.","");
            System.out.println("left side of regex "+leftSideOfRegEx);
            System.out.println("right side of regex "+rightSideOfRegEx);


            for (int indexInPhrase = 0; indexInPhrase < phrase.length()-lengthOfNotEmptySide(leftSideOfRegEx, rightSideOfRegEx)-counter; indexInPhrase++) {
                System.out.println("right side is empty: "+rightSideOfRegEx.isEmpty()+" compare: "+phrase.substring(indexInPhrase, indexInPhrase+leftSideOfRegEx.length())+" to "+leftSideOfRegEx);

                if (indexInPhrase+rightSideOfRegEx.length() > phrase.length()){
                    break;
                }
                else if (phrase.substring(indexInPhrase,indexInPhrase+leftSideOfRegEx.length()).equals(leftSideOfRegEx) &&
                        phrase.substring(indexInPhrase+leftSideOfRegEx.length()+counter,indexInPhrase+rightSideOfRegEx.length()+counter+1).equals(rightSideOfRegEx)){
                    matchingList.add(indexInPhrase);
                    System.out.println(matchingList);
                }
                else if (rightSideOfRegEx.isEmpty() && phrase.substring(indexInPhrase, indexInPhrase+leftSideOfRegEx.length()).equals(leftSideOfRegEx)){
                    matchingList.add(indexInPhrase);
                    System.out.println("right side is empty");
                }
                else if (leftSideOfRegEx.isEmpty() && phrase.substring(indexInPhrase, indexInPhrase+rightSideOfRegEx.length()+counter-1).equals(rightSideOfRegEx)){
                    matchingList.add(indexInPhrase-1);
                    System.out.println("left side is empty");
                }
                else {
                    continue;
                }
            }
        }
        else if (!regEx.contains(".") && regEx.contains("(")){
            System.out.println("nur ( enthalten");
            String afterBracket = substringAfter(regEx,"(");
            String bracketContent = substringBefore(afterBracket,")");
            System.out.println(bracketContent);

            for (int indexInPhrase = 0; indexInPhrase < phrase.length(); indexInPhrase++) {
                if (indexInPhrase+bracketContent.length() > phrase.length()){
                    break;
                }
                else if (phrase.substring(indexInPhrase, indexInPhrase+bracketContent.length()).equals(bracketContent) ){
                    System.out.println("compare: "+phrase.substring(indexInPhrase, indexInPhrase+bracketContent.length())+" and "+bracketContent);
                    if (phrase.substring(indexInPhrase-bracketContent.length(), indexInPhrase-bracketContent.length()+1).equals(substringBefore(regEx, "(")) &&
                            phrase.substring(indexInPhrase+bracketContent.length(), indexInPhrase+bracketContent.length()+1).equals(substringAfter(regEx, ")"))){
                        matchingList.add(indexInPhrase);
                        System.out.println(matchingList);
                    }
                    else {
                        System.out.println("no match");

                    }

                }
            }

        }
        else if (regEx.contains(".") && regEx.contains("(")){
            System.out.println(". und ( sind enthalten");
        }
        else {
            System.out.println("No matchings found!");
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
        System.out.println("counter is: "+counter);

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

    public static List<Integer> wildcardMatch(String phrase, String regEx){
        List<Integer> wildcardMatchList = new ArrayList<>();
        if (phrase.charAt(0)=='.'){
            for (int phraseIndex = 0; phraseIndex < phrase.length(); phraseIndex++) {
                if (substringAfter(regEx, ".").equals(phrase.substring(phraseIndex, phraseIndex+regEx.length()+operandCounter('.', regEx)))){
                    wildcardMatchList.add(phraseIndex);
                    System.out.println("Match on: "+wildcardMatchList);
                }
            }
        }

        return wildcardMatchList;
    }
}
