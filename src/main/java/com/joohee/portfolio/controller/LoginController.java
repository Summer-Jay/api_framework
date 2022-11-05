package com.joohee.portfolio.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import com.joohee.portfolio.coupler.RequestLoginCoupler;
import com.joohee.portfolio.service.LoginService;



@Controller
public class LoginController implements RequestLoginCoupler{
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;

	@Override
	public ResponseEntity<Map<String, Object>> selelctUserList(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		HttpHeaders header = new HttpHeaders();
		try {
			result = loginService.getSampleData();
	        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Map<String, Object>>(result, header, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveMemberInfo(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		HttpHeaders header = new HttpHeaders();
		try {
			result = loginService.saveMemberInfo(request);
	        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Map<String, Object>>(result, header, HttpStatus.OK);
	}
}
