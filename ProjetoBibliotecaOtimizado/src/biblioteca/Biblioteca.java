package biblioteca;


//Importação das classes Scanner e ArrayList
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Definição da classe Biblioteca
public class Biblioteca {
private static ArrayList<Livro> livros; // Cria um ArrayList para armazenar os livros da biblioteca
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
public static Livro getLivroPorId(int idLivro) {
    for (Livro livro : livros) {
        if (livro.getId() == idLivro) {
            return livro;
        }
    }
    return null; // Retorna null caso não encontre o livro com o ID especificado
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
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s\n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");

    // Loop para listar os livros físicos
    livros.sort(Comparator.comparing(Livro :: getTitulo));
    for (Livro livro : livros) {
    	System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s\n",
    	        livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
    	        livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(), "-", "-");
    	}
    System.out.println("");
    System.out.println("Livros Digitais");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s\n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");
    // Loop para listar os livros digitais
    livrosDigitais.sort(Comparator.comparing(Livro :: getTitulo));
    for (LivroDigital livroDigital : livrosDigitais) {
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s\n", livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(), livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(), livroDigital.getFormato(), livroDigital.getTamanho());
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
}
return false; // Livro não encontrado
}
public void imprimirLivro(Livro livro) {
	  System.out.println("ID: " + livro.getId()); // Imprime o ID do livro
	  System.out.println("\tTítulo: " + livro.getTitulo()); // Imprime o título do livro
	  System.out.println("\tAutor: " + livro.getAutor()); // Imprime o autor do livro
	  System.out.println("\tEditora: " + livro.getEditora()); // Imprime a editora do livro
	  System.out.println("\tAno de Publicação: " + livro.getAnoPubli()); // Imprime o ano de publicação do livro
	  System.out.println("\tNúmero de páginas: " + livro.getNumeroPaginas()); // Imprime o número de páginas do livro
	}

