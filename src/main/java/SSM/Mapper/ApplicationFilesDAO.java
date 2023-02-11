package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.ApplicationFiles;
import SSM.pojo.CheckFile;
import SSM.pojo.Student;

import java.util.List;

public interface ApplicationFilesDAO {
    List<ApplicationFiles> selectAllApplicationFiles();

    List<ApplicationFiles> selectAllApplicationFiles(Page page);

    ApplicationFiles selectApplicationFilesByAPPID(Integer appId);

    Student selectStudentByAPPID(Integer appId);

//    CheckFile selectCheckFileByAPPID(Integer appId);

    void deleteApplicationFilesByAPPIDS(Integer[] appIds);

    void insertApplicationFiles(ApplicationFiles applicationFiles);

    void updateApplicationFiles(ApplicationFiles applicationFiles);

    void deleteApplicationFilesByAPPID(Integer appId);

    void deleteApplicationFilesBySIDs(String[] sIds);

    List<Integer> selectAllApplicationFilesID();

    Integer[] selectAllApplicationFilesIDBySIDS(String[] sIds);

}
