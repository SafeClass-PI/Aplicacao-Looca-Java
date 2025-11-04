package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Livros {
    public static void main(String[] args) {
        Scanner entradaString = new Scanner(System.in);
        Scanner entradaInteiro = new Scanner(System.in);
        List<String> listaTituloLivros = new ArrayList<>();
        List<String> listaAutorLivros = new ArrayList<>();
        List<Integer> listaLancamentoLivros = new ArrayList<>();
        Boolean whileMenu = Boolean.TRUE;


        while (whileMenu) {
            System.out.println("""
                    +--------------------------------+
                    |     Menu da Livraria da Ma     |
                    +--------------------------------+
                    | 01. Cadastrar livro            |
                    | 02. Listar livros              |
                    | 03. Buscar livro pelo título   |
                    | 04. Conhecer um livro          |
                    | 05. Sair                       |
                    +--------------------------------+
                    """);

            System.out.print("Digite sua opção aqui:");
            Integer indiceMenu = entradaInteiro.nextInt();


            if (indiceMenu.equals(1)) {
                System.out.println(""" 
                        +--------------------------------+
                        |   📚Cadastro de Novo Livro📚   |
                        +--------------------------------+
                        """);
                System.out.print(" ➡ Digite o título do livro: ");
                listaTituloLivros.add(entradaString.nextLine());

                System.out.print(" ➡ Digite o autor do livro: ");
                listaAutorLivros.add(entradaString.nextLine());

                System.out.print(" ➡ Digite o ano de lançamento: ");
                listaLancamentoLivros.add(entradaInteiro.nextInt());
                entradaInteiro.nextLine();

                System.out.println(String.format("""
                                \n
                                +--------------------------------------+
                                    Livro cadastrado com sucesso!!
                                   Título: %s
                                   Autor:  %s
                                   Ano:    %d
                                +--------------------------------------+
                                """,
                        listaTituloLivros.get(listaTituloLivros.size() - 1),
                        listaAutorLivros.get(listaAutorLivros.size() - 1),
                        listaLancamentoLivros.get(listaLancamentoLivros.size() - 1)));
            } else if (indiceMenu.equals(2)) {
                if (listaTituloLivros.isEmpty()) {
                    System.out.println("Nenhum livro cadastrado ainda.");
                } else {
                    System.out.println("📚Lista de livros cadastrados:");
                    System.out.println("--------------------------------------");
                    for (int i = 0; i < listaTituloLivros.size(); i++) {
                        System.out.println("Título: " + listaTituloLivros.get(i));
                        System.out.println("Autor:  " + listaAutorLivros.get(i));
                        System.out.println("Ano:" + listaLancamentoLivros.get(i));
                        System.out.println("--------------------------------------");
                    }
            }} else if (indiceMenu.equals(3)) {
                System.out.print(" ➡ Digite o livro que quer buscar:");
                String livroBuscado = entradaString.nextLine();
                for (int i = 0; i < listaTituloLivros.size(); i++) {
                    if (livroBuscado.equals(listaTituloLivros.get(i))) {
                        System.out.println(String.format("""
                                        \n
                                        +--------------------------------------+
                                           📚Livro encontrado com sucesso!!
                                           Título: %s
                                           Autor:  %s
                                           Ano:    %d
                                        +--------------------------------------+
                                        """,
                                listaTituloLivros.get(i),
                                listaAutorLivros.get(i),
                                listaLancamentoLivros.get(i)));
                        break;
                    }
                    if (i == listaTituloLivros.size() - 1) {
                        System.out.println(" Que pena... Esse livro não foi cadastrado.");
                    }
                }

                    System.out.println("Que pena...Esse livro não foi encontrado");
            } else if (indiceMenu.equals(4)) {
                    if (listaTituloLivros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado para recomendar.");
                    }
                    else {
                        Integer numAleatorio = ThreadLocalRandom.current().nextInt(0, listaTituloLivros.size() - 1);
                        System.out.println(String.format("""
                                        \n
                                        +--------------------------------------+
                                             📚Recomendação de hoje:
                                           Título: %s
                                           Autor:  %s
                                           Ano:    %d
                                        +--------------------------------------+
                                        """,
                                listaTituloLivros.get(numAleatorio),
                                listaAutorLivros.get(numAleatorio),
                                listaLancamentoLivros.get(numAleatorio)));
                }

            } else if (indiceMenu.equals(5)) {
                System.out.println("Tchau!!!Esperamos você para a próxima");
                whileMenu = Boolean.FALSE;

            } else {
                System.out.println("Opção Inválida,digite novamente");
            }

        }
    }
}

