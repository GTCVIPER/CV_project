package SSM.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  审核表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckFile {

  private Integer cId; // 审核材料编号

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date cTime; // 审核时间
  private String cText; // 审核内容
  private Integer cState; // 审核状态


  private Integer pId; // 材料编号
  private Integer appId; // 提交编号

  private PioneerFiles pioneerFiles;
  private ApplicationFiles applicationFiles;

}
