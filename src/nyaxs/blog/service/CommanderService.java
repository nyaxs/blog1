package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Commander;

public interface CommanderService {
	
	List<Commander> list();
	Commander login(String name,String password);
}
