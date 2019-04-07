package aplicacao12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades12.Produto;

public class Principal {

	public static void main(String[] args) {
		

		List <Produto> produtos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Digite o local do arquivo: ");
		String local = sc.nextLine(); 
		
		File original = new File (local);
		
		String caminho = original.getParent();
		
		boolean successo = new File(caminho + "\\out").mkdir();
		
		String destino = original.getParent() + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader (new FileReader (local))){
			
			String linha = br.readLine();
			while (linha != null) {
				String informacoes [] = linha.split(",");
				String nome = informacoes [0];
				double preco = Double.parseDouble(informacoes [1]);
				int quantidade = Integer.parseInt(informacoes[2]);
				
				produtos.add(new Produto (nome, preco,quantidade));
				
				linha = br.readLine();
			}
				try (BufferedWriter bw = new BufferedWriter (new FileWriter (destino))) {
					
					for (Produto p : produtos) {
						bw.write(p.getNome() + "," + String.format("%.2f", p.total()));
						bw.newLine();
					}
					
					System.out.println(destino + "  CRIADO!");
				}
				catch (IOException e) {
				System.out.println("Erro na escrita do arquivo: "+ e.getMessage());
				
				}
		}
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo: "+ e.getMessage());
		}
		
		sc.close();

	}

}
