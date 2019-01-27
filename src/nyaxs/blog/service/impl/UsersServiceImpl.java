package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.UsersMapper;
import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.UsersService;

@Service
public class UsersServiceImpl implements  UsersService{

	@Autowired
	UsersMapper userMapper;
	
	@Override
	public int userRegister(Users user) {
		userMapper.userRegister(user);
		return 1;
	}

	@Override
	public int userDelete(Users user) {
		userMapper.userDelete(user);
		return 1;
	}

	@Override
	public Users userGetById(int id) {
		return userMapper.userGetById(id);
	}

	@Override
	public int userUpdatePass(Users user) {
		userMapper.userUpdatePass(user);
		return 1;
	}

	@Override
	public List<Users> userList() {
		return userMapper.userList();
	}

	@Override
	public Users userLogin(String user_login, String user_pass) {
		return userMapper.userLogin(user_login, user_pass);
	}
}
