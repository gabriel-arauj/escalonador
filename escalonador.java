import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class escalonador {

	static String caminho;
	static String tEscalonador;
	static String adicional;
	static int tipoEstat;
	static ArrayList<Processo> processos = new ArrayList<Processo>();
	

	static void parse(String[] args) throws IOException{
		try {
			caminho = args[0];
			tEscalonador = args[1];
			tipoEstat = Integer.parseInt(args[2]);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		if(tEscalonador.equals("RR")) {

		}
		
		BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/" + caminho)); 
		while(br.ready()){ 
			String linha = br.readLine(); 
			String dados[] = linha.split("[,;]");
			long tempoChegada = Long.parseLong(dados[0]);
			int idProcesso = Integer.parseInt(dados[1]);
			long bustTime = Long.parseLong(dados[2]);
			int prioridade = Integer.parseInt(dados[3]);
			Processo p = new Processo(idProcesso, tempoChegada, bustTime, prioridade);
			processos.add(p);
		} 
		br.close(); 
	}	
	public static void estatisticas(AbstractEscalonador e){
		System.out.println("Tempo total de processamento: " + e.tempoTotal);
		System.out.println("pecentual de utilização do CPU: " + 100*e.bustTotal/e.tempoTotal + "%");
		System.out.println("pecentual de utilização do CPU: " + 100*(e.tempoTotal-e.troca)/e.tempoTotal + "%");
		for(Processo p: e.terminados){
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException{
		parse(args);
		AbstractEscalonador e = new FCFS(processos);
		e.init();
		estatisticas(e);
	}
}
