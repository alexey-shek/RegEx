package matcher;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {

    public static List<String> matchWithDots(String phrase,String regex){
        List<String> partResult = new ArrayList<>();
        List<String> result = new ArrayList<>();



        partResult=dotSubstring(regex);
        System.out.println(partResult);

        return result;
    }

    private static List<String> dotSubstring(String regex){
        List<String> result = new ArrayList<>();
        StringBuilder tempResult = new StringBuilder();
        int dotCount = 0;

        for (int regexCharPosition = 0; regexCharPosition < regex.length(); regexCharPosition++) {

            if (regex.charAt(regexCharPosition)=='.'){
                while (regex.charAt(regexCharPosition)=='.'){
                    dotCount++;
                    System.out.println("position: "+regexCharPosition+" dotcount: "+dotCount);
                    regexCharPosition++;

                }
                regexCharPosition--;
            }

            if (regex.charAt(regexCharPosition)!='.' && dotCount==0){
                tempResult.append(regex.charAt(regexCharPosition));
                System.out.println("temp: "+tempResult);
            }
            if (regex.charAt(regexCharPosition)!='.' && dotCount>0){
                System.out.println(regexCharPosition);
                tempResult.append(convertToDots(dotCount));
                result.add(tempResult.toString());
                dotCount=0;
                tempResult.delete(0, regex.length());
                tempResult.append(regex.charAt(regexCharPosition));
            }
            if (regexCharPosition==regex.length()-1){
                result.add(tempResult.toString());
            }

        }

        return result;
    }

    public static List<String> match(String phrase,String regex){
        List<String> result = new ArrayList<>();
        int stringposition;
        do {
            stringposition = findStringInOtherString(regex,phrase);
            if (stringposition < 0){
                break;
            }
            result.add(regex);
            phrase = phrase.substring(stringposition + regex.length());
        } while ( true);
        return result;
    }


    private static String convertToDots(int numberOfDots){
        String result="";

        for (int i = 0; i < numberOfDots; i++) {
            result = result.concat(".");
        }

        return result;
    }



    private static int findStringInOtherString(String string,String otherString){
        if (string == null || otherString == null){
            return -1;
        }
        return otherString.indexOf(string);
    }


}
