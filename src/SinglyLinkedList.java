public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int length(){
        return size;
    }

    public boolean isEmpty(){
        return this.head == null;
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
            if(this.isEmpty()){
                newNode.setNext(this.head);
                this.tail = this.head = newNode;
            }else{
                newNode.setNext(this.tail.getNext());
                this.tail.setNext(newNode);
                this.tail = newNode;
            }
        }
        size++;
    }

    public void insert(T data, int index){
        if(size < index || index < 0) System.out.println("Invalid index.\n");
        else if(index == size) insert(data);
        else{
            Node<T> newNode = new Node<T>(data);
            Node<T> aux = this.head;
            if(index == 0){
                newNode.setNext(this.head);
                this.head = newNode;
            }else{
                for(int i=1; i<index; i++){
                    aux = aux.getNext();
                }
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            }
        }
        size++;
    }

    public T remove(){
        if(this.isEmpty()){
            System.out.println("Empty list.\n");
            return null;
        }
        else{
            Node<T> aux = this.head;
            T data;
            if(this.tail == this.head){
                data = this.tail.getData();
                this.tail = this.head = null;
            }else{
                while(aux.getNext() != this.tail) aux = aux.getNext();
                data = aux.getNext().getData();
                aux.setNext(this.tail.getNext());
                this.tail = aux;
            }
            size--;
            return data;
        }
    }

    public T remove(int index){
        if(size < index || index < 0){
            System.out.println("Invalid index.\n");
            return null;
        }
        else{
            if(isEmpty()){
                System.out.println("Empty list.\n");
                return null;
            }else{
                Node<T> aux = this.head;
                T data;
                if(index == 0){
                    data = this.head.getData();
                    this.head = this.head.getNext();
                }else{
                    for(int i = 1; i < index; i++){
                        aux = aux.getNext();
                    }
                    data = aux.getNext().getData();
                    aux.setNext(aux.getNext().getNext());
                }
                size--;
                return data;
            }
        }
    }

    @Override
    public String toString() {
        String linkedList = "Printing Linked List: \n";
        Node<T> aux = this.head;
        while(aux != null){
            linkedList += aux.toString() + " -> ";
            aux = aux.getNext();
        }
        linkedList += "null";
        return linkedList;
    }
}