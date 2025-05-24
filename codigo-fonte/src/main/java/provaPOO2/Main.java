package provaPOO2;

public class Main {

	public static void main(String[] args) {
		
		// cria a janela do jogo
		Janela janela = new Janela();
		
		// criando containers para label e cartas
		Container containerLabel = new Container();
		Container containerCartas = new Container();
		containerCartas.adicionarFlowLayout();
		containerCartas.adicionarEspacamento(50, 0, 650, 0);
		containerLabel.adicionarCor("titulo");
		containerCartas.adicionarCor("cartas");
		
		// adicionando os containers
		janela.getJanela().add(containerLabel.getPainel());
		janela.getJanela().add(containerCartas.getPainel());
		
		// inserindo texto no container de label
		Texto nomeJogoLabel = new Texto("JOGO DA MEMORIA");
		nomeJogoLabel.aumentarFonte(40);
		nomeJogoLabel.adicionarEspacamento(20, 10, 10, 10);
		containerLabel.getPainel().add(nomeJogoLabel.getTexto());
		
		// criando um array com 10 caracteres que serão usados como valores das cartas
		char[] valores = {'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E'};
		
		// criando 10 cartas com os valores
		Carta[] cartas = new Carta[10]; 
		for(int i = 0; i <= valores.length - 1; i++) {
			cartas[i] = new Carta(valores[i]);
		}

		// inserindo as cartas e embaralhando no tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inserirCartaAleatoria(cartas);
		
		// insere as cartas no container de cartas para serem visíveis
		for(int linha = 0; linha <= 1; linha++) {
			for(int coluna = 0; coluna <= 4; coluna++) {
				containerCartas.getPainel().add(tabuleiro.tabuleiro[linha][coluna].getCarta());
			}
		}
		
		
		// iniciando as partidas
		// enquanto o jogo não é encerrado, as partidas continuam rodando
		Gameplay gameplay = new Gameplay();
		Texto tentativasLabel = new Texto("tentativas: " + gameplay.getTentativas());
		tentativasLabel.aumentarFonte(20);
		tentativasLabel.adicionarEspacamento(20, 20, 0, 0);
		containerLabel.getPainel().add(tentativasLabel.getTexto());
		
		while(!gameplay.getEncerrado()) {
			janela.iniciar();
			
			if(gameplay.getEncerrado()) break; // verifica se a partida foi encerrada
			
			if (gameplay.getAguardandoVirarCartas()) continue; // aguarda até que as cartas sejam viradas
			
			// pega as cartas viradas no tabuleiro
			Carta[] cartasViradas = gameplay.pegarCartasViradas(tabuleiro.tabuleiro);
			
			// faz a comparação das cartas se forem iguais
			// incrementa tentativas toda vez que duas cartas são viradas
			if(gameplay.temDuasCartas(cartasViradas)) {
				gameplay.incrementarTentativas();
				
				// desativa as duas cartas mantendo seu valor na tela se forem iguais
				// desvira as duas se forem diferentes
				if(gameplay.saoIguais(cartasViradas)) {
					gameplay.desativarCartas(cartasViradas);
					
				} else {
					gameplay.desvirarCartas(cartasViradas);

				}
			}
			
			// limpa cartasViradas
			cartasViradas[0] = null;
			cartasViradas[1] = null;
			
			// atualiza o contador de tentativas
			tentativasLabel.getTexto().setText("tentativas: " + gameplay.getTentativas());
			gameplay.verificarFimDeJogo(tabuleiro.tabuleiro); // verifica se o jogo chegou ao fim
			
		} // <- fim do loop
		
		// exibe a mensagem de fim de jogo
		MensagemFimDeJogo mensagem = new MensagemFimDeJogo(gameplay.getTentativas());
		mensagem.mostrar();
		
		
	}

}
