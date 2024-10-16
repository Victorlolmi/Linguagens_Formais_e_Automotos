import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Matriz de entrada de estados
        String matrizCSV = "4,2\n1,2\n3,2\n1,3\n3,3";
        String[] linhas = matrizCSV.split("\n");

        int linhasMatriz = linhas.length;
        int colunasMatriz = linhas[0].split(",").length;

        int[][] matrizEstados = new int[linhasMatriz][colunasMatriz];

        // Preenchendo a matriz com os valores do CSV
        for (int i = 0; i < linhasMatriz; i++) {
            String[] valores = linhas[i].split(",");
            for (int j = 0; j < colunasMatriz; j++) {
                matrizEstados[i][j] = Integer.parseInt(valores[j]);
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

        // Verificar o estado final
        if (estado == 3) {
            System.out.println("Aceita");
        } else {
            System.out.println("Rejeita");
        }

        scanner.close(); // Fechar o scanner
    }
}
