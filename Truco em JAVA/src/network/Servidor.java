/*
Classe Servidor.java

Responsabilidades:
- Iniciar o servidor e esperar conexões via sockets.
- Aceitar conexões dos jogadores.
- Enviar e receber informações do jogo em tempo real (ações, jogadas, truco).
*/

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int PORTA = 12345;
        
        try (ServerSocket servidor = new ServerSocket(PORTA)) {
            System.out.println("Servidor iniciado. Aguardando jogadores...");

            Socket jogador1 = servidor.accept();
            System.out.println("Jogador 1 conectado!");

            Socket jogador2 = servidor.accept();
            System.out.println("Jogador 2 conectado!");

            BufferedReader entradaJogador1 = new BufferedReader(new InputStreamReader(jogador1.getInputStream()));
            PrintWriter saidaJogador1 = new PrintWriter(jogador1.getOutputStream(), true);

            BufferedReader entradaJogador2 = new BufferedReader(new InputStreamReader(jogador2.getInputStream()));
            PrintWriter saidaJogador2 = new PrintWriter(jogador2.getOutputStream(), true);

            // Exemplo básico de comunicação
            saidaJogador1.println("Bem-vindo Jogador 1");
            saidaJogador2.println("Bem-vindo Jogador 2");

            // Recebe uma mensagem simples do Jogador 1 e encaminha para Jogador 2
            String mensagemDoJogador1 = entradaJogador1.readLine();
            System.out.println("Jogador 1 disse: " + mensagemDoJogador1);
            saidaJogador2.println("Jogador 1 disse: " + mensagemDoJogador1);

            // Fecha conexões após uso (implementar lógica completa posteriormente)
            jogador1.close();
            jogador2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}