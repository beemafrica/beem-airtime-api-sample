package com.dp.api.service;

import java.nio.charset.Charset;

import javax.management.ServiceNotFoundException;
import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dp.api.constants.SystemConstants;
import com.dp.api.entity.SmsEntity;
import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.ResponseMessage;


import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.AirtimeResponseMessage;

/**
 * AirtimeIntegrationServiceImpl .
 * 
 * @author admin
 *
 */
@Service
@Transactional
public class AirtimeIntegrationServiceImpl implements AirtimeIntegrationService {

	Logger logger = LoggerFactory.getLogger(AirtimeIntegrationServiceImpl.class);

	/**
	 * restTemplate
	 */
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public AirtimeResponseMessage getResponseFromAirtime(AirtimeMessage request) throws ServiceNotFoundException {
		// TODO Auto-generated method stub
		AirtimeResponseMessage response = new AirtimeResponseMessage();
		String url = SystemConstants.Airtime_URL;
		ResponseEntity<AirtimeResponseMessage> responseEntity = null;
		// request entity is created with request body and headers
		HttpEntity<AirtimeMessage> requestEntity = new HttpEntity<>(request, createHeaders("<USER_NAME>",
				"" + "<USER_PASSSWORD>"));
		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AirtimeResponseMessage.class);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured while making the call to downstream : {}", e.getMessage());
			throw new ServiceNotFoundException(e.getMessage());
		}
		if (responseEntity != null) {
			responseEntity.getBody();
			logger.info("Body Value : {}", responseEntity.getBody());
		}
		return responseEntity.getBody();
	}

	/**
	 * Create Headers.
	 *
	 * @param username Username
	 * @param password password
	 * @return HttpHeaders
	 */
	private HttpHeaders createHeaders(String username, String password) {
		HttpHeaders httpHeader = new HttpHeaders();
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		logger.info("Authorization header sent to fetch message Data: {}", authHeader);
		httpHeader.add("Authorization", authHeader);
		return httpHeader;
	}

}
