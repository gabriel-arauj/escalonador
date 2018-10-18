import java.util.ArrayList;
import java.util.Iterator;

public class FCFS extends AbstractEscalonador {

	public FCFS(ArrayList<Processo> processos) {
		super(processos);
	}

	@Override
	public boolean run(Processo p) {

		if (p == null)
			return false;
		else {
			if(p.getTempoInit() == -1)
				p.setTempoInit(tempoTotal);
			long bust = p.getBustTime();
			for (int i = 0; i < bust; i++) {
				tempoTotal++;
				bustTotal++;
			}
			p.terminar(tempoTotal);
			iteratorProntos.remove();
			terminados.add(p);
			tempoTotal++; //esse temppo é pra troca de contexto
		}
		return true;
	}

	@Override
	public Processo CPUEscalonador() {
		iteratorProntos = prontos.iterator();
		if (iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			troca++;
			return p;
		}
		return null;
	}

}
