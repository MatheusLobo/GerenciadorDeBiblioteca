package biblioteca;

import java.util.Scanner;
import java.util.List;
import java.util.Random;
public class Program {

	public static void main(String[] args) {
		   Biblioteca biblioteca = new Biblioteca();
		    biblioteca.addlivro(new Livro("A Revolução dos Bichos", "George Orwell", "Editora A", "1945", 150, "Brochura", "Ficção"));
	        biblioteca.addlivro(new Livro("Orgulho e Preconceito", "Jane Austen", "Editora B", "1813", 400, "Capa dura", "Romance"));
	        biblioteca.addlivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Editora C", "1943", 100, "Brochura", "Infantil"));
	        biblioteca.addlivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Editora D", "1967", 368, "Brochura", "Romance"));
	        biblioteca.addlivro(new Livro("Harry Potter e a Câmara Secreta", "J.K. Rowling", "Editora E", "1998", 320, "Capa dura", "Fantasia"));
	        biblioteca.addlivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Editora F", "1954", 1178, "Brochura", "Fantasia"));
	        biblioteca.addlivro(new Livro("O Quinze", "Rachel de Queiroz", "Jose Olympio", "1930", 160, "Capa Mole", "Drama"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade", "Livros do Brasil", "1928", 192, "Capa Dura", "Ficção"));
	        
	        biblioteca.addlivro(new LivroDigital("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", "Editora L", "1954", 423, "Fantasia", "Digital", "EPUB", 2.89));
	        biblioteca.addlivro(new LivroDigital("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Rocco", "1997", 256, "Fantasia", "Digital", "PDF", 1.8 ));
	        biblioteca.addlivro(new LivroDigital("Percy Jackson e o Ladrão de Raios", "Rick Riordan", "Intrínseca", "2005", 377, "Fantasia", "Digital", "EPUB", 3.2 ));
	        biblioteca.addlivro(new LivroDigital("A Culpa é das Estrelas", "John Green", "Intrínseca", "2012", 313, "Romance", "Digital", "PDF", 1.2));
	        biblioteca.addlivro(new LivroDigital("A Menina que Roubava Livros", "Markus Zusak", "Nova Fronteira", "2005", 480, "Romance", "Digital", "MOBI", 2.5));
	        biblioteca.addlivro(new LivroDigital("1984", "George Orwell", "Editora Nacional", "1949", 368, "Ficção Distópica", "Digital", "EPUB", 1.6));
	     

	        System.out.println("Bem-vindo à Biblioteca Java 2023 Unifacs\n");

	        Scanner read = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nEscolha uma opção:");
	            System.out.println("1 - Registrar Livro");
	            System.out.println("2 - Listar Livros");
	            System.out.println("3 - Buscar Livro");
	            System.out.println("4 - Remover Livro");
	            System.out.println("5 - Editar Livro");
	            System.out.println("6 - Listar Livros por atributo");
	            System.out.println("7 - Sair\n");

	            String opcaoString = read.nextLine();
	            int opcao = Integer.parseInt(opcaoString);

	            if (opcao == 1) {
	                System.out.println("Digite o nome do livro:");
	                String titulo = read.nextLine();

	                System.out.println("Digite o nome do Autor:");
	                String autor = read.nextLine();

	                System.out.println("Digite o nome da Editora:");
	                String editora = read.nextLine();

	                System.out.println("Digite o ano de Publicação:");
	                String ano_Publi = read.nextLine();

	                System.out.println("Digite o número de páginas:");
	                int numero_paginas = Integer.parseInt(read.nextLine());

	                System.out.println("Digite o formato do livro (Capa Dura, Capa Mole, Digital):");
	                String formato = read.nextLine();
	                
	                String formatoDoArquivo = "";
	                	if(formato.equalsIgnoreCase("Digital")) {
	                		System.out.println("Qual tipo do arquivo (PDF, EPUB, MOBI)");
	                		formatoDoArquivo = read.nextLine();
	                	}

	                System.out.println("Digite o gênero do livro:");
	                String genero = read.nextLine();

	                Livro novoLivroFisico;
	                LivroDigital novoLivroDigital;
	                Random random = new Random();
	                double tamanhoDoArquivo = random.nextDouble(3.75);
	                
	                if (formato.equalsIgnoreCase("Digital")) {
	                	novoLivroDigital = new LivroDigital(titulo, autor, editora, ano_Publi, numero_paginas, formato , genero ,formatoDoArquivo, tamanhoDoArquivo);
	                	 biblioteca.addLivroDigital(novoLivroDigital);
	                	 System.out.println("Livro Adicionado com sucesso");
	                } else {
	                	novoLivroFisico = new Livro(titulo, autor, editora, ano_Publi, numero_paginas, formato, genero);
	                    biblioteca.addlivro(novoLivroFisico);
	                    System.out.println("Livro Adicionado com sucesso");
	                }
	           
	            } else if (opcao == 2) {
	                biblioteca.listarLivros();
	                System.out.println(" ");
	                
	            } else if (opcao == 3) {
	                System.out.println("Digite o título do livro que deseja buscar:");
	                String tituloBusca = read.nextLine();
	                List<Livro> livrosEncontrados = biblioteca.buscarLivro(tituloBusca);
	                if (livrosEncontrados.isEmpty()) {
	                    System.out.println("Nenhum livro encontrado com esse título.");
	                } else {
	                    System.out.println("Livros encontrados:");
	                    for (Livro livro : livrosEncontrados) {
	                    	System.out.println("ID: " + livro.getId());
	                        System.out.println("Título: " + livro.getTitulo());
	                        System.out.println("Autor: " + livro.getAutor());
	                        System.out.println("Editora: " + livro.getEditora());
	                        System.out.println("Ano de Publicação: " + livro.getAnoPubli());
	                        System.out.println("Número de Páginas: " + livro.getNumeroPaginas());
	                        if (livro instanceof LivroDigital) {
	                        	LivroDigital livroFisico = (LivroDigital) livro;
	                            System.out.println("Formato: " + livroFisico.getFormato());
	                            System.out.println("Gênero: " + livroFisico.getGenero());
	                        }
	                        System.out.println();
	                    }
	                }
	                
	            } else if (opcao == 4) {
	                System.out.println("\nDigite o título do livro que deseja remover:");
	                String tituloBusca = read.nextLine();

	                List<Livro> livrosEncontrados = biblioteca.buscarLivro(tituloBusca);

	                if (livrosEncontrados.isEmpty()) {
	                    System.out.println("Nenhum livro encontrado com o título informado.\n");
	                } else {
	                    System.out.printf("%-6s%-25s%-25s%-25s%-20s%-15s%-15s%s%n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Formato", "Gênero");

	                    for (Livro livro : livrosEncontrados) {
	                        System.out.printf("%-6d%-25s%-25s%-25s%-20s%-15d", livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAnoPubli(), livro.getNumeroPaginas());
	                        if (livro instanceof LivroDigital) {
	                        	LivroDigital livroDigital = (LivroDigital) livro;
	                            System.out.printf("%-15s%-15s", livroDigital.getFormato(), livroDigital.getGenero());
	                        } else {
	                            System.out.printf("%-15s%-15s", "-", "-");
	                        }
	                        System.out.println();
	                    }

	                    System.out.println("\nDigite o ID do livro que deseja remover:");
	                    int idRemocao = Integer.parseInt(read.nextLine());

	                    boolean livroRemovido = biblioteca.removerLivro(idRemocao);

	                    if (livroRemovido) {
	                        System.out.println("Livro removido com sucesso!\n");
	                    } else {
	                        System.out.println("Falha ao remover o livro. Verifique o ID informado.\n");
	                    }
	                }
	                
	            } else if (opcao == 5) {
	                System.out.println("Lista de Livros:");
	                biblioteca.listarLivros();
	                System.out.println("\nDigite o ID do livro que deseja editar:\n");
	                int idLivro = Integer.parseInt(read.nextLine());

	                System.out.println("Digite a opção que deseja editar (todos, titulo, autor, editora, ano, paginas, formato, genero):");
	                String opcaoEdicao = read.nextLine();

	                System.out.println("Digite o novo valor:");
	                String novoValor = read.nextLine();

	                biblioteca.editarLivro(idLivro, opcaoEdicao, novoValor);
	                
	            }else if (opcao == 6) {
	                System.out.println("Digite o atributo pelo qual deseja procurar (id, titulo, autor, editora, ano, paginas, formato, genero):");
	                String atributo = read.nextLine();
	                System.out.println("Digite o valor do atributo:");
	                String valor = read.nextLine();
	                biblioteca.listaratr(atributo, valor);
	                }else if (opcao == 7) {
	                System.out.println("Obrigado por utilizar a Biblioteca Java 2023 Unifacs. Até mais!");
	                break;
	            } else {
	                System.out.println("Opção inválida. Digite novamente.\n");
	            }
	        }

	        read.close();
	    }
	

}


