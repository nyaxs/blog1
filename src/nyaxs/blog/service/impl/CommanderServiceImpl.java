package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.CommanderMapper;
import nyaxs.blog.pojo.Commander;
import nyaxs.blog.service.CommanderService;

@Service
public class CommanderServiceImpl implements CommanderService{

	@Autowired
	CommanderMapper commMapper;
	
	@Override
	public List<Commander> list() {
		// TODO Auto-generated method stub
		return commMapper.list();
	}

	@Override
	public Commander login(String name, String password) {
		// TODO Auto-generated method stub
		return commMapper.login(name, password);
	}

	
}
