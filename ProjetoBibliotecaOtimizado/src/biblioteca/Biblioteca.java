package biblioteca;

//Importação das classes Scanner e ArrayList
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



//Definição da classe Biblioteca
public class Biblioteca {
ArrayList<Livro> livros; // Cria um ArrayList para armazenar os livros da biblioteca
ArrayList<LivroDigital> livrosDigitais;

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



// Verifica se um determinado ID já existe na lista de livros.
public boolean existeId(int id) {
    for (Livro livro : livros) {
        if (livro.getId() == id) {
            return true; // O ID foi encontrado na lista de livros
        }
    }
    return false; // O ID não foi encontrado na lista de livros
}
public Livro getLivroById(int id) {
    for (Livro livro : livros) {
        if (livro.getId() == id) {
            return livro;
        }
    }
    return null;
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
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s\n", livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(), livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(), livroDigital.getFormatoD(), livroDigital.getTamanho());
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
    for (Iterator<Livro> iterator = livros.iterator(); iterator.hasNext();) {
        Livro livro = iterator.next();
        if (livro.getId() == id) {
            iterator.remove();
            System.out.println("Livro removido com sucesso.");
            return true;
        }
    }

    for (Iterator<LivroDigital> digitalIterator = livrosDigitais.iterator(); digitalIterator.hasNext();) {
        LivroDigital livroDigital = digitalIterator.next();
        if (livroDigital.getId() == id) {
            digitalIterator.remove();
           
            return true;
        }
    }

    System.out.println("Livro não removido.");
    return false;
}





public void imprimirLivro(Livro livro) {
	  System.out.println("ID: " + livro.getId()); // Imprime o ID do livro
	  System.out.println("\tTítulo: " + livro.getTitulo()); // Imprime o título do livro
	  System.out.println("\tAutor: " + livro.getAutor()); // Imprime o autor do livro
	  System.out.println("\tEditora: " + livro.getEditora()); // Imprime a editora do livro
	  System.out.println("\tAno de Publicação: " + livro.getAnoPubli()); // Imprime o ano de publicação do livro
	  System.out.println("\tNúmero de páginas: " + livro.getNumeroPaginas()); // Imprime o número de páginas do livro
	}
public void editarLivroDigital(int id, String opcaoEdicao, String novoValor) {
	 Scanner read = new Scanner(System.in);
    for (Livro livro : livros) {
        if (livro.getId() == id && livro instanceof LivroDigital) {
            LivroDigital livroDigital = (LivroDigital) livro;
            switch (opcaoEdicao.toLowerCase()) {
                case "todos":
                    System.out.println("Alterando todas as informações do livro digital...");
                    System.out.println("Digite o novo título:");
                    String novoTitulo = read.nextLine();
                    livroDigital.setTitulo(novoTitulo);

                    System.out.println("Digite o novo autor:");
                    String novoAutor = read.nextLine();
                    livroDigital.setAutor(novoAutor);

                    System.out.println("Digite a nova editora:");
                    String novaEditora = read.nextLine();
                    livroDigital.setEditora(novaEditora);

                    System.out.println("Digite o novo ano de publicação:");
                    String novoAno = read.nextLine();
                    livroDigital.setAnoPubli(novoAno);

                    System.out.println("Digite o novo número de páginas:");
                    String novoPaginas = read.nextLine();
                    livroDigital.setNumeroPaginas(novoPaginas);

                    System.out.println("Digite o novo gênero:");
                    String novoGenero = read.nextLine();
                    livroDigital.setGenero(novoGenero);

                    System.out.println("Digite o novo formato:");
                    String novoFormato = read.nextLine();
                    livroDigital.setFormatoD(novoFormato);

                    System.out.println("Digite o novo tamanho:");
                    String novoTamanho = read.nextLine();
                    livroDigital.setTamanho(novoTamanho);

                    System.out.println("Todas as informações do livro digital foram atualizadas.");
                    return;
                case "titulo":
                    System.out.println("Alterando o título do livro digital...");
                    System.out.println("Digite o novo título:");
                    String Titulo = read.nextLine();
                    livroDigital.setTitulo(Titulo);
                    System.out.println("O título do livro digital foi atualizado.");
                    return;
                case "autor":
                    System.out.println("Alterando o autor do livro digital...");
                    System.out.println("Digite o novo autor:");
                    String Autor = read.nextLine();
                    livroDigital.setAutor(Autor);
                    System.out.println("O autor do livro digital foi atualizado.");
                    return;
                case "editora":
                    System.out.println("Alterando a editora do livro digital...");
                    System.out.println("Digite a nova editora:");
                    String Editora = read.nextLine();
                    livroDigital.setEditora(Editora);
                    System.out.println("A editora do livro digital foi atualizada.");
                    return;
                case "ano":
                    System.out.println("Alterando o ano de publicação do livro digital...");
                    System.out.println("Digite o novo ano de publicação:");
                    String novo_Ano = read.nextLine();
                    livroDigital.setAnoPubli(novo_Ano);
                    System.out.println("O ano de publicação do livro digital foi atualizado.");
                    return;
                case "paginas":
                    System.out.println("Opção inválida para livro digital.");
                    return;
                case "genero":
                    System.out.println("Alterando o gênero do livro digital...");
                    System.out.println("Digite o novo gênero:");
                    String novo_Genero = read.nextLine();
                    livroDigital.setGenero(novo_Genero);
                    System.out.println("O gênero do livro digital foi atualizado.");
                    return;
                case "formato":
                    System.out.println("Alterando o formato do livro digital...");
                    System.out.println("Digite o novo formato:");
                    String novo_Formato = read.nextLine();
                    livroDigital.setFormatoD(novo_Formato);
                    System.out.println("O formato do livro digital foi atualizado.");
                    return;
                case "tamanho":
                    System.out.println("Alterando o tamanho do livro digital...");
                    System.out.println("Digite o novo tamanho:");
                    String novo_Tamanho = read.nextLine();
                    livroDigital.setTamanho(novo_Tamanho);
                    System.out.println("O tamanho do livro digital foi atualizado.");
                    return;

                default:
                    System.out.println("Opção inválida para livro digital.");
                    return;
            }
        }
    }
    System.out.println("Livro digital não encontrado.");
}
public void editarLivro(int id, String opcaoEdicao, String novoValor) {
	 Scanner read = new Scanner(System.in);
    for (Livro livro : livros) {
        if (livro.getId() == id) {
            if (livro instanceof LivroDigital) {
                LivroDigital livroDigital = (LivroDigital) livro;
                switch (opcaoEdicao.toLowerCase()) {
                    case "formato":
                        System.out.println("Alterando o formato do livro digital...");
                        livroDigital.setFormatoD(novoValor);
                        System.out.println("O formato do livro digital foi atualizado.");
                        return;
                    case "tamanho":
                        System.out.println("Alterando o tamanho do livro digital...");
                        livroDigital.setTamanho(novoValor);
                        System.out.println("O tamanho do livro digital foi atualizado.");
                        return;
                    default:
                        System.out.println("Opção inválida para livro digital.");
                        return;
                }
            } else if (livro instanceof Livro) {
                switch (opcaoEdicao.toLowerCase()) {
                    case "todos":
                        System.out.println("Alterando todas as informações do livro...");
                        System.out.println("Digite o novo título:");
                        String novoTitulo = read.nextLine();
                        livro.setTitulo(novoTitulo);

                        System.out.println("Digite o novo autor:");
                        String novoAutor = read.nextLine();
                        livro.setAutor(novoAutor);

                        System.out.println("Digite a nova editora:");
                        String novaEditora = read.nextLine();
                        livro.setEditora(novaEditora);

                        System.out.println("Digite o novo ano de publicação:");
                        String novoAno = read.nextLine();
                        livro.setAnoPubli(novoAno);

                        if (livro instanceof Livro) {
                            System.out.println("Digite o novo número de páginas:");
                            String novoPaginas = read.nextLine();
                            ((Livro) livro).setNumeroPaginas(novoPaginas);
                        }

                        System.out.println("Digite o novo gênero:");
                        String novoGenero = read.nextLine();
                        livro.setGenero(novoGenero);

                        System.out.println("Todas as informações do livro foram atualizadas.");
                        return;
                    case "titulo":
                        System.out.println("Alterando o título do livro...");
                        String novo_Titulo = read.nextLine();
                        livro.setTitulo(novo_Titulo);
                        System.out.println("O título do livro foi atualizado.");
                        return;
                    case "autor":
                        System.out.println("Alterando o autor do livro...");
                        String novo_Autor = read.nextLine();
                        livro.setAutor(novo_Autor);
                        System.out.println("O autor do livro foi atualizado.");
                        return;
                    case "editora":
                        System.out.println("Alterando a editora do livro...");
                        String nova_Editora = read.nextLine();
                        livro.setEditora(nova_Editora);
                        System.out.println("A editora do livro foi atualizada.");
                        return;
                    case "ano":
                        System.out.println("Alterando o ano de publicação do livro...");
                        String novo_Ano = read.nextLine();
                        livro.setAnoPubli(novo_Ano);
                        System.out.println("O ano de publicação do livro foi atualizado.");
                        return;
                    case "paginas":
                        if (livro instanceof Livro) {
                            System.out.println("Alterando o número de páginas do livro impresso...");
                            String novoPaginas = read.nextLine();
                            ((Livro) livro).setNumeroPaginas(novoPaginas);
                            System.out.println("O número de páginas do livro impresso foi atualizado.");
                        } else {
                            System.out.println("Opção inválida para livro digital.");
                        }
                        return;
                    case "genero":
                        System.out.println("Alterando o gênero do livro...");
                        String novo_Genero = read.nextLine();
                        livro.setGenero(novo_Genero);
                        System.out.println("O gênero do livro foi atualizado.");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                        return;
                }
            }
            System.out.println("Opção inválida."); // Opção de edição inválida
            return;
        }
    }
    System.out.println("Livro não encontrado."); // Livro com o ID fornecido não encontrado
}
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
        	for (Livro livro : livros) {
                if (livro.getNumeroPaginas().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosEncontrados.add(livro);
                }
            }
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getNumeroPaginas().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break;
          
        case "formato":
            for (LivroDigital livroDigital : livrosDigitais) {
                if (livroDigital.getFormatoD().toLowerCase().contains(valorBusca.toLowerCase())) {
                    livrosDigiEncontrados.add(livroDigital);
                }
            }
            break; 
         case "tamanho":
                for (LivroDigital livroDigital : livrosDigitais) {
                    if (livroDigital.getTamanho().toLowerCase().contains(valorBusca.toLowerCase())) {
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
            System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10s%n",
                    livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
                    livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
                    livroDigital.getFormatoD(), livroDigital.getTamanho());
        } else {
            System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10s%n",
                    livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                    livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(),
                    "-", "-");
        }
    }
    System.out.println("");
    System.out.println("Digital");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho (Mb)");
    for (LivroDigital livroDigital : livrosDigiEncontrados) {
    	
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10s%n",
                livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
                livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
                livroDigital.getFormatoD(), livroDigital.getTamanho());
    }
}
}