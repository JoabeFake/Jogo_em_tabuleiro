package jogo.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jogo.model.checkboard.Tabuleiro;
import jogo.model.player.factory.JogadorFactory;
import jogo.model.player.factory.JogadorFactoryImpl;
import jogo.model.player.types.Jogador;

public class Jogo {
    private static Jogo instance;
    private final boolean isDebugMode;
    private final Tabuleiro tabuleiro;
    private final List<Jogador> jogadores;
    private final Scanner input;
    private final JogadorFactory jogadorFactory;
    private final Random random;

    private Jogo(boolean isDebugMode) {
        input = new Scanner(System.in);
        jogadores = new ArrayList<>();
        tabuleiro = Tabuleiro.getInstance(jogadores);
        this.isDebugMode = isDebugMode;
        this.jogadorFactory = new JogadorFactoryImpl();
        random = new Random();
    }

    public static Jogo getInstance(boolean isDebugMode) {
        if (instance == null) {
            instance = new Jogo(isDebugMode);
        }
        return instance;
    }

    public void iniciarJogo() {
        System.out.println("Selecione o número de jogadores (2-6):");
        int numJogadores = input.nextInt();

        if (numJogadores > 6 || numJogadores < 2) {
            System.out.println("Digite um número de jogadores válido");
            return;
        }

        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite a cor para o jogador " + (i + 1));
            String cor = input.next();

            int escolha = 0;
            Jogador.TipoJogador tipo;
            if (isDebugMode) {
                System.out.println("Digite o tipo de Jogador para o jogador " + (i + 1));
                System.out.println("1 - NORMAL");
                System.out.println("2 - SORTUDO");
                System.out.println("3 - AZARADO");
                escolha = input.nextInt() - 1;
                tipo = Jogador.TipoJogador.values()[escolha];
            }else{
                tipo = Jogador.TipoJogador.values()[random.nextInt(Jogador.TipoJogador.values().length)];
            }

            Jogador jogador = jogadorFactory.criarJogador(cor, tipo);

            jogadores.add(jogador);
            System.out.println("Jogador " + (i + 1) + ": " + jogador.getCor() + " - " + jogador.getTipo());
        }

        rodarJogo();
    }

    private void rodarJogo(){
        boolean jogoAtivo = true;

        while(jogoAtivo){
            for(Jogador jogador : jogadores){
                jogoAtivo = jogarTurno(jogador);
                if(!jogoAtivo){
                    System.out.println("Jogador " + jogador.getCor() + " Venceu o jogo!");
                    return;
                }
            }
        }
    }

    private boolean jogarTurno(Jogador jogador){
        System.out.println("Vez do jogador " + jogador.getCor());

        if(jogador.getPularRodada()){
            jogador.setPularRodada(false);
            System.out.println("Jogador " + jogador.getCor() + " pulou a vez");
            return true;
        }

        System.out.println();
        System.out.println("1. Lançar Dado");
        int escolha = input.nextInt();
        int resultado = 0;

        if(escolha == 1){
            if(isDebugMode){
                System.out.println("Digite a posição de destino:");
                int destino = input.nextInt();
                resultado = destino - jogador.getPosition();
            } else {
                resultado = jogador.rolarDados();
            }
        } else{
            System.out.println("Opção inválida");
            return true;
        }

        jogador.setPosition(jogador.getPosition() + resultado);
        System.out.println("Jogador " + jogador.getCor() + " rolou: " + resultado);
        System.out.println("Jogador " + jogador.getCor() + " está na casa: " + jogador.getPosition());
        System.out.println();
        tabuleiro.executarCasaEspecial(jogador);

        return !tabuleiro.verificarFimJogo(jogador);
    }
}

