package com.joohee.portfolio.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.joohee.portfolio.mapper.LoginMapper;
import com.joohee.portfolio.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource(name="loginMapper")
	private LoginMapper loginMapper;
	
	@Override
	public Map<String, Object> getSampleData() throws Exception {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		List<HashMap<String, Object>> userListMap = new ArrayList<HashMap<String,Object>>();
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			userListMap = loginMapper.selectUserList(param);
			
			if(userListMap != null) {
				resultMap.put("RESP_RESULT", userListMap);
				resultMap.put("RESULT_CODE", HttpStatus.OK);	
			}else {
				resultMap.put("RESULT_CODE", "500");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

}
