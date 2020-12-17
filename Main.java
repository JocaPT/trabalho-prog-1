package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Nome: João Silva, Nº: 20201634, Engenharia Informatica, Turma 3
		// Nome: Miguel Gonçalves, Nº 20201167, Engenharia Informatica, Turma 3
				
		// Criação e inicialização das váriaveis
		Scanner scanner = new Scanner(System.in);
		Scanner scannerStrings = new Scanner(System.in);
		
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
			// Menu Principal
			do {
				System.out.println("\n#-#-# ESTarefas 1.0 #-#-#");
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
			
			sairSubMenu = false;
			
			switch (opcaoMenuPrincipal) {
				// Menu de Visualização
				case "v": case "V":
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
							
							System.out.println("\nIntroduza a opção que pretende efetuar: ");
							opcaoSubMenu = scanner.next();
							
							if(opcaoSubMenu.equalsIgnoreCase("t") || opcaoSubMenu.equalsIgnoreCase("d") || opcaoSubMenu.equalsIgnoreCase("a") || opcaoSubMenu.equalsIgnoreCase("p") || opcaoSubMenu.equalsIgnoreCase("f") || opcaoSubMenu.equalsIgnoreCase("l") || opcaoSubMenu.equalsIgnoreCase("v")) {
								subMenuValido = true;
							} else {
								System.out.println("\nIntroduza uma opção válida.");
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
								diaValido = false;
								
								do {
									System.out.println("\nIntroduza o mês: ");
									dataIntroduzida[1] = scanner.nextInt();
									
									if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
										mesValido = true;
									} else {
										System.out.println("\nIntroduza um mês válido.");
									}
								} while(!mesValido);
								mesValido = false;
								
								do {
									System.out.println("\nIntroduza o ano: ");
									dataIntroduzida[2] = scanner.nextInt();
									
									if(dataIntroduzida[2] >= 1) {
										anoValido = true;
									} else {
										System.out.println("\nIntroduza um ano válido.");
									}
								} while(!anoValido);
								anoValido = false;
								
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
								diaValido = false;
								
								do {
									System.out.println("\nIntroduza o mês: ");
									dataIntroduzida[1] = scanner.nextInt();
									
									if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
										mesValido = true;
									} else {
										System.out.println("\nIntroduza um mês válido.");
									}
								} while(!mesValido);
								mesValido = false;
								
								do {
									System.out.println("\nIntroduza o ano: ");
									dataIntroduzida[2] = scanner.nextInt();
									
									if(dataIntroduzida[2] >= 1) {
										anoValido = true;
									} else {
										System.out.println("\nIntroduza um ano válido.");
									}
								} while(!anoValido);
								anoValido = false;
								
								System.out.printf("%9s %22s\n", "Tarefa", "Data");
								for(int i = 0; i < nTarefas; i++) {
									if(!foiFeita[i] && temPrazo[i]) {
										if(dataIntroduzida[0] >= data[i][0] || dataIntroduzida[2] > data[i][2]) {
											if(dataIntroduzida[1] >= data[i][1] || dataIntroduzida[2] > data[i][2]) {
												if(dataIntroduzida[2] >= data[i][2]) {
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
								palavraProcurar = scannerStrings.next();
								
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
							
							System.out.println("\nIntroduza a opção que pretende efetuar: ");
							opcaoSubMenu = scanner.next();
							
							if(opcaoSubMenu.equalsIgnoreCase("f") || opcaoSubMenu.equalsIgnoreCase("t") || opcaoSubMenu.equalsIgnoreCase("d") || opcaoSubMenu.equalsIgnoreCase("n") || opcaoSubMenu.equalsIgnoreCase("v")) {
								subMenuValido = true;
							} else {
								System.out.println("\nIntroduza uma opção válida.");
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
								texto = scannerStrings.next();
								
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
								diaValido = false;
								
								do {
									System.out.println("\nIntroduza o mês: ");
									dataIntroduzida[1] = scanner.nextInt();
									
									if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
										mesValido = true;
									} else {
										System.out.println("\nIntroduza um mês válido.");
									}
								} while(!mesValido);
								mesValido = false;
								
								do {
									System.out.println("\nIntroduza o ano: ");
									dataIntroduzida[2] = scanner.nextInt();
									
									if(dataIntroduzida[2] >= 1) {
										anoValido = true;
									} else {
										System.out.println("\nIntroduza um ano válido.");
									}
								} while(!anoValido);
								anoValido = false;
								
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
							System.out.println("\n#-#-# Editar #-#-#");
							System.out.println("(A)dicionar tarefa");
							System.out.println("Adicionar (t)arefa na posição n");
							System.out.println("Apagar tarefa na (p)osição n");
							System.out.println("Apagar (f)eitas");
							System.out.println("(E)ditar tarefa");
							System.out.println("(V)oltar");
							
							System.out.println("\nIntroduza a opção que pretende efetuar: ");
							opcaoSubMenu = scanner.next();
							
							if(opcaoSubMenu.equalsIgnoreCase("t") || opcaoSubMenu.equalsIgnoreCase("d") || opcaoSubMenu.equalsIgnoreCase("a") || opcaoSubMenu.equalsIgnoreCase("p") || opcaoSubMenu.equalsIgnoreCase("f") || opcaoSubMenu.equalsIgnoreCase("e") || opcaoSubMenu.equalsIgnoreCase("v")) {
								subMenuValido = true;
							} else {
								System.out.println("\nIntroduza uma opção válida.");
							}
							
						} while(!subMenuValido);
						
						sairEditarSubMenu = false;
						
						switch (opcaoSubMenu) {
							case "a": case "A":
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
									do {
										System.out.println("\nIntroduza o dia: ");
										dataIntroduzida[0] = scanner.nextInt();
										
										if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
											diaValido = true;
										} else {
											System.out.println("\nIntroduza um dia válido.");
										}
									} while(!diaValido);
									diaValido = false;
									
									do {
										System.out.println("\nIntroduza o mês: ");
										dataIntroduzida[1] = scanner.nextInt();
										
										if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
											mesValido = true;
										} else {
											System.out.println("\nIntroduza um mês válido.");
										}
									} while(!mesValido);
									mesValido = false;
									
									do {
										System.out.println("\nIntroduza o ano: ");
										dataIntroduzida[2] = scanner.nextInt();
										
										if(dataIntroduzida[2] >= 1) {
											anoValido = true;
										} else {
											System.out.println("\nIntroduza um ano válido.");
										}
									} while(!anoValido);
									anoValido = false;
									
									data[nTarefas][0] = dataIntroduzida[0];
									data[nTarefas][1] = dataIntroduzida[1];
									data[nTarefas][2] = dataIntroduzida[2];
								}
								
								nTarefas += 1;
								
								System.out.println("\nA tarefa foi criada com sucesso.");
							break;
							
							case "t": case "T":
								do {
									System.out.println("\nIntroduza o número da tarefa: ");
									numeroTarefa = scanner.nextInt();
									numeroTarefa -= 1;
									
									if (numeroTarefa < 0 || numeroTarefa > tamMax) {
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
								
								System.out.println("\nIntroduza a descrição da tarefa: ");
								tarefa[numeroTarefa] = scannerStrings.nextLine();
								
								do {
									System.out.println("\nA tarefa está feita? (S / N)");
									booleanoIntroduzido = scanner.next();
									
									if(booleanoIntroduzido.equalsIgnoreCase("s")) {
										foiFeita[numeroTarefa] = true;
										booleanValido = true;
									} else if(booleanoIntroduzido.equalsIgnoreCase("n")) {
										foiFeita[numeroTarefa] = false;
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
										temPrazo[numeroTarefa] = true;
										booleanValido = true;
									} else if(booleanoIntroduzido.equalsIgnoreCase("n")) {
										temPrazo[numeroTarefa] = false;
										booleanValido = true;
									} else {
										System.out.println("\nIntroduza uma opção valida.");
									}
								} while(!booleanValido);
								booleanValido = false;
								
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
									diaValido = false;
									
									do {
										System.out.println("\nIntroduza o mês: ");
										dataIntroduzida[1] = scanner.nextInt();
										
										if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
											mesValido = true;
										} else {
											System.out.println("\nIntroduza um mês válido.");
										}
									} while(!mesValido);
									mesValido = false;
									
									do {
										System.out.println("\nIntroduza o ano: ");
										dataIntroduzida[2] = scanner.nextInt();
										
										if(dataIntroduzida[2] >= 1) {
											anoValido = true;
										} else {
											System.out.println("\nIntroduza um ano válido.");
										}
									} while(!anoValido);
									anoValido = false;
									
									data[numeroTarefa][0] = dataIntroduzida[0];
									data[numeroTarefa][1] = dataIntroduzida[1];
									data[numeroTarefa][2] = dataIntroduzida[2];
								}
								
								nTarefas += 1;
								
								System.out.println("\nA tarefa foi criada com sucesso.");
							break;
							
							case "p": case "P":
								do {
									System.out.println("\nIntroduza o número da tarefa: ");
									numeroTarefa = scanner.nextInt();
									numeroTarefa -= 1;
									System.out.println(numeroTarefa);
									
									if (numeroTarefa < 0 || numeroTarefa > nTarefas || numeroTarefa > tamMax) {
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
								
								nTarefas -= 1;
								
								System.out.println("\nTarefa foi apagada com sucesso.");
							break;
							
							case "f": case "F":
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
								nTarefas -= tarefasApagadas;
								System.out.printf("\nForam apagadas %d tarefas com sucesso.", tarefasApagadas);
							break;
							
							case "e": case "E":
								do {						
									do {
										System.out.println("\n#-#-# Editar Tarefa #-#-#");
										System.out.println("(E)ditar texto");
										System.out.println("(R)emover/adicionar data");
										System.out.println("(V)oltar");
										
										System.out.println("\nIntroduza a opção que pretende efetuar: ");
										opcaoEditarSubMenu = scanner.next();
										
										if(opcaoSubMenu.equalsIgnoreCase("e") || opcaoSubMenu.equalsIgnoreCase("r") || opcaoSubMenu.equalsIgnoreCase("v")) {
											editarSubMenuValido = true;
										} else {
											System.out.println("\nIntroduza uma opção válida.");
										}
										
									} while(!editarSubMenuValido);
									switch(opcaoEditarSubMenu) {
										case "e": case "E":
											do {
												System.out.println("\nIntroduza o número da tarefa: ");
												numeroTarefa = scanner.nextInt();
												numeroTarefa -= 1;
												
												if (numeroTarefa < 0 || numeroTarefa > nTarefas || numeroTarefa > tamMax) {
													System.out.println("\nEste número de tarefa não é valido.");
												} else {
													numeroTarefaValido = true;
												}
											} while(!numeroTarefaValido);
											
											System.out.println("\nIntroduza a nova descrição da tarefa: ");
											tarefa[numeroTarefa] = scannerStrings.next();
											System.out.println("\nTarefa edita com sucesso.");
										break;
										
										case "r": case "R":
											do {
												System.out.println("\nIntroduza o número da tarefa: ");
												numeroTarefa = scanner.nextInt();
												numeroTarefa -= 1;
												
												if (numeroTarefa < 0 || numeroTarefa > nTarefas || numeroTarefa > tamMax) {
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
												do {
													System.out.println("\nIntroduza o dia: ");
													dataIntroduzida[0] = scanner.nextInt();
													
													if(dataIntroduzida[0] >= 1 && dataIntroduzida[0] <= 31) {
														diaValido = true;
													} else {
														System.out.println("\nIntroduza um dia válido.");
													}
												} while(!diaValido);
												diaValido = false;
												
												do {
													System.out.println("\nIntroduza o mês: ");
													dataIntroduzida[1] = scanner.nextInt();
													
													if(dataIntroduzida[1] >= 1 && dataIntroduzida[1] <= 12) {
														mesValido = true;
													} else {
														System.out.println("\nIntroduza um mês válido.");
													}
												} while(!mesValido);
												mesValido = false;
												
												do {
													System.out.println("\nIntroduza o ano: ");
													dataIntroduzida[2] = scanner.nextInt();
													
													if(dataIntroduzida[2] >= 1) {
														anoValido = true;
													} else {
														System.out.println("\nIntroduza um ano válido.");
													}
												} while(!anoValido);
												anoValido = false;
												
												temPrazo[numeroTarefa] = true;
												data[numeroTarefa][0] = dataIntroduzida[0];
												data[numeroTarefa][1] = dataIntroduzida[1];
												data[numeroTarefa][2] = dataIntroduzida[2];
												
												System.out.println("\nFoi adicionada a data da tarefa com sucesso.");
											}
										break;
										
										case "v": case "V":
											sairEditarSubMenu = true;
										break;
									}
								} while(!sairEditarSubMenu);
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
		
		scanner.close();
		scannerStrings.close();
	}
}
