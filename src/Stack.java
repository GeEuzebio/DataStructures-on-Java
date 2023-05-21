public class Stack<T> {
    private Node<T> top;

    Stack(){
        this.top = null;
    }

    public boolean isEmpty(){
        if(this.top == null){
            System.out.println("Empty stack.\n");
            return true;
        }
        return false;
    }

    public void push(T data){
        if(data == null) System.out.println("Data could not be null.\n");
        else{
            Node<T> newNode = new Node<>(data);
            newNode.setNext(this.top);
            this.top = newNode;
        }
    }

    public T pop(){
        Node<T> aux = this.top;
        if(this.isEmpty()) return null;
        this.top = aux.getNext();
        return aux.getData();
    }

    public T top(){
        return this.top.getData();
    }

    @Override
    public String toString(){
        Node<T> aux = this.top;
        String stack = "Printing Stack:\n";
        if(this.isEmpty()) return "";
        while(aux != null){
            stack += aux.toString() + "\n";
            aux = aux.getNext();
        }        
        stack += "null\n";
        return stack;
    }
}
