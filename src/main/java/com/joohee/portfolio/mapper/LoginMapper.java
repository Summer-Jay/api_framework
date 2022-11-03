package com.joohee.portfolio.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginMapper")
public class LoginMapper {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<HashMap<String,Object>> selectUserList(HashMap<String,Object> param) throws Exception{
		return sqlSession.selectList("LoginMapper.selectUserList",param);
	}
}
