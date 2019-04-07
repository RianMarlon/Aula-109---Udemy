package aplicacao9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades9.Company;
import entidades9.Individual;
import entidades9.TaxPayer;

public class Principal2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> lista = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char r = sc.next().charAt(0);

			if (r == 'i') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double anualincome = sc.nextDouble();
				System.out.print("Health expenditures: ");
				sc.nextLine();
				double healthExpenditures = sc.nextDouble();

				lista.add(new Individual(name, anualincome, healthExpenditures));
			} else if (r == 'c') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double anualincome = sc.nextDouble();
				System.out.print("Number of employees: ");
				sc.nextLine();
				int numberOfEmployees = sc.nextInt();

				lista.add(new Company(name, anualincome, numberOfEmployees));
			} else {
				System.out.print("Error!");
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");

		double sum = 0.0;

		for (TaxPayer tp : lista) {
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
			sum += tp.tax();
		}

		System.out.println();

		System.out.printf("TOTAL TAXES: $ %.2f%n", sum);

		sc.close();

	}

}