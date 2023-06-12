package biblioteca;

public class LivroDigital extends Livro {
	
	String formato;
	String tamanhoDoArquivo;
	
		public LivroDigital(String titulo, String autor, String editora,String ano_Publi, String numero_paginas, String genero, String formato, String tamanhoDoArquivo) {
			super(titulo, autor, editora, ano_Publi, numero_paginas, genero);
			setFormatoD(formato);
			setTamanho(tamanhoDoArquivo);
			
		}

		public String getFormatoD() {
			return formato;
		}

		public void setFormatoD(String formato) {
			this.formato = formato;
		}

		public String getTamanho() {
			return tamanhoDoArquivo;
		}

		public void setTamanho(String tamanhoDoArquivo) {
			this.tamanhoDoArquivo = tamanhoDoArquivo;
		}
		
	}
