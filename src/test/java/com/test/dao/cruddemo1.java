package com.test.dao;
import com.test.entity.user;
import com.test.entity.user;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class cruddemo1 {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Test
    public void demo(){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session s=sessionFactory.openSession();
        s.beginTransaction();
        User user=new User();
        user.setCellphone("345");
        user.setCreateTime(sdf.format(calendar.getTime()));
        user.setEmail("gzh@qq.com");
        user.setPassword("mima");
        user.setUserId(5);
        user.setSalt("2");
        user.setState(1);
        user.setUserName("gzh");
        s.save(user);
        s.getTransaction().commit();
        s.close();
        sessionFactory.close();
    }


}
