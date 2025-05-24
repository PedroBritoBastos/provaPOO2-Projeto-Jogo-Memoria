package provaPOO2;
import java.util.Random;

/**
 * Classe que cria um tabuleiro para armazenar as cartas
 */
public class Tabuleiro {
    public Carta[][] tabuleiro = new Carta[2][5];
    
    /**
     * recebe as cartas e as embaralha no tabuleiro
     * @param cartas
     */
    public void inserirCartaAleatoria(Carta[] cartas) {
        Random random = new Random();
        int linhas = tabuleiro.length;       
        int colunas = tabuleiro[0].length;   
        
        // percorre todo o array de cartas e insere em uma posição aleatoria.
        // insere a carta na posiçao que estiver vazia, senao tenta outra posicao.
        for (Carta carta : cartas) {
            while (true) {
                int linha = random.nextInt(linhas);
                int coluna = random.nextInt(colunas);

                if (tabuleiro[linha][coluna] == null) {  
                    tabuleiro[linha][coluna] = carta;
                    break;
                }
            }
        }
    }
    
    
}
