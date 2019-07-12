package main;

import helper.Helper;
import matcher.Match;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner inputObject = new Scanner(System.in);
        //System.out.print("Enter you phrase ");
        //String inputPhrase = inputObject.nextLine();

        //System.out.print("Enter the regular expression: ");
        //String inputRegEx = inputObject.nextLine();

        String inputPhrase = "bab bbb bcb";
        String inputRegEx = "b.b";
        System.out.println("phrase: "+inputPhrase+", RegEx: "+inputRegEx);

        System.out.println(Match.getMatch(Helper.cleanInput(inputPhrase), Helper.cleanInput(inputRegEx)));
    }
}
