package com.dp.api.model;

import java.util.List;

/**
 * AirtimeMessage .
 * 
 * @author admin
 *
 */
//@Getter
//@Setter
public class AirtimeMessage {


	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * source_addr .
     * 
     */
    private String source_addr;
    
    /**
     * amount .
     * 
     */
    private Integer amount;
    
	public String getSource_addr() {
		return source_addr;
	}

	public void setSource_addr(String source_addr) {
		this.source_addr = source_addr;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer Amount) {
		this.amount = Amount;
	}

}
