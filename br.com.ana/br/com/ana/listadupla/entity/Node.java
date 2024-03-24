package br.com.ana.listadupla.entity;

public class Node {
    public Node(Integer value){
        this.value = value;
    }
    private Node previous = null;
    private Node next = null;
    private Integer value;

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "previous=" + previous +
                ", next=" + next +
                ", value=" + value +
                '}';
    }
}
