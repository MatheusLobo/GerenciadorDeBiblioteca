package cadastaAluno;

import java.util.ArrayList;

public class Escola {

	private ArrayList<Aluno> alunos;
	
	public Escola() {
		alunos = new ArrayList<>();
	}
	
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	public void removeAlunosCadastrados(String nome) {
		Aluno alunoRemovido = null;
		for(Aluno aluno : alunos) {
			if(aluno.getNome().equalsIgnoreCase(nome)) {
				alunoRemovido = aluno;
				break;
			}
		}
		if(alunoRemovido != null) {
			alunos.remove(alunoRemovido);
			System.out.println("Aluno " + nome + " Removido");
		}else {
			System.out.println("Aluno " + nome + "não encontrado");
		}
	}
	public Aluno buscarAluno(String nome) {
		for(Aluno aluno : alunos) {
			if(aluno.getNome().equalsIgnoreCase(nome)) {
				return aluno;
			}
		}
		return null;
	}
	
	public void listarAluno() {
		System.out.println("\nAlunos Matriculados");
		System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s\n", "[Nomes]", "[Idades]", "[CPF]" , "[Data de Nascimento]", "[Serie]", "[Matricula]");
		for(Aluno aluno : alunos) {
			System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s\n", aluno.getNome(), aluno.getIdade(), 
					aluno.getCpf(),aluno.getDataDeNascimento(),aluno.getSerie(), aluno.getMatricula());
		}
	}
}
