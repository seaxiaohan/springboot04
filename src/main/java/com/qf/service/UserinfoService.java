package com.qf.service;

import com.qf.pojo.Userinfo;

import java.util.List;

/**
 * Thanks for Everything.
 */
public interface UserinfoService {

	public void adduser(Userinfo pojo);

	public Userinfo findById(Long uid);

	public List<Userinfo> findAll();

	public void deluser(long uid);

	public List<Userinfo> bluruser(String userName,String userPass);

}
