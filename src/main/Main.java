package main;

import matcher.Match;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String inputPhrase = "baa bab bac";
        String inputRegEx = "b.c";
        System.out.println("phrase: "+inputPhrase+", RegEx: "+inputRegEx);

        //Match.matching(inputPhrase,inputRegEx);


        if (inputRegEx.contains(".")){

            for (int erg : Match.matchWithDots(inputPhrase, inputRegEx)) {
                System.out.println("results: " + erg);
            }
        }
        else {
            for (String s : Match.match(inputPhrase,inputRegEx)){
                System.out.println("result:" +  s);
            }
        }


        String string = "aabaabaabaabaaax";
        String searchString = "aa";
        int occurences = 0;
        if (0 != searchString.length()) {
            for (int index = string.indexOf(searchString, 0); index != -1; index = string.indexOf(searchString, index + 1)) {
                occurences++;
            }
        }
        System.out.println(occurences);


    }
}
