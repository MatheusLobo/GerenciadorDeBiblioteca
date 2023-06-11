package biblioteca;

public class LivroDigital extends Livro {
	
	private String formatoDoArquivo;
	private double tamanhoDoArquivo;
	
		public LivroDigital(String titulo, String autor, String editora, String ano_Publi, int numero_paginas,String genero,
				String formato, String formatoDoArquivo, double tamanhoDoArquivo ) {
			super(titulo, autor, editora, ano_Publi, numero_paginas, genero, formato);
			setFormato(formatoDoArquivo);
			setTamanho(tamanhoDoArquivo);
			
		}

		public String getFormatoDoArquivo() {
			return formatoDoArquivo;
		}

		public void setFormatoDoArquivo(String formatoDoArquivo) {
			this.formatoDoArquivo = formatoDoArquivo;
		}

		public double getTamanho() {
			return tamanhoDoArquivo;
		}

		public void setTamanho(double tamanhoDoArquivo) {
			this.tamanhoDoArquivo = tamanhoDoArquivo;
		}
		
	}
