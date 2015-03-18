package br.unibh;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unibh.entidade.Aluno;
import br.unibh.entidade.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

public class Testes {

	// Aluno - Testes
	
	
	
	@Before
	public void preparaBanco(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = new Aluno(null, new Long(1234), "Marcelo Luiz da Silva", "12312312399", new Date());
		Aluno a2 = new Aluno(null, new Long(34544), "Maria", "12312312388", new Date());
		Aluno a3 = new Aluno(null, new Long(23423), "Tiago", "12312312377", new Date());
		dao.insert(a1);
		dao.insert(a2);
		dao.insert(a3);
	}
	
	@After
	public void limpaBanco(){
		AlunoDAO dao = new AlunoDAO();
		dao.clean();
	}
	
	
	
	
	@Test
	public void testeBuscarAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find("12312312399");
		Assert.assertEquals(a.getNome(), "Marcelo Luiz da Silva");
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
	public void testeAtualizaAluno(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = dao.find(1L);
		a1.setNome("Marcelo Silva");
		dao.update(a1);
		Aluno a2 = dao.find(1L);
		Assert.assertEquals(a2.getNome(), "Marcelo Silva");
	}

	
	
	@Test
	public void testeExcluirAluno(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = dao.find(1L);
		dao.delete(a1);
		List<Aluno> lista = dao.findAll();
		
		Assert.assertEquals(lista.size(), 2);
	}

	
	@Test
	public void testeSelecionarTodosAluno(){
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 3);
	}
	
	
	
	
	
	
	
	
	// Professor - Testes
	
	@Test
	public void testeProfessorFind(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a1 = dao.find(1L);
		Assert.assertEquals(a1.getCpf(), "7445");
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
	public void professorUpdate(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(1L);
		a.setNome("Teste");
		a.setCpf("7445");
		a.setSalario(new BigDecimal(2000));
		dao.update(a);
	}	
	
	@Test
	public void professorDelete(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(1L);
		dao.delete(a);
		List<Professor> listas =  dao.findAll();
		Assert.assertEquals(listas.size(), 2);
	}

	@Test
	public void professorTodos(){
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> listas = dao.findAll();
		Assert.assertEquals(listas.size(), 3);
	}
	
	
	
}
