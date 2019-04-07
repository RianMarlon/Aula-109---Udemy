/*Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.*/

package aplicacao14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal2 {

	public static void main(String[] args) {
		
		Map <String, Integer> votos = new LinkedHashMap <>();
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o caminho do seu arquivo:");
		
		String original = sc.next();
			
		try (BufferedReader br = new BufferedReader(new FileReader(original))) {
			
			String linha = br.readLine();
			
			while  (linha != null) {
				String informacoes [] = linha.split(",");
				
				String nome  =  informacoes[0];
				int quantidade =  Integer.parseInt(informacoes[1]);

				if (votos.containsKey(nome)) {
					int count = votos.get(nome);
					votos.put(nome, quantidade + count);
					
				} else {
					votos.put(nome, quantidade);
				}
				linha = br.readLine();
			}
			
			for (String chave: votos.keySet()) {
				System.out.println(chave + ": "+ votos.get(chave));
			}
		
		}
		catch (IOException e) {
			System.out.println("Erro na leitura: "+ e.getMessage());
		}
		
		sc.close();

	}

}