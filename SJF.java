import java.util.ArrayList;

public class SJF extends AbstractEscalonador {

	public SJF(ArrayList<Processo> processos) {
		super(processos);
	}

	@Override
	public void run(Processo p) {
		if (p == null)
			tempoTotal++;
		else{
			if(p.getEstado() == Estados.PRONTO)
				p.setTempoInit(tempoTotal);
			tempoTotal += p.getBustTime();
			bustTotal += p.getBustTime();
			p.terminar(tempoTotal);
			terminados.add(p);
			prontos.remove(p);
			if(quantProcess != terminados.size()) {
				troca++;
				tempoTotal++; //add 1 para tempo de troca
			}	
		}
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
		return aux;
	}

}
