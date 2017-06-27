package org_khmeracademy.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org_khmeracademy.app.model.User;
public interface Userservice {
//	public List<User> Showuser();
//	public void addUser(User user);
//	public void RemovUser(int id);
//	public User getUsertById(int id);
//	
	public List<User> findAll();
	public boolean save(User user);
	public boolean deleteByHash(String userhash);
	public boolean updatebyUserhash(User user);
	public User finduserbyhash( String userhash);
	public List<User> maleuser();
	public List<User> femaleuser();
}
