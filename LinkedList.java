/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/**
 *
 * @author Ebude
 */
class LinkedList
{
    private static Node head;
    private static int  countNodes;
    
    // Define Node
    class Node
    {
        private Node next;
        private Object data;
        Node(Object d)  { data = d;  next=null; } 
    }
    
    public LinkedList(Object dat)
    {
        head = new Node(dat);
    }
    
    // Add object to list
    
    public void AtHead(Object dat)
    {
        Node temp = head;
        head= new Node(dat);
        head.next=temp;
        countNodes++;
    }
    
    public void AtEnd(Object dat)
    {
        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next=new Node(dat);
        countNodes++;
    }
    
    public void AtIndex(int index, Object dat)
    {
        Node temp = head;
        Node holder;
        for (int i=0; i<index-1 && temp.next !=null;i++ )
        {
            temp=temp.next;
        }
        holder=temp.next;
        temp.next=new Node(dat);
        temp.next.next=holder;
        countNodes++;
    }
    
    // Delete object in a list at an index
    
    public void DeleteI(int index)
    {
        Node temp = head;
        for (int i=0; i<index && temp.next!=null; i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        countNodes--;
    }
    
    // Delete object from list
    
    public void DeleteOb(Object dat)
    {
        Node temp=head;
        while(temp.next.data!= dat)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        countNodes--;     
    }
    
    // Find the index of a given node
    
    public static int FindI(Object node)
    {
        Node temp = head;
        int index =0;
        while(temp!=node)
        {
            index++;
            temp=temp.next;
        }
        return index;
    }
    
    //Find the node for a given index
    
    public static Node FindN(int index)
    {
        Node temp = head;
        for (int i=0; i<index && temp.next!=null; i++)
        {
            temp=temp.next;
        }
        return temp;
    }
    
    //Print out objects in a list
    
    public static void PrintList()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.print(temp.data);
            temp=temp.next;
        }
    }
    
    // Get the list size
    
    public static int getSize()
    {
       return countNodes; 
    }
    
    
    //-----------------------------TESTING CODE----------------------------------------------//
    
    public static void main(String[] agrs)
    {
        System.out.println("---------TESTING CODE------------");
        LinkedList ll=new LinkedList(10);
        ll.AtHead(52);
        ll.AtEnd(178);
        ll.AtIndex(2, 47);
        ll.AtHead(14);
        ll.AtEnd(9);
        ll.DeleteI(3);
        ll.DeleteOb(47);
        ll.PrintList();
        
    }
}