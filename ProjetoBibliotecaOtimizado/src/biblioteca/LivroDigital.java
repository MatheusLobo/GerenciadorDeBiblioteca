package biblioteca;

public class LivroDigital extends Livro {
	
	private String formatoDoArquivo;
	private double tamanhoDoArquivo;
	
		public LivroDigital(String titulo, String autor, String editora,
				String ano_Publi, int numero_paginas, String genero,
				String formatoDoArquivo, double tamanhoDoArquivo) {
			super(titulo, autor, editora, ano_Publi, numero_paginas, genero);
			setFormatoD(formatoDoArquivo);
			setTamanho(tamanhoDoArquivo);
			
		}

		public String getFormatoD() {
			return formatoDoArquivo;
		}

		public void setFormatoD(String formatoDoArquivo) {
			this.formatoDoArquivo = formatoDoArquivo;
		}

		public double getTamanho() {
			return tamanhoDoArquivo;
		}

		public void setTamanho(double tamanhoDoArquivo) {
			this.tamanhoDoArquivo = tamanhoDoArquivo;
		}
		
	}
