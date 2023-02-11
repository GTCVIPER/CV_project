package SSM.service.impl;


import SSM.Mapper.ExamsDAO;
import SSM.bean.Page;
import SSM.pojo.ExamFile;
import SSM.service.ExamsService;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("examsService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class ExamFileServiceImpl implements ExamsService {

    @Resource
    private ExamsDAO examsDAO;

    @Override
    public void saveExamFile(ExamFile examFile) {
        if (!StringUtils.isEmpty(examFile.getSId())){
            examsDAO.insertExamFile(examFile);
        }
    }

    @Override
    public void updateExamFile(ExamFile examFile) {
        if (!StringUtils.isEmpty(examFile.getSId())){
            examsDAO.updateExamFile(examFile);
        }
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public ExamFile findExamFileBySID(String sId) {
        return examsDAO.selectExamFileBySID(sId);
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<ExamFile> findALLExamFile() {
        return examsDAO.selectAllExamFiles();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<ExamFile> findExamFilesByCareer(String eCareer) {
        if (!StringUtils.isEmpty(eCareer)){
            return examsDAO.selectExamFilesByCareer(eCareer);
        }
        return null;
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PageInfo<ExamFile> findALLExamFile(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<ExamFile> examFiles = examsDAO.selectAllExamFiles(page);
        return new PageInfo<>(examFiles);
    }

    @Override
    public void removeExamFileBySIDS(String[] sIds) {
        examsDAO.deleteExamFilesBySIDS(sIds);
    }

    @Override
    public void removeExamFileBySID(String sId) {
        examsDAO.deleteExamFileBySID(sId);
    }
}
