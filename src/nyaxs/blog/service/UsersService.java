package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Users;

public interface UsersService {
	int userRegister(Users user);
	int userDelete(Users user);
	Users userGetById(int id);
	int userUpdatePass(Users user);
	List<Users> userList();
	Users userLogin(String user_login,String user_pass);
}
