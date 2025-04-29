package lista_duplamente_encadeada;

import java.util.Scanner;

public class ListaDuplamenteEncadeada {
    class No {
        int dado;
        No proximo;
        No anterior;

        No(int dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }

    No inicio = null;
    No fim = null;

    public boolean vazia() {
        return inicio == null;
    }

    public void insere(int dado) {
        No novoNo = new No(dado);
        if (vazia()) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Lista vazia!");
        } else {
            System.out.print("\nLista: ");
            No atual = inicio;
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    public void remove(int numero) {
        if (!vazia()) {
            No atual = inicio;

            while (atual != null) {
                if (atual.dado == numero) {
                    if (atual == inicio && atual == fim) {
                        inicio = fim = null;
                    } else if (atual == inicio) {
                        inicio = inicio.proximo;
                        if (inicio != null) inicio.anterior = null;
                    } else if (atual == fim) {
                        fim = fim.anterior;
                        if (fim != null) fim.proximo = null;
                    } else {
                        atual.anterior.proximo = atual.proximo;
                        atual.proximo.anterior = atual.anterior;
                    }
                    return;
                }
                atual = atual.proximo;
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Boas-vindas!");

        boolean continuaPrograma = true;
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.insere(20);
        lista.insere(21);
        lista.insere(35);

        while (continuaPrograma) {
            if (!lista.vazia()) lista.imprime();
            else System.out.println("A lista está vazia.");

            System.out.println("\nEscolha sua opção: ");
            System.out.println("[ 1 ] Remover um número");
            System.out.println("[ 2 ] Adicionar um número");
            System.out.println("[ 3 ] Sair");
            System.out.print("Sua opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a ser removido: ");
                    int numeroParaRemover = Integer.parseInt(scanner.nextLine());
                    lista.remove(numeroParaRemover);
                    break;

                case 2:
                    System.out.print("Digite o número a ser adicionado: ");
                    int numeroParaAdicionar = Integer.parseInt(scanner.nextLine());
                    lista.insere(numeroParaAdicionar);
                    break;

                default:
                    System.out.println("Obrigada por usar o programa!");
                    continuaPrograma = false;
                    break;
            }
        }

        scanner.close();
    }
}
