package SSM.service;


import SSM.bean.Page;
import SSM.pojo.CheckFile;
import SSM.pojo.PioneerFiles;
import SSM.pojo.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PioneerService {

    void savePioneerFiles(PioneerFiles pioneerFiles);

    void updatePioneerFiles(PioneerFiles pioneerFiles);

    PioneerFiles findPioneerFilesByPID(Integer pId);

    List<PioneerFiles> findALLPioneerFiles();

    PageInfo<PioneerFiles> findALLPioneerFiles(Page page);

    List<PioneerFiles> findPioneerFilesByPName(String pName);

    List<Integer> findAllPioneerFilesID();


    Integer[] findAllPioneerFilesIDBySIDs(String[] sIds);

    Student findStudentByPID(Integer pId);

//    CheckFile findCheckFileByPID(Integer pId);

    void removePioneerFilesByPIDS(Integer[] pIds);

    void removePioneerFilesByPID(Integer pId);

    void removePioneerFilesBySID(String sId);
}
