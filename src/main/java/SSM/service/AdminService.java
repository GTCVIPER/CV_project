package SSM.service;

import SSM.bean.Page;
import SSM.pojo.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);

    void updateAdmin(Admin admin);

    Admin findAdminByID(String adId);

    List<Admin> findALLAdmins();

    PageInfo<Admin> findALLAdmins(Page page);

    Admin loginAdmin(String userId,String passwd);
}
