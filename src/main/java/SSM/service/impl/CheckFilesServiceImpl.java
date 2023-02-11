package SSM.service.impl;


import SSM.Mapper.CheckFilesDAO;

import SSM.bean.Page;
import SSM.pojo.CheckFile;
import SSM.service.CheckFilesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("checkFilesService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class CheckFilesServiceImpl implements CheckFilesService {

    @Resource
    private CheckFilesDAO checkFilesDAO;

    @Override
    public void saveCheckFile(CheckFile checkFile) {
        checkFilesDAO.insertCheckFiles(checkFile);
    }

    @Override
    public void updateCheckFile(CheckFile checkFile) {
        checkFilesDAO.updateCheckFiles(checkFile);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public CheckFile findCheckFileByCID(Integer cId) {
        return checkFilesDAO.selectCheckFilesByCID(cId);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<CheckFile> findALLCheckFiles() {
        return checkFilesDAO.selectAllCheckFiles();
    }


    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public PageInfo<CheckFile> findALLCheckFiles(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<CheckFile> CheckFiles = checkFilesDAO.selectAllCheckFiles(page);
        return new PageInfo<>(CheckFiles);
    }

    @Override
    public void removeCheckFileByCIDS(Integer[] cIds) {
        checkFilesDAO.deleteCheckFilesBySCIDS(cIds);
    }

    @Override
    public void removeCheckFileByCID(Integer cId) {
        checkFilesDAO.deleteCheckFilesByCID(cId);
    }
}
