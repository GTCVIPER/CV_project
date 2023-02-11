package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> selectAllStudents();


    List<String> selectAllStudentsID();

    List<Student> selectAllStudents(Page page);

    Student selectStudentByID(String sId);

    List<Student> selectStudentByName(String sName);

    List<Student> selectStudentByStates(Integer sState);

    void deleteStudentByID(String sId);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentsBySIDS(String[] sIds);


}
