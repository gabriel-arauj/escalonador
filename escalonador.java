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
	static int quantum;
	static ArrayList<Processo> processos = new ArrayList<Processo>();

	static void parse(String[] args) throws IOException {
		try {
			caminho = args[0];
			tEscalonador = args[1];
			tipoEstat = Integer.parseInt(args[2]);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		if (tEscalonador.equals("RR")) {
			quantum = Integer.parseInt(args[3]);
		}

		BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/" + caminho));
		while (br.ready()) {
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

	public static void estatisticas(AbstractEscalonador e) {
		Estatisticas est = new Estatisticas(e);
		if(tipoEstat == 1) {
			if(quantum != 0)
				System.out.println("algoritimo: " + tEscalonador + "quantum: " + quantum);
			else
				System.out.println("algoritimo: " + tEscalonador);
			System.out.println("Tempo total de processamento: " + est.tempoTotal());
			System.out.format("pecentual de utilização do CPU: %.2f%% %n", est.utilCPU());
			System.out.format("média throughput: %.2f %n", est.mediaThroughput());
			System.out.format("média turnaround: %.2f %n", est.mediaTurnaround());
			System.out.format("média tempo de espera: %.2f %n", est.mediaTempoEsp());
			System.out.format("média tempo de resposta: %.2f %n", est.mediaTempoResp());
			System.out.format("média troca de contexto: %.2f %n", est.mediaTrocaContexto());
			System.out.format("Número de processos executados: %d %n", e.quantProcess);
		}else {
			System.out.format("ID do processo   | Tempo de processamento%n");
			for(Processo p: e.terminados) {
			System.out.format("     %02d          |    %02d %n", p.getIdProcesso(), p.getTempoTermino() - p.getTempoInit());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		parse(args);
		AbstractEscalonador e = null;
		switch (tEscalonador) {
		case "FCFS":
			e = new FCFS(processos);
			break;
		case "SJF":
			e = new SJF(processos);
			break;
		case "SJFP":
			e = new SJFP(processos);
			break;
		case "Priority":
			e = new Priority(processos);
			break;
		case "PriorityP":
			e = new PriorityP(processos);
			break;
		case "RR":
			e = new RR(processos, quantum);
			break;
		default:
			break;
		}
		e.init();
		estatisticas(e);
	}
}
