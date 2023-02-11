package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.Communicate;

import java.util.List;

public interface CommunicateDAO {
    
    List<Communicate> selectAllCommunicates();

    List<Communicate> selectAllCommunicates(Page page);

    Communicate selectCommunicateByAcNumber(Integer acNumber);

    void deleteCommunicateByAcNumber(Integer acNumber);

    void insertCommunicate(Communicate situation);

    void updateCommunicate(Communicate situation);

    void deleteCommunicateByAcNumberS(Integer[] acNumbers);

}
