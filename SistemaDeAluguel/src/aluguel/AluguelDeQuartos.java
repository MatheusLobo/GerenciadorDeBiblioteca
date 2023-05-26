package aluguel;

import java.util.Arrays;
import java.util.Scanner;

public class AluguelDeQuartos {

	public static void main(String[] args) {
 String[] quartos = new String[10];
		 
		 Arrays.fill(quartos, "Desocupado"); /*Nesta linha faço preenchimento pra q todo indice do array esteja armazado
		 a palvara desocupado.*/
		 
	        int n;
	        int nAluguel = 0;
	        int nQuarto = 0;
	        String nomeEstudante = "";

	        try (Scanner teclado = new Scanner(System.in)) {
	        	
				System.out.println("Numero de estudantes que vão alugar: ");//Pergunta o numero de estudantes
				n = teclado.nextInt();
				
				if(n > 10 || n < 0) {    //Neste if Faço o tratamento para numero nao exceder o numero estabelecido de vagas
				    System.out.println("Numero execede numero de vagas");
				    return;
				}

				for(int i = 0; i< n; i++) {/*Neste for eu faço o prenchimento das variaveis inicializadas acima guardando 
					os dados necessarios para impressao e atraves dele ja exibir no console*/
				    System.out.println("Qual numero do quarto: ");
				    nQuarto = teclado.nextInt();    
				    
				    if(nQuarto >= quartos.length || nQuarto < 0) { //Neste if Faço novamente um tratamento pra numero digita nao exceder numero de quartos total
				        System.out.println("Numero excede numero de quartos");
				        return;
				    }
				    if (quartos[nQuarto].equals("Desocupado")){ // nesse verifica se o numero do quarto esta ocupado 
				            nAluguel += 1;
				            System.out.println("Nome do estudante: ");
				            nomeEstudante = teclado.nextLine();
				            nomeEstudante = teclado.nextLine();
				            System.out.println("------------------------------");
				            quartos[nQuarto] = nomeEstudante;
				            System.out.println("Aluguel#" + nAluguel);
				            System.out.println("Quarto: " + nQuarto);
				            System.out.println("Nome: " + nomeEstudante);         
				    } else { // se estiver ocupado ele mostra a mensagem
				        System.out.println("Quarto ocupado");
				    
				    }
				}
				teclado.close();
			}

	        //essa parte abaixo vai exibir o numero dos quartos ocupados e os aluno que estão ocupando estes quartos
	        
	        System.out.println("-----------------------");

	        System.out.println("Quartos Ocupados");
	        
	        for(int i = 0; i<quartos.length; i++) {
	            if(!quartos[i].equals("Desocupado")) {
	                System.out.println(i + ": " + quartos[i]);
	            }
	     }
	        
   }	
}	
