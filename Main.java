public class main {
	
	public static void menuPrincipal (Scanner scanner)  {
		String opcaoMenuPrincipal;
		boolean menuPrincipalValido= false;
		
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
		
		boolean sairSubMenu = false;
		
		switch (opcaoMenuPrincipal) {
	}
	
	public static void menuVizualizar (Scanner scanner) {
	boolean subMenuValido =false;
	String opcaoSubMenu;
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
	}
	
	public static void menuMarcacao () {
		System.out.println("\n#-#-# Marcação #-#-#");
		System.out.println("Marcar como (f)eita por número");
		System.out.println("Marcar como feita por (t)exto");
		System.out.println("(D)esmarcar última feita");
		System.out.println("Marcar todas (n)o dia d");
		System.out.println("(V)oltar");
		
		System.out.println("\nIntroduza a opção que pretende efetuar: ");
	}
	
	public static void menuEditar () {
		System.out.println("\n#-#-# Editar #-#-#");
		System.out.println("(A)dicionar tarefa");
		System.out.println("Adicionar (t)arefa na posição n");
		System.out.println("Apagar tarefa na (p)osição n");
		System.out.println("Apagar (f)eitas");
		System.out.println("(E)ditar tarefa");
		System.out.println("(V)oltar");
		
		System.out.println("\nIntroduza a opção que pretende efetuar: ");
	}
	
	public static void subMenuEditar () {
		System.out.println("\n#-#-# Editar Tarefa #-#-#");
		System.out.println("(E)ditar texto");
		System.out.println("(R)emover/adicionar data");
		System.out.println("(V)oltar");
		
		System.out.println("\nIntroduza a opção que pretende efetuar: ");
		
	}
	
	public static void protecaoDeDadosDatas (int dia, int mes, int ano, Scanner scanner) {
		boolean diaValido= false, mesValido=false , anoValido= false;
		do {
			System.out.println("\nIntroduza o dia: ");
			dia = scanner.nextInt();
			
			if(dia >= 1 && dia <= 31) {
				diaValido = true;
			} else {
				System.out.println("\nIntroduza um dia válido.");
			}
		} while(!diaValido);
		diaValido = false;
		
		do {
			System.out.println("\nIntroduza o mês: ");
			mes = scanner.nextInt();
			
			if(mes >= 1 && mes <= 12) {
				mesValido = true;
			} else {
				System.out.println("\nIntroduza um mês válido.");
			}
		} while(!mesValido);
		mesValido = false;
		
		do {
			System.out.println("\nIntroduza o ano: ");
			ano = scanner.nextInt();
			
			if(ano >= 1) {
				anoValido = true;
			} else {
				System.out.println("\nIntroduza um ano válido.");
			}
		} while(!anoValido);
		anoValido = false;
	}
	
	
