package main;

import matcher.Match;

public class Main {

    public static void main(String[] args) {
        String inputPhrase = "bab bbb bbb";
        String inputRegEx = "bab";
        System.out.println("phrase: "+inputPhrase+", RegEx: "+inputRegEx);

        Match.matching(inputPhrase,inputRegEx);
    }
}
