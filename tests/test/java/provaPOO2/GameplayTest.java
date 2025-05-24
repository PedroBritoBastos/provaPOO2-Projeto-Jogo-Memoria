package provaPOO2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

public class GameplayTest {
	
	
	/* Testar se o valor de Finalizado está correto */
	@Test
	public void testVerificarFimDeJogo() {
		Gameplay gameplay = new Gameplay();
        Carta carta1 = new Carta('A');
        Carta carta2 = new Carta('B');
        
        carta1.setVirada(true);
        carta1.getCarta().setEnabled(false);

        carta2.setVirada(true);
        carta2.getCarta().setEnabled(false);
        
        Carta[][] cartas = {
            { carta1, carta2 }
        };
        
        gameplay.verificarFimDeJogo(cartas);
        assertEquals(true, gameplay.getEncerrado());
	}
	
	
	// testar se o metodo retorna o array de cartas
	@Test
	public void testPegarCartasViradas() {
		Gameplay gameplay = new Gameplay();
		
		// testando se retorna 2 cartas 
        Carta carta1 = new Carta('A');
        Carta carta2 = new Carta('B');
        Carta carta3 = new Carta('C');
        Carta carta4 = new Carta('D');
        
        carta1.setVirada(true);
        carta2.setVirada(true);
        
        Carta[][] cartas = {{carta1, carta2}, {carta3, carta4}};
        Carta[] cartaResultado = {carta1, carta2};
        
        assertEquals(cartaResultado, gameplay.pegarCartasViradas(cartas));
	}
	
	
	// testar se as cartas são iguais
	@Test
	public void testSaoIguais() {
		Gameplay gameplay = new Gameplay();
		
		// criando 2 cartas com valores iguais
        Carta carta1 = new Carta('A');
        Carta carta2 = new Carta('A');
        
        Carta[] cartasTeste = {carta1, carta2};
        
        // testando se o valor será true
        assertEquals(true, gameplay.saoIguais(cartasTeste));
        
        // criando 2 cartas com valores diferentes
        Carta carta3 = new Carta('G');
        Carta carta4 = new Carta('H');
        
        Carta[] cartasTesteDiferentes = {carta3, carta4};
        
        // testando se o valor será false
        assertEquals(false, gameplay.saoIguais(cartasTesteDiferentes));
	}
	
	
	// testando se o método está desvirando as cartas correntamente
	@Test
	public void testDesvirarCartas() {
		Gameplay gameplay = new Gameplay();
		
		// criando 2 cartas de teste
		Carta carta1 = new Carta('A');
		Carta carta2 = new Carta('B');
		
		carta1.setVirada(true);
		carta2.setVirada(true);
		
		Carta[] cartasTeste = {carta1, carta2};
		
		// testando
		gameplay.desvirarCartas(cartasTeste);
		assertEquals(false, carta1.getVirada());
		assertEquals(false, carta2.getVirada());
	}
}
