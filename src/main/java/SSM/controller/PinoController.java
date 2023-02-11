package SSM.controller;

import SSM.bean.BaseResult;
import SSM.bean.Page;
import SSM.bean.TableData;
import SSM.pojo.PioneerFiles;
import SSM.service.PioneerService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pino")
public class PinoController {

    @Resource
    private PioneerService pioneerService;

    @RequestMapping("/pinoList")
    public TableData getPinoList(Page page, @RequestParam(name = "pId", required = false, defaultValue = "") String pId) {

        if ("".equals(pId)) {

            final PageInfo<PioneerFiles> allPinos = pioneerService.findALLPioneerFiles(page);

            final List<PioneerFiles> pinos = allPinos.getList();
            return new TableData(0, "pino data", allPinos.getTotal(), pinos);
        } else {
            List<PioneerFiles> files = new ArrayList<>(1);
            try {
                final PioneerFiles file = pioneerService.findPioneerFilesByPID(Integer.parseInt(pId));
                if (file == null) {
                    return new TableData(0, "check data", 1, null);
                }
                files.add(file);
//            System.out.println(files);
                return new TableData(0, "check data", 1, files);
            } catch (Exception e) {
                e.printStackTrace();
                return new TableData(0, "check data", 1, null);
            }
        }
    }


    @RequestMapping("/pinoDels")
    public BaseResult removePinos(Integer[] pIds, HttpServletRequest request) {

        try {

            pioneerService.removePioneerFilesByPIDS(pIds);

            final HttpSession session = request.getSession();
            session.setAttribute("pinos", pioneerService.findAllPioneerFilesID());


            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }


    @RequestMapping("/pinoUpdate")
    public BaseResult modifyPinos(PioneerFiles pioneerFiles) {

        try {

//            System.err.println(exam);

            pioneerService.updatePioneerFiles(pioneerFiles);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

    @RequestMapping("/pinoAdd")
    public BaseResult savePinos(PioneerFiles pioneerFiles, HttpServletRequest request) {

        try {

            pioneerService.savePioneerFiles(pioneerFiles);
            final HttpSession session = request.getSession();
            session.setAttribute("pinos", pioneerService.findAllPioneerFilesID());

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

}