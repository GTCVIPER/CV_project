package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.CheckFile;
import SSM.pojo.PioneerFiles;
import SSM.pojo.Student;

import java.util.List;

public interface PioneerDAO {


    List<PioneerFiles> selectAllPioneerFiles();

    List<PioneerFiles> selectAllPioneerFiles(Page page);

    PioneerFiles selectPioneerFilesByPID(Integer pId);

    List<PioneerFiles> selectPioneerFilesByPName(String pName);

    Student selectStudentByPID(Integer pId);

//    CheckFile selectCheckFileByPID(Integer pId);

    void deletePioneerFilesByPID(Integer pId);

    void deletePioneerFilesBySID(String sId);

    void insertPioneerFiles(PioneerFiles pioneerFiles);

    void updatePioneerFiles(PioneerFiles pioneerFiles);

    void deletePioneerFilesByPIDS(Integer[] pIds);

    void deletePioneerFilesBySIDS(String[] sIds);

    List<Integer> selectAllPioneerFilesID();

    Integer[] selectAllPioneerFilesIDBySIDs(String[] sIds);

}
