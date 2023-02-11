package SSM.service;


import SSM.bean.Page;
import SSM.pojo.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    void updateStudent(Student student);

    Student findStudentByID(String sId);

    List<Student> findStudentByName(String sName);

    List<Student> findALLStudents();

    List<String> findALLStudentsID();

    PageInfo<Student> findALLStudents(Page page);

    List<Student> findStudentByStates(Integer sState);

    void removeStudentsByIDS(String[] sIds);

    void removeStudentByID(String sId);

    Student loginStudent(String userId, String passwd);
}
