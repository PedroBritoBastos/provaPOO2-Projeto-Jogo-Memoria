package provaPOO2;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * Classe para toda a lógica do jogo
 */
public class Gameplay {
    private boolean encerrado = false;
    private int tentativas = 0;
    private boolean aguardandoVirarCartas = false; 

    /**
     * retorna as cartas viradas pelo jogador
     * @param cartas -> o tabuleiro atual
     * @return cartas encontradas
     */
    public Carta[] pegarCartasViradas(Carta[][] cartas) {
        Carta[] encontradas = new Carta[2];
        int index = 0;

        for (int i = 0; i < cartas.length && index < 2; i++) {
            for (int j = 0; j < cartas[i].length && index < 2; j++) {
                Carta atual = cartas[i][j];
                if (atual.getVirada() && atual.getCarta().isEnabled()) {
                    encontradas[index] = atual;
                    index++;
                }
            }
        }

        return encontradas; // Pode conter 0, 1 ou 2 cartas, com valores null nas posições não preenchidas
    }
    
    
    /**
     * verifica se foram viradas duas cartas
     * @param cartasViradas -> o array com as cartas duas viradas
     * @return um booleano indicando se há duas cartas viradas
     */
    public boolean temDuasCartas(Carta[] cartasViradas) {
    	
    	// retorna falso de alguma posição for null
    	for(int i = 0; i <= cartasViradas.length - 1; i++) {
    		
    		if(cartasViradas[i] == null) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    /**
     * verifica se as duas cartas viradas são iguais
     * @param cartasViradas
     * @return um booleano indicando se as cartas são iguais
     */
    public boolean saoIguais(Carta[] cartasViradas) {
    	
    	// compara se as duas cartas sao diferentes
    	if(cartasViradas[0].getValor() != cartasViradas[1].getValor()) {
    		return false;
    	}
    	
    	return true;
    }
    
    
    /**
     * desativa todas as cartas viradas
     * @param cartasViradas -> o array de cartas viradas
     */
    public void desativarCartas(Carta[] cartasViradas) {
        cartasViradas[0].getCarta().setEnabled(false);
        cartasViradas[1].getCarta().setEnabled(false);
    }

    
    /**
     * esconde o valor das cartas e desvira
     * @param cartasViradas -> o array de cartas viradas
     */
    public void desvirarCartas(Carta[] cartasViradas) {
    	this.aguardandoVirarCartas = true;
    	
        final Carta c1 = cartasViradas[0];
        final Carta c2 = cartasViradas[1];

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.getCarta().setText("?");
                c2.getCarta().setText("?");
                
                c1.getCarta().setBackground(new Color(145, 137, 137));
                c2.getCarta().setBackground(new Color(145, 137, 137));

                c1.setVirada(false);
                c2.setVirada(false);
                
                aguardandoVirarCartas = false;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
   
    /**
     * verifica se todas as jogadas possiveis foram concluidas
     * altera o estado de encerrado caso o jogo seja finalizado
     * @param cartas
     */
    public void verificarFimDeJogo(Carta[][] cartas) {
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas[i].length; j++) {
                if (cartas[i][j].getCarta().isEnabled()) {
                    return;
                }
            }
        }
        this.encerrado = true;
    }
    
    /**
     * retorna o estado de encerrado
     * @return
     */
    public boolean getEncerrado() {
        return this.encerrado;
    }
    
    /**
     * retorna a quantidade de tentativas
     * @return
     */
    public int getTentativas() {
        return this.tentativas;
    }
    
    /**
     * altera o valor de tentativas
     * @param valor
     */
    public void setTentativas(int valor) {
        this.tentativas = valor;
    }
    
    
    /**
     * incrementa o numero de tentativas
     */
    public void incrementarTentativas() {
        this.tentativas++;
    }
    
    /**
     * retorna o estado de aguardar as cartas serem viradas
     * @return
     */
    public boolean getAguardandoVirarCartas() {
    	return this.aguardandoVirarCartas;
    }
}
