package SSM.service.impl;

import SSM.Mapper.AdminDAO;
import SSM.bean.Page;
import SSM.pojo.Admin;
import SSM.service.AdminService;
import SSM.utils.Md5Util;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
// 类里方法抛出异常，就会回滚， 数据库里的数据也会回滚
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDAO adminDAO;

    @Override
    public void saveAdmin(Admin admin) {
        if (!StringUtils.isEmpty(admin.getAdId())) {
            admin.setAdPassword(Md5Util.md5(admin.getAdPassword()));
            adminDAO.insertAdmin(admin);
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        if (!StringUtils.isEmpty(admin.getAdId())){
            if (!StringUtils.isEmpty(admin.getAdPassword())) {
                admin.setAdPassword(Md5Util.md5(admin.getAdPassword()));
            }
            adminDAO.updateAdmin(admin);
        }
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Admin findAdminByID(String adId) {
        return adminDAO.selectAdminByID(adId);
    }


    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Admin> findALLAdmins() {
        return adminDAO.selectAllAdmins();
    }

    @Override
    // Spring 的事务传播机制中 Propagation.SUPPORTS 级别的意义是，如果当前环境有事务，就加入到当前事务；如果没有事务，就以非事务的方式执行。
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    // 分页专用
    public PageInfo<Admin> findALLAdmins(Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        final List<Admin> admins = adminDAO.selectAllAdmins(page);
        return new PageInfo<>(admins);
    }



    @Override
    public Admin loginAdmin(String userId, String passwd) {

        final Admin admin = findAdminByID(userId);

        // 判断是否登陆成功
        if (admin != null && admin.getAdPassword().equals(Md5Util.md5(passwd))) {
            System.out.println("登陆成功！！！");

                return admin;
            }else {
                System.out.println("账号或密码错误！！");
                return null;
            }
        }
    }

