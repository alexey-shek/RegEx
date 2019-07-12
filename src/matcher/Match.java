package matcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

public class Match {

    public static List getMatch(String phrase, String regEx){
        List<String> matchingOutputList = new ArrayList<>();

        if (regEx.contains(".") && !regEx.contains("(")){
            System.out.println("Regex has only .");
            //expressionSubstring(regEx).compareToIgnoreCase(phrase);
            String outputClean = expressionSubstring(regEx);
            System.out.println(outputClean);

//            Matcher matcher = Pattern.compile(regEx).matcher(phrase);
//            while (matcher.find()) {
//                matchingOutputList.add(matcher.group());
//            }
        }
        else if (regEx.contains(".") && regEx.contains("(")){
            System.out.println("Regex has . and ()");
        }
        else if (regEx.contains("(") && !regEx.contains(".")){
            System.out.println("Regex contains only ()");
        }
        else {
            System.out.println("Regex has no allowed operators");
        }

        return matchingOutputList;
    }

    public static String expressionSubstring(String expression){
        if (expression.contains(".")){
            String expressionNew = substringBefore(expression,".")+" "+substringAfter(expression, ".");
            System.out.println(""+expressionNew);
            return expressionNew;
        }

        return "Nothing to do";
    }
}
