package biblioteca;

//Importação da classe Scanner

//Definição da classe Livro
public class Livro {
private int id;
private String titulo; // Título do livro
private String autor; // Autor do livro
private String editora; // Editora do livro
private String ano_Publi; // Ano de publicação do livro
private String numero_paginas; // Número de páginas do livro
private String genero;
private String formato;

//Construtor da classe Livro
public Livro(String titulo, String autor, String editora, String ano_Publi, String numero_paginas, String genero, String formato) {
 setTitulo(titulo); // Atribui o título fornecido ao atributo "titulo"
 setAutor(autor); // Atribui o autor fornecido ao atributo "autor"
 setEditora(editora); // Atribui a editora fornecida ao atributo "editora"
 setAnoPubli(ano_Publi); // Atribui o ano de publicação fornecido ao atributo "ano_Publi"
 setNumeroPaginas(numero_paginas); // Atribui o número de páginas fornecido ao atributo "numero_paginas"
 setGenero(genero);
 setFormato(formato);
}

public void setId(int id) {
 this.id = id;
}

//Método getter para obter o ID do livro
public int getId() {
 return id; // Retorna o valor do atributo "id"
}

//Método setter para definir o título do livro
public void setTitulo(String titulo) {
 this.titulo = titulo; // Atribui o valor fornecido ao atributo "titulo"
}

//Método setter para definir o autor do livro
public void setAutor(String autor) {
 this.autor = autor; // Atribui o valor fornecido ao atributo "autor"
}

//Método setter para definir a editora do livro
public void setEditora(String editora) {
 this.editora = editora; // Atribui o valor fornecido ao atributo "editora"
}

//Método setter para definir o ano de publicação do livro
public void setAnoPubli(String ano_Publi) {
 this.ano_Publi = ano_Publi; // Atribui o valor fornecido ao atributo "ano_Publi"
}

//Método setter para definir o número de páginas do livro
public void setNumeroPaginas(String numero_paginas) {
 this.numero_paginas = numero_paginas; // Atribui o valor fornecido ao atributo "numero_paginas"
}
public void setFormato(String formato) {
	this.formato = formato;
}

//Método getter para obter o título do livro
public String getTitulo() {
 return titulo; // Retorna o valor do atributo "titulo"
}

//Método getter para obter o autor do livro
public String getAutor() {
 return autor; // Retorna o valor do atributo "autor"
}

//Método getter para obter a editora do livro
public String getEditora() {
 return editora; // Retorna o valor do atributo "editora"
}

//Método getter para obter o ano de publicação do livro
public String getAnoPubli() {
 return ano_Publi; // Retorna o valor do atributo "ano_Publi"
}

//Método getter para obter o número de páginas do livro
public String getNumeroPaginas() {
 return numero_paginas; // Retorna o valor do atributo "numero_paginas"
}

public String getGenero() {
return genero;
}

public void setGenero(String genero) {
this.genero = genero;
}

public String getFormato() {
	return formato;
}
}