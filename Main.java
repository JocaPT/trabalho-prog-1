package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Nome: João Silva, Nº: 20201634, Turma 3
		// Nome: Miguel Gonçalves, Nº 20201167, Turma 3
		
		// Criação e inicialização das váriaveis
		Scanner scanner = new Scanner(System.in);
		
		int tamMax = 100;
		int data[][] = new int[tamMax][3];
		int nTarefas = 0;
		
		String[] tarefa = new String[tamMax];
		
		boolean temPrazo[] = new boolean[tamMax];
		boolean foiFeita[] = new boolean[tamMax];
		
		// Criação das tarefas pré programadas
		tarefa[0] = "Ir ao dentista"; temPrazo[0] = true; foiFeita[0] = false; data[0][0] = 17; data[0][1] = 12; data[0][2] = 2020;
		tarefa[1] = "Teste prático de P1"; temPrazo[1] = true; foiFeita[1] = true; data[1][0] = 14; data[1][1] = 12; data[1][2] = 2020;
		tarefa[2] = "Corrigir testes"; temPrazo[2] = false; foiFeita[2] = false;
		tarefa[3] = "Frequência de P1"; temPrazo[3] = true; foiFeita[3] = false; data[3][0] = 13; data[3][1] = 1; data[3][2] = 2021;
		tarefa[4] = "Presentes!!"; temPrazo[4] = true; foiFeita[4] = false; data[4][0] = 25; data[4][1] = 12; data[4][2] = 2020;
		
		nTarefas = 5;
		
		
		//
		
		boolean sair = false;
		
		do {
			String funcionalidade = "";
			
			boolean funcionalidadeValida = false;
			
			do {
				System.out.println("\n#-#-# Menu Principal #-#-#");
				System.out.println("(V)isualizar");
				System.out.println("(M)arcar");
				System.out.println("(E)ditar");
				System.out.println("(S)air");
				
				System.out.println("\nIntroduza a funcionalidade que pretende efetuar: ");
				funcionalidade = scanner.next();
				
				if(funcionalidade.equalsIgnoreCase("v") || funcionalidade.equalsIgnoreCase("m") || funcionalidade.equalsIgnoreCase("e") || funcionalidade.equalsIgnoreCase("s")) {
					funcionalidadeValida = true;
				} else {
					System.out.println("\nIntroduza um funcionalidade válida.");
				}
				
			} while(funcionalidadeValida == false);
			
			funcionalidade.toLowerCase();
			
			switch (funcionalidade) {
				case "v":
					
					String visualizacao = "";
					
					boolean visualizacaoValida = false;
					
					do {
						System.out.println("#-#-# Visualizar #-#-#");
						System.out.println("Visualizar (t)odas");
						System.out.println("Visualizar (d)ia d");
						System.out.println("Visualizar (a)té dia d");
						System.out.println("Visualizar (p)or fazer");
						System.out.println("Visualizar (f)eitas");
						System.out.println("Visualizar por pa(l)avra p");
						System.out.println("(V)oltar");
						
						System.out.println("\nIntroduza a visualização que pretende efetuar: ");
						visualizacao = scanner.next();
						
						if(visualizacao.equalsIgnoreCase("t") || visualizacao.equalsIgnoreCase("d") || visualizacao.equalsIgnoreCase("a") || visualizacao.equalsIgnoreCase("p") || visualizacao.equalsIgnoreCase("f") || visualizacao.equalsIgnoreCase("l") || visualizacao.equalsIgnoreCase("v")) {
							visualizacaoValida = true;
						} else {
							System.out.println("\nIntroduza um visualização válida.");
						}
						
					} while(visualizacaoValida == false);
					
					visualizacao.toLowerCase();
					
					switch (visualizacao) {
						case "t":
							System.out.printf("%11s %s %s\n", "Tarefa", "Data", "Feita");
							
							int tempData[] = new int[3];
							char x = ' ';
							
							for(int i = 0; i < nTarefas; i++) {
								if(temPrazo[i]) {
									tempData[0] = data[i][0];
									tempData[1] = data[i][1];
									tempData[2] = data[i][2];
								} else {
									tempData[0] = 0;
									tempData[1] = 0;
									tempData[2] = 0;
								}
								
								if(foiFeita[i]) {
									x = 'X';
								} else {
									x = ' ';
								}
								
								System.out.printf("%d: %17s %d/%d/%d %c\n", i+1, tarefa[i], tempData[0], tempData[1], tempData[2], x);
								
							}
							
						break;
						
						case "d":
							int dia = 0, mes = 0, ano = 0;
							
							boolean diaValido = false;
							boolean mesValido = false;
							boolean anoValido = false;
							
							do {
								System.out.println("\nIntroduza o dia: ");
								dia = scanner.nextInt();
								
								if(dia > 1 || dia < 31) {
									diaValido = true;
								} else {
									System.out.println("\nIntroduza um dia valido.");
								}
							} while(diaValido == false);
							
							do {
								System.out.println("\nIntroduza o mês: ");
								mes = scanner.nextInt();
								
								if(dia > 1 || dia < 12) {
									mesValido = true;
								} else {
									System.out.println("\nIntroduza um mês valido.");
								}
							} while(mesValido == false);
							
							do {
								System.out.println("\nIntroduza o ano: ");
								ano = scanner.nextInt();
								
								if(ano > 1) {
									anoValido = true;
								} else {
									System.out.println("\nIntroduza um ano valido.");
								}
							} while(anoValido == false);
							
							for(int i = 0; i < nTarefas; i++) {
								if(data[i][0] == dia && data[i][1] == mes && data[i][2] == ano) {
									if(foiFeita[i]) {
										x = 'X';
									} else {
										x = ' ';
									}
									
									System.out.printf("%s %s %s\n", "Tarefa", "Data", "Feita");
									System.out.printf("%d: %s %d/%d/%d %c\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2], x);
									break;
								} else {
									System.out.println("Não existe nenhuma tarefa a realizar nesse dia.");
								}
							}
						break;
					}
					
				break;
				case "s":
					sair = true;
					break;
					
				default:
					System.out.println("default");
			}
			
			funcionalidade = "";
			
		} while(sair == false);
		
	}

}
