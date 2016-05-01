/**
 * Created by lauminyi on 13/2/16.
 */
public class LinkedList {
    //the head of the first link will always be updated when we addFirstLink
    public Link firstlink;

    LinkedList(){
        firstlink=null;
    }
    public boolean isEmpty(){
        return (firstlink == null);
    }

    public void addFirstLink(String bookname, int millionssold){
        Link newLink = new Link(bookname,millionssold);
        newLink.next=firstlink;
        firstlink=newLink;
    }

    public Link removeFirst(){
        //always holds a reference to the first link before its deleted;
        Link linkreference = firstlink;
        if (!isEmpty()){
            //sets the firstlink as the next one which removes the first link
            firstlink=firstlink.next;
        }else{
            System.out.println("Empty linked list!");
        }
        return linkreference;
    }

    public void display(){
        Link theLink = firstlink;
        while(theLink!=null) {
            theLink.display();
            System.out.println("The next link is: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link search(String bookname){
        Link theLink = firstlink;
        if(!isEmpty()){
            while(theLink.bookname!=bookname) {
                //We have reached the end of the list
                if(theLink.next==null){
                    //No match is found so we return nothing
                    return null;
                }
                else{
                    theLink=theLink.next;
                }
            }
        }else{
            System.out.println("Empty Linked List!");
        }
        return theLink;
    }

    public Link remove(String bookname){
        Link currentLink = firstlink;
        Link previousLink = firstlink;
        while(currentLink.bookname!=bookname){
            //Check if its the last link
            if (currentLink.next==null){
                return null;
            }
            else {
                //keep updating the list of links
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        //if the link to be removed is the first link
        if(currentLink==firstlink){
            firstlink=firstlink.next;
        }
        else{
            System.out.println("Found a match!");
            System.out.println("");
            previousLink.next=currentLink.next;
        }
        return currentLink;

    }

}
