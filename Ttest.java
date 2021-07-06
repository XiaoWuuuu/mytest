package cn.smbms;


import cn.smbms.pojo.Bill;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Spring整合mybaits 测试类
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
//替换运行容器
@RunWith(SpringJUnit4ClassRunner.class)
public class Ttest {
    //注入service
    @Autowired
    private BillService billService;
    @Autowired
    private UserService userService;
    @Test
    public void getById() throws Exception {
       Bill billById = billService.getBillById(2);
       System.out.println(billById);
    }
    @Test
    public void modify() throws Exception{
        //封装密码
        //封装一个id
        User user=new User();
        user.setId(1);
        user.setUserPassword("23123132");

        boolean modify = userService.modify(user);
        System.out.println(modify);
    }
    //根据用户名和密码条件获取这个用户
    @Test
    public void getUser() throws  Exception{
        User user=new User();
        user.setUserCode("admin");
        user.setUserPassword("1231231");

        User user1=userService.getUser(user);
        System.out.println(user1);
    }


}
