package gerenciador;

import java.util.ArrayList;

public class GerenciadorTarefas{
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	public void addTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	public void removeTarefa(String titulo) {
		Tarefa tarefaRemovida = null;
		for(Tarefa tarefa : tarefas) {
			if(tarefa.getTitulo().equalsIgnoreCase(titulo)) {
				tarefaRemovida = tarefa;
				break;
			}		
		}
		if(tarefaRemovida != null) {
			tarefas.remove(tarefaRemovida);
			System.out.printf("Tarefa %s removida\n", titulo);
		}else {
			System.out.printf("Tarefa %s não encontrada\n", titulo);
		}
	}
	public void marcarTarefaComoConluida(String titulo) {
		for(Tarefa tarefa : tarefas) {
			if(tarefa.getTitulo().equalsIgnoreCase(titulo)) {
				tarefa.setStatus("Concluida");
				System.out.println("Status foi atualizado");
				break;
			}else {
			System.out.println("Tarefa não encontrada");
			}
		}
	}
	
	public void listaTarefas() {
		for(Tarefa tarefa : tarefas) {
			System.out.println("Titulo: " + tarefa.getTitulo());
			System.out.println("Descrição: " + tarefa.getDescricao());
			System.out.println("Status: " + tarefa.getStatus());
			System.out.println("-----------------------------------------");
		}
	}
}
