package gerenciador;

import java.util.Scanner;

public class Testar {

	public static void main(String[] args) {
	 
		GerenciadorTarefas gerenciador = new GerenciadorTarefas();
		
		gerenciador.addTarefa(new Tarefa("Estudo java", "Estudar ArrayList e classes Abstract", "Em Andamento"));
		gerenciador.addTarefa(new Tarefa("Estudo Modelagem de Software", "Estudar Modelo Conceitual e relacional", "Em andamento"));
		gerenciador.addTarefa(new Tarefa("Estudo de inteface Grafica", "Estudar como cria e implementar intefaces graficas no java", "Em Andamento"));
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("BEM VINDO AO SEU GERENCIADOR DE TAREFAS DIARIAS \n");
		
	while(true) {
		System.out.println("1- Adicionar nova Tarefa");
		System.out.println("2- Remover Tarefa");
		System.out.println("3- Marcar como concluida");
		System.out.println("4- Mostrar Tarefas");
		System.out.println("5- Sair do Sistema");
		
		int opcao = teclado.nextInt();
		if(opcao > 5 || opcao < 0) {
			System.out.println("[Não existe esta opçao]");
		}
		
		if(opcao == 1) {
			System.out.println("Digite o titulo da tarefa: ");
			String titulo = teclado.nextLine();
			titulo = teclado.nextLine();
			System.out.println("Faça um descrição da tarefa: ");
			String descricao = teclado.nextLine();
			
			String status = "Em Andamento";
			
			gerenciador.addTarefa(new Tarefa(titulo, descricao, status));
			
		}
		if(opcao == 2) {
			System.out.println("Digite titulo da tarefa que dejesa remover");
			String titulo = teclado.nextLine();
			titulo = teclado.nextLine();
			gerenciador.removeTarefa(titulo);
		}
		if(opcao == 3) {
			System.out.println("Digite o titulo da tarefa que deseja marca com concluida");
			String titulo = teclado.nextLine();
			titulo = teclado.nextLine();
			
			gerenciador.marcarTarefaComoConluida(titulo);
			
		}if(opcao == 4) {
			gerenciador.listaTarefas();
			System.out.println(" ");
		}
		if(opcao == 5) {
			System.out.println("Sistema encerrado");
			break;
		}
	}
	teclado.close();
  }
}
