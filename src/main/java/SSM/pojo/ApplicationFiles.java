package SSM.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  入党申请书表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFiles {

  private Integer appId; // 提交编号

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date appTime; // 提交时间
  private String appText; // 入党申请书内容


  private String sId; // 学生账号
//  private Integer cId; // 审核材料编号

  private Student student;

//  private CheckFile checkFile;
}
