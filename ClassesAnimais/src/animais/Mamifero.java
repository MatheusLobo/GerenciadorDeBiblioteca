package animais;

public class Mamifero extends Animal {
	
	//ATRIBUTOS
	private String alimento;
	
	//METODO CONSTRUTOR
	
	public Mamifero(String n, float com, int np, String c, String am, float vm, String al) {
		super(n , com , np, c, am, vm);
		setNome(n);
		setComprimento(com);
		setNumeroDePatas(np);
		setCor(c);
		setAmbiente(am);
		setVelocidadeMedia(vm);
		setAlimento(al);
	}
	
	public String getAlimento() {
		return this.alimento;
	}
	
	public void setAlimento(String al) {
		this.alimento = al;
	}
	
	//METODO DADOS
	
	public void dadosMamifero() {
		System.out.println("Nome: " + getNome());
		System.out.println("Comprimento: " + getComprimento() + "cm");
		System.out.println("Patas: " + 	getNumeroDePatas());
		System.out.println("Cor: " + getCor());
		System.out.println("Ambiente: " + getAmbiente());
		System.out.println("Velocidade: " + getVelocidadeMedia() + "m/s");
		System.out.println("Alimento: " + getAlimento());
	}
	
}
