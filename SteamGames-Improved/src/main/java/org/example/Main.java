package org.example;

import ordenations.OrdenationsAvlTree;
import ordenations.OrdenationsBinarySearchTree;
import ordenations.OrdenationsRedBlackTree;
import transformations.Transformations;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Iniciando as transformações:");
        Transformations.mainTransformations();
        System.out.println("Todas as transformações foram feitas!");
        System.out.println("Iniciando ordenações:");
        System.out.println("--------------------------------------------------");
        System.out.println("Árvore Binária de busca");
        OrdenationsBinarySearchTree.mainOrdenationsBinarySearchTree();
        System.out.println("--------------------------------------------------");
        System.out.println("Árvore AVL");
        OrdenationsAvlTree.mainOrdenationsAvlTree();
        System.out.println("--------------------------------------------------");
        System.out.println("Árvore Vermelho-Preto");
        OrdenationsRedBlackTree.mainOrdenationsRedBlackTree();
        System.out.println("--------------------------------------------------");

    }

}