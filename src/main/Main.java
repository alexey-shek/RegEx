package main;

import matcher.Match;

public class Main {

    public static void main(String[] args) {
        String inputPhrase = "baa bacb bcbd";
        String inputRegEx = "b..d";
        System.out.println("phrase: "+inputPhrase+", RegEx: "+inputRegEx);

        Match.matching(inputPhrase,inputRegEx);
    }
}
