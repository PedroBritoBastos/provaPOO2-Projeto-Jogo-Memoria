package provaPOO2;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Color;

/**
 * Cria uma janela 
 */
public class Janela {
	private JFrame janela;
	
	public Janela() {
		this.janela = new JFrame("Jogo da memória");
		this.janela.setSize(1000, 1500);
		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.getContentPane().setLayout(new BoxLayout(this.janela.getContentPane(), BoxLayout.Y_AXIS));
		this.janela.getContentPane().setBackground(new Color(255, 204, 204));
	}
	
	/**
	 * inicia a janela do jogo
	 */
	public void iniciar() {
		this.janela.setVisible(true);
	}
	
	public JFrame getJanela() {
		return this.janela;
	}
	
}
