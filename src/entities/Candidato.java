package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import exceptions.DomainExceptions;
import exceptions.MessageUtil;

public class Candidato implements Comparable<Candidato> {

	private String nome;
	private String sobrenome;
	private String cpf;
	private Date nascimento;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Candidato() {
	}

	public Candidato(String nome, String sobrenome, String cpf, Date nascimento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public void verificarNome(String nome) {
		if (nome.equals("") || nome == null) {
			throw new DomainExceptions("O nome é obrigatório. O Cliente não foi adicionado à lista.");
		}
	}

	public void verificarSobrenome(String sobrenome) {
		if (sobrenome.equals("") || sobrenome == null) {
			throw new DomainExceptions("O sobrenome é obrigatório. O Cliente não foi adicionado à lista.");
		}
	}

	public void verificarCpf(String cpf) {
		if (cpf.equals("") || cpf == null) {
			throw new DomainExceptions("O CPF é obrigatório. O Cliente não foi adicionado à lista.");
		}
	}

	public void verificarNascimento(String dataDigitada) {
		if (dataDigitada.equals("") || dataDigitada == null) {
			throw new DomainExceptions("A data de nascimento é obrigatória. O Cliente não foi adicionado à lista.");
		}
	}
	

	public void verificarDados(String nome, String sobrenome, String cpf, String dataDigitada) {
		verificarNome(nome);
		verificarSobrenome(sobrenome);
		verificarCpf(cpf);
		verificarNascimento(dataDigitada);
	}
	
	public int pegarIdade(Date data) {
		Calendar dataDigitada = Calendar.getInstance();
		Calendar hoje = Calendar.getInstance();
		dataDigitada.setTime(data);
		dataDigitada.set(Calendar.YEAR, hoje.get(Calendar.YEAR));
		int idade = dataDigitada.after(hoje) ? -1 : 0;
		dataDigitada.setTime(data);
		idade += hoje.get(Calendar.YEAR) - dataDigitada.get(Calendar.YEAR);
		return idade;
	}
	
	public String verificarMaioridade(Date nascimento) {
		var idade = pegarIdade(nascimento);
		if(idade >= 18) {
			return MessageUtil.MAIOR;
		}
		return MessageUtil.MENOR;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(cpf, other.cpf);
	}

	
	@Override 
	public String toString() { 
		return nome + " " + sobrenome + " CPF: " +
	cpf + " Data de nascimento: " + sdf.format(nascimento) + ". " +
	pegarIdade(nascimento) + " Anos. " + verificarMaioridade(nascimento); 
	}
	  
	@Override
	public int compareTo(Candidato other) {
		return cpf.compareTo(other.getCpf());
	}

}
