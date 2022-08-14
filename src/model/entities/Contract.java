package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number;
	private Date contractDate;
	private Double totalValue;
	
	public Contract () {
	}

	private List<Installment>installments= new ArrayList<Installment>();
	
	
	public Contract(Integer number, Date contractDate, Double totalValue) {
		super();
		this.number = number;
		this.contractDate = contractDate;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<Installment> getInstallments() {
		return installments;
	}
}
