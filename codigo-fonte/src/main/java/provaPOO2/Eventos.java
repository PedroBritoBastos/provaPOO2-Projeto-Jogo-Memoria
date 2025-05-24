package provaPOO2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Classe para criar eventos dos botões
 */
public class Eventos {

	/**
	 * cria um evento de virar carta
	 * mostra o valor da carta quando é disparado
	 * @param carta
	 * @return
	 */
    public static ActionListener EventoVirarCarta(Carta carta) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carta.getVirada()) {
                    carta.getCarta().setText(String.valueOf(carta.getValor()));
                    carta.getCarta().setBackground(new Color(209, 197, 197));
                    carta.setVirada(true);
                }
            }
        };
    }
    
    /**
     * cria um evento de fechar todas as janelas
     * fecha todas as janelas abertas
     * @return
     */
    public static ActionListener EventoFecharJanelas() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Frame f : Frame.getFrames()) {
                    f.dispose();
                }
            }
        };
    }
}
