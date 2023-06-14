package biblioteca;


import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		   Biblioteca biblioteca = new Biblioteca();
			// Criando uma instância da Biblioteca (classe pai)
		    biblioteca.addlivro(new Livro("A Revolução dos Bichos", "George Orwell", "Aleph", "1945", "150", "Ficção"));
	        biblioteca.addlivro(new Livro("Orgulho e Preconceito", "Jane Austen", "T. Egerton", "1813", "400","Romance"));
	        biblioteca.addlivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Gallimard", "1943", "100","Infantil"));
	        biblioteca.addlivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Sudamericana", "1967", "368","Romance"));
	        biblioteca.addlivro(new Livro("Harry Potter e a Câmara Secreta", "J.K. Rowling", "Bloomsbury", "1998", "320","Fantasia"));
	        biblioteca.addlivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Allen Unwin", "1954", "1178","Fantasia"));
	        biblioteca.addlivro(new Livro("O Quinze", "Rachel de Queiroz", "Jose Olympio", "1930", "160", "Drama"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade1", "Livros do Brasil1", "1928", "192","Ficção"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade2", "Livros do Brasil2", "1928", "192", "Ficção"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade3", "Livros do Brasil3", "1928", "192","Ficção"));
	     // Adicionando livros digitais à biblioteca (classe filha)
	        biblioteca.addLivroDigital(new LivroDigital("Macunaima", "Mário de Andrade4", "Livros do Brasil5", "1928", "192", "Ficção", "EPUB", "2.89")); 
	        biblioteca.addLivroDigital(new LivroDigital("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", "Allen Unwin", "1954", "423", "Fantasia", "EPUB", "2.89"));
	        biblioteca.addLivroDigital(new LivroDigital("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Bloomsbury", "1997", "256", "Fantasia", "Digital", "1.8"));
	        biblioteca.addLivroDigital(new LivroDigital("Percy Jackson e o Ladrão de Raios", "Rick Riordan", "Intrínseca", "2005", "377", "Fantasia", "EPUB", "3.2"));
	        biblioteca.addLivroDigital(new LivroDigital("A Culpa é das Estrelas", "John Green", "Intrínseca", "2012", "313", "Romance", "Digital", "1.2"));
	        biblioteca.addLivroDigital(new LivroDigital("A Menina que Roubava Livros", "Markus Zusak", "Nova Fronteira", "2005", "480", "Romance", "Digital", "2.5"));
	        biblioteca.addLivroDigital(new LivroDigital("1984", "George Orwell", "Secker Warburg", "1949", "368", "Ficção", "Digital", "1.6"));


	        System.out.println("Bem-vindo à Biblioteca Java 2023 Unifacs\n");

	        Scanner read = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nEscolha uma opção:");
	            System.out.println("1 - Registrar Livro");
	            System.out.println("2 - Listar Livros");
	            System.out.println("3 - Buscar Livro");
	            System.out.println("4 - Remover Livro");
	            System.out.println("5 - Editar Livro");
	            System.out.println("6 - Listar Livros Fisicos por atributo");
	            System.out.println("7 - Listar Livros Digitais por atributo");
	            System.out.println("8 - Sair\n");

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
	                String numero_paginas  = read.nextLine();

	                System.out.println("Digite o formato do livro (Capa Dura, Capa Mole, Digital):");
	                String formato = read.nextLine();
	                
	                String formatoDoArquivo = "";
	                	if(formato.equalsIgnoreCase("Digital")) {
	                		System.out.println("Qual tipo do arquivo (PDF, EPUB, MOBI)");
	                		formato = read.nextLine();
	                	}

	                System.out.println("Digite o gênero do livro:");
	                String genero = read.nextLine();

	                Livro novoLivroFisico;
	                LivroDigital novoLivroDigital;
	                Random random = new Random();
	                String tamanho = read.nextLine();
	                
	                if (formato.equalsIgnoreCase("Digital")) {
	                	novoLivroDigital = new LivroDigital(titulo, autor, editora, ano_Publi, numero_paginas, genero , formato, tamanho);
	                	 biblioteca.addLivroDigital(novoLivroDigital);
	                	 System.out.println("Livro Adicionado com sucesso");
	                } else {
	                	novoLivroFisico = new Livro(titulo, autor, editora, ano_Publi, numero_paginas, genero);
	                    biblioteca.addlivro(novoLivroFisico);
	                    System.out.println("Livro Adicionado com sucesso");
	                }
	           
	            } else if (opcao == 2) {
	             	// Listar todos os livros da biblioteca
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
	                        	LivroDigital livroDigital = (LivroDigital) livro;
	                            System.out.println("Formato: " + livroDigital.getFormato());
	                            System.out.println("Gênero: " + livroDigital.getGenero());
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
	                        System.out.printf("%-6d%-25s%-25s%-25s%-20s%-15s", livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAnoPubli(), livro.getNumeroPaginas());
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

	                // System.out.println("Digite o novo valor:");
	                            
	                if (opcaoEdicao.toLowerCase().equals("todos")) {
	                    String novoValor;
	                    System.out.println("Digite o valor para o novo titulo");
	                    novoValor = read.nextLine();
	                    biblioteca.editarTitulo(idLivro, novoValor);

	                    System.out.println("Digite o valor para o Autor");
	                    novoValor = read.nextLine();
	                    biblioteca.editarAutor(idLivro, novoValor);

	                    System.out.println("Digite o valor para o novo Editora");
	                    novoValor = read.nextLine();
	                    biblioteca.editarEditora(idLivro, novoValor);

	                    System.out.println("Digite o valor para o novo AnoPubli");
	                    novoValor = read.nextLine();
	                    biblioteca.editarAnoPublicacao(idLivro, novoValor);	
	            	 
	                    System.out.println("Digite o valor para o novo NumeroPaginas");
	                    novoValor = read.nextLine();
	                    biblioteca.editarNumeroPaginas(idLivro, novoValor);	    
	                    System.out.println("Digite o valor para o novo Formato");
	                    novoValor = read.nextLine();
	                    biblioteca.editarFormato(idLivro, novoValor);	   
	                    System.out.println("Digite o valor para o novo Genero");
	                    novoValor = read.nextLine();
	                    biblioteca.editarGenero(idLivro, novoValor);	
	                } else {
	                    System.out.println("Digite o novo valor");
	                    String novoValor = read.nextLine();
	                    switch (opcaoEdicao.toLowerCase()) {
	                        case "titulo":
	                            biblioteca.editarTitulo(idLivro, novoValor);
	                            break;
	                        case "autor":
	                            biblioteca.editarAutor(idLivro, novoValor);
	                            break;
	                        case "editora":
	                            biblioteca.editarEditora(idLivro, novoValor);
	                            break;
	                        case "ano":
	                            biblioteca.editarAnoPublicacao(idLivro, novoValor);
	                            break;
	                        case "paginas":
	                            biblioteca.editarNumeroPaginas(idLivro, novoValor);
	                            break;
	                        case "formato":
	                            biblioteca.editarFormato(idLivro, novoValor);
	                            break;
	                        case "genero":
	                            biblioteca.editarGenero(idLivro, novoValor);
	                            break;
	                        default:
	                            System.out.println("Opção inválida.");
	                            break;
	                    }
	                }
	            
   
	                				   }else if (opcao == 6) {
	            	 // Listar livros por atributo
	                System.out.println("Digite o atributo pelo qual deseja procurar (titulo, autor, editora, ano, paginas, formato, genero):");
	                String atributo = read.nextLine();
	                System.out.println("Digite o valor do atributo:");
	                String valor = read.nextLine();
	                biblioteca.listaratr(atributo, valor);
	                }else if(opcao == 7) {
	                	System.out.println("Digite o atributo pelo qual deseja procurar (titulo, autor, editora, ano, paginas, formato, genero):");
		                String atributo = read.nextLine();
		                System.out.println("Digite o valor do atributo:");
		                String valor = read.nextLine();
		                biblioteca.listarAtrLivroDigi(atributo, valor);
	                }else if (opcao == 8) {
	                System.out.println("Obrigado por utilizar a Biblioteca Java 2023 Unifacs. Até mais!");
	                break;
	            } else {
	                System.out.println("Opção inválida. Digite novamente.\n");
	            }
	        }

	        read.close();
	    }
}


