package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Users;

public interface UsersService {
	int userRegister(Users user) throws Exception;
	int userDelete(Users user) throws Exception;
	Users userGetById(int id) throws Exception;
	int userUpdatePass(Users user) throws Exception;
	List<Users> userList() throws Exception;
	Users userLogin(String user_login,String user_pass) throws Exception;
}
