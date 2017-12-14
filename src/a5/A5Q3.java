/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a5;

/**
 *
 * @author keyew7019
 */
public class A5Q3 {

    //create an array to store the characters
    private char[] stack;
    //create a new string for the comparison
    private String wordNew;
    // move forwards through the array using an int
    private int oppMove;

    public boolean inLang(String word) {
        //create a char array as long as the word
        stack = new char[word.length()];
        //start the oppMove at 0
        oppMove = 0;
        //put characters into the array backwards
        for (int pos = word.length() - 1; pos >= 0; pos--) {
            //position equals the character on the opposite side in the word
            stack[oppMove] = word.charAt(pos);
            //move to next array position
            oppMove++;
        }
        //create the string
        wordNew = new String(stack);
        //check if wordNew equals the old word/if it has a $ sign at the center
        if ((wordNew.contains(word)) && word.charAt(word.length() / 2) == '$') {
            //if this word is a part of the language, return true
            return true;
        } else {
            //if it is not, return false
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A5Q3 p = new A5Q3();
        System.out.println("Is cat$tac in the language: " + p.inLang("cat$tac"));
        System.out.println("Is cat$cat in the language: " + p.inLang("cat$cat"));
        System.out.println("Is rabbit in the language: " + p.inLang("rabbit"));

    }
}
