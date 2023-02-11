package SSM.controller;

import SSM.bean.BaseResult;
import SSM.bean.Page;
import SSM.bean.TableData;
import SSM.pojo.Student;
import SSM.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/stuList")
    public TableData getStuList(Page page, @RequestParam(name = "sId", required = false, defaultValue = "") String sId) {

        if ("".equals(sId)) {

            final PageInfo<Student> allStus = studentService.findALLStudents(page);
            final List<Student> stus = allStus.getList();
            return new TableData(0, "stu data", allStus.getTotal(), stus);
        } else {
            List<Student> files = new ArrayList<>(1);
            try {
                final Student file = studentService.findStudentByID(sId);
                if (file == null) {
                    return new TableData(0, "stu data", 1, null);
                }
                files.add(file);
//            System.out.println(files);
                return new TableData(0, "stu data", 1, files);
            } catch (Exception e) {
                e.printStackTrace();
                return new TableData(0, "stu data", 1, null);
            }
        }
    }


    @RequestMapping("/stuDels")
    public BaseResult removeStus(String[] sIds, HttpServletRequest request) {

        try {

            studentService.removeStudentsByIDS(sIds);
            final HttpSession session = request.getSession();
            session.setAttribute("stus", studentService.findALLStudentsID());

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }


    @RequestMapping("/stuUpdate")
    public BaseResult modifyStus(Student student) {

        try {

            System.err.println(student);

            studentService.updateStudent(student);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

    @RequestMapping("/stuAdd")
    public BaseResult saveStus(Student student, HttpServletRequest request) {

        try {

            studentService.saveStudent(student);
            final HttpSession session = request.getSession();
            session.setAttribute("stus", studentService.findALLStudentsID());


            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

}
