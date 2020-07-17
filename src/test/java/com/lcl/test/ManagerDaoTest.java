package com.lcl.test;

import com.lcl.bean.Consignee;
import com.lcl.bean.Manager;
import com.lcl.dao.ManagerDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ManagerDaoTest {
    private InputStream in;
    private SqlSession session;
    private ManagerDao managerDao;

    @Before
    public void init() throws IOException {
        //1.读取主配置文件，返回文件流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //3.创建SqlSessionFactory工厂
        SqlSessionFactory factory = builder.build(in);
        //4.使用工厂生产SqlSession对象
        session = factory.openSession();
        //5.创建dao的代理对象
        managerDao = session.getMapper(ManagerDao.class);
    }

    @After
    public void destroy() throws Exception {
        //提交事务
        session.commit();
        //8.关闭资源
        session.close();
        in.close();
    }

    @Test
    public void testLogin(){
        Manager manager = managerDao.login("myfactory", "myfactory");
        if(manager!=null){
            System.out.println("Login Successfully!");
        }else{
            System.out.println("fail");
        }
    }

    @Test
    public void testInsert(){
        Manager manager=new Manager();
        manager.setUserId(2);
        manager.setAccount("testManager");
        manager.setPassword("testManager");
        manager.setName("test");
        manager.setEmail("sample@qq.com");
        manager.setType("工厂管理员");
        manager.setTel("test");
        managerDao.insert(manager);
    }

    @Test
    public void testDeleteById(){
        managerDao.deleteById(2);
    }

    @Test
    public void testFindAll(){
        List<Manager> list = managerDao.findAll();
        for(Manager manager:list){
            System.out.println(manager.getAccount());
        }
    }

    @Test
    public void testUpdate(){
        Manager manager=new Manager();
        manager.setUserId(2);
        manager.setAccount("testManager2");
        manager.setPassword("testManager");
        manager.setName("test");
        manager.setEmail("sample@qq.com");
        manager.setType("工厂管理员");
        manager.setTel("test");
        managerDao.update(manager);
    }

    @Test
    public void testFindByInfo(){
        List<Manager> consigneeList = managerDao.findByInfo("15071707098");
        for(Manager manager:consigneeList){
            System.out.println(manager.getName());
        }
    }
}
