package jogo.model.player.types;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jogo.model.diceroll.DiceStrategy;
import jogo.model.diceroll.LuckyRoll;
import jogo.model.diceroll.NormalRoll;
import jogo.model.diceroll.UnluckyRoll;

public abstract class Jogador {
    private Random random;

    protected int position;
    protected int moedas;
    protected String cor;
    protected boolean pularRodada;
    protected DiceStrategy strategy;
    protected TipoJogador tipo;

    public enum TipoJogador {
        NORMAL,
        SORTUDO,
        AZARADO
    }

    // Construtor protegido (só a Factory pode chamar)
    protected Jogador(String cor, DiceStrategy strategy) {
        this.cor = cor;
        this.strategy = strategy;
        this.position = 0;
        this.moedas = 0;
        random = new Random();
    }

    public void mudarTipo(){
        if(random == null){
            random = new Random();
        }
        TipoJogador[] tipos = TipoJogador.values();
        tipo = tipos[random.nextInt(tipos.length)];
        setRollDiceStrategy();
    }

    public Jogador escolherJogador(List<Jogador> jogadores){
        Scanner input = new Scanner(System.in);
        int escolha = -1;
        System.out.println("Escolha um jogador para voltar ao início:");
        for(int i = 0; i < jogadores.size(); i++){
            System.out.println((i+1)+ "-" + jogadores.get(i).getCor() + " casa: " + jogadores.get(i).getPosition());
        }

        while(true){
            System.out.println("Digite o número correspondente: ");
            if(input.hasNext()){
                escolha = input.nextInt()-1;
                if(escolha >= 0 && escolha < jogadores.size()){
                    break;
                }
            } else {
                input.next();
            }
            System.out.println("Entrada inválida! Escolha entre 1 e " + jogadores.size());
        }

        return jogadores.get(escolha);
    }

    private void setRollDiceStrategy(){
        switch (tipo) {
            case NORMAL:
                this.strategy = new NormalRoll();
                break;
            case SORTUDO:
                this.strategy = new LuckyRoll();
                break;
            case AZARADO:
                this.strategy = new UnluckyRoll();
                break;
        }
    }

    public void addMoedas(int quantidade){
        this.moedas += quantidade;
    }

    public int rolarDados(){
        return strategy.rolarDados();
    }

    // Getters e Setters
    public DiceStrategy getStrategy() {
        return strategy;
    }

    public TipoJogador getTipo(){
        return tipo;
    }

    public void setstrategy(DiceStrategy strategy){
        this.strategy = strategy;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }

    public String getCor() {
        return cor;
    }

    public boolean getPularRodada() {
        return pularRodada;
    }

    public void setPularRodada(boolean pularRodada) {
        this.pularRodada = pularRodada;
    }
}
