package com.javen.testmybatis;

import com.javen.dao.MessageBoardInfoDao;
import com.javen.dao.UsrTableDao;
import com.javen.model.MessageBoardInfo;
import com.javen.model.UsrTable;
import com.javen.model.UsrTableExample;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  

//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }
	@Autowired
	MessageBoardInfoDao messageBoardInfoDao;
	@Autowired
	UsrTableDao usrTableDao;

	@Test
	public void messageBoardInfoDaoTest() {
		MessageBoardInfo messageBoardInfo = messageBoardInfoDao.selectByPrimaryKey(1);
		System.out.println(messageBoardInfo);
	}
	@Test
	public void connectDNTest() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///message_board?useSSL=false&autoReconnect=true&serverTimezone=UTC", "root", "root");
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	@Test
	public void usrTableDaoTest() {
		UsrTable usrTable = usrTableDao.selectByPrimaryKey(1);
		System.out.println(usrTable);
	}

	@Test
	public void usrTableExampleTest() {
		UsrTableExample ux = new UsrTableExample();
		ux.createCriteria().andUsrAccountEqualTo("admin1");
		List<UsrTable> usrTables = usrTableDao.selectByExample(ux);
		if(!usrTables.isEmpty()){
			System.out.println(usrTables);
		}

	}

}  