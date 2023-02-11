package SSM.controller;

import SSM.bean.BaseResult;
import SSM.bean.Page;
import SSM.bean.TableData;

import SSM.pojo.CheckFile;
import SSM.service.CheckFilesService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {

    @Resource
    private CheckFilesService checkFilesService;

    @RequestMapping("/checkList")
    public TableData getCheckList(Page page, @RequestParam(name = "cId", required = false, defaultValue = "") String cId) {

        if ("".equals(cId)) {

            final PageInfo<CheckFile> allChecks = checkFilesService.findALLCheckFiles(page);

            final List<CheckFile> checks = allChecks.getList();
            return new TableData(0, "check data", allChecks.getTotal(), checks);
        } else {
            List<CheckFile> files = new ArrayList<>(1);
            try {
                final CheckFile file = checkFilesService.findCheckFileByCID(Integer.parseInt(cId));
                if (file == null) {
                    return new TableData(0, "check data", 1, null);
                }
                files.add(file);
                return new TableData(0, "check data", 1, files);
            } catch (Exception e) {
                e.printStackTrace();
                return new TableData(0, "check data", 1, null);
            }
        }
    }


    @RequestMapping("/checkDels")
    public BaseResult removeChecks(Integer[] cIds) {

        try {

            checkFilesService.removeCheckFileByCIDS(cIds);


            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }


    @RequestMapping("/checkUpdate")
    public BaseResult modifyChecks(CheckFile checkFile) {

        try {

            System.err.println(checkFile);

            checkFilesService.updateCheckFile(checkFile);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

    @RequestMapping("/checkAdd")
    public BaseResult saveChecks(CheckFile checkFile) {

        try {

            checkFilesService.saveCheckFile(checkFile);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

}