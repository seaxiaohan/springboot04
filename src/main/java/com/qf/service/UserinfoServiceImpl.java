package com.qf.service;

import com.qf.dao.UserinfoMapper;
import com.qf.pojo.Userinfo;
import com.qf.pojo.UserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Thanks for Everything.
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {

	//注入持久层
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Override
	public void adduser(Userinfo pojo) {
		userinfoMapper.insertSelective(pojo);
	}

	@Override
	public Userinfo findById(Long uid) {
		return userinfoMapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<Userinfo> findAll() {
		UserinfoExample example = new UserinfoExample();
		List<Userinfo> userinfos = userinfoMapper.selectByExample(example);
		return userinfos;
	}

	@Override
	public void deluser(long uid) {
		userinfoMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public List<Userinfo> bluruser(String userName,String userPass) {

		List<Userinfo> userinfos = userinfoMapper.queryByKeyWord(userName,userPass);
		return userinfos;
	}
}
