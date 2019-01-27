package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.Commander;

public interface CommanderMapper {
	int add(Commander comm);
	void delete(String name);
	Commander get(int id);
	int update(Commander comm);
	List<Commander> list();
	int count();
	Commander login(String name,String password);
}
