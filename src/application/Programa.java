package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

		List<Candidato> list = new ArrayList<>();
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

		System.out.print("Entre com o número de vagas: ");
		int vaga = sc.nextInt();
		sc.nextLine();
		int n = vaga * 3;

		try {
			for (int i = 1; i <= n; i++) {
				System.out.println();

				System.out.println("Candidato #" + i + ": ");

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
				empresa = new Empresa(nomeEmpresa, numeroDaVaga);
				
				candidato = new Candidato(nome, sobrenome, cpf, nascimento);
				empresa.verificarVaga(numeroDaVaga);
				System.out.println();

				System.out.print("Candidato: " + candidato);
				System.out.println();

				if (list.contains(candidato)) {
					System.out.println();
					System.out.println("ERRO: CPF já cadastrado no sistema!");
				} 
				list.add(candidato);
				System.out.println();
				System.out.println("SUCESSO: Candidato cadastrado");
				System.out.println("--------------------------------------------------------------------------------------------");
				}
		}
		catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch (ParseException e) {
			System.out.println("ERRO: Data inválida. O formato esperado é dd/MM/aaaa");
		}

		for(Candidato candidato1 : list) {
			HashMap<Integer, String>candidatosParaVagas = new HashMap<>();
			String cand =("Nome: ") + candidato1.toString();
			candidatosParaVagas.put(vaga, cand);
		
			System.out.println("Vaga: " + candidatosParaVagas);
		}
		sc.close();
	}
}
