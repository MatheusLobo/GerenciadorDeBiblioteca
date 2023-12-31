package biblioteca;


//Importação das classes Scanner e ArrayList
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

//Definição da classe Biblioteca
public class Biblioteca {
private ArrayList<Livro> livros; // Cria um ArrayList para armazenar os livros da biblioteca
private ArrayList<LivroDigital> livrosDigitais;

//Construtor da classe Biblioteca
public Biblioteca() {
livros = new ArrayList<>(); // Inicializa a lista de livros vazia
livrosDigitais = new ArrayList<>();
}

//Método para adicionar um livro à biblioteca
public void addlivro(Livro livro) {
	  livro.setId(gerarNovoId());// Gera um novo ID para o livro
	  livros.add(livro);// Adiciona o livro à lista de livros da biblioteca
	}


	public void addLivroDigital(LivroDigital livroDigital) {
	    livroDigital.setId(gerarNovoId()); // Gera um novo ID para o livro digital
	    livrosDigitais.add(livroDigital); // Adiciona o livro digital à lista de livros digitais
	}


//Verifica se um determinado ID já existe na lista de livros.
public boolean existeId(int id) {
  for (Livro livro : livros) {
      if (livro.getId() == id) {
          return true; // O ID foi encontrado na lista de livros
      }
  }
  return false; // O ID não foi encontrado na lista de livros
}

public int gerarNovoId() {
  Random random = new Random();
  int novoId = random.nextInt(10000) + 1; // Gera um número aleatório entre 1 e 10000
  while (existeId(novoId)) { // Verifica se o ID já está sendo usado por outro livro
      novoId = random.nextInt(10000) + 1; // Gera um novo número aleatório
  }
  return novoId; // Retorna o novo ID gerado
}

/// Método para listar os livros registrados
public void listarLivros() {
    System.out.println("\nLivros Registrados:\n");
    System.out.println("[Livros Fisicos]\n");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-9s %-9s %-5s\n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");

   
    // Loop para listar os livros físicos
    livros.sort(Comparator.comparing(Livro :: getTitulo));
    for (Livro livro : livros) {
    	System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-9s %-9s %-5s\n",
    	        livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
    	        livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(), livro.getFormato(), "-");
    	}
    System.out.println("");
    System.out.println("[Livros Digitais]\n");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-9s %-9s %-5s\n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");
    // Loop para listar os livros digitais
    livrosDigitais.sort(Comparator.comparing(Livro :: getTitulo));
    for (LivroDigital livroDigital : livrosDigitais) {
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-9s %-9s %-5s\n", livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), 
        		livroDigital.getEditora(), livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(), livroDigital.getFormato(), 
        		livroDigital.getTamanho());
    }
}

public List<Livro> buscarLivro(String titulo) {
    List<Livro> livrosEncontrados = new ArrayList<>();

    // Procura na lista de livros físicos
    for (Livro livro : livros) {
        if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
            livrosEncontrados.add(livro);
        }
    }

    // Procura na lista de livros digitais
    for (LivroDigital livroDigital : livrosDigitais) {
        if (livroDigital.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
            livrosEncontrados.add(livroDigital);
        }
    }

    return livrosEncontrados;
}

