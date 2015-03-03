package br.teste;

import java.math.BigDecimal;
import java.util.Date;

public class Teste1b {

	public static void main(String[] args) {
		/*int i = 0;
		while (i < 10) {
			System.out.println("Alo Mundo!");
			i++;
		}*/
		
		
		// Criação dos objetos
		Aluno a1 = new Aluno(111111L, "Joao", "987698798765", new Date());
		Aluno a2 = new Aluno(222222L, "Maria", "987698798764");
		Aluno a3 = new Aluno(333333L, "Tiago");		
		Professor p1 = new Professor("Joao", "123456", new BigDecimal(123456));
		Professor p2 = new Professor("Joao", "123456");

		
		//Exibir na tela (imprimir)
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(p1);
		System.out.println(p2);
		
	}
}