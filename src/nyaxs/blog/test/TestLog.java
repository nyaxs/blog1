package nyaxs.blog.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nyaxs.blog.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLog {
	@Autowired
	UsersService us;
	
	static Logger logger = Logger.getLogger(TestLog.class);
	
	@Test
	public void testUserList() throws Exception {
		//PropertyConfigurator.configure("D:\\Project\\Eclipse_jee\\Blog1\\src\\log4j.properties");
		//BasicConfigurator.configure();
		logger.setLevel(Level.DEBUG);
		logger.trace("跟踪信息");
		logger.debug("调试信息");
		logger.info("info");
		Thread.sleep(100);
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		System.out.println(us.userList());
	}
	

}
