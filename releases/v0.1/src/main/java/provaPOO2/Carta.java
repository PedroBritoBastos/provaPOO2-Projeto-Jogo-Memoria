package provaPOO2;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * Classe que cria uma carta com um valor
 */
public class Carta {
	private JButton carta;
	private char valor;
	private boolean virada = false;
	
	/**
	 * construtor da Carta
	 * @param valor
	 */
	public Carta(char valor) {
		this.valor = valor;
		this.carta = new JButton("?");
		this.carta.setPreferredSize(new Dimension(200, 300));
		this.carta.addActionListener(Eventos.EventoVirarCarta(this));
		this.carta.setFont(new Font("Arial", Font.BOLD, 70));
		this.carta.setBorder(new LineBorder(new Color(117, 108, 108), 8, false));
		this.carta.setBackground(new Color(145, 137, 137));
		this.carta.setForeground(Color.WHITE);
	}
	
	public JButton getCarta() {
		return this.carta;
	}
	
	public char getValor() {
		return this.valor;
	}
	
	public boolean getVirada() {
		return this.virada;
	}
	
	public void setVirada(boolean status) {
		this.virada = status;
	}
	
}
