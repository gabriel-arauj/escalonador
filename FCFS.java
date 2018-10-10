import java.util.ArrayList;

public class FCFS extends AbstractEscalonador{

	public FCFS(ArrayList<Processo> processos) {
		super(processos);
	}

	@Override
	public boolean run(Processo p) {

		if(p == null)
			return false;
		else {
			long bust = p.getBustTime();
			//System.out.println(bust);
			for(int i = 0; i < bust; i++) {
				tempoTotal++;
			}
			p.terminar(tempoTotal);
		}
		return true;
	}

	@Override
	public Processo CPUEscalonador() {
		while(iteratorProntos.hasNext()) {
			Processo p = iteratorProntos.next();
			if(p.estado == Estados.PRONTO) {
				return p;
			}
		}
		return null;
	}

}
