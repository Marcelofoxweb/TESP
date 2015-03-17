package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.unibh.entidade.Professor;


public class ProfessorDAO implements DAO<Professor, Long> {


	public Professor find(Long id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p =  JDBCUtil.getConnection().prepareStatement("select * from tb_professor where id=?");
			p.setLong(1, id);
			ResultSet r = p.executeQuery();
			if(r.next()){
				return new Professor(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getBigDecimal("salario"));
				//return new Professor
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("insert into tb_professor (nome, cpf, salario) values (?, ?, ?)");
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.executeUpdate();
			JDBCUtil.closedConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Professor t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Professor t) {
		// TODO Auto-generated method stub
		
	}

	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
