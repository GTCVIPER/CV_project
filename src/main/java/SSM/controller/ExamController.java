package SSM.controller;

import SSM.bean.BaseResult;
import SSM.bean.Page;
import SSM.bean.TableData;

import SSM.pojo.ExamFile;
import SSM.service.ExamsService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    private ExamsService examsService;

    @RequestMapping("/examList")
    public TableData getexamList(Page page, @RequestParam(name = "sId", required = false, defaultValue = "") String sId) {

        if ("".equals(sId)) {

            final PageInfo<ExamFile> allExams = examsService.findALLExamFile(page);

            final List<ExamFile> exams = allExams.getList();
            return new TableData(0, "exam data", allExams.getTotal(), exams);
        } else {
            List<ExamFile> files = new ArrayList<>(1);
            try {
                final ExamFile file = examsService.findExamFileBySID(sId);
                if (file == null) {
                    return new TableData(0, "exam data", 1, null);
                }
                files.add(file);
//            System.out.println(files);
                return new TableData(0, "exam data", 1, files);
            } catch (Exception e) {
                e.printStackTrace();
                return new TableData(0, "exam data", 1, null);
            }
        }
    }

    @RequestMapping("/examDels")
    public BaseResult removeExams(String[] sIds) {

        try {

            examsService.removeExamFileBySIDS(sIds);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }


    @RequestMapping("/examUpdate")
    public BaseResult modifyExams(ExamFile exam) {

        try {

//            System.err.println(exam);

            examsService.updateExamFile(exam);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

    @RequestMapping("/examAdd")
    public BaseResult saveExams(ExamFile exam) {

        try {

            examsService.saveExamFile(exam);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

}
