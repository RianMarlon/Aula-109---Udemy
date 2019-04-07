package aplicacao9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades9.ImportedProduct;
import entidades9.Product;
import entidades9.UsedProduct;

public class Principal {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> lista = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data");
			System.out.print("Common, used or imported (c/u/i)? ");
			char r = sc.next().charAt(0);
			sc.nextLine();

			if (r == 'c') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				sc.nextLine();

				lista.add(new Product(name, price));
			} else if (r == 'u') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				sc.nextLine();

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date manufactureDate = sdf.parse(sc.next());

				lista.add(new UsedProduct(name, price, manufactureDate));
			} else if (r == 'i') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				sc.nextLine();

				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				sc.nextLine();

				lista.add(new ImportedProduct(name, price, customsFee));
			} else {
				System.out.println("Error!");
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");

		for (Product c : lista) {
			System.out.println(c.priceTag());
		}

		sc.close();
	}
}