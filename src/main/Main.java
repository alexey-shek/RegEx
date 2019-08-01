package main;

import matcher.Match;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String inputPhrase = "baa bab baa bbb";
        String inputRegEx = "b..";
        System.out.println("phrase: "+inputPhrase+", RegEx: "+inputRegEx);

        //Match.matching(inputPhrase,inputRegEx);


        if (inputRegEx.contains(".")){
            System.out.println(".");

            for (String s : Match.matchWithDots(inputPhrase, inputRegEx)) {
                System.out.println("for");
                System.out.println("results: " + s);
            }
        }
        else {
            for (String s : Match.match(inputPhrase,inputRegEx)){
                System.out.println("result:" +  s);
            }
        }


    }
}
