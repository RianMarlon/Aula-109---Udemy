/*Em um portal de cursos online, cada usu�rio possui um c�digo �nico, representado por
um n�mero inteiro.
Cada instrutor do portal pode ter v�rios cursos, sendo que um mesmo aluno pode se
matricular em quantos cursos quiser. Assim, o n�mero total de alunos de um instrutor n�o
� simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
alunos repetidos em mais de um curso.
O instrutor Alex possui tr�s cursos A, B e C, e deseja saber seu n�mero total de alunos.
Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
quantidade total e alunos dele, conforme exemplo.*/

package aplicacao14;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entidades14.Classe;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		Set <Classe> set = new HashSet <>();
		
		System.out.print("How many students for course A? ");
		int a = sc.nextInt();
		for (int i = 0; i < a; i++) {
			int n1 = sc.nextInt();
			
			set.add(new Classe (n1));
		}
		
		System.out.print("How many students for course B? ");
		int b = sc.nextInt();
		
		for (int i = 0; i < b; i++) {
			int n1 = sc.nextInt();
			
			set.add(new Classe (n1));
		}
		
		System.out.print("How many students for course C? ");
		int c = sc.nextInt();
		
		for (int i = 0; i < c; i++) {
			int n1 = sc.nextInt();
			
			set.add(new Classe (n1));
		}
		
		System.out.print("Total students: "+ set.size());
		
		sc.close();

	}

}
