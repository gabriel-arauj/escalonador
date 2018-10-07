
public class Processo {
	int idProcesso;
	double tempoChegada;
	double bustTime;
	int prioridade;
	
	public int getIdProcesso() {
		return idProcesso;
	}
	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}
	public double getTempoChegada() {
		return tempoChegada;
	}
	public void setTempoChegada(double tempoChegada) {
		this.tempoChegada = tempoChegada;
	}
	public double getBustTime() {
		return bustTime;
	}
	public void setBustTime(double bustTime) {
		this.bustTime = bustTime;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public Processo(int idProcesso, double tempoChegada, double bustTime, int prioridade) {
		this.idProcesso = idProcesso;
		this.tempoChegada = tempoChegada;
		this.bustTime = bustTime;
		this.prioridade = prioridade;
	}
	
	
	
}
