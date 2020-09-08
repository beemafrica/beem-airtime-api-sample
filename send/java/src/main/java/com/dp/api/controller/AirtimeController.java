package com.dp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dp.api.constants.SystemConstants;
import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.ResponseMessage;
import com.dp.api.service.AirtimeIntegrationService;


/**
 * SmsController .
 * 
 * @author admin
 *
 */
@RestController
@CrossOrigin(exposedHeaders = "Content-Disposition")
public class AirtimeController {

    Logger logger = LoggerFactory.getLogger(AirtimeController.class);

    @Autowired
    private AirtimeIntegrationService airtimeIntegrationService;
    
	
	/**
	 * restApiCall.
	 *
	 * @param requestHeader the requestHeader
	 * @param request       the request
	 * @return ResponseEntity< CreateUserResponse >
	 * @throws Exception
	 */
	@RequestMapping(value = SystemConstants.Airtime_INTEGRATION_CALL, method = RequestMethod.POST)
	public ResponseEntity<AirtimeResponseMessage> restApiCall(@RequestBody AirtimeMessage request) throws Exception {

		AirtimeResponseMessage response = new AirtimeResponseMessage();
		logger.info("Request Receiver from API : Airtime");
		response = airtimeIntegrationService.getResponseFromAirtime(request);
		logger.info("Response sent from API : {}" ,response.getCode());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}


}
