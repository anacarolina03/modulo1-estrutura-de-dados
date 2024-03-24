package br.com.ana.listadupla;

import br.com.ana.listadupla.entity.ListaDupla;
import br.com.ana.listadupla.entity.Node;

public class MainListaDupla {
    public static void main(String[] args) {
        ListaDupla listaDupla = new ListaDupla();
        listaDupla.push(new Node(10));
        listaDupla.push(new Node(20));
        listaDupla.push(new Node(30));
        listaDupla.printList();
        System.out.println("===================");
        Node pop = listaDupla.pop();
        listaDupla.printList();
        System.out.println("===================");
        System.out.println(pop.getValue());
    }
}
