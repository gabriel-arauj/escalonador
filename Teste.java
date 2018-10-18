import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class Teste {

	@Test
	public void testFCFS() throws IOException {
		escalonador.parse(new String[] {"src/file.csv", "FCFS", "1"});
		
		AbstractEscalonador e = new FCFS(escalonador.processos);
		e.init();
		assertEquals(21, e.tempoTotal);
		assertEquals(4, e.troca);
		assertEquals(5, e.terminados.size());
		assertEquals(0, e.prontos.size());
		assertEquals(0, e.processos.size());
	}

}
