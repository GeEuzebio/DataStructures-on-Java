public class App {
    public static void main(String[] args) throws Exception {
        DoublylinkedList<Integer> doublyLinkedList = new DoublylinkedList<>();

        doublyLinkedList.insert(10);
        doublyLinkedList.insert(20);

        System.out.println("Printing head: " + doublyLinkedList.peek());
        System.out.println("Printing tail: " + doublyLinkedList.getTail());

        System.out.println(doublyLinkedList.toString());

        doublyLinkedList.remove();

        System.out.println(doublyLinkedList.toString());

        doublyLinkedList.remove();

        System.out.println(doublyLinkedList.toString());
    }
}
