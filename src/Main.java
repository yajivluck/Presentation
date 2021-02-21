import java.util.Scanner;

public class Main {

    public static void main(String [] args){


        SLinkedList list1 = new SLinkedList();
        System.out.println("Add something to the linked list or blank to finish");
        Scanner scan = new Scanner(System.in);


        while (true){

            String element = scan.nextLine();
            if (element.isEmpty()) break;
                element = element.trim();
                list1.addFirst(element);

            if (element.isEmpty()) {
                scan.close();
                break;
            }

        }

        System.out.println(list1);
        list1.remove_duplicates();
        System.out.println(list1);

    }
}
