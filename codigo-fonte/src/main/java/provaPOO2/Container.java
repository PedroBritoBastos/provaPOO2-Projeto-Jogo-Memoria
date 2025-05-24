package provaPOO2;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Container {
	private JPanel painel;
	
	public Container() {
		this.painel = new JPanel();
	}
	
	public void adicionarFlowLayout() {
		this.painel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
	}
	
	public void adicionarEspacamento(int topo, int esquerda, int baixo, int direita) {
		this.painel.setBorder(new EmptyBorder(topo, esquerda, baixo, direita));
	}
	
	public JPanel getPainel() {
		return this.painel;
	}
	
	public void adicionarCor(String componente) {
		switch(componente) {
		case "titulo":
			this.painel.setBackground(new Color(125, 106, 106)); 
			break;
			
		case "cartas":
			this.painel.setBackground(new Color(84, 72, 72)); 
			break;
		}
		
	}
}
