import java.util.ArrayList;

public class PriorityP extends AbstractEscalonador  {
	
	Processo antigoP = null;
	public PriorityP(ArrayList<Processo> processos) {
		super(processos);
	}

	@Override
	public boolean run(Processo p) {
		if (p == null) {
			tempoTotal++; 
			return false;
		}else {
			if(antigoP!= p  && antigoP != null)
				tempoTotal ++;		
			System.out.println("tempo: "+ tempoTotal);
			System.out.println("p: "+ p.getIdProcesso());
	
			if(p.getEstado() == Estados.PRONTO && p.getTempoInit() == -1)
				p.setTempoInit(tempoTotal);
			antigoP = p;
			p.setRealBust(p.getRealBust() - 1);
			tempoTotal++;
			bustTotal++;
			if(p.getRealBust() == 0) {
				p.terminar(tempoTotal);
				terminados.add(p);
				prontos.remove(p);
			}
		}
		return true;
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
		if(aux == null) {
			return null;
		}else {
			if(antigoP != aux && antigoP != null) {
					troca++;
					antigoP.setEstado(Estados.PRONTO);
					System.out.println("tempo: "+ tempoTotal);
					System.out.println("troca");
			}
			return aux;
		}
	}

}
