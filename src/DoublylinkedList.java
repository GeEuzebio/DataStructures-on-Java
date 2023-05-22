public class DoublylinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublylinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public T peek(){
        return this.head.getData();
    }

    public T getTail(){
        return this.tail.getData();
    }

    public void insert(T data){
        if(data == null) System.out.println("Data could not be null.\n");
        else{
            Node<T> newNode = new Node<T>(data);
            if(this.size == 0){
                newNode.setNext(this.tail);
                newNode.setPrev(this.head);
                this.tail = this.head = newNode;
            }else if(this.size == 1){
                newNode.setNext(this.tail.getNext());
                this.tail.setNext(newNode);
                newNode.setPrev(this.tail);
                this.tail = newNode;
            }else{
                newNode.setNext(this.tail.getNext());
                this.tail.setNext(newNode);
                newNode.setPrev(this.tail);
                newNode.getNext().setPrev(newNode);
                this.tail = newNode;
            }
            this.size++;
        }
    }

    public void insert(T data, int index){

    }

    public T remove(){
        if(this.isEmpty()) return null;
        Node<T> aux = this.tail;
        return aux.getData();
    }

    @Override
    public String toString(){
        if(this.isEmpty()) return "Empty doubly linked list.\n";
        String dll = "null <- " + this.head.toString();
        Node<T> aux = this.head.getNext();
        while(aux != this.tail){
            dll += " <-> " + aux.toString() + " <-> ";
            aux = aux.getNext();
        }
        dll += " <-> " + this.tail.toString() + " -> null";
        return dll;
    }
}
