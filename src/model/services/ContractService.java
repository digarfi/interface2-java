package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
}
	
	public void contractMonth(Contract contract, int months) {
		double liquidInstallment = contract.getTotalValue() / months;
		
		for (int i= 1; i <= months; i++) {
									
			Date dueDate = addMonths(contract.getContractDate(), i);
			double InterestInstallment =liquidInstallment + onlinePaymentService.interest(liquidInstallment,i);
			double completePayment = InterestInstallment + onlinePaymentService.paymentFee(InterestInstallment);
			contract.getInstallments().add(new Installment(dueDate, completePayment));
		}
}
	
			Date addMonths(Date contractDate, int n) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(contractDate);
			cal.add(Calendar.MONTH, n);
			return cal.getTime();
		}
}


	


	
	
	

