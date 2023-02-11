package SSM.service.impl;



import SSM.Mapper.ExamsDAO;

import SSM.Mapper.StudentDAO;
import SSM.bean.Page;
import SSM.pojo.Student;
import SSM.service.ApplicationFilesService;
import SSM.service.PioneerService;
import SSM.service.StudentService;
import SSM.utils.Md5Util;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDAO studentDAO;

    @Resource
    private PioneerService pioneerService;

    @Resource
    private ApplicationFilesService applicationFilesService;

    @Resource
    private ExamsDAO examsDAO;

    @Override
    public void saveStudent(Student student) {
        if (!StringUtils.isEmpty(student.getSId())) {
            student.setSPassword(Md5Util.md5(student.getSPassword()));
            studentDAO.insertStudent(student);
        }
    }

    @Override
    public void updateStudent(Student student) {
        if (!StringUtils.isEmpty(student.getSId())){
            if (!StringUtils.isEmpty(student.getSPassword())) {
                student.setSPassword(Md5Util.md5(student.getSPassword()));
            }
            studentDAO.updateStudent(student);
        }
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Student findStudentByID(String sId) {
        return studentDAO.selectStudentByID(sId);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Student> findStudentByName(String sName) {
        if (!StringUtils.isEmpty(sName)){
            return studentDAO.selectStudentByName(sName);
        }
        return null;
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Student> findALLStudents() {
        return studentDAO.selectAllStudents();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<String> findALLStudentsID() {
        return studentDAO.selectAllStudentsID();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PageInfo<Student> findALLStudents(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<Student> students = studentDAO.selectAllStudents(page);
        return new PageInfo<>(students);
    }

    @Override
    public List<Student> findStudentByStates(Integer sState) {
        return studentDAO.selectStudentByStates(sState);
    }

    @Override
    public void removeStudentsByIDS(String[] sIds) {

        studentDAO.deleteStudentsBySIDS(sIds);
        final Integer[] appIds = applicationFilesService.findAllApplicationFilesIDBySIDS(sIds);
        if (appIds.length != 0) applicationFilesService.removeApplicationFilesByAPPIDS(appIds);

        examsDAO.deleteExamFilesBySIDS(sIds);
        final Integer[] pIds = pioneerService.findAllPioneerFilesIDBySIDs(sIds);

        if (pIds.length != 0) pioneerService.removePioneerFilesByPIDS(pIds);
    }

    @Override
    public void removeStudentByID(String sId) {
        studentDAO.deleteStudentByID(sId);
    }

    @Override
    public Student loginStudent(String userId, String passwd) {

        final Student student = findStudentByID(userId);

        if (student != null && student.getSPassword().equals(Md5Util.md5(passwd))) {

            System.out.println("登陆成功！！！");

            return student;
        }else {
            System.out.println("账号或密码错误！！");
            return null;
        }
    }
}
