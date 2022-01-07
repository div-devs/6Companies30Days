package Amazon;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/
public class mNodesAfterNnodes {

    static class Node
    {
        int data;
        Node next;

        Node() {}
        Node(int data) {
            this.data = data;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args)
    {
        Node head = null;
        int M=2, N=3;
        head=push(head, 10);
        head=push(head, 9);
        head=push(head, 8);
        head=push(head, 7);
        head=push(head, 3);
        head=push(head, 2);
        head=push(head, 1);

        System.out.println("Input LinkedList: ");
        printList(head);

        skipMdeleteN(head, M, N);

        System.out.println("Result LinkedList: ");
        printList(head);
    }

    private static Node push(Node head, int new_data) {

        Node new_node = new Node(new_data);
        if(head == null) {
            head = new_node;
            return head;
        }

        new_node.next = head;
        head = new_node;

        return head;
    }


    private static void printList(Node head) {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void skipMdeleteN( Node head, int M, int N) {
        Node curr = head, t;
        int count;

        while (curr!=null)
        {
            for (count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            t = curr.next;
            for (count = 1; count <= N && t != null; count++) {
                t = t.next;
            }

            curr.next = t;
            curr = t;
        }
    }
}
