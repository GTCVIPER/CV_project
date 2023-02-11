package SSM.controller;


import SSM.bean.BaseResult;
import SSM.bean.Page;
import SSM.bean.TableData;

import SSM.pojo.ApplicationFiles;
import SSM.service.ApplicationFilesService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/app")
public class AppController {

    @Resource
    private ApplicationFilesService applicationFilesService;

    @RequestMapping("/appList")
    public TableData getAppList(Page page, @RequestParam(name = "appId", required = false, defaultValue = "") String appId) {


        if ("".equals(appId)) {

            final PageInfo<ApplicationFiles> allApps = applicationFilesService.findALLApplicationFiles(page);

            final List<ApplicationFiles> apps = allApps.getList();
            return new TableData(0, "app data", allApps.getTotal(), apps);
        } else {
            List<ApplicationFiles> files = new ArrayList<>(1);
            try {
                final ApplicationFiles file = applicationFilesService.findApplicationFilesByAPPID(Integer.parseInt(appId));
                if (file == null) {
                    return new TableData(0, "app data", 1, null);
                }
                files.add(file);
//            System.out.println(files);
                return new TableData(0, "app data", 1, files);
            } catch (Exception e) {
                e.printStackTrace();
                return new TableData(0, "app data", 1, null);
            }
        }
    }


    @RequestMapping("/appDels")
    public BaseResult removeApps(Integer[] appIds, HttpServletRequest request) {

        try {

            applicationFilesService.removeApplicationFilesByAPPIDS(appIds);

            final HttpSession session = request.getSession();

            session.setAttribute("apps", applicationFilesService.findAllApplicationFilesID());

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }


    @RequestMapping("/appUpdate")
    public BaseResult modifyApps(ApplicationFiles applicationFiles) {

        try {

            applicationFilesService.updateApplicationFiles(applicationFiles);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

    @RequestMapping("/appAdd")
    public BaseResult saveApps(ApplicationFiles applicationFiles, HttpServletRequest request) {

        try {

//            System.err.println(applicationFiles);
            applicationFilesService.saveApplicationFiles(applicationFiles);
            final HttpSession session = request.getSession();

            session.setAttribute("apps", applicationFilesService.findAllApplicationFilesID());


            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

}
