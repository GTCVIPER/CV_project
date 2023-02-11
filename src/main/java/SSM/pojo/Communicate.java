package SSM.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  交流园地管理表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Communicate {

  private Integer acNumber; // 文章发布编号

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date acTime; // 文章发布时间
  private String acContent; // 发布内容


}
