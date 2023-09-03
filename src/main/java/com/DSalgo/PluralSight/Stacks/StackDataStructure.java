package com.DSalgo.PluralSight.Stacks;

/*There are 5 basic Data structures to arrange the data in a fashion
that can lead to minimal friction of the program

* 1. Stack
* 2. Queue
* 3. HashTable
* 4. Linked List
* 5. Binary Tree*/

/* Has a generics X which allows any data type
*  To understand better, visualize a deck of cards */
public class StackDataStructure<X> {

/* Use that generics as a variable, No getters
*  and setters, its private and let it be internal.
* */
    private X [] data;
    private int stackPointer;

    //Constructors are used here to initialize objects.
    public StackDataStructure() {
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    //PUSH operation has O(1)
    public void push(X pushItems){
        // new item goes to position 0 and this happens till the increment reaches limit.
        data[stackPointer++] = pushItems;
    }

    //POP Operation has O(1)
    public X pop(){
        if(stackPointer == 0){
            throw new IllegalArgumentException("No items in stack to pop");
        }
        // No deletion is happening here, but simply returning and decrementing stackpointer.
        return data[--stackPointer];
    }

    //CONTAINS Operation takes O(n)
    public String contains(X itemToCheck){
        boolean found = false;

        for (int i = 0; i < stackPointer; i++) {
            if(data[i].equals(itemToCheck))
                found = true;
            break;
        }
        return String.valueOf(found);
    }

    //ACCESS operation takes O(n)
    public X access(X itemToAccess){
       while(stackPointer>0)
       {
           X item = pop();
           if(itemToAccess.equals(item)){
               return item;
           }
       }
       throw new IllegalArgumentException("Item :"+itemToAccess+" is not found");
    }

    //SIZE Operation takes O(1)
    public String size(){
        return String.valueOf(stackPointer);
    }
}
