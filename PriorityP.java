import java.util.ArrayList;

public class PriorityP extends AbstractEscalonador  {

	Processo antigoP = null;
	public PriorityP(ArrayList<Processo> processos) {
		super(processos);
	}

	@Override
	public void run(Processo p) {
		if (p == null) {
			tempoTotal++; 
		}else {
			antigoP = p;
			if(p.getTempoInit() == -1)
				p.setTempoInit(tempoTotal);
			p.setRealBust(p.getRealBust() - 1);
			tempoTotal++;
			bustTotal++;
			if(p.getRealBust() == 0) {
				p.terminar(tempoTotal);
				terminados.add(p);
				prontos.remove(p);
			}
		}
	}

	@Override
	public Processo CPUEscalonador() {
		iteratorProntos = prontos.iterator();
		Processo aux = null;
		while(iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			if (aux == null || p.getPrioridade() < aux.getPrioridade()) {
				aux = p;
			}
		}
		if(antigoP != aux && antigoP != null) {
			troca++;
			tempoTotal ++;
		}
		return aux;
	}

}
