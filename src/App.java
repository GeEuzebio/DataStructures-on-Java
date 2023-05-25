public class App {
    public static void main(String[] args) throws Exception {
        DoublylinkedList<Integer> doublyLinkedList = new DoublylinkedList<>();

        doublyLinkedList.insert(10);
        doublyLinkedList.insert(20);
        doublyLinkedList.insert(30);
        doublyLinkedList.insert(40);
        doublyLinkedList.insert(50);
        doublyLinkedList.insert(25, 1);

        System.out.println(doublyLinkedList.toString());
    }
}
