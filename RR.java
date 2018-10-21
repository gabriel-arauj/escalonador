import java.util.ArrayList;

public class RR extends AbstractEscalonador {
	
	int quantum;
	Processo antigoP = null;
	public RR(ArrayList<Processo> processos, int quantum) {
		super(processos);
		this.quantum = quantum;
	}
	@Override
	public void run(Processo p) {
		if (p == null) {
			tempoTotal++; 
		}else {
			antigoP = p;
			if(p.getTempoInit() == -1)
				p.setTempoInit(tempoTotal);
			for (int i = 0; i < quantum; i++) {
				p.setRealBust(p.getRealBust() - 1);
				tempoTotal++;
				bustTotal++;
				jobEscalonador();
				if(p.getRealBust() == 0) {
					p.terminar(tempoTotal);
					terminados.add(p);
					prontos.remove(p);
					return;
				}			
			}
			prontos.remove(p);
			prontos.add(p);
		}
	}

	@Override
	public Processo CPUEscalonador() {
		iteratorProntos = prontos.iterator();
		Processo aux = null;
		if (iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			aux = p;
		}
		if(antigoP != aux && antigoP != null) {
			troca++;
			tempoTotal ++;
		}
		return aux;
	}
}
