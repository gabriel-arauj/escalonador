
public class Estatisticas {
	AbstractEscalonador e;

	public Estatisticas(AbstractEscalonador e) {
		super();
		this.e = e;
	}
	public double tempoTotal() {
		return e.getTempoTotal();
	}
	public double utilCPU() {
		return 100.0 * (e.getTempoTotal() - e.getTroca()) / e.getTempoTotal() ;
	}
	public double mediaThroughput() {
		return (double)e.getQuantProcess()/e.getTempoTotal();
	}
	public double mediaTurnaround() {
		long sum = 0;
		for(Processo p: e.terminados) {
			sum += p.getTempoTermino() - p.getTempoChegada();
		}
		return (double)sum/e.getQuantProcess();
	}
	
	public double mediaTempoEsp() {
		long sum = 0;
		for(Processo p: e.terminados) {
			sum += p.getTempoTermino() - p.getTempoChegada() - p.getBustTime();
		}
		return (double)sum/e.getQuantProcess();
	}
	
	public double mediaTempoResp() {
		long sum = 0;
		for(Processo p: e.terminados) {
			sum += p.getTempoInit() - p.getTempoChegada();
		}
		return (double)sum/e.getQuantProcess();
	}
	public double mediaTrocaContexto() {
		return (double)e.getTroca()/e.getQuantProcess();
	}
	
}
