package SSM.service;


import SSM.bean.Page;
import SSM.pojo.Communicate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommunicateService {

    void saveCommunicate(Communicate communicate);

    void updateCommunicate(Communicate communicate);

    Communicate findCommunicateByACNumber(Integer acNumber);

    List<Communicate> findALLCommunicates();

    PageInfo<Communicate> findALLCommunicates(Page page);

    void removeCommunicatesByACNumbers(Integer[] acNumbers);

    void removeCommunicateByACNumber(Integer acNumber);

}