public void editarTitulo(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro != null) {
        System.out.println("Alterando o título do livro...");
        livro.setTitulo(novoValor);
        System.out.println("O título do livro foi atualizado.");

        if (livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            System.out.println("Alterando o título do livro digital...");
            livroDigital.setTitulo(novoValor);
            System.out.println("O título do livro digital foi atualizado.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}

public void editarNumeroPaginas(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro != null) {
        System.out.println("Alterando o número de páginas do livro...");
        livro.setNumeroPaginas(novoValor);
        System.out.println("O número de páginas do livro foi atualizado.");

        if (livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            System.out.println("Alterando o número de páginas do livro digital...");
            livroDigital.setNumeroPaginas(novoValor);
            System.out.println("O número de páginas do livro digital foi atualizado.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}

public void editarAutor(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro != null) {
        System.out.println("Alterando o autor do livro...");
        livro.setAutor(novoValor);
        System.out.println("O autor do livro foi atualizado.");

        if (livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            System.out.println("Alterando o autor do livro digital...");
            livroDigital.setAutor(novoValor);
            System.out.println("O autor do livro digital foi atualizado.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}

public void editarEditora(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro != null) {
        System.out.println("Alterando a editora do livro...");
        livro.setEditora(novoValor);
        System.out.println("A editora do livro foi atualizada.");

        if (livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            System.out.println("Alterando a editora do livro digital...");
            livroDigital.setEditora(novoValor);
            System.out.println("A editora do livro digital foi atualizada.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}

public void editarAnoPublicacao(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro != null) {
        System.out.println("Alterando o ano de publicação do livro...");
        livro.setAnoPubli(novoValor);
        System.out.println("O ano de publicação do livro foi atualizado.");

        if (livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            System.out.println("Alterando o ano de publicação do livro digital...");
            livroDigital.setAnoPubli(novoValor);
            System.out.println("O ano de publicação do livro digital foi atualizado.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}




public void editarFormato(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro instanceof LivroDigital) {
        LivroDigital livroDigital = (LivroDigital) livro;
        System.out.println("Alterando o formato do livro...");
        livroDigital.setFormato(novoValor);
        System.out.println("O formato do livro foi atualizado.");
    } else {
        System.out.println("O livro não é um livro digital.");
    }
}

public void editarGenero(int idLivro, String novoValor) {
    Livro livro = Biblioteca.getLivroPorId(idLivro);
    if (livro instanceof LivroDigital) {
        LivroDigital livroDigital = (LivroDigital) livro;
        System.out.println("Alterando o gênero do livro...");
        livroDigital.setGenero(novoValor);
        System.out.println("O gênero do livro foi atualizado.");
    } else {
        System.out.println("O livro não é um livro digital.");
    }
}
  

//Lista os livros registrados com base no atributo e valor de busca fornecidos.
public void listaratr(String atributo, String valorBusca) {
    List<Livro> livrosEncontrados = new ArrayList<>();
    List<LivroDigital> livrosDigiEncontrados = new ArrayList<>();
    livros.sort(Comparator.comparing(Livro::getTitulo));
    livrosDigitais.sort(Comparator.comparing(Livro::getTitulo));

    switch (atributo.toLowerCase()) {
        case "titulo":
            for (Livro livro : livros) {
                if (livro.getTitulo().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getTitulo().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
        case "autor":
            for (Livro livro : livros) {
                if (livro.getAutor().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getAutor().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
        case "editora":
            for (Livro livro : livros) {
                if (livro.getEditora().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getEditora().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
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
        case "paginas":
            int numPaginas = Integer.parseInt(valorBusca);
            for (Livro livro : livros) {
                if (livro.getNumeroPaginas().equalsIgnoreCase(valorBusca)) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getNumeroPaginas().equalsIgnoreCase(valorBusca)) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
          
        case "formato":
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
        default:
            System.out.println("Atributo inválido.");
            return;
    }

    // Imprimir a lista de livros encontrados
    System.out.println("\nLivros Registrados (Atributo: " + atributo + "):\n");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");

    for (Livro livro : livrosEncontrados) {
        if (livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
                    livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
                    livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
                    livroDigital.getFormato(), livroDigital.getTamanho());
        } else {
            System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
                    livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                    livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(),
                    "-", "-");
        }
    }
    System.out.println("");
    System.out.println("Digital");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");
    for (LivroDigital livroDigital : livrosDigiEncontrados) {
    	
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
                livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
                livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
                livroDigital.getFormato(), livroDigital.getTamanho());
    }
}

public void listarAtrLivroDigi(String atributo, String valorBusca) {
	List<LivroDigital> livrosDigiEncontrados = new ArrayList<>();
  switch (atributo.toLowerCase()) { // Verifica o atributo fornecido
      case "titulo":
      	 livrosDigiEncontrados = livrosDigitais.stream()
          .filter(livroDigital -> livroDigital.getTitulo()
          .toLowerCase().contains(valorBusca.toLowerCase()))
          .collect(Collectors.toList()); 
          break;
      case "autor":
      	 livrosDigiEncontrados = livrosDigitais.stream()
          .filter(livroDigital -> livroDigital.getAutor().toLowerCase().contains(valorBusca.toLowerCase()))
          .collect(Collectors.toList()); 
          break;
      case "editora":
      	livrosDigiEncontrados = livrosDigitais.stream()
          .filter(livroDigital -> livroDigital.getEditora().toLowerCase().contains(valorBusca.toLowerCase()))
          .collect(Collectors.toList());
          break;
      case "ano":
      	livrosDigiEncontrados = livrosDigitais.stream().filter(livroDigital -> livroDigital.getAnoPubli().toLowerCase().contains(valorBusca.toLowerCase())).collect(Collectors.toList()); // Fil
          break;
      case "paginas":
      	livrosDigiEncontrados = livrosDigitais.stream().filter(livroDigital -> livroDigital.getNumeroPaginas().toLowerCase().contains(valorBusca.toLowerCase())).collect(Collectors.toList()); // Fil
          break;
      case "formato":
          livrosDigiEncontrados = livrosDigitais.stream().filter(livroDigital -> livroDigital.getFormato().toLowerCase().contains(valorBusca.toLowerCase())).collect(Collectors.toList()); // Filtra os livros digitais pelo formato que contém o valor de busca
          break;
      case "genero":
          livrosDigiEncontrados = livrosDigitais.stream().filter(livroDigital -> livroDigital.getGenero().toLowerCase().contains(valorBusca.toLowerCase())).collect(Collectors.toList()); // Filtra os livros digitais pelo gênero que contém o valor de busca
          break;
      default:
          System.out.println("Atributo inválido."); // Atributo inválido
          return;
  }
  
  System.out.println("\nLivros Registrados (Atributo: " + atributo + "):\n");
  System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
          "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho");
  // Loop para imprimir os livros digitais encontrados
  for (LivroDigital livroDigital : livrosDigiEncontrados) {
      System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10.2f%n",
              livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
              livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
              livroDigital.getFormato(), livroDigital.getTamanho());

  }
}
}