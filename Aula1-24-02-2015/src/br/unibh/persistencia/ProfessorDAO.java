package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
				return new Professor(
						r.getLong("id"), 
						r.getString("nome"), 
						r.getString("cpf"), 
						r.getBigDecimal("salario")
				);
				
			}
			JDBCUtil.closedConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Professor find(String cpf) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().
			prepareStatement("select * from tb_professor where cpf = ?");
			p.setString(1, cpf);
			ResultSet r = p.executeQuery();
			if (r.next()){
				return new Professor(
							r.getLong("id"), 
							r.getString("nome"),
							r.getString("cpf"),
							r.getBigDecimal("salario")
				);
			}
			JDBCUtil.closedConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void insert(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnection().
			prepareStatement("insert into tb_professor (nome, cpf, salario) values (?, ?, ?)");
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
	@Override
	public void update(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnection().
			prepareStatement("update tb_professor set nome = ?, salario = ?");
			p.setString(1, t.getNome());
			p.setBigDecimal(2, t.getSalario());
			p.executeUpdate();
			JDBCUtil.closedConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public void delete(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p =  JDBCUtil.getConnection().
			prepareStatement("delete from tb_professor where ID = ?");
			p.setLong(1, t.getId());
			p.executeUpdate();
			JDBCUtil.closedConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	@Override
	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		PreparedStatement p;
		try {
			p = JDBCUtil.getConnection().prepareStatement("select * from tb_professor");
			ResultSet r = p.executeQuery();
			while(r.next()){
				lista.add (new Professor(
						r.getLong("id"), 
						r.getString("nome"),
						r.getString("cpf"),
						r.getBigDecimal("salario")));
			}
			JDBCUtil.closedConnection();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public void clean() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p =  JDBCUtil.getConnection().prepareStatement("delete from tb_professor");
			p.executeUpdate();
			JDBCUtil.closedConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
