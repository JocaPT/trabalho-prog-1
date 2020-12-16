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



			switch (funcionalidade) {
			case "v":
			case "V":	
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



				switch (visualizacao) {
				case "t":
				case "T":
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
				case "D":
					int dia = 0, mes = 0, ano = 0;

					boolean diaValido = false;
					boolean mesValido = false;
					boolean anoValido = false;

					do {
						System.out.println("\nIntroduza o dia: ");
						dia = scanner.nextInt();

						if(dia >= 1 && dia <= 31) {
							diaValido = true;
						} else {
							System.out.println("\nIntroduza um dia valido.");
						}
					} while(diaValido == false);

					do {
						System.out.println("\nIntroduza o mês: ");
						mes = scanner.nextInt();

						if(mes >= 1 && mes <= 12) {
							mesValido = true;
						} else {
							System.out.println("\nIntroduza um mês valido.");
						}
					} while(mesValido == false);

					do {
						System.out.println("\nIntroduza o ano: ");
						ano = scanner.nextInt();

						if(ano >= 1) {
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

						break;
					}
				}



			case "a":
			case "A":
				int dia = 0, mes = 0, ano = 0;

				boolean diaValido = false;
				boolean mesValido = false;
				boolean anoValido = false;

				do {
					System.out.println("\nIntroduza o dia: ");
					dia = scanner.nextInt();

					if(dia >= 1 && dia <= 31) {
						diaValido = true;
					} else {
						System.out.println("\nIntroduza um dia valido.");
					}
				} while(diaValido == false);

				do {
					System.out.println("\nIntroduza o mês: ");
					mes = scanner.nextInt();

					if(mes >= 1 && mes <= 12) {
						mesValido = true;
					} else {
						System.out.println("\nIntroduza um mês valido.");
					}
				} while(mesValido == false);

				do {
					System.out.println("\nIntroduza o ano: ");
					ano = scanner.nextInt();

					if(ano >= 1) {
						anoValido = true;
					} else {
						System.out.println("\nIntroduza um ano valido.");
					}
				} while(anoValido == false);


				char x;

				System.out.printf("%s %s %s\n", "Tarefa", "Data", "Feita");

				for( int i=0; i<nTarefas; i++) {
					if (dia>=data[i][0] && mes>=data[i][1] && ano>=data[i][2] && temPrazo[i]) {


						if(foiFeita[i]) {
							x = 'X';
						}else {
							x= ' ';
						}
						
						System.out.printf("%d: %s %d/%d/%d %c\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2], x);
						
					}else {
						System.out.println("Não existe nenhuma tarefa até à data!");


					}
				}





			case "s":
			case "S":
				sair = true;
				break;

			default:
				System.out.println("default");
			}

			funcionalidade = "";

		} while(sair == false);

	}

}















































				System.out.printf("%s %s %s\n", "Tarefa", "Data", "Feita"); //
				char x ='x';
				for (int i=0; i<nTarefas; i++) {
					if(data[i][0]<=dia && data[i][1]<=mes && data[i][2]<=ano && temPrazo[i] && foiFeita[i]) {
							System.out.printf("\n %d: %s %d/%d/%d %c", i+1, tarefa[i], data[i][0], data[i][1], data[i][2], x); //x nao esta a funcionar
						}else if(data[i][0]<=dia && data[i][1]<=mes && data[i][2]<=ano && temPrazo[i] && foiFeita[i]==false) {
							System.out.printf("\n %d: %s %d/%d/%d", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
						}else {
							System.out.printf("\nNão há tarefas para fazer até a essa data!");    //se o numero for menor que 13 ou 14 nao funciona
						}
				
				}

				}		
				}
							

























































