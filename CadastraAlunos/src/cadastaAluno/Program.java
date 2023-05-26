package cadastaAluno;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Escola escola = new Escola();
		
		escola.addAluno(new Aluno("Cauã Souza Conceição", 18,234767136, "13/06/2004", "3 médio", 713242117 ));
		escola.addAluno(new Aluno("Pedro de avares santo", 17, 988812312, "12/01/2005", "2 médio", 255672126 ));
		escola.addAluno(new Aluno("Cleber do santos jesus", 13, 2123537102, "11/04/2011", "6 fundamental ", 412321321 ));
		escola.addAluno(new Aluno("Joao cleber ", 17, 866234312, "21/04/2004", "3 médio", 976495412));
		escola.addAluno(new Aluno("Jonas da cruz machado", 15, 219975761, "28/09/2006", "1 médio", 765988215 ));
		escola.addAluno(new Aluno("Helder da silva santos", 14, 295740305, "21/06/2004", "9 fundamental", 0237323545 ));
		escola.addAluno(new Aluno("Vitor cruz", 18, 2121312317, "25/10/2004", "3 médio", 542107694 ));
		escola.addAluno(new Aluno("Matheus lobo", 18, 866221258, "02/02/2005", "2 médio", 212321321 ));
		
		System.out.println("Sistema de Matricula");
		
		Scanner teclado = new Scanner(System.in);
		
		while(true) {
			System.out.println("1-Matricular Aluno");
			System.out.println("2-Buscar Aluno Matriculado");
			System.out.println("3-Listar Alunos Matriculados");
			System.out.println("4-Remover Aluno");
			System.out.println("5-Sair do Sistema");
			
			int numero = teclado.nextInt();
			
			if(numero == 1) {
				System.out.println("Etapa de Matricula");
				
				System.out.println("Informe Nome: ");
				String nome = teclado.nextLine();
				nome = teclado.nextLine();
				System.out.println("Infome idade: ");
				int idade = teclado.nextInt();
				System.out.println("Informe seu cpf: ");
				long cpf = teclado.nextLong();
				System.out.println("Informe data de nascimento: ");
				String data = teclado.nextLine();
				data = teclado.nextLine();
				System.out.println("Informe a serie: ");
				String serie = teclado.nextLine();
				
				int matricula;
				Random random = new Random();
				matricula = random.nextInt(100000000, 900000000);
				
				Aluno aluno = new Aluno(nome, idade, cpf, data, serie, matricula);
				escola.addAluno(aluno);
			}
			 if(numero == 2) {
					System.out.println("Digite nome do aluno");
					String nome = teclado.nextLine();
					nome = teclado.nextLine();
					escola.buscarAluno(nome);
					
					Aluno alunoEncontrado = escola.buscarAluno(nome); 
					if( alunoEncontrado != null) {
						System.out.println("\nAluno encontrado!!");
						System.out.println("----------------------");
						System.out.println("Nome do aluno: " + alunoEncontrado.getNome());
						System.out.println("Idade: " + alunoEncontrado.getIdade());
						System.out.println("cpf: " + alunoEncontrado.getCpf());
						System.out.println("Data de nascimento: " + alunoEncontrado.getDataDeNascimento());
						System.out.println("Série: " + alunoEncontrado.getSerie());
						System.out.println("matricula: " + alunoEncontrado.getMatricula());
						System.out.println("----------------------");
					}else {
						System.out.println("Aluno Não foi encontrado");
					}
			 }
			 if(numero == 3) {
				 escola.listarAluno();
				 System.out.println(" ");
			 }
			 
			 if(numero == 4) {
				 System.out.println("Digite nome do aluno a ser removido");
					String nome = teclado.nextLine();
					nome = teclado.nextLine();
					escola.removeAlunosCadastrados(nome);
			 }
			 if(numero == 5) {
				 System.out.println("SISTEMA ENCERRADO!!");
				 break;
			 }
			 
		}
		teclado.close();	
	}
}

