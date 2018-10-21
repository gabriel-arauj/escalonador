import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractEscalonador {
    protected long bustTotal;
    protected long tempoTotal = 0;
    protected int quantProcess;
    protected long troca;
    ArrayList<Processo> processos = new ArrayList<Processo>();
	ArrayList<Processo> prontos = new ArrayList<Processo>();
	ArrayList<Processo> terminados = new ArrayList<Processo>();
	Iterator<Processo> iteratorProntos;
	
	public AbstractEscalonador(ArrayList<Processo> processos) {
		this.processos = processos;
		quantProcess = processos.size();
	}
	
	public void jobEscalonador() {
		Iterator<Processo> iteratorProcessos = processos.iterator();
		while (iteratorProcessos.hasNext()) {
			Processo p = iteratorProcessos.next();
			if (p.getEstado() == Estados.NOVO && p.getTempoChegada() <= tempoTotal) {
				p.setEstado(Estados.PRONTO);
				prontos.add(p);
				iteratorProcessos.remove();
			}
		}
	}
	
	public void init() {
		while (quantProcess != terminados.size()) {
			jobEscalonador();
			Processo p = CPUEscalonador();
			run(p);
		}
	}
	
	public long getBustTotal() {
		return bustTotal;
	}

	public void setBustTotal(long bustTotal) {
		this.bustTotal = bustTotal;
	}

	public long getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(long tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public int getQuantProcess() {
		return quantProcess;
	}

	public void setQuantProcess(int quantProcess) {
		this.quantProcess = quantProcess;
	}

	public long getTroca() {
		return troca;
	}

	public void setTroca(long troca) {
		this.troca = troca;
	}
	
	public abstract void run(Processo p);

	public abstract Processo CPUEscalonador();

}
