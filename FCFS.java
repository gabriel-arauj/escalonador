import java.util.ArrayList;

public class FCFS extends AbstractEscalonador {

	public FCFS(ArrayList<Processo> processos) {
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
		if (iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			troca++;
			iteratorProntos.remove();
			return p;
		}
		return null;
	}

}
