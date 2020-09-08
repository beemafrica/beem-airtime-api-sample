package com.dp.api.model;

/**
 * AirtimeResponseMessage .
 * 
 * @author admin
 *
 */
//@Getter
//@Setter
public class AirtimeResponseMessage {

	private Integer code;
	
	private long transaction_id;

	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Integer getTransactionId() {
		return transaction_id;
	}

	public void setTransactionId(Integer TransactionId) {
		this.transaction_id = TransactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
