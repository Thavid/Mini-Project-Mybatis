package org_khmeracademy.app.serviceimplement;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org_khmeracademy.app.model.User;
import org_khmeracademy.app.repository.UserRepository;
import org_khmeracademy.app.service.Userservice;
@Service("userservice")
public class UserserviceImp implements Userservice {
	
	private List<User>  list=new ArrayList<User>();
//	JDBC......
	private UserRepository userRepository;
	@Autowired
	public UserserviceImp(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	@Override
	public boolean save(User user) {
		String userhash=UUID.randomUUID().toString();
		user.setUser_hash(userhash);
		boolean status=userRepository.save(user);
		if(status){
			System.out.println("sucess");
		}else{
			System.out.println("fail");
		}
		return status;
	}
	@Override
	public boolean deleteByHash(String userhash) { 
		boolean status=userRepository.delete(userhash);
		if(status){
			System.out.println("sucess");
		}else{
			System.out.println("fail");
		}
		return status;
	}
	@Override
	public boolean updatebyUserhash(User user) {
		return userRepository.update(user);
	}
	@Override
	public User finduserbyhash(String userhash) {
		// TODO Auto-generated method stub
		return userRepository.finduserbyhash(userhash);
	}
	@Override
	public List<User> maleuser() {
		return userRepository.maleuser();
	}
	@Override
	public List<User> femaleuser() {
		return userRepository.femaleuser();
	}

}
