package com.joohee.portfolio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

	public Map<String, Object> getSampleData() throws Exception;
	public Map<String, Object> saveMemberInfo(HttpServletRequest request) throws Exception;

}
