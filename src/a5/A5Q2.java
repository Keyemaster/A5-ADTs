/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a5;

/**
 *
 * @author keyew7019
 */
public class A5Q2 {

    // store all of the integers on the stack
    private int[] stack;
    // keep track of how many items
    private int numItems;

    public A5Q2() {
        stack = new int[10];
        numItems = 0;
    }

    public void add(int index, int item) {
        // if there is room in the stack\
        if (numItems > stack.length - 2) {
            // make more room
            int[] temp = new int[stack.length * 2];
            // copy items over
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            // stack becomes new array
            stack = temp;
            // add item
            stack[numItems] = item;
        } else {
            if (index >= numItems) {
                stack[numItems] = item;
            } else {

                // if there is a number
                if (stack[index] > 0) {

                    for (int i = numItems - 1; i >= index; i--) {
                        stack[i + 1] = stack[i];
                    }
                    stack[index] = item;

                } else {

                    // put the item on the stack
                    stack[index] = item;
                }
            }
        }
        numItems++;
        //System.out.println(numItems);
    }

    //remove the number at the index
    public void remove(int index) {
        //copy all of the Items after the place you want to get rid of (index)
        int[] store = new int[numItems];
        for (int i = index + 1; i < numItems; i++) {
            store[i] = stack[i];
//            System.out.println(store[i]);
        }
        //remove that number
        //then set the rest of the numbers after the ones you copied
        numItems = numItems - 1;
        for (int i = index; i < numItems; i++) {
            stack[i] = stack[i +1];
        }
        
    }

    // return the amount of items
    public int size() {
        return numItems;
    }

    //check if there is no numItems
    public boolean isEmpty() {
        return numItems == 0;
    }

    //get the number at the position
    public int get(int index) {
        return stack[index];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        A5Q2 p = new A5Q2();
        //add in numbers
        for (int i = 0; i < 13; i++) {
            p.add(i, i + 1);
        }
        //remove number at the index location
        p.remove(2);
        // show the numbers
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i));
        }
    }
}
