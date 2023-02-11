package SSM.service.impl;

import SSM.Mapper.ApplicationFilesDAO;
import SSM.Mapper.CheckFilesDAO;
import SSM.bean.Page;
import SSM.pojo.ApplicationFiles;
import SSM.pojo.Student;
import SSM.service.ApplicationFilesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("applicationFilesService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class ApplicationFilesServiceImpl implements ApplicationFilesService {

    @Resource
    private ApplicationFilesDAO applicationFilesDAO;

    @Resource
    private CheckFilesDAO checkFilesDAO;

    @Override
    public void saveApplicationFiles(ApplicationFiles applicationFiles) {
            applicationFilesDAO.insertApplicationFiles(applicationFiles);
    }

    @Override
    public void updateApplicationFiles(ApplicationFiles ApplicationFiles) {
            applicationFilesDAO.updateApplicationFiles(ApplicationFiles);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public ApplicationFiles findApplicationFilesByAPPID(Integer appId) {
        return applicationFilesDAO.selectApplicationFilesByAPPID(appId);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<ApplicationFiles> findALLApplicationFiles() {
        return applicationFilesDAO.selectAllApplicationFiles();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PageInfo<ApplicationFiles> findALLApplicationFiles(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<ApplicationFiles> ApplicationFiless = applicationFilesDAO.selectAllApplicationFiles(page);
        return new PageInfo<>(ApplicationFiless);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Student findStudentByAPPID(Integer appId) {
        return applicationFilesDAO.selectStudentByAPPID(appId);
    }

    @Override
    public void removeApplicationFilesByAPPIDS(Integer[] appIds) {
        applicationFilesDAO.deleteApplicationFilesByAPPIDS(appIds);
        checkFilesDAO.deleteCheckFilesBySAPPIDS(appIds);
    }

    @Override
    public void removeApplicationFilesByAPPID(Integer appId) {
        applicationFilesDAO.deleteApplicationFilesByAPPID(appId);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Integer> findAllApplicationFilesID() {
        return applicationFilesDAO.selectAllApplicationFilesID();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Integer[] findAllApplicationFilesIDBySIDS(String[] sIds) {
        return applicationFilesDAO.selectAllApplicationFilesIDBySIDS(sIds);
    }
}
