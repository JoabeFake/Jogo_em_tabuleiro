import java.util.Scanner;

import jogo.model.game.Jogo;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Modo Debug? (true/false)");
        boolean debugMode = input.nextBoolean();

        // 🔹 Obtendo a única instância do jogo
        Jogo jogo = Jogo.getInstance(debugMode);

        jogo.iniciarJogo();

        input.close();
    }
}
