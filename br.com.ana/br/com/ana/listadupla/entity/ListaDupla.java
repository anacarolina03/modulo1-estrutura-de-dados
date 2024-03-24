package br.com.ana.listadupla.entity;

public class ListaDupla {
    private Node head;
    private Node tail;
    private int value;
    private int size;

    //o(1) para inserção já que o ponteiro sempre aponta para o ultimo o mesmo para espaço que é alocado a cada inserção
    public void push(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
    }

    //o(1) para tempo pois já temos o ultimo apenas precisamos mudar o apontador e também o(1) para espaço já que é removido na hora
    public Node pop(){
        if(size == 0){
            return null;
        }else{
            Node temp = tail;
            this.tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return temp;
        }
    }

    //o(n) para tempo já que precisamos percorrer todos até chegar na posição desejada e o(1) para espaço já que ela é alocada só trocando os ponteiros
    public void insert(int index, Node node){
        if(index < 0 || index > size){
            System.out.println("Index out of bounds");
        }else if(index == size){
            push(node);
        }else{
            Node temp = elementAt(index);
            temp.getPrevious().setNext(node);
            node.setPrevious(temp.getPrevious());
            node.setNext(temp);
            temp.setPrevious(node);
            size++;
        }
    }
    //o(n) para tempo por conta do percorrimento e o(1) para espaço já que é removido e não fica arestas sobrando
    public void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("Index out of bounds");
        }else if(index == size-1){
            pop();
        }else{
            Node temp = elementAt(index);
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
            size--;
        }
    }
    //para tempo o(n) a depender da quandade de elementos a percorrer até chegar na posição e o(1) para espaço já que retorna a referencia na memoria e não o cria
    public Node elementAt(int index){
        if(index < 0 || index >= size){
            return null;
        }else{
            Node temp = head;
            for(int i=0; i<index; i++){
                temp = temp.getNext();
            }
            return temp;
        }
    }
    public int size(){
        return size;
    }
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListaDupla{" +
                "head=" + head +
                ", tail=" + tail +
                ", value=" + value +
                ", size=" + size +
                '}';
    }
}
