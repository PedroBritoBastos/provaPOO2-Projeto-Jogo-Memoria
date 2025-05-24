package provaPOO2;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/**
 * Classe para criar os textos do jogo
 */
public class Texto {
	private JLabel texto;
	
	/**
	 * Construtor da classe Texto
	 * @param texto
	 */
	public Texto(String texto) {
		this.texto = new JLabel(texto);
		this.texto.setForeground(Color.WHITE);
	}
	
	/**
	 * Define o tamanho da fonte recebendo um tamanho como parâmetro
	 * @param tamanho
	 */
	public void aumentarFonte(int tamanho) {
		this.texto.setFont(new Font("Arial", Font.PLAIN, tamanho));
	}
	
	/**
	 * Adiciona espaçamento ao texto
	 * @param topo
	 * @param esquerda
	 * @param baixo
	 * @param direita
	 */
	public void adicionarEspacamento(int topo, int esquerda, int baixo, int direita) {
		this.texto.setBorder(new EmptyBorder(topo, esquerda, baixo, direita));
	}
	
	/**
	 * retorna o componente
	 * @return
	 */
	public JLabel getTexto() {
		return this.texto;
	}

	
}
