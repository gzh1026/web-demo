package com.test.controller;

import com.test.dao.User;
import com.test.dao.Userloginlog;
import com.test.entity.user;
import com.test.entity.userloginlog;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
@Controller
@RequestMapping("/test")//Contoller下所有接口统一入口
public class UserController {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/tiaozhuan")
    public String zhuce(){
        return "error";
    }


    @RequestMapping("/login")
    public String logindemo(user user){
        boolean loflag;
        boolean paflag;
        String loginemail= user.getEmail();
        String loginpassword=user.getPassword();
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        String sql = "select * from user  where email = '"+loginemail+"'";//这里直接对表product_进行查询
        Query q= s.createSQLQuery(sql);//使用Session的createSQLQuery方法执行标准SQL语句
        List<Object[]> list= q.list();
        if (list.isEmpty())
            loflag=false;
        else
            loflag=true;

        String sql1="select password from user  where email = '"+loginemail+"'";
        Query q1=s.createSQLQuery(sql1);
        List<String> list1=q1.list();
        if (list1.contains(loginpassword))
            {paflag=true;}
        else
            {paflag=false;}
        s.getTransaction().commit();
        s.close();
         if (loflag||paflag){
             return "success";
         }
         else{
             return "error";
         }
    }

    @RequestMapping("/register")
    public String registerdemo(user u) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String ip=addr.getHostAddress();
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        User q=new User();
        q.setState(1);
        q.setUserId(u.getUser_id());
        q.setCellphone(u.getCellphone());
        q.setCreateTime(sdf.format(calendar.getTime()));
        q.setEmail(u.getEmail());
        q.setPassword(u.getPassword());
        q.setUserName(u.getUser_name());
//        System.out.println(u.getCellphone()+"    "+sdf.format(calendar.getTime()));
        Userloginlog userloginlog=new Userloginlog();
        userloginlog.setLoginTime(sdf.format(calendar.getTime()));
        userloginlog.setLoginIp(ip);
        userloginlog.setUserId(u.getUser_id());
        userloginlog.setLoginId(u.getUser_id());
        s.save(userloginlog);
        s.save(q);
        s.getTransaction().commit();
/*        u.setUser_name(u.getUser_name());
        u.setPassword(u.getPassword());
        u.setEmail(u.getEmail());
        u.setCreate_time(sdf.format(calendar.getTime()));
        u.setCellphone(u.getCellphone());
        u.setState(1);
        s.save(u);
        s.getTransaction().commit();
        System.out.println("first  +  "+u.getCellphone());*/
        s.close();
        sf.close();
        return "success";
    }



}