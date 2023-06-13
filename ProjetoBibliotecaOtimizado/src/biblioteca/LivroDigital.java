package biblioteca;


public class LivroDigital extends Livro {
	
	private String formato;
	private String tamanho;
	
		public LivroDigital(String titulo, String autor, String editora, String ano_Publi, String numero_paginas,String genero, String formato, String tamanho ) {
			super(titulo, autor, editora, ano_Publi, numero_paginas, genero);
			setFormato(formato);
			setTamanho(tamanho);
			
		}

		public String getFormato() {
			return formato;
		}

		public void setFormato(String formato) {
			this.formato = formato;
		}

		public String getTamanho() {
			return tamanho;
		}

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}
		
	}