package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.CheckFile;

import java.util.List;

public interface CheckFilesDAO {

    List<CheckFile> selectAllCheckFiles();

//    List<Integer> selectAllCheckFilesID();

    List<CheckFile> selectAllCheckFiles(Page page);

    CheckFile selectCheckFilesByCID(Integer cId);

    void deleteCheckFilesByCID(Integer cId);

    void insertCheckFiles(CheckFile files);

    void updateCheckFiles(CheckFile files);

    void deleteCheckFilesBySCIDS(Integer[] cIds);

    void deleteCheckFilesBySAPPIDS(Integer[] appIds);

    void deleteCheckFilesBySPIDS(Integer[] pIds);



}
