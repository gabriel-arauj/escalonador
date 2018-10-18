import java.util.ArrayList;
import java.util.Iterator;


public abstract class AbstractEscalonador {
	long bustTotal;
	long tempoTotal;
	int quantProcess;
	long troca;
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
		while(iteratorProcessos.hasNext()) {
			Processo p = iteratorProcessos.next();
			if(p.estado == Estados.NOVO && p.getTempoChegada() <= tempoTotal) {
				p.estado = Estados.PRONTO;
				prontos.add(p);
				iteratorProcessos.remove();
			}
		}		
	}
	public void init() {
		while(quantProcess != terminados.size()) {
			jobEscalonador();
			Processo p = CPUEscalonador();
			run(p);
			tempoTotal ++;
		}
		tempoTotal--;
		troca--;
		
	}
	public abstract boolean run(Processo p);

	public abstract Processo CPUEscalonador();

}
	
