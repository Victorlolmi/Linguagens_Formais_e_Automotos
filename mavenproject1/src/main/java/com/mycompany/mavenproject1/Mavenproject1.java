/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author W10
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        // Matriz de entrada de estados
        //String matrizCSV = "4,2\n1,2\n3,2\n1,3\n3,3";
        //String matrizCSV = "4,2\n1,0\n3,2\n3,0\n3,3";
        String matrizCSV = "7,3\n1,5,-1\n3,2,-1\n4,1,-1\n3,-1,-1\n4,-1,-1\n-1,1,6\n-1,2,5";
        
        String[] linhas = matrizCSV.split("\n");

        int linhasMatriz = linhas.length - 1; // Ignorar a primeira linha
        int colunasMatriz = linhas[1].split(",").length; // Contar as colunas usando a segunda linha

        int[][] matrizEstados = new int[linhasMatriz][colunasMatriz];

        // Preenchendo a matriz com os valores do CSV a partir da segunda linha
        for (int i = 1; i < linhas.length; i++) { 
            String[] valores = linhas[i].split(",");
            for (int j = 0; j < colunasMatriz; j++) {
                matrizEstados[i - 1][j] = Integer.parseInt(valores[j]); // Ajuste no índice
            }
        }

        // Imprimir a nova matriz
        for (int i = 0; i < matrizEstados.length; i++) {
            System.out.println("q" + i + " -> " + matrizEstados[i][0] + ", " + matrizEstados[i][1]);
        }

        // Iniciando a lógica da palavra
        int estado = 0;
        System.out.print("Digite a palavra: ");
        String palavra = scanner.nextLine();

        // Processar a palavra
        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);

            if (letra == 'a') {
                // Transição para o estado correspondente ao valor da primeira coluna
                estado = matrizEstados[estado][0]; // Aqui não precisa de Integer.parseInt
            } else if (letra == 'b') {
                // Transição para o estado correspondente ao valor da segunda coluna
                estado = matrizEstados[estado][1]; // Correção na sintaxe
            } else {
                break; // Se a letra não for 'a' ou 'b', sai do loop
            }
        }
        System.out.println(estado);
                
        // Verificar o estado final
        if (estado == 3) {
            System.out.println("Aceita");
        } else {
            System.out.println("Rejeita");
        }

        scanner.close(); // Fechar o scanner
    }
}
