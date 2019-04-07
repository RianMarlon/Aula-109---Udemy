package aplicacao13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades13.Contract;
import modelo.entidades13.Installment;
import modelo.servicos13.ContractService;
import modelo.servicos13.PaypalService;

public class Principal {

	public static void main(String[] args) throws ParseException {
		

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		sc.nextLine();
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		sc.nextLine();
		double totalValue = sc.nextDouble();
		
		Contract  contract =  new Contract (number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		sc.nextLine();
		int months = sc.nextInt();
		
		ContractService contractService = new  ContractService (new PaypalService());
		
		contractService.processContract(contract, months);
		
		System.out.println();
		
		System.out.println("Installments: ");
		for (Installment i : contract.getInstallments()) {
			System.out.println(i);
		}
		
		sc.close();


	}

}
