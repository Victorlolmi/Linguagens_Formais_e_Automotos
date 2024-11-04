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
        String matrizCSV = "3,2\n0,1,2\n1,0\n1,2\n-1,1";
        //String matrizCSV = "4,2\n1,0\n3,2\n3,0\n3,3";
        //String matrizCSV = "7,3\n1,5,-1\n3,2,-1\n4,1,-1\n3,-1,-1\n4,-1,-1\n-1,1,6\n-1,2,5";
        
        String[] linhas = matrizCSV.split("\n");
       // System.out.println(linhas[0]);
        int linhasMatriz = linhas.length - 2; // qntd linhas sem contar a primeira e a segunda 
        int colunasMatriz = linhas[0].split(",").length; // qntd colunas
        System.out.println(colunasMatriz);
        int[][] matrizEstados = new int[linhasMatriz][colunasMatriz];

        // Preenchendo a matriz com os valores do CSV a partir da segunda linha
        for (int i = 2; i < linhas.length; i++) { 
            String[] valores = linhas[i].split(",");
            for (int j = 0; j < colunasMatriz; j++) {
                matrizEstados[i - 2][j] = Integer.parseInt(valores[j]); 
            }
        }
        // Vetor de estados finais
        
        for (int i = 0; i < linhasMatriz; i++) { 
            String[] vetorEstados = linhas[i].split(",");
            System.out.println(vetorEstados[i]);
        }
        
        // Imprimir matriz
        for (int i = 0; i < matrizEstados.length; i++) {
            System.out.println("q" + i + " -> " + matrizEstados[i][0] + ", " + matrizEstados[i][1]);
        }
        
        
        int estado = 0;
        System.out.print("Digite a palavra: ");
        String palavra = scanner.nextLine();

        // Fita para processar a palavra
        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);

            if (letra == 'a') {
                // Transição para o estado correspondente ao valor da primeira coluna
                estado = matrizEstados[estado][0]; 
            } else if (letra == 'b') {
                // Transição para o estado correspondente ao valor da segunda coluna
                estado = matrizEstados[estado][1]; 
            } else {
                break; // Se a letra não for 'a' ou 'b', sai do loop
            }
        }
                
        // Verificar o estado final
        System.out.println(estado);
        if (estado == 0 || estado == 1 || estado == 2) {
            System.out.println("Aceita");
        } else {
            System.out.println("Rejeita");
        }

        scanner.close(); // Fechar o scanner
    }
}