public boolean removerLivro(int id) {
for (Livro livro : livros) {
    if (livro.getId() == id) { // checa se o id fornecido bate com o id de um livro existente para remoçao
        livros.remove(livro);
        return true; // Livro encontrado e removido com sucesso
    }
    for(LivroDigital livroDigital : livrosDigitais) {
    	if(livroDigital.getId() == id) {
    		livrosDigitais.remove(livroDigital);
    		return true;
    	}
    }
}
return false; // Livro não encontrado
}
public void editarLivro(int id, String opcao, String novoValor) {
    boolean livroEncontrado = false;
    boolean livroFisico = false;
    
    for (Livro livro : livros) {
        if (livro.getId() == id) {
            livroEncontrado = true;
            
            if (livro instanceof LivroFisico) {
                livroFisico = true;
                
                switch (opcao.toLowerCase()) {
                    case "todos":
                        System.out.println("\nAlterando todas as informações do livro...\n");
                        editarTodasInformacoes(livro, novoValor);
                        System.out.println("Todas as informações do livro físico foram atualizadas.");
                        break;
                    case "titulo":
                        System.out.println("Alterando o título do livro...");
                        livro.setTitulo(novoValor);
                        System.out.println("O título do livro físico foi atualizado.");
                        break;
                    case "autor":
                        System.out.println("Alterando o autor do livro...");
                        livro.setAutor(novoValor);
                        System.out.println("O autor do livro físico foi atualizado.");
                        break;
                    case "editora":
                        System.out.println("Alterando a editora do livro...");
                        livro.setEditora(novoValor);
                        System.out.println("A editora do livro físico foi atualizada.");
                        break;
                    case "ano":
                        System.out.println("Alterando o ano de publicação do livro...");
                        livro.setAnoPubli(novoValor);
                        System.out.println("O ano de publicação do livro físico foi atualizado.");
                        break;
                    case "paginas":
                        System.out.println("Alterando o número de páginas do livro...");
                        livro.setNumeroPaginas(novoValor);
                        System.out.println("O número de páginas do livro físico foi atualizado.");
                        break;
                    case "genero":
                        System.out.println("Alterando o gênero do livro...");
                        livro.setGenero(novoValor);
                        System.out.println("O gênero do livro físico foi atualizado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        return;
                }
            }
            break;
        }
    }
    
    if (!livroEncontrado) {
        System.out.println("Livro não encontrado.");
    } else if (!livroFisico) {
        System.out.println("O livro selecionado não é físico.");
    }
}

public void editarTodasInformacoes(Livro livro, String novoValor) {
    livro.setTitulo(novoValor);
    livro.setAutor(novoValor);
    livro.setEditora(novoValor);
    livro.setAnoPubli(novoValor);
    livro.setNumeroPaginas(novoValor);
    livro.setGenero(novoValor);
}

public void editarLivroDigital(int id, String opcao, String novoValor) {
    boolean livroEncontrado = false;
    
    for (LivroDigital livroDigital : livrosDigitais) {
        if (livroDigital.getId() == id) {
            livroEncontrado = true;
            
            switch (opcao.toLowerCase()) {
                case "todos":
                    System.out.println("\nAlterando todas as informações do livro...\n");
                    editarTodasInformacoes(livroDigital, novoValor);
                    System.out.println("Todas as informações do livro digital foram atualizadas.");
                    break;
                case "titulo":
                    System.out.println("Alterando o título do livro...");
                    livroDigital.setTitulo(novoValor);
                    System.out.println("O título do livro digital foi atualizado.");
                    break;
                case "autor":
                    System.out.println("Alterando o autor do livro...");
                    livroDigital.setAutor(novoValor);
                    System.out.println("O autor do livro digital foi atualizado.");
                    break;
                case "editora":
                    System.out.println("Alterando a editora do livro...");
                    livroDigital.setEditora(novoValor);
                    System.out.println("A editora do livro digital foi atualizada.");
                    break;
                case "ano":
                    System.out.println("Alterando o ano de publicação do livro...");
                    livroDigital.setAnoPubli(novoValor);
                    System.out.println("O ano de publicação do livro digital foi atualizado.");
                    break;
                case "paginas":
                    System.out.println("Alterando o número de páginas do livro...");
                    livroDigital.setNumeroPaginas(novoValor);
                    System.out.println("O número de páginas do livro digital foi atualizado.");
                    break;
                case "genero":
                    System.out.println("Alterando o gênero do livro...");
                    livroDigital.setGenero(novoValor);
                    System.out.println("O gênero do livro digital foi atualizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }
            break;
        }
    }
    
    if (!livroEncontrado) {
        System.out.println("Livro digital não encontrado.");
    }
}
//Lista os livros registrados com base no atributo e valor de busca fornecidos.
public void listaratr(String atributo, String valorBusca) {
    List<Livro> livrosEncontrados = new ArrayList<>();
    List<LivroDigital> livrosDigiEncontrados = new ArrayList<>();
    livros.sort(Comparator.comparing(Livro::getTitulo));
    livrosDigitais.sort(Comparator.comparing(Livro::getTitulo));

    switch (atributo.toLowerCase()) {
        case "ano":
            for (Livro livro : livros) {
                if (livro.getAnoPubli().equalsIgnoreCase(valorBusca)) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getAnoPubli().equalsIgnoreCase(valorBusca)) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
        case "formato":
        	   for (Livro livro : livros) {
                   if (livro.getFormato().toLowerCase().contains(valorBusca.toLowerCase())) {
                       livrosEncontrados.add(livro);
                   }
               } 
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getFormato().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break; 
        case "genero":
            for (Livro livro : livros) {
                if (livro.getGenero().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getGenero().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
            
        case "tipo do arquivo" :
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getTipoDoArquivo().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
        default:
            System.out.println("Atributo inválido.");
            return;
    }

    // Imprimir a lista de livros encontrados
    System.out.println("\nLivros Registrados (Atributo: " + atributo + "):\n");
    System.out.println("[Livros Fisicos]");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");

    for (Livro livro : livrosEncontrados) {
            System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
                    livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                    livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(),
                    livro.getFormato(), "-");
        }

    System.out.println("");
    
    System.out.println("[Livros Digital]");
    
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n", "ID", "Título", "Autor", "Editora", 
    		"Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");
    
    for (LivroDigital livroDigital : livrosDigiEncontrados) {
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
                livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
                livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
                livroDigital.getFormato(), livroDigital.getTamanho());
    }
}

}
