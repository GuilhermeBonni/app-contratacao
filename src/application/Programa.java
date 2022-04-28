package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Candidato;
import entities.Empresa;
import exceptions.DomainExceptions;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		executarContratacao();
	}

	public static void executarContratacao() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Candidato> listaDeCandidato = new ArrayList<>();
		Candidato candidato = new Candidato();
		Empresa empresa = new Empresa();
		String nome = null;
		String sobrenome = null;
		String cpf = null;
		Date nascimento = null;

		System.out.println("Bem vindo a tela de contratação, insira seus dados para seguir no processo: ");
		System.out.println();
		
		System.out.print("Entre com o nome da empresa: ");
		String nomeEmpresa = sc.next();
		empresa.setNomeEmpresa(nomeEmpresa);
		
		sc.nextLine();

		try {
			for (int idDoCandidato = 1; idDoCandidato <= 15; idDoCandidato++) {
				System.out.println();

				System.out.println("Candidato #" + idDoCandidato + ": ");

				System.out.print("Nome: ");
				nome = sc.nextLine();

				System.out.print("Sobrenome: ");
				sobrenome = sc.nextLine();

				System.out.print("CPF: ");
				cpf = sc.nextLine();

				System.out.print("Data de Nascimento (dd/MM/aaaa): ");
				String dataDigitada = sc.nextLine();
				candidato.verificarDados(nome, sobrenome, cpf, dataDigitada);
				nascimento = sdf.parse(dataDigitada);
				
				System.out.print("Nº da vaga: ");
				String numeroDaVaga = sc.nextLine();
				System.out.println();
				
				candidato = new Candidato(nome, sobrenome, cpf, nascimento);
				empresa.verificarVaga(numeroDaVaga);
				

				System.out.print("Candidato: " + candidato);
				System.out.println();

				if (listaDeCandidato.contains(candidato)) {
					System.out.println();
					throw new DomainExceptions("ERRO: CPF já cadastrado no sistema!");
				} 
				listaDeCandidato.add(candidato);
				candidato.toString();
				empresa.getCandidatosParaVagas().get(Integer.parseInt(numeroDaVaga)).add(candidato);
				
				System.out.println();
				System.out.println("SUCESSO: Candidato cadastrado.");
				System.out.println("--------------------------------------------------------------------------------------------");
				}
		}
		catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch (ParseException e) {
			System.out.println("ERRO: Data inválida. O formato esperado é dd/MM/aaaa");
		}
		
		var listaDaVaga1 = empresa.getCandidatosParaVagas().get(1);
		System.out.println();
		System.out.println("Vaga \t" + "Nome \t" + "\t" + "\t" + "CPF \t" + "\t" +"Nascimento \t" + "Idade");
		for(int i = 0; i < listaDaVaga1.size(); i++) {
			var candidatoDaLinha = listaDaVaga1.get(i);
			if(candidatoDaLinha.getNome().length() > 8) {
				System.out.println("1 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
			else {
				System.out.println("1 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + "\t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
		}
		
		var listaDaVaga2 = empresa.getCandidatosParaVagas().get(2);
		for(int i = 0; i < listaDaVaga2.size(); i++) {
			var candidatoDaLinha = listaDaVaga2.get(i);
			if(candidatoDaLinha.getNome().length() > 8) {
			System.out.println("2 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
			else {
				System.out.println("1 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + "\t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
		}
		
		var listaDaVaga3 = empresa.getCandidatosParaVagas().get(3);
		for(int i = 0; i < listaDaVaga3.size(); i++) {
			var candidatoDaLinha = listaDaVaga3.get(i);
			if(candidatoDaLinha.getNome().length() > 8) {
			System.out.println("3 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
			else {
				System.out.println("1 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + "\t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
		}
		
		var listaDaVaga4 = empresa.getCandidatosParaVagas().get(4);
		for(int i = 0; i < listaDaVaga4.size(); i++) {
			var candidatoDaLinha = listaDaVaga4.get(i);
			if(candidatoDaLinha.getNome().length() > 8) {
			System.out.println("4 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
			else {
				System.out.println("1 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + "\t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
		}
		
		var listaDaVaga5 = empresa.getCandidatosParaVagas().get(5);
		for(int i = 0; i < listaDaVaga5.size(); i++) {
			var candidatoDaLinha = listaDaVaga5.get(i);
			if(candidatoDaLinha.getNome().length() > 8) {
			System.out.println("5 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
			else {
				System.out.println("1 \t" + candidatoDaLinha.getNome() + " " + candidatoDaLinha.getSobrenome() + " \t" + "\t" + candidatoDaLinha.getCpf() + " \t" + sdf.format(candidatoDaLinha.getNascimento()) + " \t" + candidatoDaLinha.pegarIdade(candidatoDaLinha.getNascimento()));
			}
		}

		System.out.println();
		System.out.println("Tabela contendo os Candidatos da empresa " + empresa.getNomeEmpresa() );
		System.out.println();
		
		System.out.println();
		System.out.println("Terminado o processo de cadastro de candidatos!");
		System.out.println();
		System.out.println("Deseja salvar a tabela com os dados dos candidatos? (S/N)");
		String salvar = sc.nextLine();
		if(salvar.equals("S")) {
			System.out.println("Tabela de candidatos salva!");
		}
		if(salvar.equals("N")) {
			System.out.println("Tabela de candidatos não foi salva!");
			executarContratacao();
		}
	}
}