package trabalho_pratico_2;
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
					System.out.println("\nIntroduza uma funcionalidade válida.");
				}

			} while(funcionalidadeValida == false);



			switch (funcionalidade) {
			case "v":
			case "V":	
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



				switch (visualizacao) {
				case "t":
				case "T":
					System.out.printf("%11s %s %s\n", "Tarefa", "Data", "Feita"); //

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

						System.out.printf("%d: %17s %d/%d/%d %c\n", i+1, tarefa[i], tempData[0], tempData[1], tempData[2], x); //

					}

					break;

				case "d":
				case "D":
					int dia = 0, mes = 0, ano = 0;

					boolean diaValido = false;
					boolean mesValido = false;
					boolean anoValido = false;

					do {
						System.out.println("\nIntroduza o dia: ");
						dia = scanner.nextInt();

						if(dia >= 1 && dia <= 31) {
							diaValido = true;
						} else {
							System.out.println("\nIntroduza um dia valido.");
						}
					} while(diaValido == false);

					do {
						System.out.println("\nIntroduza o mês: ");
						mes = scanner.nextInt();

						if(mes >= 1 && mes <= 12) {
							mesValido = true;
						} else {
							System.out.println("\nIntroduza um mês valido.");
						}
					} while(mesValido == false);

					do {
						System.out.println("\nIntroduza o ano: ");
						ano = scanner.nextInt();

						if(ano >= 1) {
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

							System.out.printf("%s %s %s\n", "Tarefa", "Data", "Feita"); //
							System.out.printf("%d: %s %d/%d/%d %c\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2], x);
							break;
						} else {
							System.out.println("Não existe nenhuma tarefa a realizar nesse dia.");
						}

						break;
					}




				case "a":
				case "A":
					 

					 diaValido = false;
					 mesValido = false;
					 anoValido = false;

					do {
						System.out.println("\nIntroduza o dia: ");
						dia = scanner.nextInt();

						if(dia >= 1 && dia <= 31) {
							diaValido = true;
						} else {
							System.out.println("\nIntroduza um dia valido.");
						}
					} while(diaValido == false);

					do {
						System.out.println("\nIntroduza o mês: ");
						mes = scanner.nextInt();

						if(mes >= 1 && mes <= 12) {
							mesValido = true;
						} else {
							System.out.println("\nIntroduza um mês valido.");
						}
					} while(mesValido == false);

					do {
						System.out.println("\nIntroduza o ano: ");
						ano = scanner.nextInt();

						if(ano >= 1) {
							anoValido = true;
						} else {
							System.out.println("\nIntroduza um ano valido.");
						}
					} while(anoValido == false);


					System.out.printf("%s %s %s\n", "Tarefa", "Data", "Feita"); //
					x= 'X';
					for (int i=0; i<nTarefas; i++) {
						if(data[i][0]<=dia && data[i][1]<=mes && data[i][2]<=ano && temPrazo[i] && foiFeita[i]) {
							System.out.printf("\n %d: %s %d/%d/%d %c", i+1, tarefa[i], data[i][0], data[i][1], data[i][2], x); //x nao esta a funcionar
						}else if(data[i][0]<=dia && data[i][1]<=mes && data[i][2]<=ano && temPrazo[i] && foiFeita[i]==false) {
							System.out.printf("\n %d: %s %d/%d/%d", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
						}else {
							System.out.printf("\nNão há tarefas para fazer até a essa data!");    //se o numero for menor que 13 ou 14 nao funciona
						}
						
					}
					break;

				case "p":
				case "P":

					System.out.printf("%s %s %s\n", "Tarefa", "Data", "Feita");

					for(int i=0; i<nTarefas; i++) {
						if(foiFeita[i]==false) {
							System.out.printf("\n %d: %s %d/%d/%d", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
						}else {
							System.out.println();
						}
					}





				case "s":
				case "S":
					sair = true;
					break;

				default:
					System.out.println("default");
				}

				funcionalidade = "";

			} while(sair == false);

		}while(sair == false);
	}
}


































			case "E":
			case "e":



				do {
					String editar = "";
					boolean editarValido = false;
					do {
						System.out.println("#-#-# Editar #-#-#");
						System.out.println("(A)dicionar tarefa");
						System.out.println("Adicionar (t)arefa na posição n");
						System.out.println("Apagar tarefa na (p)osição n");
						System.out.println("Apagar (f)eitas");
						System.out.println("(E)ditar tarefa");
						System.out.println("(V)oltar");

						System.out.println("\nIntroduza a visualização que pretende efetuar: ");
						editar = scanner.next();

						if(editar.equalsIgnoreCase("a") || editar.equalsIgnoreCase("t") || editar.equalsIgnoreCase("p") || editar.equalsIgnoreCase("f") || editar.equalsIgnoreCase("e") || editar.equalsIgnoreCase("V")) {
							editarValido = true;
						}else {
							System.out.println("Introduziu um editar inválido!");
						}	
					}while(editarValido==false);


					switch (editar) {
					case "p":
					case "P":
						boolean tarefaValida= false;
						int apagarTarefaN;
						do { 
							System.out.println("Introduza a tarefa que quer apagar:");
							apagarTarefaN = scanner.nextInt();
							apagarTarefaN -=1;
							if(apagarTarefaN>=0 && apagarTarefaN<=nTarefas) {
								tarefaValida=true;
							}else {
								System.out.println("Introduza uma tarefa válida!");
							}
						}while(tarefaValida=false);

						System.out.printf("%9s %22s\n", "Tarefa", "Data");

						for(int i=0; i<nTarefas; i++) {
							if(apagarTarefaN==i) {
								System.out.print("");
							}else {
								System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
							}
						}
						System.out.println();
						break;

					case "f":
					case "F":
						System.out.printf("%9s %22s\n", "Tarefa", "Data");

						for(int i=0; i<nTarefas;i++) {
							if(foiFeita[i]==true) {
								System.out.print("");        //nao sei se é preciso ficar no tarefa[i] todo seguido pq salta do 1 ao 3
							}else {
								System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);

							}
						}

						System.out.println();
						break;
					case "e":
					case "E":
						String editarTarefa= "";
						do {
							System.out.println("#-#-# Editar-Submenu #-#-#");
							System.out.println("(E)ditar texto");
							System.out.println("(R)emover/adicionar data");
							System.out.println("(V)oltar");

							System.out.println("\nIntroduza o que pretende efetuar: ");
							editarTarefa = scanner.next();

							if(editarTarefa.equalsIgnoreCase("e") || editarTarefa.equalsIgnoreCase("r") || editarTarefa.equalsIgnoreCase("v")) {
								editarValido = true;
							}else {
								System.out.println("Introduziu um editar inválido!");
							}	
						}while(editarValido==false);

						switch(editarTarefa) {



						case "e":
						case "E":
							boolean editarTarefaNValida=false;
							System.out.println("Selecione a tarefa que pretende editar:");
							int editarTarefaN;
							editarTarefaN = scanner.nextInt();
							editarTarefaN -=1;
							do {
								if(editarTarefaN>=0 && editarTarefaN <= nTarefas) {
									editarTarefaNValida=true;
								}else {
									System.out.println("Introduza uma variável válida!");
									System.out.println();
								}

							}while(editarTarefaNValida=false);

							System.out.printf("%9s %22s\n", "Tarefa", "Data");

							for(int i=0; i<nTarefas; i++) {
								if(editarTarefaN==i) {
									System.out.println("Introduza uma nova tarefa:");
									tarefa[i]=scanner.next();  //falta o split 
									System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
								}else {
									System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
								}
							}
							System.out.println();
							break;

						case "r":
						case "R":

							boolean removerOuAdicionarData=false;
							System.out.println("Selecione a tarefa que pretende editar:");
							int removerOuAdicionarDataN;
							removerOuAdicionarDataN = scanner.nextInt();
							removerOuAdicionarDataN -=1;
							do {
								if(removerOuAdicionarDataN>=0 && removerOuAdicionarDataN <= nTarefas) {
									removerOuAdicionarData=true;
								}else {
									System.out.println("Introduza uma variável válida!");
									System.out.println();
								}

							}while(removerOuAdicionarData=false);

							System.out.printf("%9s %22s\n", "Tarefa", "Data");

							for(int i=0; i<nTarefas; i++) {
								if(removerOuAdicionarDataN==i && temPrazo[i]==true) {
									temPrazo[i]=false;
									System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i]);
								}else if (removerOuAdicionarDataN==i && temPrazo[i]==false) {
									temPrazo[i]=true;
									System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]);
								}else {
									System.out.printf("%d: %-24s %d/%d/%d\n", i+1, tarefa[i], data[i][0], data[i][1], data[i][2]); //??
								}
							}
							System.out.println();
							break;
						case "v":
						case "V":

							sairFuncionalidade=true;
							break;

						}while (sairFuncionalidade==false);

					case "v":
					case "V":
						sairFuncionalidade=true;
						break;
					}
				}while(sairFuncionalidade==false);

			}
		} while(sairPrograma == false);
	}
}
