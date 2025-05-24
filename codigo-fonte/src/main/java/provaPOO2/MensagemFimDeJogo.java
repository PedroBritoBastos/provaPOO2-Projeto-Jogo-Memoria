package provaPOO2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

/**
 * Cria uma janela com a mensagem de fim de jogo
 */
public class MensagemFimDeJogo {
    private JFrame caixaMensagem;
    
    /**
     * construtor da classe 
     * @param tentativas
     */
    public MensagemFimDeJogo(int tentativas) {
        this.caixaMensagem = new JFrame("Fim de jogo!");
        this.caixaMensagem.setSize(300, 180);
        this.caixaMensagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.caixaMensagem.setLocationRelativeTo(null);
        this.caixaMensagem.setLayout(new BorderLayout());

        JLabel mensagem = new JLabel("Fim de jogo!", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 24));
        this.caixaMensagem.add(mensagem, BorderLayout.CENTER);

        JLabel mensagemTentativas = new JLabel("Tentativas: " + tentativas, SwingConstants.CENTER);
        mensagemTentativas.setFont(new Font("Arial", Font.PLAIN, 16));
        mensagemTentativas.setBorder(new EmptyBorder(20, 0, 0, 0));
        this.caixaMensagem.add(mensagemTentativas, BorderLayout.NORTH);

        JButton botaoFechar = new JButton("fechar");
        botaoFechar.setPreferredSize(new Dimension(80, 30));
        botaoFechar.addActionListener(Eventos.EventoFecharJanelas());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoFechar);
        this.caixaMensagem.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    /**
     * mostra a janela com a mensagem
     */
    public void mostrar() {
        this.caixaMensagem.setVisible(true);
    }
}
