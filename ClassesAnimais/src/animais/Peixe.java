package animais;

public class Peixe extends Mamifero {
	//METODOS
	private String caracteristica;
	
	//CONTRUTOR
	public Peixe(String n, float com, int np, String c, String am, float vm, String ca) {
		super(n, com, np, c, am, vm, ca);
		setNome(n);
		setComprimento(com);
		setNumeroDePatas(np);
		setCor(c);
		setAmbiente(am);
		setVelocidadeMedia(vm);
		setCaracteristica(ca);
	}
	
	//METODOS GETTERS E SETTERS
	
	public String getCaracteristicas() {
		return this.caracteristica;
	}
	
	public void setCaracteristica(String ca) {
		this.caracteristica = ca;
	}
	
	//METODO DADOS
	
	public void dadosPeixe() {
		System.out.println("Nome: " + getNome());
		System.out.println("Comprimento: " + getComprimento() + "cm");
		System.out.println("Patas: " + 	getNumeroDePatas());
		System.out.println("Cor: " + getCor());
		System.out.println("Ambiente: " + getAmbiente());
		System.out.println("Velocidade" + getVelocidadeMedia() + "m/s");
		System.out.println("Caracteristica: " + getCaracteristicas());
	}
	
}
