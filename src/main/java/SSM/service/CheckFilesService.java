package SSM.service;




import SSM.bean.Page;
import SSM.pojo.CheckFile;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface CheckFilesService {

    void saveCheckFile(CheckFile files);

    void updateCheckFile(CheckFile files);

    CheckFile findCheckFileByCID(Integer cId);

    List<CheckFile> findALLCheckFiles();

    PageInfo<CheckFile> findALLCheckFiles(Page page);

    void removeCheckFileByCIDS(Integer[] cIds);

    void removeCheckFileByCID(Integer cId);

}
