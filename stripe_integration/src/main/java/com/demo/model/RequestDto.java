package com.demo.model;

public class RequestDto {
	private long amount;
	private String currency;

	public RequestDto(long amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
