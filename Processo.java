
public class Processo {
	int idProcesso;
	long tempoChegada;
	long bustTime;
	int prioridade;
	long tempoTermino;	
	Enum<Estados> estado;
	
	public int getIdProcesso() {
		return idProcesso;
	}
	public long getTempoChegada() {
		return tempoChegada;
	}

	public long getBustTime() {
		return bustTime;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public Processo(int idProcesso, long tempoChegada, long bustTime, int prioridade) {
		this.idProcesso = idProcesso;
		this.tempoChegada = tempoChegada;
		this.bustTime = bustTime;
		this.prioridade = prioridade;
		this.estado = Estados.NOVO;
	}
	public void terminar(long termino) {
		tempoTermino = termino;
		estado = Estados.TERMINADO;
	}
	
	
	
}
