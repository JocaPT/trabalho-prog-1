package trabalho_prático_3;

import java.util.Scanner;

public class main {

	public static String leituraDadosString(Scanner scannerStrings, String msg) {
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

	public static boolean verificarNTarefa(int numeroTarefa, int nTarefas) {
		if(numeroTarefa >= 0 && numeroTarefa <= nTarefas) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verificarString(String texto, String texto2) {
		if(texto.equalsIgnoreCase(texto2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verificarListaAtiva(int listaAtiva) {
		if (listaAtiva != -1) {
			return true;
		} else {
			return false;
		}
	}

	public static int menuGerir(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, int listaAtiva, int nListas, String nomeListas[]) {
		do {
			do {
				System.out.println("\n#-#-# Gerir listas #-#-#");
				System.out.println("(S)elecionar lista ativa");
				System.out.println("(L)istar listas");
				System.out.println("(C)riar nova lista");
				System.out.println("(A)pagar lista");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scannerStrings, "\nIntroduza a funcionalidade que pretende efetuar: ");

				switch (opcaoSubMenu) {
				case "s": case "S":
					subMenuValido = true;
					listaAtiva = listaAtiva(scanner, listaAtiva, nListas);
					break;

				case "l": case "L":
					subMenuValido = true;
					listarListas(nListas, nomeListas);
					break;

				case "c": case "C":
					subMenuValido = true;
					break;

				case "a": case "A":
					subMenuValido = true;
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu = true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					subMenuValido = false;
					break;
				}
			} while(!subMenuValido);
		} while(!sairSubMenu);
		return listaAtiva;
	}

	public static int listaAtiva(Scanner scanner, int listaAtiva, int nListas) {
		listaAtiva = leituraDadosInt(scanner, "\nIntroduza o número da lista ativa: ");

		if (listaAtiva >= nListas) {
			System.out.println("Está lista não é valída.");
			listaAtiva = 0;
		}

		return listaAtiva;
	}

	public static void listarListas(int nListas, String nomeListas[]) {
		for(int i = 0; i < nListas; i++) {
			System.out.printf("%d | %s", i, nomeListas[i]);
		}
	}

	public static int criarLista(Scanner scannerStrings, int nListas, String nomeListas[]) {
		nomeListas[nListas - 1] = leituraDadosString(scannerStrings, "");

		return nListas;
	}

	public static void menuVisualizar(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[], boolean foiEncontrado) {
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

				opcaoSubMenu = leituraDadosString(scannerStrings, "\nIntroduza a funcionalidade que pretende efetuar: ");

				switch (opcaoSubMenu) {
				case "t": case "T":
					subMenuValido = true;
					visualizarTodas(tarefa, temPrazo, foiFeita, data, nTarefas);
					break;

				case "d": case "D":
					subMenuValido = true;
					visualizarDia(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, foiEncontrado);
					break;

				case "a": case "A":
					subMenuValido = true;
					visualizarAteDia(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, foiEncontrado);
					break;

				case "p": case "P":
					subMenuValido = true;
					visualizarPorFazer(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, foiEncontrado);
					break;

				case "f": case "F":
					subMenuValido = true;
					visualizarFeitas(tarefa, temPrazo, foiFeita, data, nTarefas, foiEncontrado);
					break;

				case "l": case "L":
					subMenuValido = true;
					visualizarPorPalavra(scannerStrings, tarefa, temPrazo, foiFeita, data, nTarefas, foiEncontrado);
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu = true;
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

	public static void visualizarDia(Scanner scanner, int dataIntroduzida[],String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, boolean foiEncontrado) {
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

	public static void visualizarAteDia(Scanner scanner, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, boolean foiEncontrado) {
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

	public static void visualizarPorFazer(Scanner scanner, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, boolean foiEncontrado) {
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

	public static void visualizarFeitas(String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, boolean foiEncontrado) {
		System.out.printf("%9s %22s\n", "Tarefa", "Data");

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

	public static void visualizarPorPalavra(Scanner scannerStrings, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, boolean foiEncontrado) {
		String palavra = leituraDadosString(scannerStrings, "\nIntroduza a palavra a procurar: ");

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

	public static void menuMarcacao(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[], int ultimoEditado, int numeroTarefa, boolean numeroTarefaValido, boolean foiEncontrado) {
		do {
			do {
				System.out.println("\n#-#-# Marcação #-#-#");
				System.out.println("Marcar como (f)eita por número");
				System.out.println("Marcar como feita por (t)exto");
				System.out.println("(D)esmarcar última feita");
				System.out.println("Marcar todas (n)o dia d");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scannerStrings, "\nIntroduza a funcionalidade que pretende efetuar: ");

				switch (opcaoSubMenu) {
				case "f": case "F":
					subMenuValido = true;
					ultimoEditado = marcarFeitaNumero(scanner, numeroTarefa, nTarefas, numeroTarefaValido, ultimoEditado);
					break;

				case "t": case "T":
					subMenuValido = true;
					ultimoEditado = marcarFeitaTexto(scannerStrings, tarefa, nTarefas, foiFeita, ultimoEditado, foiEncontrado);
					break;

				case "d": case "D":
					subMenuValido = true;
					desmarcarUltimaFeita(foiFeita, ultimoEditado);
					break;

				case "n": case "N":
					subMenuValido = true;
					marcarDiaD(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, foiEncontrado);
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu = true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					subMenuValido = false;
					break;
				}
			} while(!subMenuValido);
		} while(!sairSubMenu);
	}

	public static int marcarFeitaNumero(Scanner scanner, int numeroTarefa, int nTarefas, boolean numeroTarefaValido, int ultimoEditado) {
		do {
			numeroTarefa = leituraDadosInt(scanner, "\nIntroduza o número da tarefa: ") - 1;

			if (verificarNTarefa(numeroTarefa, nTarefas)) {
				numeroTarefaValido= true;
			} else {
				System.out.println("\nNão existe nenhuma tarefa com este número.");
			}
		} while(!numeroTarefaValido);

		ultimoEditado = numeroTarefa;
		System.out.printf("A tarefa com número %d foi marcada como feita.", numeroTarefa + 1);
		return ultimoEditado;
	}

	public static int marcarFeitaTexto(Scanner scannerStrings, String tarefa[], int nTarefas, boolean foiFeita[], int ultimoEditado, boolean foiEncontrado) {
		String texto = leituraDadosString(scannerStrings, "\nIntroduza uma palavra: ");

		for(int i = 0; i < nTarefas; i++) {
			if(tarefa[i].indexOf(texto) != -1) {
				foiFeita[i] = true;
				foiEncontrado = true;
				ultimoEditado = i;
				System.out.printf("A tarefa com o texto %s foi marcada como feita.", texto);
			}
		}

		if(!foiEncontrado) {
			System.out.println("Não existe nenhuma tarefa que contenha essa palavra.");
		}

		return ultimoEditado;
	}

	public static void desmarcarUltimaFeita(boolean foiFeita[], int ultimoEditado) {
		if(ultimoEditado != -1) {
			foiFeita[ultimoEditado] = false;
			System.out.printf("A tarefa com número %d foi marcada como por fazer.", ultimoEditado + 1);
		} else {
			System.out.println("Ainda não modificou nenhuma tarefa.");
		}
	}

	public static void marcarDiaD(Scanner scanner, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, boolean foiEncontrado) {
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

	public static void menuEditar(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[], int tamMax, String booleanoIntroduzido, boolean booleanValido, int numeroTarefa, boolean numeroTarefaValido) {
		do {
			do {
				System.out.println("\n#-#-# Editar #-#-#");
				System.out.println("(A)dicionar tarefa");
				System.out.println("Adicionar (t)arefa na posição n");
				System.out.println("Apagar tarefa na (p)osição n");
				System.out.println("Apagar (f)eitas");
				System.out.println("(E)ditar tarefa");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scannerStrings, "\nIntroduza a funcionalidade que pretende efetuar: ");

				switch (opcaoSubMenu) {
				case "a": case "A":
					subMenuValido = true;
					nTarefas = adicionarTarefa(scanner, scannerStrings, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, tamMax, booleanoIntroduzido, booleanValido);
					break;

				case "t": case "T":
					subMenuValido = true;
					adicionarTarefaPosN(scanner, scannerStrings, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, tamMax, booleanoIntroduzido, booleanValido, numeroTarefa, numeroTarefaValido);
					break;

				case "p": case "P":
					subMenuValido = true;
					nTarefas = apagarTarefaN(scanner, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, tamMax, numeroTarefa, numeroTarefaValido);
					break;

				case "f": case "F":
					subMenuValido = true;
					nTarefas = apagarTarefaFeita(scannerStrings, dataIntroduzida, tarefa, temPrazo, foiFeita, data, nTarefas, tamMax);
					break;

				case "e": case "E":
					subMenuValido = true;
					break;

				case "v": case "V":
					subMenuValido = true;
					sairSubMenu = true;
					break;

				default:
					System.out.println("\nIntroduza um funcionalidade válida.");
					subMenuValido = false;
					break;
				}
			} while(!subMenuValido);
		} while(!sairSubMenu);
	}

	public static int adicionarTarefa(Scanner scanner, Scanner scannerStrings, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int tamMax, String booleanoIntroduzido, boolean booleanValido) {
		if(nTarefas - 1 >= tamMax) {
			System.out.printf("\nJá existe o número máximo de tarefas, o máximo é %d.", tamMax);
			return nTarefas;
		}

		tarefa[nTarefas] = leituraDadosString(scannerStrings, "\nIntroduza a descrição da tarefa: ");

		do {
			booleanoIntroduzido = leituraDadosString(scanner, "\nA tarefa está feita? (S / N)");

			if(verificarString(booleanoIntroduzido, "s")) {
				foiFeita[nTarefas] = true;
				booleanValido = true;
			} else if(verificarString(booleanoIntroduzido, "n")) {
				foiFeita[nTarefas] = false;
				booleanValido = true;
			} else {
				System.out.println("\nIntroduza uma opção valida.");
			}
		} while(!booleanValido);
		booleanValido = false;

		do {
			booleanoIntroduzido = leituraDadosString(scanner, "\nA tarefa está feita? (S / N)");

			if(verificarString(booleanoIntroduzido, "s")) {
				temPrazo[nTarefas] = true;
				booleanValido = true;
			} else if(verificarString(booleanoIntroduzido, "n")) {
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

		System.out.println("\nA tarefa foi criada com sucesso.");

		return nTarefas + 1;
	}

	public static void adicionarTarefaPosN(Scanner scanner, Scanner scannerStrings, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int tamMax, String booleanoIntroduzido, boolean booleanValido, int numeroTarefa, boolean numeroTarefaValido) {
		if(nTarefas - 1 >= tamMax) {
			System.out.printf("\nJá existe o número máximo de tarefas, o máximo é %d.", tamMax);
			return;
		}

		do {
			numeroTarefa = leituraDadosInt(scanner, "\\nIntroduza o número da tarefa: ") - 1;

			if (numeroTarefa < 0 || numeroTarefa > tamMax - 1) {
				System.out.println("\nEste número de tarefa não é valido.");
			} else {
				numeroTarefaValido = true;
			}
		} while(!numeroTarefaValido);

		for(int i = nTarefas; i >= numeroTarefa; i--) {
			tarefa[i] = tarefa[i - 1];
			temPrazo[i] = temPrazo[i - 1];
			foiFeita[i] = foiFeita[i - 1];
			data[i][0] = data[i - 1][0];
			data[i][1] = data[i - 1][1];
			data[i][2] = data[i - 1][2];
		}

		tarefa[numeroTarefa] = leituraDadosString(scannerStrings, "\nIntroduza a descrição da tarefa: ");

		do {
			booleanoIntroduzido = leituraDadosString(scanner, "\nA tarefa está feita? (S / N)");

			if(verificarString(booleanoIntroduzido, "s")) {
				foiFeita[numeroTarefa] = true;
				booleanValido = true;
			} else if(verificarString(booleanoIntroduzido, "n")) {
				foiFeita[numeroTarefa] = false;
				booleanValido = true;
			} else {
				System.out.println("\nIntroduza uma opção valida.");
			}
		} while(!booleanValido);
		booleanValido = false;

		do {
			booleanoIntroduzido = leituraDadosString(scanner, "\nA tarefa está feita? (S / N)");

			if(verificarString(booleanoIntroduzido, "s")) {
				temPrazo[numeroTarefa] = true;
				booleanValido = true;
			} else if(verificarString(booleanoIntroduzido, "n")) {
				temPrazo[numeroTarefa] = false;
				booleanValido = true;
			} else {
				System.out.println("\nIntroduza uma opção valida.");
			}
		} while(!booleanValido);
		booleanValido = false;

		if(temPrazo[numeroTarefa]) {
			do  {
				dataIntroduzida[0] = leituraDadosInt(scanner, "Introduza o dia: ");
			} while(verificarDados(dataIntroduzida, 0, 1, 31));

			do  {
				dataIntroduzida[1] = leituraDadosInt(scanner, "Introduza o mês: ");
			} while(verificarDados(dataIntroduzida, 1, 1, 12));

			do  {
				dataIntroduzida[2] = leituraDadosInt(scanner, "Introduza o ano: ");
			} while(verificarDados(dataIntroduzida, 2, 1));

			data[numeroTarefa][0] = dataIntroduzida[0];
			data[numeroTarefa][1] = dataIntroduzida[1];
			data[numeroTarefa][2] = dataIntroduzida[2];
		}

		System.out.println("\nA tarefa foi criada com sucesso.");
	}

	public static int apagarTarefaN(Scanner scanner, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int tamMax, int numeroTarefa, boolean numeroTarefaValido) {
		do {
			numeroTarefa = leituraDadosInt(scanner, "\nIntroduza o número da tarefa: ") - 1;

			if (numeroTarefa < 0 || numeroTarefa > nTarefas || numeroTarefa > tamMax - 1) {
				System.out.println("\nEste número de tarefa não é valido.");
			} else {
				numeroTarefaValido = true;
			}
		} while(!numeroTarefaValido);

		tarefa[numeroTarefa] = null;
		temPrazo[numeroTarefa] = false;
		foiFeita[nTarefas] = false;
		data[nTarefas][0] = 0;
		data[nTarefas][1] = 0;
		data[nTarefas][2] = 0;

		for(int i = numeroTarefa; i < nTarefas; i++) {
			tarefa[i] = tarefa[i + 1];
			temPrazo[i] = temPrazo[i + 1];
			foiFeita[i] = foiFeita[i + 1];
			data[i][0] = data[i + 1][0];
			data[i][1] = data[i + 1][1];
			data[i][2] = data[i + 1][2];
		}

		System.out.println("\nTarefa foi apagada com sucesso.");

		return nTarefas - 1;
	}

	public static int apagarTarefaFeita(Scanner scanner, int dataIntroduzida[], String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int tamMax) {
		int tarefasApagadas = 0;

		for(int i = 0; i < nTarefas; i++) {
			if(foiFeita[i]) {
				tarefa[i] = null;
				temPrazo[i] = false;
				foiFeita[i] = false;
				data[i][0] = 0;
				data[i][1] = 0;
				data[i][2] = 0;

				for(int j = i; j < nTarefas; j++) {
					tarefa[j] = tarefa[j + 1];
					temPrazo[j] = temPrazo[j + 1];
					foiFeita[j] = foiFeita[j + 1];
					data[j][0] = data[j + 1][0];
					data[j][1] = data[j + 1][1];
					data[j][2] = data[j + 1][2];
				}

				tarefasApagadas += 1;
			}
		}
		System.out.printf("\nForam apagadas %d tarefas com sucesso.", tarefasApagadas);

		return nTarefas - tarefasApagadas;
	}

	public static void menuEditarTarefa(Scanner scanner, Scanner scannerStrings, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[], int tamMax, int numeroTarefa, boolean numeroTarefaValido) {
		do {
			do {
				System.out.println("\n#-#-# Editar Tarefa #-#-#");
				System.out.println("(E)ditar texto");
				System.out.println("(R)emover/adicionar data");
				System.out.println("(V)oltar");

				opcaoSubMenu = leituraDadosString(scannerStrings, "\nIntroduza a funcionalidade que pretende efetuar: ");

				switch (opcaoSubMenu) {
				case "e": case "E":
					subMenuValido = true;
					editarTexto(scanner, scannerStrings, tarefa, nTarefas, tamMax, numeroTarefa, numeroTarefaValido);
					break;

				case "r": case "R":
					subMenuValido = true;
					removerAdicionarData(scanner, tarefa, temPrazo, foiFeita, data, dataIntroduzida, nTarefas, tamMax, numeroTarefa, numeroTarefaValido);
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

	public static void editarTexto(Scanner scanner, Scanner scannerStrings, String tarefa[], int nTarefas, int tamMax ,int numeroTarefa, boolean numeroTarefaValido) {
		do {
			numeroTarefa = leituraDadosInt(scanner, "\nIntroduza o número da tarefa: ") - 1;

			if (numeroTarefa < 0 || numeroTarefa > nTarefas || numeroTarefa > tamMax - 1) {
				System.out.println("\nEste número de tarefa não é valido.");
			} else {
				numeroTarefaValido = true;
			}
		} while(!numeroTarefaValido);

		tarefa[numeroTarefa] = leituraDadosString(scannerStrings, "\nIntroduza a nova descrição da tarefa: ");

		System.out.println("\nTarefa edita com sucesso.");
	}

	public static void removerAdicionarData(Scanner scanner, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int dataIntroduzida[], int nTarefas, int tamMax, int numeroTarefa, boolean numeroTarefaValido) {
		do {
			numeroTarefa = leituraDadosInt(scanner, "\nIntroduza o número da tarefa: ") - 1;

			if (numeroTarefa < 0 || numeroTarefa > nTarefas || numeroTarefa > tamMax - 1) {
				System.out.println("\nEste número de tarefa não é valido.");
			} else {
				numeroTarefaValido = true;
			}
		} while(!numeroTarefaValido);

		if(temPrazo[numeroTarefa]) {
			temPrazo[numeroTarefa] = false;
			data[numeroTarefa][0] = 0;
			data[numeroTarefa][1] = 0;
			data[numeroTarefa][2] = 0;
			System.out.println("\nFoi removida a data da tarefa com sucesso.");
		} else {
			do  {
				dataIntroduzida[0] = leituraDadosInt(scanner, "Introduza o dia: ");
			} while(verificarDados(dataIntroduzida, 0, 1, 31));

			do  {
				dataIntroduzida[1] = leituraDadosInt(scanner, "Introduza o mês: ");
			} while(verificarDados(dataIntroduzida, 1, 1, 12));

			do  {
				dataIntroduzida[2] = leituraDadosInt(scanner, "Introduza o ano: ");
			} while(verificarDados(dataIntroduzida, 2, 1));

			temPrazo[numeroTarefa] = true;
			data[numeroTarefa][0] = dataIntroduzida[0];
			data[numeroTarefa][1] = dataIntroduzida[1];
			data[numeroTarefa][2] = dataIntroduzida[2];

			System.out.println("\nFoi adicionada a data da tarefa com sucesso.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner scannerStrings = new Scanner(System.in);

		int tamMax = 100;
		int listaMax = 10;

		String[][] tarefa = new String[listaMax][tamMax];
		boolean temPrazo[][] = new boolean[listaMax][tamMax];
		boolean foiFeita[][] = new boolean[listaMax][tamMax];
		int data[][][] = new int[listaMax][tamMax][3];

		int nTarefas[] = new int[listaMax];
		String nomeListas[] = new String[listaMax];

		int nListas = 0;
		int listaAtiva = -1;

		nomeListas[0] = "Tarefas Urgentes";

		tarefa[0][0] = "Ir ao dentista"; temPrazo[0][0] = true; foiFeita[0][0] = false; data[0][0][0] = 16; data[0][0][1] = 1; data[0][0][2] = 2021;
		tarefa[0][1] = "Enunciado de P1"; temPrazo[0][1] = true; foiFeita[0][1] = true; data[0][1][0] = 27; data[0][1][1] = 1; data[0][1][2] = 2021;
		tarefa[0][2] = "Marcar reunião"; temPrazo[0][2] = false; foiFeita[0][2] = false;
		tarefa[0][3] = "Reunião CTC"; temPrazo[0][3] = true; foiFeita[0][3] = false; data[0][3][0] = 7; data[0][3][1] = 1; data[0][3][2] = 2021;

		nTarefas[0] = 4;
		nListas = 1;

		String opcaoMenuPrincipal = "";
		String opcaoSubMenu = "";

		boolean menuPrincipalValido = false;
		boolean sairMenuPrincipal = false;
		boolean subMenuValido = false;
		boolean sairSubMenu = false;
		boolean editarSubMenuValido = false;

		String booleanoIntroduzido = "";

		int dataIntroduzida[] = new int[3];
		int ultimoEditado = -1;
		int numeroTarefa = -1;

		boolean foiEncontrado = false;
		boolean numeroTarefaValido = false;
		boolean booleanValido = false;

		do {
			do {
				System.out.println("\n#-#-# ESTarefas 2.0 #-#-#");
				if (verificarListaAtiva(listaAtiva))  {
					System.out.println("(G)erir listas");
					System.out.println("(V)isualizar lista");
					System.out.println("(M)arcar tarefas");
					System.out.println("(E)ditar lista");
					System.out.println("(C)opiar / colar");
					System.out.println("(S)air");
				} else {
					System.out.println("(G)erir listas");
				}

				opcaoMenuPrincipal = leituraDadosString(scannerStrings, "\nIntroduza a funcionalidade que pretende efetuar: ");

				switch (opcaoMenuPrincipal) {
				case "g": case "G":
					menuPrincipalValido = true;
					listaAtiva = 	menuGerir(scanner, scannerStrings, opcaoSubMenu, editarSubMenuValido, sairSubMenu, listaAtiva, nListas, nomeListas);

					break;

				case "v": case "V":
					if(verificarListaAtiva(listaAtiva)) {
						menuPrincipalValido = true;
						menuVisualizar(scanner, scannerStrings, opcaoSubMenu, editarSubMenuValido, sairSubMenu, tarefa[listaAtiva], temPrazo[listaAtiva], foiFeita[listaAtiva], data[listaAtiva], nTarefas[listaAtiva], dataIntroduzida, foiEncontrado);
					} else {
						System.out.println("Não tem nenhuma lista ativa.");
					}
					break;

				case "m": case "M":
					if(verificarListaAtiva(listaAtiva)) {
						menuPrincipalValido = true;
						menuMarcacao(scanner, scannerStrings, opcaoSubMenu, editarSubMenuValido, sairSubMenu, tarefa[listaAtiva], temPrazo[listaAtiva], foiFeita[listaAtiva], data[listaAtiva], nTarefas[listaAtiva], dataIntroduzida, ultimoEditado, numeroTarefa, numeroTarefaValido, foiEncontrado);
					} else {
						System.out.println("Não tem nenhuma lista ativa.");
					}
					break;

				case "e": case "E":
					if(verificarListaAtiva(listaAtiva)) {
						menuPrincipalValido = true;menuEditar(scanner, scannerStrings, opcaoSubMenu, editarSubMenuValido, sairSubMenu, tarefa[listaAtiva], temPrazo[listaAtiva], foiFeita[listaAtiva], data[listaAtiva], nTarefas[listaAtiva], dataIntroduzida, tamMax, booleanoIntroduzido, booleanValido, numeroTarefa, numeroTarefaValido);
					} else {
						System.out.println("Não tem nenhuma lista ativa.");
					}
					break;

				case "c": case "C":
					menuPrincipalValido = true;
					break;

				case "s": case "S":
					menuPrincipalValido = true;
					sairMenuPrincipal = true;
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
