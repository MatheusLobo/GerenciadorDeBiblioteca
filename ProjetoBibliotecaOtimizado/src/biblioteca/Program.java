package biblioteca;


import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		   Biblioteca biblioteca = new Biblioteca();
			// Criando uma instância da Biblioteca (classe pai)
		    biblioteca.addlivro(new Livro("A Revolução dos Bichos", "George Orwell", "Aleph", "1945", "150", "Ficção", "Fisico" ));
	        biblioteca.addlivro(new Livro("Orgulho e Preconceito", "Jane Austen", "T. Egerton", "1813", "400","Romance", "Fisico"));
	        biblioteca.addlivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Gallimard", "1943", "100","Infantil", "Fisico"));
	        biblioteca.addlivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Sudamericana", "1967", "368","Romance", "Fisico"));
	        biblioteca.addlivro(new Livro("Harry Potter e a Câmara Secreta", "J.K. Rowling", "Bloomsbury", "1998", "320","Fantasia", "Fisico"));
	        biblioteca.addlivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Allen Unwin", "1954", "1178","Fantasia", "Fisico"));
	        biblioteca.addlivro(new Livro("O Quinze", "Rachel de Queiroz", "Jose Olympio", "1930", "160", "Drama", "Fisico"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade1", "Livros do Brasil1", "1928", "192","Ficção", "Fisico"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade2", "Livros do Brasil2", "1928", "192", "Ficção", "Fisico"));
	        biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade3", "Livros do Brasil3", "1928", "192","Ficção", "Fisico"));
	     // Adicionando livros digitais à biblioteca (classe filha)
	        biblioteca.addLivroDigital(new LivroDigital("Macunaima", "Mário de Andrade4", "Livros do Brasil5", "1928", "192", "Ficção", "Digital" ,"EPUB", 29.0)); 
	        biblioteca.addLivroDigital(new LivroDigital("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", "Allen Unwin", "1954", "423", "Fantasia", "Digital","EPUB", 12.0));
	        biblioteca.addLivroDigital(new LivroDigital("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Bloomsbury", "1997", "256", "Fantasia", "Digital","PDF", 10.0));
	        biblioteca.addLivroDigital(new LivroDigital("Percy Jackson e o Ladrão de Raios", "Rick Riordan", "Intrínseca", "2005", "377", "Fantasia", "Digital" , "epub", 23.0));
	        biblioteca.addLivroDigital(new LivroDigital("A Culpa é das Estrelas", "John Green", "Intrínseca", "2012", "313", "Romance", "Digital", "PDF", 70.0));
	        biblioteca.addLivroDigital(new LivroDigital("A Menina que Roubava Livros", "Markus Zusak", "Nova Fronteira", "2005", "480", "Romance", "Digital","PDF" , 50.0));
	        biblioteca.addLivroDigital(new LivroDigital("1984", "George Orwell", "Secker Warburg", "1949", "368", "Ficção", "Digital", "EPUB", 40.0));

	        System.out.println("Bem-vindo à Biblioteca Java 2023 Unifacs\n");
	        int opcao = 0;
	        Scanner read = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nEscolha uma opção:");
	            System.out.println("1 - Registrar Livro");
	            System.out.println("2 - Listar Livros");
	            System.out.println("3 - Buscar Livro");
	            System.out.println("4 - Remover Livro");
	            System.out.println("5 - Editar Livro Fisico");
	            System.out.println("6 - Editar Livro Digital");
	            System.out.println("7 - Listar Livros por atributo");
	            System.out.println("8 - Sair\n");

	            String opcaoString = read.nextLine();
	            try {
	            opcao = Integer.parseInt(opcaoString);
	            }catch(NumberFormatException error) {
	            	System.out.println("Opção Invalida. Digite Novamente");
	            }
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
	                String numero_paginas = read.nextLine(); ;

	                System.out.println("Digite o formato do livro (Fisico,Digital):");
	                String formato = read.nextLine();
	        
	                String tamanhoLetras = "";
	                String tamanhoNum = "";
	                String tipoDoArquivo = "";
	                	if(formato.equalsIgnoreCase("Digital")) {
	                		System.out.println("Qual tipo do arquivo (pdf, epub)");
	                		tipoDoArquivo = (read.nextLine());
	                		
	                		System.out.println("Qual tamanho do arquivo:");
	                		tamanhoLetras = read.nextLine();
	                		tamanhoNum = tamanhoLetras.replaceAll("[^ 0-9]", "");
	                	}
	                	double tamanho = Double.parseDouble(tamanhoNum);
	                	
	                System.out.println("Digite o gênero do livro:");
	                String genero = read.nextLine();

	                Livro novoLivroFisico;
	                LivroDigital novoLivroDigital;
	                
	                if (formato.equalsIgnoreCase("Digital")) {
	                	novoLivroDigital = new LivroDigital(titulo, autor, editora, ano_Publi, numero_paginas, genero , formato, tipoDoArquivo, tamanho );
	                	 biblioteca.addLivroDigital(novoLivroDigital);
	                	 System.out.println("Livro Adicionado com sucesso");
	                } else {
	                	novoLivroFisico = new Livro(titulo, autor, editora, ano_Publi, numero_paginas, genero, formato);
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
	                        System.out.println("Gênero: " + livro.getGenero());
	                        System.out.println("Formato: " + livro.getFormato());
	                        if (livro instanceof LivroDigital) {
	                        	LivroDigital livroDigital = (LivroDigital) livro;
	                            System.out.println("Tipo Do Arquivo: " + livroDigital.getTipoDoArquivo());
	                            System.out.println("Tamanho do arquivo: " + livroDigital.getTamanho());
	                        }
	                        System.out.println();
	                    }
	                }
	            } else if (opcao == 4) {
	                System.out.println("\nDigite o título do livro que deseja remover para confirmar remoçao:");
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
	                            System.out.printf("%-15s%-15s", livro.getFormato(), livro.getGenero());
	                        }
	                        System.out.println();
	                    }

	                    System.out.println("\nDigite o ID do livro que deseja remover pra confirmar remoção ou digite [-1] para cancelar remocao:");
	                    int confirmacao = Integer.parseInt(read.nextLine());
	                    
	                    boolean livroRemovido = biblioteca.removerLivro(confirmacao);
	                    
	                    if(confirmacao == -1) {
	                    	System.out.println("Remoção cancelada");
	                    }else if(confirmacao != -1 && livroRemovido) {
	                    	biblioteca.removerLivro(confirmacao);
	                    	System.out.println("Livro Removido com sucesso");
	                    }else if(livroRemovido == false) {
	                    	System.out.println("Livro não encontrado");
	                    }
	                }
	                
	            } else if (opcao == 5) {
	                System.out.println("Lista de Livros:");
	                biblioteca.listarLivros();
	                System.out.println("\nDigite o ID do livro Fisico que deseja editar:\n");
	                int idLivro = Integer.parseInt(read.nextLine());

	                System.out.println("Digite a opção que deseja editar (todos, titulo, autor, editora, ano, paginas, genero):");
	                String opcaoEdicao = read.nextLine();

	                System.out.println("Digite o novo valor:");
	                String novoValor = read.nextLine();

	                biblioteca.editarLivro(idLivro, opcaoEdicao, novoValor);
	          
	                
	            }else if(opcao == 6) {
	            	System.out.println("Lista de Livros:");
	                biblioteca.listarLivros();
	                System.out.println("\nDigite o ID do livro Digital que deseja editar:\n");
	                int idLivro = Integer.parseInt(read.nextLine());

	                System.out.println("Digite a opção que deseja editar (todos, titulo, autor, editora, ano, paginas, genero):");
	                String opcaoEdicao = read.nextLine();

	                System.out.println("Digite o novo valor:");
	                String novoValor = read.nextLine();

	                biblioteca.editarLivroDigital(idLivro, opcaoEdicao, novoValor);
	            }
	            
	            else if (opcao == 7) {
	            	 // Listar livros por atributo
	                System.out.println("Digite o atributo pelo qual deseja procurar (autor, ano, formato, genero, Tipo Do Arquivo):");
	                String atributo = read.nextLine();
	                System.out.println("Digite o valor do atributo:");
	                String valor = read.nextLine();
	                biblioteca.listaratr(atributo, valor);
	                
	                }else if(opcao == 8) {
	                System.out.println("Obrigado por utilizar a Biblioteca Java 2023 Unifacs. Até mais!");
	                break;
	        }
	            
	    }
	        read.close();
}
}
