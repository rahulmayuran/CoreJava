package com.DSalgo.PluralSight.Queues;

//Generics
public class DS_Queue<X> {

    //The data array is of any type X.
    private X[] data;
    //front and end are two pointers which start from -1, as array starts from 0th position.
    private int front;
    private int end;

    public DS_Queue() {
        this(1000);
    }

    public DS_Queue(int size)
    {
        //As arrays are beginning with 0.
        this.front = -1;
        this.front = -1;
        data = (X[])new Object[size];
    }

    public int size()
    {
        //In case of an empty array {front(-1)->|nothing|<-end(-1)}
        if(front==-1 && end==-1)
        {
            return 0;
        }
        //+1 is needed because, {front(-1)->|1 element|<-end(-1)}
        return end-front+1;
    }

    public void enQueue(X item)
    {

        /* Check if the Queue is full
        * Here % is the reminder that checks with front value.
        * Lets say, the data array is of length 1000, front will be 1 and end will be 1000
        * {front(-1)->|1000 elements|<-end(1000)}
        * not sure, how this works.
        */
        if( (end + 1) % data.length == front)
        {
            throw new IllegalStateException("Queue is full!");
        }

        //Check whether any items are added to the Queue, First time add
        else if(size()==0)
        {
            //Reset the pointers to point to the 0th element of the array and insert item to last 0th position
            front++;
            end++;
            data[end] = item;
        }

        //Add item to the end of the queue if already there are items, always push the pointers to next place
        else
        {
            end++;
            data[end] = item;
        }
    }

    public X deQueue()
    {
      X item = null;

      //If queue is empty
        if(size()==0)
        {
            throw new IllegalStateException("Unable to Deque as the queue is empty");
        }
        //If you are trying to deque the last item in your queue
        //After assigning item to 0, reset the pointers back to original position
        else if(front==end)
        {
            item = data[front];
            front = -1;
            end = -1;
        }
        //Adjust the front pointer to next position and grab the front of the queue.
        else
        {
            item = data[front];
            front++;
        }
        return item;
    }

    public boolean contains(X item){

        boolean itemFound = false;

        if(size()==0){
            return itemFound;
        }

        //As it is a Queue, Let's assume there are n elements in between
        // It starts from front and iterates till end.

        for (int i = front; i < end; i++) {
            if(data[i].equals(item)){
                itemFound = true;
                break;
            }
        }
        return itemFound;
    }

    public X access(int position)
    {
        if(size()==0 || position>size() ){
            throw new IllegalArgumentException("Queue is already empty");
        }

        //A for loop to check the index of the item to be checked and the item provided
        //And returning the element at that position that matched.

        int itemIndex = 0;
        for (int i = front ; i < end; i++)
        {
            if(itemIndex == position){
                return data[i];
            }
            itemIndex++;
        }
        throw new IllegalArgumentException("Unable to find the item at position "+position);
    }

}
