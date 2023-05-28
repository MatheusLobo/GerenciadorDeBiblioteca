package gerenciador;

public class Tarefa{
	private String titulo;
	private String descricao;
	private String status;
	
	public Tarefa(String titulo, String descricao, String status) {
		setTitulo(titulo);
		setDescricao(descricao);
		setStatus(status);
	}
	
	public void procurarTarefa(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
