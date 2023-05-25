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
                this.tail = newNode;
            }
            this.size++;
        }
    }

    public void insert(T data, int index){
        if(data == null) System.out.println("Data could not be null.\n");
        if(size < index || index < 0) System.out.println("Invalid index.\n");
        else if(index == size) insert(data);
        else{
            Node<T> newNode = new Node<T>(data);
            Node<T> aux = this.head;
            if(index == 0){
                newNode.setNext(this.head);
                newNode.setPrev(this.head.getPrev());
                this.head.setPrev(newNode);
                this.head = newNode;
            }else{
                for(int i = 0; i < index; i++){
                    aux = aux.getNext();
                }
                aux.getPrev().setNext(newNode);
                newNode.setNext(aux);
                newNode.setPrev(aux.getPrev());
                aux.setPrev(newNode);
            }
            size++;
        }
    }

    public T remove(){
        if(this.isEmpty()) return null;
        if(this.tail == this.head){
            T data = this.head.getData();
            this.tail = this.head = null;
            size--;
            return data;
        }
        Node<T> aux = this.head;
        aux.getNext().setPrev(this.head.getPrev());
        this.head = aux.getNext();
        size--;
        return aux.getData();
    }

    @Override
    public String toString(){
        if(this.isEmpty()) return "Empty doubly linked list.\n";
        if(size == 0) return "Empty doubly linked list.\n";
        if(size == 1) return "null <- " + this.head.toString() + " -> null";
        String dll = "null <- " + this.head.toString();
        Node<T> aux = this.head.getNext();
        while(aux != this.tail){
            dll += " <-> " + aux.toString();
            aux = aux.getNext();
        }
        dll += " <-> " + this.tail.toString() + " -> null";
        return dll;
    }
}
