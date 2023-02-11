package SSM.controller;

import SSM.bean.BaseResult;
import SSM.bean.Page;
import SSM.bean.TableData;
import SSM.pojo.Communicate;
import SSM.service.CommunicateService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comm")
public class CommController {

    @Resource
    private CommunicateService communicateService;

    @RequestMapping("/commList")
    public TableData getCommList(Page page, @RequestParam(name = "acNumber", required = false, defaultValue = "") String acNumber) {

        if ("".equals(acNumber)) {

            final PageInfo<Communicate> allComms = communicateService.findALLCommunicates(page);

            final List<Communicate> comms = allComms.getList();
            return new TableData(0, "comm data", allComms.getTotal(), comms);
        } else {
            List<Communicate> files = new ArrayList<>(1);
            try {
                final Communicate file = communicateService.findCommunicateByACNumber(Integer.parseInt(acNumber));
                if (file == null) {
                    return new TableData(0, "comm data", 1, null);
                }
                files.add(file);
//            System.out.println(files);
                return new TableData(0, "comm data", 1, files);
            } catch (Exception e) {
                e.printStackTrace();
                return new TableData(0, "comm data", 1, null);
            }
        }
    }


    @RequestMapping("/commDels")
    public BaseResult removeComms(Integer[] acNumbers) {

        try {

            communicateService.removeCommunicatesByACNumbers(acNumbers);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }


    @RequestMapping("/commUpdate")
    public BaseResult modifyComms(Communicate communicate) {

        try {

//            System.err.println(student);

            communicateService.updateCommunicate(communicate);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

    @RequestMapping("/commAdd")
    public BaseResult saveComms(Communicate communicate) {

        try {

            communicateService.saveCommunicate(communicate);

            return new BaseResult(true, "SUCCESS!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(false, "FAIL!!!");
        }

    }

}