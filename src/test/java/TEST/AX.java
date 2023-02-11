package TEST;

import SSM.pojo.Admin;
import SSM.pojo.Student;
import SSM.service.AdminService;
import SSM.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-context.xml")
public class AX {

    @Resource
    private StudentService studentService;

    @Resource
    private AdminService adminService;

    @Test
    public void sdv() {


//        studentService.removeStudentsByIDS(new String[] {"20192161","215462"});

        studentService.saveStudent(new Student("20192161",
                "cecec","wde","男","recerve","你看4545吗",
                "3434545643","5g4f4f",3,new Date(),new Date(),new Date(),
                new Date(),null,null));
    }


    @Test
    public void ssdv() {

//            adminService.saveAdmin(new Admin("root","root"));
        String[] s = new String[] {"fcfdv","vfdvd"};
            studentService.removeStudentsByIDS(s);
    }
}
