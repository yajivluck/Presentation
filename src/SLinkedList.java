public class SLinkedList {

    private SNode dummyHead;
    private SNode dummyTail;
    private int size=0;


    private class SNode {
        String element;          //Node is an object containing an element and a
        SNode next;              //reference to its successor node
    }

//
//    public static String getElement(SNode node){       //Getter Method for node element//
//        return node.element;
//    }   //Getter

    public SLinkedList() {          //Constructor of a linked list//
        dummyHead = new SNode();    //Dummyhead and DummyTail present in a default list with appropriate fields//
        dummyTail = new SNode();
        dummyHead.next = dummyTail;     //Connect dummyHead to dummyTail//
        dummyTail.next = null;          //Connect dummyTail to nothing//
    }

    public void addFirst(String value){

        SNode newNode = new SNode();    //Creating new SNode containing the a value//
        newNode.element = value;
        newNode.next = dummyHead.next;  //Connecting that new node to the old first node//
        dummyHead.next = newNode;       //Connecting the dummyhead to the new first node//
        size++;                         //Increasing size of list//
        return;
    }

    public int getSize(){
        return size;
    }   //Getter method for the size field of a linked list//


    public void removeFirst() {
        if (size == 0) {            //Edge case of an empty list//
            System.out.println("Cannot remove an element from an empty LinkedList");
            return;
        }
        SNode temp = dummyHead.next;            //Stocking reference to first Node//
        dummyHead.next = dummyHead.next.next;   //Reassigning dummyHead link to the second Node//
        temp.next = null;         //Clearing the previous first Node's "link" to the old second node (which is now the first node)//
        size--;                   //Reducing size of list//
    }

    public void removeLast(){
        if (this.size == 0) {            //Edge case of an empty list//
            System.out.println("Cannot remove an element from an empty LinkedList");
            return;
        }

        if (this.size==1) {
            removeFirst(); //Rerouting function to specific case of a single element list//
            return;
        }

        SNode BeforeLast = dummyHead.next;   //Initializing a reference to the first element//
        while (BeforeLast.next.next!=dummyTail) {BeforeLast=BeforeLast.next;}    //Parse through list until
        //Before last node is reached//

        SNode temp = BeforeLast;
        temp.next=null;                 //Delete old last node link to tail//
        BeforeLast.next = dummyTail;    //Relink Before last node to Tail//
        size--;
    }


    public void remove(SNode node){

        if (dummyHead.next==node){                  //Edge Case predefined//
            removeFirst();                          //This is equivalent to removing the first element//
            return;
        }

        if (node.next==dummyTail){              //Edge Case predefined//
            removeLast();                       //This is equivalent to removing the last element//
            return;
        }

        SNode previous = dummyHead.next;        //Initializing a reference to the first element//

        while (previous.next!=node){        //Parsing through the list until the node preceding the one to remove is reached//
            previous=previous.next;
        }

        previous.next = node.next;    //Reassign the preceding node so that it skips the node being removed//
        node.next = null;             //Deleting "deleted" node's link to the list//
        size--;

    }


    public void remove_duplicates(){               //PRESENTATION METHOD//

        if (size==0||size==1) return;   //No possibilities of having duplicates//

        SNode trace = dummyHead.next;           //Keeps track of the node whose duplicates are being removed//
        SNode current;

        while (trace!=dummyTail) {
            current = trace.next;         //Keeps track of the node that is being parsed from//

            while (current!=dummyTail) {
                if (trace.element.equals(current.element)) {  //Travel through each nodes until the dummyTail is reached//
                    SNode duplicate = current;
                    current = current.next;         //Removes trace's duplicates in the list//
                    remove(duplicate);
                }
                else current = current.next;
            }
            trace=trace.next;   //Move the trace to the next node and repeat the process//
        }
        return;
    }


    public String toString() {      //Personalized Print of a linked list to clearly see its elements//

        String Personalized="";         //Initialize the Linked List Print as an empty string//

        SNode temp = dummyHead.next;    //Start at the first element//
        while (temp!=dummyTail){
            Personalized+= temp.element+ "\n";     //Parse through each elements//
            temp=temp.next;                         //Add the string that each node contains with a new line for each element//
        }
        Personalized+=("\n" +"Size: "+ getSize()+"\n");
        return Personalized;        //Return Listed elements//
    }





    //
//    public SNode getNode(int i){
//        if (i<=0||i>size) {
//            throw new IllegalArgumentException("Invalid Index");  //Account for faulty index//
//        }
//            int index=0;
//            SNode temp = dummyHead;  //Parsing through each elements until the ith Node is reached//
//            while (index < i){
//                 temp = temp.next;
//                 index++;
//            }
//            return temp;            //Return the ith Node//
//        }




//    public void remove_duplicates_sorted(){        //assumes sorted list//
//
//        if (size==0||size==1) return;
//
//        SNode current = dummyHead.next;
//
//        while(!current.element.equals(current.next.element)) {
//            current = current.next;
//            if (current.next==dummyTail) return;
//        }
//        while (current.element.equals(current.next.element)) {
//            remove(current.next);
//        }
//        current = current.next;
//
//        if (current==dummyTail) return;
//        remove_duplicates();
//
//    }

}

