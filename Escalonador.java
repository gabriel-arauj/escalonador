import java.util.ArrayList;
import java.util.Scanner;


public class Escalonador {
	
	static String caminho;
	static String tEscalonador;
	static String adicional;
	static int tipoEstat;
	static ArrayList<Processo> processos = new ArrayList<Processo>();
	
	
	static void parser(String argumento){
		try {
			String dados[];
			dados = argumento.split(":");
			caminho = dados[0];
			tEscalonador = dados[1];
			adicional = dados[2];
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		Scanner sc = new Scanner(caminho);
		while (sc.hasNext()) {
			String linha = sc.next();
			String dados[] = linha.split(";");
			double tempoChegada = Double.parseDouble(dados[0]);
			int idProcesso = Integer.parseInt(dados[1]);
			double bustTime = Double.parseDouble(dados[2]);
			int prioridade = Integer.parseInt(dados[3]);
			Processo p = new Processo(idProcesso, tempoChegada, bustTime, prioridade);
			processos.add(p);
		}
		
		sc.close();
	}	
	
	public static void main(String[] args){
		parser(args[0]);
	}
}
