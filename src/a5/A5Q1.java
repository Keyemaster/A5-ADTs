/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a5;

/**
 *
 * @author keyew7019
 */
public class A5Q1 {

    private IntNode head;
    private int numItems;

    public A5Q1() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        // start at beginning of list
        IntNode temp = new IntNode(num);
        // see if it is first item
        if (head == null) {
            head = temp;
        } else {
            if (num < head.getNum()) {
                IntNode p = head;
                head = temp;
                head.setNext(p);
            } else {
                IntNode node = head;
                if (head.getNext() == null) {
                    head.setNext(temp);
                } else {
                    //turn if else to a while and in that while check if it is at the end
                    while (node.getNext().getNum() < num) {
                        node = node.getNext();
                        if (node.getNext() == null) {
                            break;
                        }
                    }
                    //add then add the rest of the array
                    //right now you are on the position before either the null or the one you want 
                    IntNode pos = node.getNext();
                    temp.setNext(pos);
                    node.setNext(temp);
                }
            }
        }
        // increase the size counter
        numItems++;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int position) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    public void remove(int num) {

        IntNode node = head;
        if (head.getNum() == num) {
            head = head.getNext();
        } else {
            // move to the spot just before
            // while the next node does not equal the num
            // keep checking if it does equal num
            while (node.getNext().getNum() != num) {
                node = node.getNext();
                if (node.getNext() == null) {
                    return;
                }
            }
            // Ignores node that we are trying to remove and moves to next node
            if (node.getNext().getNum() == num) {
                node.setNext(node.getNext().getNext());
            }
        }
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        A5Q1 list = new A5Q1();
        // add numbers
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1);
        // remove a numbers
        list.remove(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
