package biblioteca;



public class LivroDigital extends Livro {
	
	private String tipoDoArquivo;
	private double tamanho;
	
		public LivroDigital(String titulo, String autor, String editora, String ano_Publi, String numero_paginas,String genero, String formato, String tipoDoArquivo, double tamanho ) {
			super(titulo, autor, editora, ano_Publi, numero_paginas, genero, formato);
			setTipoDoArquivo(tipoDoArquivo);
			setTamanho(tamanho);
			
		}

		public String getTipoDoArquivo() {
			return tipoDoArquivo;
		}

		public void setTipoDoArquivo(String tipoDoArquivo) {
			this.tipoDoArquivo = tipoDoArquivo;
		}

		public double getTamanho() {
			return tamanho;
		}

		public void setTamanho(double tamanho) {
			this.tamanho = tamanho;
		}
		
	}