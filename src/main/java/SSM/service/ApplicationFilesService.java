package SSM.service;



import SSM.bean.Page;
import SSM.pojo.ApplicationFiles;
import SSM.pojo.CheckFile;
import SSM.pojo.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ApplicationFilesService {

    void saveApplicationFiles(ApplicationFiles ApplicationFiles);

    void updateApplicationFiles(ApplicationFiles ApplicationFiles);

    ApplicationFiles findApplicationFilesByAPPID(Integer appId);

    List<ApplicationFiles> findALLApplicationFiles();

    PageInfo<ApplicationFiles> findALLApplicationFiles(Page page);

    Student findStudentByAPPID(Integer appId);

//    CheckFile findCheckFileByAPPID(Integer appId);

    void removeApplicationFilesByAPPIDS(Integer[] appIds);

    void removeApplicationFilesByAPPID(Integer appId);

    List<Integer> findAllApplicationFilesID();

    Integer[] findAllApplicationFilesIDBySIDS(String[] sIds);

}
