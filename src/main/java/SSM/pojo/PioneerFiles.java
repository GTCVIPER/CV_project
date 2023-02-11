package SSM.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  先锋模范材料表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PioneerFiles {

  private Integer pId; // 材料编号

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date pTime; // 上传时间

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date pGetTime; // 获得时间
  private String pName; // 获得名称
  private String pRank; // 级别
  private String pAdjunct; // 附件

  private String sId; // 学生账号


  private Student student;
//  private CheckFile checkFile;



}
