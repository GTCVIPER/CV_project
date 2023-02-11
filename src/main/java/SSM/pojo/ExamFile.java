package SSM.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  积极分子量化考核表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamFile {

  private String sId; // 学生账号
  private String eCareer; // 班级职务
  private Integer eMass; // 群众意见打分分数
  private Integer eCounsellor; // 辅导员意见打分分数
  private Integer eSecretary; // 支部书记意见打分分数
  private Integer eGrade; // 先锋模范总分



}
