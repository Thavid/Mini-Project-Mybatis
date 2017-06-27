package org_khmeracademy.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import org_khmeracademy.app.model.User;

@Repository
public interface UserRepository {
	@Select("SELECT"
			+" id, "
			+" username, "
			+" email, "
			+" gender, "
			+" phonenumber, "
			+" status, "
			+" user_hash, "
			+" created_date "
			+" FROM users")
	@Results({
			@Result(property="name",column="username")
	})
	List<User> findAll();
	
	@Insert("INSERT INTO users(username,email,gender,phonenumber,status,user_hash)"
			+ " VALUES(#{user.name},#{user.email},#{user.gender},#{user.phonenumber}"
			+ ",#{user.status},#{user.user_hash})")			
	public boolean save(@Param("user")User user);
	
	@Delete("DELETE FROM users WHERE user_hash=#{userhash}")
	public boolean delete(@Param("userhash")String userhash);
	
	@Update("UPDATE users SET"
			+ " username=#{user.name},"
			+ "email=#{user.email},"
			+ "gender=#{user.gender},"
			+ "phonenumber=#{user.phonenumber},"
			+ "status=#{user.status} "
			+ "WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	@Select("SELECT"
			+" id, "
			+" username, "
			+" email, "
			+" gender, "
			+" phonenumber, "
			+" status, "
			+" user_hash, "
			+" created_date "
			+" FROM users WHERE user_hash=#{userhash}")
	@Results({
		@Result(property="name",column="username")
	})
	public User finduserbyhash(@Param("userhash") String userhash);
	
	@Select("SELECT"
			+" id, "
			+" username, "
			+" email, "
			+" gender, "
			+" phonenumber, "
			+" status, "
			+" user_hash, "
			+" created_date "
			+" FROM users WHERE gender='M'")
	public List<User> maleuser();
	
	@Select("SELECT"
			+" id, "
			+" username, "
			+" email, "
			+" gender, "
			+" phonenumber, "
			+" status, "
			+" user_hash, "
			+" created_date "
			+" FROM users WHERE gender='F'")
	public List<User> femaleuser();
	
	//@Select("SELECT count(gender) FROM users WHERE gender='M'")
}
