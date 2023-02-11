package SSM.Mapper;

import SSM.bean.Page;
import SSM.pojo.Admin;

import java.util.List;

public interface AdminDAO {

    List<Admin> selectAllAdmins();

    List<Admin> selectAllAdmins(Page page);

    Admin selectAdminByID(String adId);

    void insertAdmin(Admin admin);

    void updateAdmin(Admin admin);



}
