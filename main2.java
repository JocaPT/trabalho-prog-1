package trabalho_prático_3;

import java.util.Scanner;


public class main {

	public static String leituraDadosString(Scanner scanner, String msg) {
		System.out.println(msg);
		return scanner.next();
	}

	public static String leituraDeTexto(Scanner scannerStrings, String msg) {
		System.out.println(msg);
		return scannerStrings.next();
	}


	public static int leituraDadosInt(Scanner scanner, String msg) {
		System.out.println(msg);
		return scanner.nextInt();
	}

	public static boolean verificarDados(int dataIntroduzida[], int index, int n1, int n2) {
		if(dataIntroduzida[index] >= n1 && dataIntroduzida[index] <= n2) {
			return false;
		} else {
			System.out.println("\nIntroduza um valor válido.");
			return true;
		}
	}

	public static boolean verificarDados(int dataIntroduzida[], int index, int n1) {
		if(dataIntroduzida[index] >= n1) {
			return false;
		} else {
			System.out.println("\nIntroduza um valor válido.");
			return true;
		}
	}

	public static String verificarTemPrazo(boolean temPrazo[], int data[][], int i) {
		String dataApresentar = "";

		if(temPrazo[i]) {
			dataApresentar = data[i][0] + "/" + data[i][1] + "/" + data[i][2];
		} else {
			dataApresentar = "          ";
		}

		return dataApresentar;
	}

	public static char verificarFoiFeita(boolean foiFeita[], int i) {
		char feitoX = ' ';

		if(foiFeita[i]) {
			feitoX = 'X';
		} else {
			feitoX = ' ';
		}

		return feitoX;
	}

	public static boolean verificarData(int dataIntroduzida[], int data[][], int i, boolean foiFeita[]) {
		if(dataIntroduzida[0] == data[i][0] && dataIntroduzida[1] == data[i][1] && dataIntroduzida[2] == data[i][2] && !foiFeita[i]) {
			return true;
		} else {
			return false;
		}
	}

