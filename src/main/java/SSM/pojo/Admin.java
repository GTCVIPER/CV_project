package SSM.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *  管理员表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

  private String adId; // 管理员账号
  private String adPassword; // 管理员密码


}
