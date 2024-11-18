/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author W10
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       
        // Entrada de dado
        String caminhoArquivo = "D:\\Desktop\\Documents\\GitHub\\Linguagens_Formais_e_Automotos\\mavenproject1\\entre2_as_ha_par_de_bs.csv"; 
        StringBuilder conteudoArquivo = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudoArquivo.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        
        //Tranforma o conteudo do csv em strng
        String matrizCSV =conteudoArquivo.toString();
        String[] linhas = matrizCSV.split("\n");
        
        // Extrair os estados finais da primeira linha
        String[] finaisStr = linhas[0].replace("Finais:", "").split(";"); 
        int[] estadosFinais = new int[finaisStr.length];
        for (int i = 0; i < finaisStr.length; i++) {
            estadosFinais[i] = Integer.parseInt(finaisStr[i].trim());
        }
        
        int linhasMatriz = linhas.length - 2;// ajustado com - 2 para criar a matriz desconsiderando as 2 primeiras linhas
        int colunasMatriz = linhas[2].split(";").length; //colunas criadas a partir da segunda linha

        int[][] matrizEstados = new int[linhasMatriz][colunasMatriz];

        // Preenchendo a matriz com os valores do CSV
        for (int i = 0; i < linhasMatriz; i++) {
            String[] valores = linhas[i+ 2].split(";");
            for (int j = 0; j < colunasMatriz; j++) {
                matrizEstados[i][j] = Integer.parseInt(valores[j]);
            }
        }

        // Imprimir a matriz de estados
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
                estado = matrizEstados[estado][0];
            } else if (letra == 'b') {
                // Transição para o estado correspondente ao valor da segunda coluna
                estado = matrizEstados[estado][1]; 
            } else {
                break; // Se a letra não for 'a' ou 'b', sai do loop
            }
        }
        // verifica se o estado final esta no vetor de estados finais
        boolean aceita = false;
      
        for ( int i =0; i < estadosFinais.length; i++) {
            if (estado == estadosFinais[i]) {
                aceita = true;
                break;
            }
        }

        // resposta
        if (aceita) {
            System.out.println("Aceita");
        } else {
            System.out.println("Rejeita");
        }

        scanner.close(); 
    }
}