	public static void menuVisualizar(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[]) {
		do {
			do {
				System.out.println("\n#-#-# Visualizar #-#-#");
				System.out.println("Visualizar (t)odas");
				System.out.println("Visualizar (d)ia d");
				System.out.println("Visualizar (a)té dia d");
				System.out.println("Visualizar (p)or fazer");
				System.out.println("Visualizar (f)eitas");
				System.out.println("Visualizar por pa(l)avra p");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scanner, "Introduza uma letra: ");

				switch (opcaoSubMenu) {
				case "t": case "T":
					subMenuValido = true;
					visualizarTodas(tarefa, temPrazo, foiFeita, data, nTarefas);
					break;

				case "d": case "D":
					subMenuValido = true;
					visualizarDia(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas);
					break;

				case "a": case "A":
					subMenuValido = true;
					visualizarAteDia(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas);
					break;

				case "p": case "P":
					subMenuValido = true;
					visualizarPorFazer(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas);
					break;

				case "f": case "F":
					subMenuValido = true;
					visualizarFeitas(tarefa, temPrazo, foiFeita, data, nTarefas);
					break;

				case "l": case "L":
					subMenuValido = true;
					visualizarPorPalavra(scanner, scannerStrings, nTarefas, tarefa, temPrazo, foiFeita, data);
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu=true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					subMenuValido = false;
					break;
				}
			} while(!subMenuValido);
		} while(!sairSubMenu);
	}

	public static void visualizarTodas(String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas) {
		System.out.printf("%9s %22s %12s\n", "Tarefa", "Data", "Feita");

		for(int i = 0; i < nTarefas; i++) {
			System.out.printf("%d: %-24s %-11s %c\n", i+1, tarefa[i], verificarTemPrazo(temPrazo, data, i), verificarFoiFeita(foiFeita, i));
		}
	}

	public static void visualizarDia(Scanner scanner, int dataIntroduzida[] ,String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas) {
		boolean foiEncontrado = false;

		do  {
			dataIntroduzida[0] = leituraDadosInt(scanner, "Introduza o dia: ");
		} while(verificarDados(dataIntroduzida, 0, 1, 31));

		do  {
			dataIntroduzida[1] = leituraDadosInt(scanner, "Introduza o mês: ");
		} while(verificarDados(dataIntroduzida, 1, 1, 12));

		do  {
			dataIntroduzida[2] = leituraDadosInt(scanner, "Introduza o ano: ");
		} while(verificarDados(dataIntroduzida, 2, 1));

		System.out.printf("%9s %22s\n", "Tarefa", "Data");

		for(int i = 0; i < nTarefas; i++) {
			if(verificarData(dataIntroduzida, data,  i, foiFeita)) {
				foiEncontrado = true;
				System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa a realizar nesse dia.");
		}
	}

	public static void visualizarAteDia(Scanner scanner, int dataIntroduzida[] ,String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas) {
		boolean foiEncontrado = false;

		do  {
			dataIntroduzida[0] = leituraDadosInt(scanner, "Introduza o dia: ");
		} while(verificarDados(dataIntroduzida, 0, 1, 31));

		do  {
			dataIntroduzida[1] = leituraDadosInt(scanner, "Introduza o mês: ");
		} while(verificarDados(dataIntroduzida, 1, 1, 12));

		do  {
			dataIntroduzida[2] = leituraDadosInt(scanner, "Introduza o ano: ");
		} while(verificarDados(dataIntroduzida, 2, 1));

		System.out.printf("%9s %22s\n", "Tarefa", "Data");

		for(int i = 0; i < nTarefas; i++) {
			if((!foiFeita[i] && temPrazo[i]) && (dataIntroduzida[0] >= data[i][0] && dataIntroduzida[1] >= data[i][1] && dataIntroduzida[2] >= data[i][2])) {
				foiEncontrado = true;
				System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa a realizar nesse dia.");
		}
	}


	public static void visualizarPorFazer(Scanner scanner, int dataIntroduzida[] ,String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas) {
		boolean foiEncontrado = false;

		for(int i = 0; i < nTarefas; i++) {
			if(!foiFeita[i]) {
				foiEncontrado = true;
				System.out.printf("%d: %-24s %s\n", i+1, tarefa[i], verificarTemPrazo(temPrazo, data, i));
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa a realizar nesse dia.");
		}
	}

	public static void visualizarFeitas(String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas) {
		System.out.printf("%9s %22s\n", "Tarefa", "Data");
		boolean foiEncontrado=false;
		for(int i = 0; i < nTarefas; i++) {
			if(foiFeita[i]) {
				foiEncontrado = true;

				System.out.printf("%d: %-24s %s\n", i+1, tarefa[i], verificarTemPrazo(temPrazo, data, i));
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa feita.");
		}
	}

	public static String leituraDePalavra(Scanner scannerStrings) {
		System.out.println("\nIntroduza a palavra a procurar: ");
		return scannerStrings.next();                                     

	}




	public static void visualizarPorPalavra(Scanner scanner,Scanner scannerStrings, int nTarefas, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][]) {
		String palavra = leituraDePalavra(scannerStrings);
		boolean foiEncontrado=false;
		System.out.printf("%9s %22s %12s\n", "Tarefa", "Data", "Feita");
		for(int i = 0; i < nTarefas; i++) {
			if(tarefa[i].indexOf(palavra) != -1) {
				foiEncontrado = true;

				System.out.printf("%d: %-24s %-11s %c\n", i+1, tarefa[i], verificarTemPrazo(temPrazo, data, i), verificarFoiFeita(foiFeita, i));
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa que contenha essa palavra.");
		}

	}

	public static boolean verificacaoDeTarefaN(int numeroTarefa, int nTarefas) {
		if(numeroTarefa >= 0 && numeroTarefa <= nTarefas) {
			return true;
		} else {
			return false;
		}
	}

	public static void menuMarcacao(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[], boolean numeroTarefaValido,int ultimoEditado, int numeroTarefa, boolean foiEncontrado) {
		do {
			do {
				System.out.println("\n#-#-# Marcação #-#-#");
				System.out.println("Marcar como (f)eita por número");
				System.out.println("Marcar como feita por (t)exto");
				System.out.println("(D)esmarcar última feita");
				System.out.println("Marcar todas (n)o dia d");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scanner,"Introduza uma letra:");  

				switch (opcaoSubMenu) {
				case "f": case "F":
					subMenuValido = true;
					marcarComoFeitaPorNumero(scanner,numeroTarefa, nTarefas, numeroTarefaValido, foiFeita, ultimoEditado);
					break;

				case "t": case "T":
					subMenuValido = true;
					marcarComoFeitaPorTexto(scannerStrings, nTarefas, foiFeita, ultimoEditado, foiEncontrado, tarefa);
					break;

				case "d": case "D":
					subMenuValido = true;

					break;

				case "n": case "N":
					subMenuValido = true;
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu=true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					subMenuValido = false;
					break;
				}
			} while(!subMenuValido);
		} while(!sairSubMenu);
	}

	public static void marcarComoFeitaPorNumero(Scanner scanner, int numeroTarefa, int nTarefas, boolean numeroTarefaValido, boolean foiFeita[], int ultimoEditado) {
		do {

			leituraDadosInt(scanner, "\nIntroduza o número da tarefa: ");
			numeroTarefa -= 1;

			if (verificacaoDeTarefaN(numeroTarefa, nTarefas))
				numeroTarefaValido= true;
			else
				System.out.println("\nNão existe nenhuma tarefa com este número.");

		} while(!numeroTarefaValido);                                                                        

		foiFeita[numeroTarefa] = true;
		ultimoEditado = numeroTarefa;
		System.out.printf("A tarefa com número %d foi marcada como feita.", numeroTarefa + 1);
	}

	public static void marcarComoFeitaPorTexto(Scanner scannerStrings, int nTarefas, boolean foiFeita[], int ultimoEditado, boolean foiEncontrado, String tarefa[]) {

		String texto = "";

		leituraDeTexto(scannerStrings, "Introduza uma palavra");

		for(int i = 0; i < nTarefas; i++) {
			if(tarefa[i].indexOf(texto) != -1) {                         //nao sei

				foiFeita[i] = true;
				foiEncontrado = true;
				ultimoEditado = i;
				System.out.printf("A tarefa com o texto %s foi marcada como feita.", texto);
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa que contenha essa palavra.");
		}
	}

	public static void desmarcarUltimaFeita(Scanner scannerStrings, int nTarefas, boolean foiFeita[], int ultimoEditado, boolean foiEncontrado, String tarefa[]) {
		if(ultimoEditado != -1) {
			foiFeita[ultimoEditado] = false;
			System.out.printf("A tarefa com número %d foi marcada como por fazer.", ultimoEditado + 1);
		} else {
			System.out.println("Ainda não modificou nenhuma tarefa.");
		}
	}

	public static void marcarTodasNoDiaN(Scanner scanner, Scanner scannerStrings, int nTarefas, boolean foiFeita[], int ultimoEditado, boolean foiEncontrado, String tarefa[], int dataIntroduzida[], int data[][]) {
		do  {
			dataIntroduzida[0] = leituraDadosInt(scanner, "Introduza o dia: ");
		} while(verificarDados(dataIntroduzida, 0, 1, 31));

		do  {
			dataIntroduzida[1] = leituraDadosInt(scanner, "Introduza o mês: ");
		} while(verificarDados(dataIntroduzida, 1, 1, 12));

		do  {
			dataIntroduzida[2] = leituraDadosInt(scanner, "Introduza o ano: ");
		} while(verificarDados(dataIntroduzida, 2, 1));

		for(int i = 0; i < nTarefas; i++) {
			if(dataIntroduzida[0] == data[i][0] && dataIntroduzida[1] == data[i][1] && dataIntroduzida[2] == data[i][2] && !foiFeita[i]) {

				foiEncontrado = true;
				foiFeita[i] = true;

				System.out.printf("\nA tarefa com número %d foi marcada como feita.", i + 1);
			}
		}

		if(!foiEncontrado) {
			System.out.println("\nNão existe nenhuma tarefa a realizar até esse dia.");
		}

	}

	public static void menuEditar(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[], boolean numeroTarefaValido,int ultimoEditado, int numeroTarefa, boolean foiEncontrado) {
		do {
			do {
				System.out.println("\n#-#-# Editar #-#-#");
				System.out.println("(A)dicionar tarefa");
				System.out.println("Adicionar (t)arefa na posição n");
				System.out.println("Apagar tarefa na (p)osição n");
				System.out.println("Apagar (f)eitas");
				System.out.println("(E)ditar tarefa");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scanner,"Introduza uma letra:");  

				switch (opcaoSubMenu) {
				case "a": case "A":
					subMenuValido = true;
					break;

				case "t": case "T":
					subMenuValido = true;

					break;

				case "n": case "N":
					subMenuValido = true;

					break;

				case "p": case "P":
					subMenuValido = true;
					break;

				case "f": case "F":
					subMenuValido = true;
					break;

				case "e": case "E":
					subMenuValido = true;
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu=true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					subMenuValido = false;
					break;
				}
			} while(!subMenuValido);
		} while(!sairSubMenu);
	}

	public static boolean adicionarTarefa(int numeroTarefa, int nTarefas) {

		if(nTarefas - 1 >= tamMax) {
			System.out.printf("\nJá existe o número máximo de tarefas, o máximo é %d.", tamMax);
			break;
		}

		System.out.println("\nIntroduza a descrição da tarefa: ");
		tarefa[nTarefas] = scannerStrings.nextLine();

		do {
			System.out.println("\nA tarefa está feita? (S / N)");
			booleanoIntroduzido = scanner.next();

			if(booleanoIntroduzido.equalsIgnoreCase("s")) {
				foiFeita[nTarefas] = true;
				booleanValido = true;
			} else if(booleanoIntroduzido.equalsIgnoreCase("n")) {
				foiFeita[nTarefas] = false;
				booleanValido = true;
			} else {
				System.out.println("\nIntroduza uma opção valida.");
			}
		} while(!booleanValido);
		booleanValido = false;

		do {
			System.out.println("\nA tarefa tem prazo? (S / N)");
			booleanoIntroduzido = scanner.next();

			if(booleanoIntroduzido.equalsIgnoreCase("s")) {
				temPrazo[nTarefas] = true;
				booleanValido = true;
			} else if(booleanoIntroduzido.equalsIgnoreCase("n")) {
				temPrazo[nTarefas] = false;
				booleanValido = true;
			} else {
				System.out.println("\nIntroduza uma opção valida.");
			}
		} while(!booleanValido);
		booleanValido = false;

		if(temPrazo[nTarefas]) {
			do  {
				dataIntroduzida[0] = leituraDadosInt(scanner, "Introduza o dia: ");
			} while(verificarDados(dataIntroduzida, 0, 1, 31));

			do  {
				dataIntroduzida[1] = leituraDadosInt(scanner, "Introduza o mês: ");
			} while(verificarDados(dataIntroduzida, 1, 1, 12));

			do  {
				dataIntroduzida[2] = leituraDadosInt(scanner, "Introduza o ano: ");
			} while(verificarDados(dataIntroduzida, 2, 1));

			data[nTarefas][0] = dataIntroduzida[0];
			data[nTarefas][1] = dataIntroduzida[1];
			data[nTarefas][2] = dataIntroduzida[2];
		}

		nTarefas += 1;

		System.out.println("\nA tarefa foi criada com sucesso.");	

	}







	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner scannerStrings = new Scanner(System.in);

		int tamMax = 100;
		int data[][] = new int[tamMax][3];
		int nTarefas = 0;

		String[] tarefa = new String[tamMax];

		boolean temPrazo[] = new boolean[tamMax];
		boolean foiFeita[] = new boolean[tamMax];

		tarefa[0] = "Ir ao dentista"; temPrazo[0] = true; foiFeita[0] = false; data[0][0] = 17; data[0][1] = 12; data[0][2] = 2020;
		tarefa[1] = "Teste prático de P1"; temPrazo[1] = true; foiFeita[1] = true; data[1][0] = 14; data[1][1] = 12; data[1][2] = 2020;
		tarefa[2] = "Corrigir testes"; temPrazo[2] = false; foiFeita[2] = false;
		tarefa[3] = "Frequência de P1"; temPrazo[3] = true; foiFeita[3] = false; data[3][0] = 13; data[3][1] = 01; data[3][2] = 2021;
		tarefa[4] = "Presentes!!"; temPrazo[4] = true; foiFeita[4] = false; data[4][0] = 25; data[4][1] = 12; data[4][2] = 2020;

		nTarefas = 5;

		String opcaoMenuPrincipal = "";
		String opcaoSubMenu = "";
		String opcaoEditarSubMenu = "";

		boolean menuPrincipalValido = false;
		boolean sairMenuPrincipal = false;
		boolean subMenuValido = false;
		boolean sairSubMenu = false;
		boolean editarSubMenuValido = false;
		boolean sairEditarSubMenu = false;

		String dataApresentar = "";
		String palavraProcurar = "";
		String booleanoIntroduzido = "";

		char feitoX = ' ';

		int dataIntroduzida[] = new int[3];
		int ultimoEditado = -1;
		int numeroTarefa = -1;
		int tarefasApagadas = 0;

		boolean diaValido = false;
		boolean mesValido = false;
		boolean anoValido = false;
		boolean foiEncontrado = false;
		boolean numeroTarefaValido = false;
		boolean booleanValido = false;

		do {
			do {
				System.out.println("\n#-#-# ESTarefas 2.0 #-#-#");
				System.out.println("(G)erir listas");
				System.out.println("(V)isualizar lista");
				System.out.println("(M)arcar tarefas");
				System.out.println("(E)ditar lista");
				System.out.println("(C)opiar / colar");
				System.out.println("(S)air");

				opcaoMenuPrincipal = leituraDadosString(scanner, "Introduza uma letra:");

				switch (opcaoMenuPrincipal) {
				case "g": case "G":
					menuPrincipalValido = true;
					break;

				case "v": case "V":
					menuPrincipalValido = true;
					menuVisualizar(scanner, scannerStrings, opcaoSubMenu, subMenuValido, sairSubMenu, tarefa, temPrazo, foiFeita, data, nTarefas, dataIntroduzida);
					break;

				case "m": case "M":
					menuPrincipalValido = true;
					break;

				case "e": case "E":
					menuPrincipalValido = true;
					break;

				case "c": case "C":
					menuPrincipalValido = true;
					break;

				case "s": case "S":
					menuPrincipalValido = true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					menuPrincipalValido = false;
					break;
				}
			} while(!menuPrincipalValido);
		} while(!sairMenuPrincipal);
	}

}
