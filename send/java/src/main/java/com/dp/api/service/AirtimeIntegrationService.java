package com.dp.api.service;

import javax.management.ServiceNotFoundException;

import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.ResponseMessage;

import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.AirtimeResponseMessage;

/**
 * AirtimeIntegrationService .
 * 
 * @author admin
 *
 */
public interface AirtimeIntegrationService {

	
	/**
	 *  getResponseFromAirtime .
	 *  
	 * @param request
	 * @return
	 */
	public ResponseMessage getResponseFromAirtime(AirtimeMessage request) throws ServiceNotFoundException;
	
}
