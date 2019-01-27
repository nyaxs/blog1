package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.Users;

public interface UsersMapper {
	void userRegister(Users user);
	void userDelete(Users user);
	Users userGetById(int id);
	void userUpdatePass(Users user);
	List<Users> userList();
	Users userLogin(String user_login,String user_pass);
}
