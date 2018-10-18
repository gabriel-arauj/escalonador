import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class Teste {

	@SuppressWarnings("deprecation")
	@Test
	public void testFCFS() throws IOException {
		escalonador.parse(new String[] {"src/file.csv", "FCFS", "1"});
		
		AbstractEscalonador e = new FCFS(escalonador.processos);
		e.init();
		
		assertEquals(17, e.getTempoTotal());
		assertEquals(3, e.getTroca());
		assertEquals(4, e.terminados.size());
		assertEquals(4, e.getQuantProcess());
		assertEquals(0, e.prontos.size());
		assertEquals(0, e.processos.size());
		Estatisticas est = new Estatisticas(e);
		assertEquals(17.0, est.tempoTotal(), 0.05);
		assertEquals(82.35, est.utilCPU(), 0.05);
		assertEquals(0.23, est.mediaThroughput(), 0.05);
		assertEquals(9, est.mediaTurnaround(), 0.05);
		assertEquals(5.5, est.mediaTempoEsp(), 0.05);
		assertEquals(5.5, est.mediaTempoResp(), 0.05);
		assertEquals(3.0/4, est.mediaTrocaContexto(), 0.05);
	}

}
