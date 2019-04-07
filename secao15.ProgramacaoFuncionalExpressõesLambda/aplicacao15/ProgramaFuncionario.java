package aplicacao15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entidades15.Funcionario;

public class ProgramaFuncionario {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Digite o caminho do arquivo: ");
		String arquivo = sc.next();
		System.out.print("Entre com um salário: ");
		Double salario = sc.nextDouble();
		
		try (BufferedReader br = new BufferedReader (new FileReader(arquivo))) {
			List <Funcionario> lista = new ArrayList<>();
			
			String linha = br.readLine();
			while (linha != null ) {
				String infor [] = linha.split(",");
				lista.add(new Funcionario (infor [0], infor[1], Double.parseDouble(infor[2])));
				linha = br.readLine();	
			}
			
			List <String> emails = lista.stream()
					.filter (f -> f.getSalario() > salario)
					.map(f -> f.getEmail())
					.sorted()
					.collect(Collectors.toList());
			
			Double soma = lista.stream()
					.filter(f -> f.getNome().charAt(0) == 'M')
					.map(f -> f.getSalario())
					.reduce(0.0, (f1,f2) -> f1 + f2);
			
			System.out.println("Email dos funcionários com o salário maior que " + String.format("%.2f", salario) + ":");
			emails.forEach(System.out::println);
			
			System.out.printf("Soma dos salário dos funcionários que começam com a letra 'M': %.2f", soma);
			
		}
		catch(IOException e) {
			System.out.println("Erro na leitura do arquivo: " + e.getMessage());
		}
		
		
		sc.close ();

	}

}
