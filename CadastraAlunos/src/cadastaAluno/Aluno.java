package cadastaAluno;

public class Aluno {
	private String nome;
	private int idade;
	private long cpf;
	private String dataDeNascimento;
	private int matricula;	
	private String serie;
	
	public Aluno() {
		
	}
	public Aluno(String nome, int idade, long cpf , String dataDeNascimento, String serie, int matricula) {
		setNome(nome);
		setIdade(idade);
		setCpf(cpf);
		setDataDeNascimento(dataDeNascimento);
		setSerie(serie);
		setMatricula(matricula);
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
}
	
	
