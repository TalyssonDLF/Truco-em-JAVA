/*
Classe Cliente.java

Responsabilidades:
- Conectar-se ao servidor via socket.
- Enviar ações do jogador para o servidor (ex.: jogar carta, truco).
- Receber atualizações do estado do jogo vindas do servidor.
*/
package network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final String IP_SERVIDOR = "127.0.0.1"; // localhost
        final int PORTA = 12345;

        try (Socket socket = new Socket(IP_SERVIDOR, PORTA)) {
            System.out.println("Conectado ao servidor!");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            String mensagemServidor = entrada.readLine();
            System.out.println("Servidor diz: " + mensagemServidor);

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Digite sua mensagem: ");
                String mensagemParaServidor = scanner.nextLine();
                saida.println(mensagemParaServidor);
            }

            String resposta = entrada.readLine();
            System.out.println("Servidor respondeu: " + resposta);

        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}