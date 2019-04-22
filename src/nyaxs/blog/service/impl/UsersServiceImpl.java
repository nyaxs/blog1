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
	public int userRegister(Users user) throws Exception{
		userMapper.userRegister(user);
		return 1;
	}

	@Override
	public int userDelete(Users user) throws Exception{
		userMapper.userDelete(user);
		return 1;
	}

	@Override
	public Users userGetById(int id) throws Exception{
		return userMapper.userGetById(id);
	}

	@Override
	public int userUpdatePass(Users user) throws Exception{
		userMapper.userUpdatePass(user);
		return 1;
	}

	@Override
	public List<Users> userList() throws Exception{
		return userMapper.userList();
	}

	@Override
	public Users userLogin(String user_login, String user_pass) throws Exception{
		return userMapper.userLogin(user_login, user_pass);
	}
}
