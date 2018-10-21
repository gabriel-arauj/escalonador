import java.util.ArrayList;

public class FCFS extends AbstractEscalonador {

	public FCFS(ArrayList<Processo> processos) {
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
		if (iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			return p;
		}
		return null;
	}

}
