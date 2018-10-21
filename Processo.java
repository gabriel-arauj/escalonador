
public class Processo {
	private int idProcesso;
	private long tempoChegada;
	private long bustTime;
	private int prioridade;
	private long tempoTermino;
	private long tempoInit;
	private Enum<Estados> estado;
	private long realBust;

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
		this.realBust = bustTime;
		this.prioridade = prioridade;
		this.setEstado(Estados.NOVO);
		this.tempoInit = -1;
	}

	public long getRealBust() {
		return realBust;
	}

	public void setRealBust(long realBust) {
		this.realBust = realBust;
	}

	public long getTempoTermino() {
		return tempoTermino;
	}

	public void terminar(long termino) {
		tempoTermino = termino;
		setEstado(Estados.TERMINADO);
	}

	public long getTempoInit() {
		return tempoInit;
	}

	public void setTempoInit(long tempoInit) {
		this.estado = Estados.RODANDO;
		this.tempoInit = tempoInit;
	}

	public Enum<Estados> getEstado() {
		return estado;
	}

	public void setEstado(Enum<Estados> estado) {
		this.estado = estado;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}
	

}
