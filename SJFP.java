import java.util.ArrayList;

public class SJFP extends AbstractEscalonador {
	
	Processo antigoP = null;
	public SJFP(ArrayList<Processo> processos) {
		super(processos);
	}


	@Override
	public Processo CPUEscalonador() {
		iteratorProntos = prontos.iterator();
		Processo aux = null;
		while(iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			if (aux == null || p.getBustTime() < aux.getBustTime()) {
				aux = p;
			}
		}
		if(antigoP != aux && antigoP != null) {
			troca++;
			tempoTotal ++;
		}
		return aux;
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

}
