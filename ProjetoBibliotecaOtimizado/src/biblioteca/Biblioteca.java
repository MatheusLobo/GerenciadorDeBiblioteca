package biblioteca;

//Importação das classes Scanner e ArrayList
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
	livroDigital.setId(gerarNovoId());
	livrosDigitais.add(livroDigital);
}

public boolean existeId(int id) {
  for (Livro livro : livros) {
      if (livro.getId() == id) {
          return true;
      }
  }
  return false;
}

public int gerarNovoId() {
  Random random = new Random();
  int novoId = random.nextInt(10000) + 1;
  while (existeId(novoId)) {
      novoId = random.nextInt(10000) + 1;
  }
  return novoId;
}



//Método para listar todos os livros da biblioteca
public void listarLivros() {
 System.out.println("\nLivros Registrados:\n");
 System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
         "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho");

 for (Livro livro : livros) {
     System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10s%n",
             livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
             livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(), "-", "-");
 }

 for (LivroDigital livroDigital : livrosDigitais) {
     System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10.2f%n",
             livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
             livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
             livroDigital.getFormato(), livroDigital.getTamanho());
 }
}

public List<Livro> buscarLivro(String titulo) {
    List<Livro> livrosEncontrados = new ArrayList<>();

    for (Livro livro : livros) {
        if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
            livrosEncontrados.add(livro);
        }
    }

    return livrosEncontrados;
}


public boolean removerLivro(int id) {
  for (Livro livro : livros) {
      if (livro.getId() == id) {
          livros.remove(livro);
          return true; // Livro encontrado e removido com sucesso
      }
  }
  return false; // Livro não encontrado
}
public void imprimirLivro(Livro livro) {
  System.out.println("ID: " + livro.getId());
  System.out.println("\tTítulo: " + livro.getTitulo());
  System.out.println("\tAutor: " + livro.getAutor());
  System.out.println("\tEditora: " + livro.getEditora());
  System.out.println("\tAno de Publicação: " + livro.getAnoPubli());
  System.out.println("\tNúmero de páginas: " + livro.getNumeroPaginas());
  
}

public void editarLivro(int id, String opcao, String novoValor) {
	
  for (Livro livro : livros) {
      if (livro.getId() == id) {
          if (livro instanceof LivroDigital) {
        	  LivroDigital livroDigital = (LivroDigital) livro; // Converte o livro para o tipo LivroFisico
              switch (opcao.toLowerCase()) {
                  case "todos":
                      System.out.println("\nAlterando todas as informações do livro...\n");
                      livro.setTitulo(novoValor);
                      livro.setAutor(novoValor);
                      livro.setEditora(novoValor);
                      livro.setAnoPubli(novoValor);
                      livro.setNumeroPaginas(Integer.parseInt(novoValor));
                      livro.setFormato(novoValor);
                      livro.setGenero(novoValor);
                      System.out.println("Todas as informações do livro foram atualizadas.");
                      break;
                  case "titulo":
                      System.out.println("Alterando o título do livro...");
                      livro.setTitulo(novoValor);
                      System.out.println("O título do livro foi atualizado.");
                      break;
                  case "autor":
                      System.out.println("Alterando o autor do livro...");
                      livro.setAutor(novoValor);
                      System.out.println("O autor do livro foi atualizado.");
                      break;
                  case "editora":
                      System.out.println("Alterando a editora do livro...");
                      livro.setEditora(novoValor);
                      System.out.println("A editora do livro foi atualizada.");
                      break;
                  case "ano":
                      System.out.println("Alterando o ano de publicação do livro...");
                      livro.setAnoPubli(novoValor);
                      System.out.println("O ano de publicação do livro foi atualizado.");
                      break;
                  case "paginas":
                      System.out.println("Alterando o número de páginas do livro...");
                      livro.setNumeroPaginas(Integer.parseInt(novoValor));
                      System.out.println("O número de páginas do livro foi atualizado.");
                      break;
                  case "formato":
                      System.out.println("Alterando o formato do livro...");
                      livroDigital.setFormato(novoValor);
                      System.out.println("O formato do livro foi atualizado.");
                      break;
                  case "genero":
                      System.out.println("Alterando o gênero do livro...");
                      livroDigital.setGenero(novoValor);
                      System.out.println("O gênero do livro foi atualizado.");
                      break;
                  default:
                      System.out.println("Opção inválida.");
                      return;
              }
          } else {
              System.out.println("O livro não é do tipo LivroFisico.");
          }
          System.out.println("Livro editado com sucesso.");
          return;
      }
  }
  System.out.println("Livro não encontrado.");
}
public void listaratr(String atributo, String valorBusca) {
    // Filtrar os livros com base no atributo fornecido
    List<Livro> livrosEncontrados = new ArrayList<>();
    List<LivroDigital> livrosDigiEncontrados = new ArrayList<>();

    switch (atributo.toLowerCase()) {
        case "titulo":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getTitulo().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());
            break;
        case "autor":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getAutor().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());
            break;
        case "editora":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getEditora().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());
            break;
        case "ano":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getAnoPubli().equalsIgnoreCase(valorBusca))
                    .collect(Collectors.toList());
            break;
        case "paginas":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getNumeroPaginas() == Integer.parseInt(valorBusca))
                    .collect(Collectors.toList());
            break;
        case "formato":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getFormato().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());
            livrosDigiEncontrados = livrosDigitais.stream()
                    .filter(livroDigital -> livroDigital.getFormato().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());
            break;
        case "genero":
            livrosEncontrados = livros.stream()
                    .filter(livro -> livro.getGenero().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());

            livrosDigiEncontrados = livrosDigitais.stream()
                    .filter(livroDigital -> livroDigital.getGenero().toLowerCase().contains(valorBusca.toLowerCase()))
                    .collect(Collectors.toList());
            break;
        default:
            System.out.println("Atributo inválido.");
            return;
    }

    // Imprimir a lista de livros encontrados
    System.out.println("\nLivros Registrados (Atributo: " + atributo + "):\n");
    System.out.printf("%-6s %-40s %-25s %-25s %-20s %-8s %-8s %-10s %-10s%n",
            "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Gênero", "Formato", "Tamanho");

    for (Livro livro : livrosEncontrados) {
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10s%n",
                livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                livro.getAnoPubli(), livro.getNumeroPaginas(), livro.getGenero(), "", "");
    }

    for (LivroDigital livroDigital : livrosDigiEncontrados) {
        System.out.printf("%-6d %-40s %-25s %-25s %-20s %-8d %-8s %-10s %-10.2f%n",
                livroDigital.getId(), livroDigital.getTitulo(), livroDigital.getAutor(), livroDigital.getEditora(),
                livroDigital.getAnoPubli(), livroDigital.getNumeroPaginas(), livroDigital.getGenero(),
                livroDigital.getFormato(), livroDigital.getTamanho());
    }
}
}
