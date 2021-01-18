package main;

import java.util.Scanner;

public class Main {

	public static String leituraDadosString(Scanner scanner) {
		System.out.println("\nIntroduza a funcionalidade que pretende efetuar: ");
		return scanner.next();
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
	
	public static void menuVisualizar(Scanner scanner, String opcaoSubMenu, boolean subMenuValido, boolean sairSubMenu, String tarefa[], boolean temPrazo[], boolean foiFeita[], int data[][], int nTarefas, int dataIntroduzida[]) {
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
				
				opcaoSubMenu = leituraDadosString(scanner);
				
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
					break;
					
					case "f": case "F":
						subMenuValido = true;
					break;
					
					case "l": case "L":
						subMenuValido = true;
					break;
					
					case "v": case "V":
						subMenuValido = true;
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
				
				opcaoMenuPrincipal = leituraDadosString(scanner);
				
				switch (opcaoMenuPrincipal) {
					case "g": case "G":
						menuPrincipalValido = true;
					break;
					
					case "v": case "V":
						menuPrincipalValido = true;
						menuVisualizar(scanner, opcaoSubMenu, subMenuValido, sairSubMenu, tarefa, temPrazo, foiFeita, data, nTarefas, dataIntroduzida);
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
