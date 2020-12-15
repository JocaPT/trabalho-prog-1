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
		tarefa[3] = "Frequência de P1"; temPrazo[3] = true; foiFeita[3] = false; data[3][0] = 13; data[3][1] = 01; data[3][2] = 2021;
		tarefa[4] = "Presentes!!"; temPrazo[4] = true; foiFeita[4] = false; data[4][0] = 25; data[4][1] = 12; data[4][2] = 2020;
		
		nTarefas = 5;
		
		String opcaoMenuPrincipal = "";
		String opcaoSubMenu = "";
		
		boolean menuPrincipalValido = false;
		boolean sairMenuPrincipal = false;
		boolean subMenuValido = false;
		boolean sairSubMenu = false;
		
		String dataApresentar = "";
		String palavraProcurar = "";
		
		char feitoX = ' ';
		
		int dataIntroduzida[] = new int[3];
		int ultimoEditado = -1;
		int numeroTarefa = -1;
		
		boolean diaValido = false;
		boolean mesValido = false;
		boolean anoValido = false;
		boolean foiEncontrado = false;
		boolean numeroTarefaValido = false;
		
		do {
			// Menu Principal
			do {
				System.out.println("\n#-#-# Menu Principal #-#-#");
				System.out.println("(V)isualizar");
				System.out.println("(M)arcar");
				System.out.println("(E)ditar");
				System.out.println("(S)air");
				
				System.out.println("\nIntroduza a funcionalidade que pretende efetuar: ");
				opcaoMenuPrincipal = scanner.next();
				
				if(opcaoMenuPrincipal.equalsIgnoreCase("v") || opcaoMenuPrincipal.equalsIgnoreCase("m") || opcaoMenuPrincipal.equalsIgnoreCase("e") || opcaoMenuPrincipal.equalsIgnoreCase("s")) {
					menuPrincipalValido = true;
				} else {
					System.out.println("\nIntroduza um funcionalidade válida.");
				}
			} while(!menuPrincipalValido);
			
			switch (opcaoMenuPrincipal) {
				// Menu de Visualização
				case "v": case "V":
					do {
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
							opcaoSubMenu = scanner.next();
							
							if(opcaoSubMenu.equalsIgnoreCase("t") || opcaoSubMenu.equalsIgnoreCase("d") || opcaoSubMenu.equalsIgnoreCase("a") || opcaoSubMenu.equalsIgnoreCase("p") || opcaoSubMenu.equalsIgnoreCase("f") || opcaoSubMenu.equalsIgnoreCase("l") || opcaoSubMenu.equalsIgnoreCase("v")) {
								subMenuValido = true;
							} else {
								System.out.println("\nIntroduza um visualização válida.");
							}
							
						} while(!subMenuValido);
						
						switch (opcaoSubMenu) {
							case "t": case "T":
								System.out.printf("%9s %22s %12s\n", "Tarefa", "Data", "Feita");
								
								for(int i = 0; i < nTarefas; i++) {
									if(temPrazo[i]) {
										dataApresentar = data[i][0] + "/" + data[i][1] + "/" + data[i][2];
									} else {
										dataApresentar = "          ";
									}
									
									if(foiFeita[i]) {
										feitoX = 'X';
									} else {
										feitoX = ' ';
									}
									
									System.out.printf("%d: %-24s %-11s %c\n", i+1, tarefa[i], dataApresentar, feitoX);
								}
							break;
								
							case "d": case "D":
								do {
									System.out.println("\nIntroduza o dia: ");
									dataIntroduzida[0] = scanner.nextInt();
									
									if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
										diaValido = true;
									} else {
										System.out.println("\nIntroduza um dia válido.");
									}
								} while(!diaValido);
								
								do {
									System.out.println("\nIntroduza o mês: ");
									dataIntroduzida[1] = scanner.nextInt();
									
									if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
										mesValido = true;
									} else {
										System.out.println("\nIntroduza um mês válido.");
									}
								} while(!mesValido);
								
								do {
									System.out.println("\nIntroduza o ano: ");
									dataIntroduzida[2] = scanner.nextInt();
									
									if(dataIntroduzida[2] >= 1) {
										anoValido = true;
									} else {
										System.out.println("\nIntroduza um ano válido.");
									}
								} while(!anoValido);
								
								System.out.printf("%9s %22s\n", "Tarefa", "Data");
								for(int i = 0; i < nTarefas; i++) {
									if(dataIntroduzida[0] == data[i][0] && dataIntroduzida[1] == data[i][1] && dataIntroduzida[2] == data[i][2] && !foiFeita[i]) {
										
										foiEncontrado = true;
										
										System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
									}
								}
								
								if(!foiEncontrado) {
									System.out.println("Não existe nenhuma tarefa a realizar nesse dia.");
								}
							break;
							
							case "a": case "A":
								do {
									System.out.println("\nIntroduza o dia: ");
									dataIntroduzida[0] = scanner.nextInt();
									
									if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
										diaValido = true;
									} else {
										System.out.println("\nIntroduza um dia válido.");
									}
								} while(!diaValido);
								
								do {
									System.out.println("\nIntroduza o mês: ");
									dataIntroduzida[1] = scanner.nextInt();
									
									if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
										mesValido = true;
									} else {
										System.out.println("\nIntroduza um mês válido.");
									}
								} while(!mesValido);
								
								do {
									System.out.println("\nIntroduza o ano: ");
									dataIntroduzida[2] = scanner.nextInt();
									
									if(dataIntroduzida[2] >= 1) {
										anoValido = true;
									} else {
										System.out.println("\nIntroduza um ano válido.");
									}
								} while(!anoValido);
								
								System.out.printf("%9s %22s\n", "Tarefa", "Data");
								for(int i = 0; i < nTarefas; i++) {
									if(!foiFeita[i] && temPrazo[i]) {
										if(data[i][2] <= dataIntroduzida[2]) {
											if(data[i][1] <= dataIntroduzida[1]) {
												if(data[i][0] <= dataIntroduzida[0]) {
													foiEncontrado = true;
													
													System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
												}
											}
										}
									}
								}
								
								if(!foiEncontrado) {
									System.out.println("Não existe nenhuma tarefa a realizar até esse dia.");
								}
							break;
							
							case "p": case "P":
								System.out.printf("%9s %22s\n", "Tarefa", "Data");
								
								for(int i = 0; i < nTarefas; i++) {
									if(!foiFeita[i]) {
										foiEncontrado = true;
										System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
									}
								}
								
								if(!foiEncontrado) {
									System.out.println("Não existe nenhuma tarefa por fazer.");
								}
							break;
							
							case "f": case "F":
								System.out.printf("%9s %22s\n", "Tarefa", "Data");
								
								for(int i = 0; i < nTarefas; i++) {
									if(foiFeita[i]) {
										if(temPrazo[i]) {
											dataApresentar = data[i][0] + "/" + data[i][1] + "/" + data[i][2];
										} else {
											dataApresentar = "          ";
										}
										
										foiEncontrado = true;
										
										System.out.printf("%d: %-24s %s\n", i+1, tarefa[i], dataApresentar);
									}
								}
								
								if(!foiEncontrado) {
									System.out.println("Não existe nenhuma tarefa feita.");
								}
							break;
							
							case "l": case "L":
								System.out.println("\nIntroduza a palavra a procurar: ");
								palavraProcurar = scanner.next();
								
								System.out.printf("%9s %22s %12s\n", "Tarefa", "Data", "Feita");
								for(int i = 0; i < nTarefas; i++) {
									if(tarefa[i].indexOf(palavraProcurar) != -1) {
										if(temPrazo[i]) {
											dataApresentar = data[i][0] + "/" + data[i][1] + "/" + data[i][2];
										} else {
											dataApresentar = "          ";
										}
										
										if(foiFeita[i]) {
											feitoX = 'X';
										} else {
											feitoX = ' ';
										}
										
										foiEncontrado = true;
										
										System.out.printf("%d: %-24s %-11s %c\n", i+1, tarefa[i], dataApresentar, feitoX);
									}
								}
								
								if(!foiEncontrado) {
									System.out.println("Não existe nenhuma tarefa que contenha essa palavra.");
								}
							break;
							
							case "v": case "V":
								sairSubMenu = true;
							break;
						}
					} while(!sairSubMenu);
				break;
				
				case "m": case "M":
					do {						
						do {
							System.out.println("\n#-#-# Marcação #-#-#");
							System.out.println("Marcar como (f)eita por número");
							System.out.println("Marcar como feita por (t)exto");
							System.out.println("(D)esmarcar última feita");
							System.out.println("Marcar todas (n)o dia d");
							System.out.println("(V)oltar");
							
							System.out.println("\nIntroduza a visualização que pretende efetuar: ");
							opcaoSubMenu = scanner.next();
							
							if(opcaoSubMenu.equalsIgnoreCase("f") || opcaoSubMenu.equalsIgnoreCase("t") || opcaoSubMenu.equalsIgnoreCase("d") || opcaoSubMenu.equalsIgnoreCase("n") || opcaoSubMenu.equalsIgnoreCase("v")) {
								subMenuValido = true;
							} else {
								System.out.println("\nIntroduza um visualização válida.");
							}
							
						} while(!subMenuValido);

						switch (opcaoSubMenu) {
							case "f": case "F":
								
								do {
									System.out.println("\nIntroduza o número da tarefa: ");
									numeroTarefa = scanner.nextInt();
									numeroTarefa -= 1;
									
									if(numeroTarefa >= 0 && numeroTarefa <= nTarefas) {
										numeroTarefaValido = true;
									} else {
										System.out.println("\nNão existe nenhuma tarefa com este número.");
									}
								} while(!numeroTarefaValido);
								
								foiFeita[numeroTarefa] = true;
								ultimoEditado = numeroTarefa;
								System.out.printf("A tarefa com número %d foi marcada como feita.", numeroTarefa + 1);
							break;
							
							case "t": case "T":
								String texto = "";
								
								System.out.println("\nIntroduza a palavra: ");
								texto = scanner.next();
								
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
							break;
							
							case "d": case "D":
								if(ultimoEditado != -1) {
									foiFeita[ultimoEditado] = false;
									System.out.printf("A tarefa com número %d foi marcada como por fazer.", ultimoEditado + 1);
								} else {
									System.out.println("Ainda não modificou nenhuma tarefa.");
								}
							break;
							
							case "n": case "N":
								do {
									System.out.println("\nIntroduza o dia: ");
									dataIntroduzida[0] = scanner.nextInt();
									
									if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
										diaValido = true;
									} else {
										System.out.println("\nIntroduza um dia válido.");
									}
								} while(!diaValido);
								
								do {
									System.out.println("\nIntroduza o mês: ");
									dataIntroduzida[1] = scanner.nextInt();
									
									if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
										mesValido = true;
									} else {
										System.out.println("\nIntroduza um mês válido.");
									}
								} while(!mesValido);
								
								do {
									System.out.println("\nIntroduza o ano: ");
									dataIntroduzida[2] = scanner.nextInt();
									
									if(dataIntroduzida[2] >= 1) {
										anoValido = true;
									} else {
										System.out.println("\nIntroduza um ano válido.");
									}
								} while(!anoValido);
								
								System.out.printf("%9s %22s\n", "Tarefa", "Data");
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
							break;
							
							case "v": case "V":
								sairSubMenu = true;
							break;
						}
					} while(!sairSubMenu);
				break;
				
				case "e": case "E":
					do {
						do {
							System.out.println("#-#-# Editar #-#-#");
							System.out.println("(A)dicionar tarefa");
							System.out.println("Adicionar (t)arefa na posição n");
							System.out.println("Apagar tarefa na (p)osição n");
							System.out.println("Apagar (f)eitas");
							System.out.println("(E)ditar tarefa");
							System.out.println("(V)oltar");
							
							System.out.println("\nIntroduza a visualização que pretende efetuar: ");
							opcaoSubMenu = scanner.next();
							
							if(opcaoSubMenu.equalsIgnoreCase("t") || opcaoSubMenu.equalsIgnoreCase("d") || opcaoSubMenu.equalsIgnoreCase("a") || opcaoSubMenu.equalsIgnoreCase("p") || opcaoSubMenu.equalsIgnoreCase("f") || opcaoSubMenu.equalsIgnoreCase("l") || opcaoSubMenu.equalsIgnoreCase("v")) {
								subMenuValido = true;
							} else {
								System.out.println("\nIntroduza um visualização válida.");
							}
							
						} while(!subMenuValido);
						
						switch (opcaoSubMenu) {
							case "a": case "A":
								System.out.println("\nIntroduza a descrição da tarefa: ");
								tarefa[nTarefas - 1] = scanner.next();
								
								System.out.println("\nA tarefa tem prazo? ");
								temPrazo[nTarefas - 1] = scanner.nextBoolean();
								
								System.out.println("\nA tarefa está feita? ");
								foiFeita[nTarefas - 1] = scanner.nextBoolean();
								
								if(temPrazo[nTarefas - 1]) {
									do {
										System.out.println("\nIntroduza o dia: ");
										dataIntroduzida[0] = scanner.nextInt();
										
										if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
											diaValido = true;
										} else {
											System.out.println("\nIntroduza um dia válido.");
										}
									} while(!diaValido);
									
									do {
										System.out.println("\nIntroduza o mês: ");
										dataIntroduzida[1] = scanner.nextInt();
										
										if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
											mesValido = true;
										} else {
											System.out.println("\nIntroduza um mês válido.");
										}
									} while(!mesValido);
									
									do {
										System.out.println("\nIntroduza o ano: ");
										dataIntroduzida[2] = scanner.nextInt();
										
										if(dataIntroduzida[2] >= 1) {
											anoValido = true;
										} else {
											System.out.println("\nIntroduza um ano válido.");
										}
									} while(!anoValido);
									
									data[nTarefas - 1][0] = dataIntroduzida[0];
									data[nTarefas - 1][1] = dataIntroduzida[1];
									data[nTarefas - 1][2] = dataIntroduzida[2];
								}
								
								nTarefas += 1;
								
								System.out.println("A tarefa foi criada com sucesso.");
							break;
							
							case "t": case "T":
								System.out.println("\nIntroduza o número da tarefa: ");
								numeroTarefa = scanner.nextInt();
								numeroTarefa -= 1;
								
								System.out.println("\nIntroduza a descrição da tarefa: ");
								tarefa[numeroTarefa] = scanner.next();
								
								System.out.println("\nA tarefa tem prazo? ");
								temPrazo[nTarefas - 1] = scanner.nextBoolean();
								
								System.out.println("\nA tarefa está feita? ");
								foiFeita[numeroTarefa] = scanner.nextBoolean();
								
								if(temPrazo[numeroTarefa]) {
									do {
										System.out.println("\nIntroduza o dia: ");
										dataIntroduzida[0] = scanner.nextInt();
										
										if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
											diaValido = true;
										} else {
											System.out.println("\nIntroduza um dia válido.");
										}
									} while(!diaValido);
									
									do {
										System.out.println("\nIntroduza o mês: ");
										dataIntroduzida[1] = scanner.nextInt();
										
										if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
											mesValido = true;
										} else {
											System.out.println("\nIntroduza um mês válido.");
										}
									} while(!mesValido);
									
									do {
										System.out.println("\nIntroduza o ano: ");
										dataIntroduzida[2] = scanner.nextInt();
										
										if(dataIntroduzida[2] >= 1) {
											anoValido = true;
										} else {
											System.out.println("\nIntroduza um ano válido.");
										}
									} while(!anoValido);
									
									data[numeroTarefa][0] = dataIntroduzida[0];
									data[numeroTarefa][1] = dataIntroduzida[1];
									data[numeroTarefa][2] = dataIntroduzida[2];
								}
								
								System.out.println("A tarefa foi criada com sucesso.");
							break;
							
							case "v": case "V":
								sairSubMenu = true;
							break;
						}
						
					} while(!sairSubMenu);
				break;
				
				case "s": case "S":
					sairMenuPrincipal = true;
				break;
			}
		} while(!sairMenuPrincipal);
	}
}
