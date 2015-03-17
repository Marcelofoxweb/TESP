package br.unibh;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.entidade.Aluno;
import br.unibh.entidade.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

public class Testes {

	// Aluno - Testes
	@Test
	public void testeBuscarAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "06476632604");
	}

	
	@Test
	public void testeInserirAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = new Aluno(null, 444444L, "Tomaz Gonzaga", "44444444444", new Date());
		Aluno a2 = new Aluno(null, 444444L, "Luiz Gonzaga", "55555555555", new Date());
		dao.insert(a1);
		dao.insert(a2);
	}

	
	@Test
	public void testeUpdateAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = new Aluno(null, 999999L, "ok Tomaz Gonzaga", "78978978900", new Date());
		Aluno a2 = new Aluno(null, 888888L, "ok Luiz Gonzaga", "12312312344", new Date());
		dao.insert(a1);
		dao.insert(a2);
	}

	
	
	
	// Professor - Testes
	
	@Test
	public void testeProfessorFind(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "123");
	}
	
	
	@Test
	public void testeProfessorInsert(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a1 = new Professor(null, "Leocardio", "7445", new BigDecimal(2000.00));
		Professor a2 = new Professor(null, "Jacare", "7446", new BigDecimal(2000.00));
		dao.insert(a1);
		dao.insert(a2);
	}
	
	
	@Test
	public void testeProfessorUpdate(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a1 = new Professor(null, "ok Leocardio", "8888", new BigDecimal(2222.00));
		Professor a2 = new Professor(null, "ok Jacare", "9999", new BigDecimal(2222.00));
		dao.insert(a1);
		dao.insert(a2);
	}

	
	
	
}
