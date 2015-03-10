package br.teste.entidade;

import java.util.Date;

public class Aluno extends Pessoa {
	private Long matricula;
	private Date dataAnivarsario;

	
	
	public Aluno(Long id, Long matricula, String nome, String cpf, Date dataAnivarsario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAnivarsario = dataAnivarsario;
	}

	
	//Esse método é "Sobrecarga" 	
	public Aluno(Long id, Long matricula, String nome, String cpf) {
		super(id, nome, cpf);
		this.matricula = matricula;
	}

	// Método de classe
	public static boolean verificaMatricula(String matricula) {
		if (matricula == null) {
			return false;
		} else if (matricula.trim().equals("")){
			return false;
		} else if (matricula.length() != 8){
			return false;
		}
		return true;
	}
	
	//Esse método é "Sobrecarga"
	public Aluno(Long id, Long matricula, String nome) {
		super(id, nome, null);
		this.matricula = matricula;
	}


	public Long getMatricula() {
		return matricula;
	}


	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}


	public Date getDataAnivarsario() {
		return dataAnivarsario;
	}


	public void setDataAnivarsario(Date dataAnivarsario) {
		this.dataAnivarsario = dataAnivarsario;
	}


	@Override
	public String toString() {
		return super.toString() 
				+ "Aluno [matricula=" + matricula + ", dataAnivarsario="
				+ dataAnivarsario + "]";
	}
	
	



	
	
	
}