import java.util.ArrayList;

public class Priority extends AbstractEscalonador  {

	public Priority(ArrayList<Processo> processos) {
		super(processos);
	}

	@Override
	public boolean run(Processo p) {
		if (p == null) {
			tempoTotal++; //tempo total
			return false;
		}else {
			if(p.getEstado() == Estados.PRONTO)
				p.setTempoInit(tempoTotal);
			long bust = p.getBustTime();
			for (int i = 0; i < bust; i++) {
				tempoTotal++;
				bustTotal++;
			}
			p.terminar(tempoTotal);
			terminados.add(p);
			tempoTotal++; //tempo total
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
			troca++;
			prontos.remove(aux);
			return aux;
		}
	}

}
