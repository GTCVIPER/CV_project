package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.ExamFile;

import java.util.List;

public interface ExamsDAO {

    List<ExamFile> selectAllExamFiles();

    List<ExamFile> selectAllExamFiles(Page page);

    ExamFile selectExamFileBySID(String sId);

    List<ExamFile> selectExamFilesByCareer(String eCareer);

    void deleteExamFileBySID(String sId);

    void insertExamFile(ExamFile ExamFile);

    void updateExamFile(ExamFile ExamFile);

    void deleteExamFilesBySIDS(String[] sIds);

}
