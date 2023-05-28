package animais;

public class testarAnimal {

	public static void main(String[] args) {
		Mamifero m1 = new Mamifero("Camelo", 150.0f, 4, "Amarelo", "Terra", 2.0f, "Gramas secas");
		Peixe p1 = new Peixe("Tubarão", 300.0f, 0,  "Cinzento", "Mar", 1.5f, "Barbatanas e cauda");
		Mamifero m2 = new Mamifero("Urso-do-canadá", 180.0f, 4, "Vermelho", "Terra", 0.5f, "Mel");

		m1.dadosAnimal();
		System.out.println("_____________________");
		p1.dadosPeixe();
		System.out.println("_____________________");
		m2.dadosMamifero();
		
	}

}
