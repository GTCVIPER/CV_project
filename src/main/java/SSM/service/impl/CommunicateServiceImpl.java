package SSM.service.impl;


import SSM.Mapper.CommunicateDAO;
import SSM.bean.Page;
import SSM.pojo.Communicate;
import SSM.service.CommunicateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("communicateService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class CommunicateServiceImpl implements CommunicateService {

    @Resource
    private CommunicateDAO communicateDAO;

    @Override
    public void saveCommunicate(Communicate communicate) {
        communicateDAO.insertCommunicate(communicate);
    }

    @Override
    public void updateCommunicate(Communicate communicate) {
            communicateDAO.updateCommunicate(communicate);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Communicate findCommunicateByACNumber(Integer acNumber) {
        return communicateDAO.selectCommunicateByAcNumber(acNumber);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Communicate> findALLCommunicates() {
        return communicateDAO.selectAllCommunicates();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public PageInfo<Communicate> findALLCommunicates(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<Communicate> files = communicateDAO.selectAllCommunicates(page);
        return new PageInfo<>(files);
    }

    @Override
    public void removeCommunicatesByACNumbers(Integer[] acNumbers) {
        communicateDAO.deleteCommunicateByAcNumberS(acNumbers);
    }

    @Override
    public void removeCommunicateByACNumber(Integer acNumber) {
        communicateDAO.deleteCommunicateByAcNumber(acNumber);
    }
}
