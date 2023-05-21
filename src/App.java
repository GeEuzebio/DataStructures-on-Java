public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);

        linkedList.insert(25, 2);
        linkedList.remove(1);

        System.out.println(linkedList.toString());
    }
}
