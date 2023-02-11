package SSM.service.impl;


import SSM.Mapper.CheckFilesDAO;
import SSM.Mapper.PioneerDAO;
import SSM.bean.Page;
import SSM.pojo.PioneerFiles;
import SSM.pojo.Student;
import SSM.service.PioneerService;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("pioneerService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class PioneerServiceImpl implements PioneerService {

    @Resource
    private PioneerDAO pioneerDAO;

    @Resource
    private CheckFilesDAO checkFilesDAO;

    @Override
    public void savePioneerFiles(PioneerFiles attach) {
           pioneerDAO.insertPioneerFiles(attach);
    }

    @Override
    public void updatePioneerFiles(PioneerFiles attach) {
            pioneerDAO.updatePioneerFiles(attach);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PioneerFiles findPioneerFilesByPID(Integer pId) {
        return pioneerDAO.selectPioneerFilesByPID(pId);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<PioneerFiles> findALLPioneerFiles() {
        return pioneerDAO.selectAllPioneerFiles();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PageInfo<PioneerFiles> findALLPioneerFiles(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<PioneerFiles> pioneerFiles = pioneerDAO.selectAllPioneerFiles(page);
        return new PageInfo<>(pioneerFiles);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<PioneerFiles> findPioneerFilesByPName(String pName) {
        if (!StringUtils.isEmpty(pName)){
            return pioneerDAO.selectPioneerFilesByPName(pName);
        }
        return null;
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Integer> findAllPioneerFilesID() {
        return pioneerDAO.selectAllPioneerFilesID();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Integer[] findAllPioneerFilesIDBySIDs(String[] sIds) {
        return pioneerDAO.selectAllPioneerFilesIDBySIDs(sIds);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Student findStudentByPID(Integer pId) {
        return pioneerDAO.selectStudentByPID(pId);
    }

    @Override
    public void removePioneerFilesByPIDS(Integer[] pIds) {
        pioneerDAO.deletePioneerFilesByPIDS(pIds);
        checkFilesDAO.deleteCheckFilesBySPIDS(pIds);
    }

    @Override
    public void removePioneerFilesByPID(Integer pId) {
        pioneerDAO.deletePioneerFilesByPID(pId);
    }

    @Override
    public void removePioneerFilesBySID(String sId) {
        pioneerDAO.deletePioneerFilesBySID(sId);
    }


}
