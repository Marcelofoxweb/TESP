package br.teste;

import java.math.BigDecimal;
import java.util.Date;

import br.teste.entidade.Aluno;
import br.teste.entidade.Professor;

public class Teste1b {

	public static void main(String[] args) {
		/*int i = 0;
		while (i < 10) {
			System.out.println("Alo Mundo!");
			i++;
		}*/
		
		
		// Criação dos objetos
		Aluno a1 = new Aluno(new Long(1), new Long(111111), "Joao", "987698798765", new Date());
		Aluno a2 = new Aluno(new Long(2), new Long(222222), "Maria", "987698798764");
		Aluno a3 = new Aluno(new Long(3), new Long(333333), "Tiago");		
		Professor p1 = new Professor(new Long(1), "Joao", "123456", new BigDecimal(123456));
		Professor p2 = new Professor(new Long(2), "Joao", "123456");
		
		
		
		
		//Exibir na tela (imprimir)
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(p1);
		System.out.println(p2);
		
		// Variável de classe. Chamando a variável de classe para imprimir
		System.out.println("BONUS ======="+Professor.BONUS);
		
		// Metodo de classe. Chamando o metodo de classe para imprimir
		System.out.println(Aluno.verificaMatricula("12345678"));
	}
}