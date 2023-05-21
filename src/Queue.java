public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Queue(){
        this.tail = null;
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void enqueue(T data){
        if(data == null) System.out.println("Data could not be null.\n");
        else{
            Node<T> newNode = new Node<T>(data);
            if(isEmpty()){
                newNode.setNext(this.tail);
                this.tail = newNode;
                this.head = newNode;
            } else{
                newNode.setNext(this.tail);
                this.tail = newNode;
            }
        }
    }

    public T dequeue(){
        if(this.isEmpty()) return null;
        Node<T> currentNode = this.tail;
        while(currentNode.getNext() != this.head){
            currentNode = currentNode.getNext();
        }
        T data = currentNode.getNext().getData();
        currentNode.setNext(null);
        this.head = currentNode;
        return data;
    }

    public T peek(){
        return this.head.getData();
    }

    public T tail(){
        return this.tail.getData();
    }

    @Override
    public String toString(){
        Node<T> aux = this.tail;
        String queue = "Printing Queue:\n";
        if(this.isEmpty()) return "Empty queue.\n";
        while(aux != null){
            queue += aux.toString() + " -> ";
            aux = aux.getNext();
        }
        queue += "null";
        return queue;
    }
}
