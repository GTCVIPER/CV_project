package SSM.service;






import SSM.bean.Page;
import SSM.pojo.ExamFile;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ExamsService {

    void saveExamFile(ExamFile file);

    void updateExamFile(ExamFile file);

    ExamFile findExamFileBySID(String sId);

    List<ExamFile> findALLExamFile();

    List<ExamFile> findExamFilesByCareer(String eCareer);

    PageInfo<ExamFile> findALLExamFile(Page page);

    void removeExamFileBySIDS(String[] sIds);

    void removeExamFileBySID(String sId);

}
