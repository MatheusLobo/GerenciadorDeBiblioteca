package animais;

public class Animal {
	//ATRIBUTOS
	private String nome;
	private float comprimento;
	private int numeroDePatas;
	private String ambiente;
	private String cor;
	private float velocidadeMedia;
	
	//CONTRUTOR ANIMAL
	public Animal(String n, float com, int np, String c, String am, float vm) {
		setNome(n);
		setComprimento(com);
		setNumeroDePatas(np);
		setCor(c);
		setAmbiente(am);
		setVelocidadeMedia(vm);
	}
	//METODOS GETTERS E SETTERS
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String n) {
		this.nome = n;
	}

	public float getComprimento() {
		return this.comprimento;
	}

	public void setComprimento(float comp) {
		this.comprimento = comp;
	}

	public int getNumeroDePatas() {
		return this.numeroDePatas;
	}

	public void setNumeroDePatas(int n) {
		this.numeroDePatas = n;
	}

	public String getCor() {
		return this. cor;
	}
	
	public void setCor(String c) {
		this.cor = c;
	}
	
	public String getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(String am ){
		this.ambiente = am;
	}
	

	public float getVelocidadeMedia() {
		return this.velocidadeMedia;
	}

	public void setVelocidadeMedia(float vm) {
		this.velocidadeMedia = vm;
	}
	
	public void dadosAnimal() {
		System.out.println("Nome: " + getNome());
		System.out.println("Comprimento: " + getComprimento() + "cm");
		System.out.println("Patas: " + 	getNumeroDePatas());
		System.out.println("Cor: " + getCor());
		System.out.println("Ambiente: " + getAmbiente());
		System.out.println("Velocidade" + getVelocidadeMedia() + "m/s");
	}
}
