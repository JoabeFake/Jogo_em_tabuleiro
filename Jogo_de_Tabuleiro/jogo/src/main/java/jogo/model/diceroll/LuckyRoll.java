package jogo.model.diceroll;

import java.util.Random;

public class LuckyRoll implements DiceStrategy{
    private Random random = new Random();

    @Override
    public int rolarDados(){
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int soma = dado1 + dado2;
        return soma >= 7 ? soma : 7;
    }
}
