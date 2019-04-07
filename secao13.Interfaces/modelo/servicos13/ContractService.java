package modelo.servicos13;

import java.util.Calendar;
import java.util.Date;

import modelo.entidades13.Contract;
import modelo.entidades13.Installment;

public class ContractService {
	
	private OnlinePaymentService payment;

	public ContractService () {
	}
	
	public ContractService(OnlinePaymentService payment) {
		this.payment = payment;
	}

	public OnlinePaymentService getPayment() {
		return payment;
	}

	public void setPayment(OnlinePaymentService payment) {
		this.payment = payment;
	}
	
	public void processContract (Contract contract, int months ) {
		double basicPayment = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updatePayment =  basicPayment + payment.interest(basicPayment, i);
			double finalPayment =  updatePayment + payment.paymentFee(updatePayment);
			
			contract.addInstallment(new Installment (date,finalPayment));
			
		}
		
	}
	
	private Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}

}
