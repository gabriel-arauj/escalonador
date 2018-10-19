import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class Teste {

	@Test
	public void testFCFS() throws IOException {
		escalonador.parse(new String[] {"file.csv", "FCFS", "1"});
		
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

	@Test
	public void testSJF() throws IOException {
		escalonador.parse(new String[] {"file.csv", "FCFS", "1"});
		
		AbstractEscalonador e = new SJF(escalonador.processos);
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
		assertEquals(4.0/e.getTempoTotal(), est.mediaThroughput(), 0.005);
		assertEquals((10+8+10+7)/4.0, est.mediaTurnaround(), 0.005);
		assertEquals((7+5+9)/4.0, est.mediaTempoEsp(), 0.005);
		assertEquals((11-4+13-7+15-7)/4.0, est.mediaTempoResp(), 0.05);
		assertEquals(3.0/4, est.mediaTrocaContexto(), 0.05);
	}
	
	@Test
	public void testPriority() throws IOException {
escalonador.parse(new String[] {"file.csv", "FCFS", "1"});
		
		AbstractEscalonador e = new Priority(escalonador.processos);
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
	
	@Test
	public void testSJFP() throws IOException {
		escalonador.parse(new String[] {"file.csv", "FCFS", "1"});
		
		AbstractEscalonador e = new SJFP(escalonador.processos);
		e.init();
		
		assertEquals(19, e.getTempoTotal());
		assertEquals(5, e.getTroca());
		assertEquals(4, e.terminados.size());
		assertEquals(4, e.getQuantProcess());
		assertEquals(0, e.prontos.size());
		assertEquals(0, e.processos.size());
		Estatisticas est = new Estatisticas(e);
		assertEquals(19.0, est.tempoTotal(), 0.05);
		assertEquals((19-5)/19.0*100, est.utilCPU(), 0.05);
		assertEquals(4.0/e.getTempoTotal(), est.mediaThroughput(), 0.005);
		assertEquals((10+8+10+7)/4.0, est.mediaTurnaround(), 0.005);
		assertEquals((7+5+9)/4.0, est.mediaTempoEsp(), 0.005);
		assertEquals((11-4+13-7+15-7)/4.0, est.mediaTempoResp(), 0.05);
		assertEquals(3.0/4, est.mediaTrocaContexto(), 0.05);
	}
	
	@Test
	public void testPriorityP() throws IOException {
escalonador.parse(new String[] {"file.csv", "FCFS", "1"});
		
		AbstractEscalonador e = new PriorityP(escalonador.processos);
		e.init();
		
		assertEquals(18, e.getTempoTotal());
		assertEquals(4, e.getTroca());
		assertEquals(4, e.terminados.size());
		assertEquals(4, e.getQuantProcess());
		assertEquals(0, e.prontos.size());
		assertEquals(0, e.processos.size());
		Estatisticas est = new Estatisticas(e);
		assertEquals(18.0, est.tempoTotal(), 0.05);
		assertEquals((18-4)/18.0*100, est.utilCPU(), 0.05);
		assertEquals(0.23, est.mediaThroughput(), 0.05);
		assertEquals(9, est.mediaTurnaround(), 0.05);
		assertEquals(5.5, est.mediaTempoEsp(), 0.05);
		assertEquals(5.5, est.mediaTempoResp(), 0.05);
		assertEquals(3.0/4, est.mediaTrocaContexto(), 0.05);
	}
}
