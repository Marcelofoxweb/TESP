package br.unibh;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.entidade.Aluno;
import br.unibh.persistencia.AlunoDAO;

public class testes {
	
	@Test
	public void testeBuscarAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), " ");
		}

	@Test
	public void testeInserirAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, 444444L, "Tomaz Gonzaga", "44444444444", new Date());
		dao.insert(a);
		Aluno a2 = dao.find(44444444444L);
		Assert.assertEquals(a2.getNome(), "Tomaz Gonzaga");
		}



}
