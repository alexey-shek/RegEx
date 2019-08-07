package matcher;


import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class Match {

    public static List<String> matchWithDots(String phrase,String regex){
        List<RegexSplit> partResult = new ArrayList<>();
        List<String> result = new ArrayList<>();



        partResult= dotSplit(regex);
        System.out.println(partResult);
        for (RegexSplit e: partResult
             ) {
            System.out.println(e.getPartLiteral()+" "+e.getDotCount());
        }

        return result;
    }

    private static List<RegexSplit> dotSplit(String regex){
        List<RegexSplit> result = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        int dotCount = 0;
        for (int regexCharPosition = 0; regexCharPosition < regex.length(); regexCharPosition++) {

                while (regex.charAt(regexCharPosition)=='.'){
                    dotCount++;
                    regexCharPosition++;
                }
//                if (dotCount>0 && value.length()!=0){
//                    result.add(new RegexSplit(value.toString(),dotCount));
//                    value.delete(0,value.length());
//                }
                if (regexCharPosition < regex.length() && regex.charAt(regexCharPosition)!='.' ){
                    value.append(regex.charAt(regexCharPosition));
                }
                if (dotCount > 0 || regexCharPosition >= regex.length()){
                    result.add(new RegexSplit(value.toString(),dotCount));
                    System.out.println(value.toString());
                }
        }

        return result;
    }

    private static class RegexSplit {
        private String partLiteral;
        private int dotCount;

        public String getPartLiteral() {
            return partLiteral;
        }

        public void setPartLiteral(String partLiteral) {
            this.partLiteral = partLiteral;
        }

        public int getDotCount() {
            return dotCount;
        }

        public void setDotCount(int dotCount) {
            this.dotCount = dotCount;
        }

        public RegexSplit(String partLiteral, int dotCount) {
            this.partLiteral = partLiteral;
            this.dotCount = dotCount;
        }
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
