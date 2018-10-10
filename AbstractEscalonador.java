import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractEscalonador {
	long bustTotal;
	long tempoTotal;
	ArrayList<Processo> processos = new ArrayList<Processo>();
	Iterator<Processo> iteratorProntos;

	public AbstractEscalonador(ArrayList<Processo> processos) {
		this.processos = processos;
		iteratorProntos = processos.iterator();
	}
	public abstract boolean run(Processo p);

	public abstract Processo CPUEscalonador();

	public boolean jobEscalonador() {
		for(Processo p: processos) {
			System.out.println("processo verificado: "+ p.estado + p.getIdProcesso());
			if(p.estado == Estados.NOVO && p.getTempoChegada() <= tempoTotal) {
				p.estado = Estados.PRONTO;
				System.out.println("processo add: "+ p.getIdProcesso());
			}else if (p.estado == Estados.NOVO){
				System.out.println("ola");
				return true;
			}
		}
		return false;		
	}
	public void init() {
		boolean job = true;
		while(iteratorProntos.hasNext() || job ) {
			job = jobEscalonador();
			Processo p = CPUEscalonador();
			run(p);
			tempoTotal ++;
		}
		
	}
}
