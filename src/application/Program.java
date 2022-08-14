package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter Contract Data ");
		System.out.print("Contract Number: ");
		int number = sc.nextInt();
		
		System.out.print("Contract Date (dd/mm/yyyy): ");
		Date contractDate = sdf.parse(sc.next());
		
		System.out.print("Contract Value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract (number, contractDate, totalValue);
		
		System.out.print("Enter the number of installments:  ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService (new PaypalService());
		
		contractService.contractMonth(contract,n);
		
		
		System.out.println("Installments: ");
		for (Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
	sc.close();
	}
}
