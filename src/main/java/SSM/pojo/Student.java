package SSM.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  学生管理表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private String sId; // 学生账号
  private String sName; // 学生姓名
  private String sPassword; // 学生密码
  private String sSex; // 学生性别
  private String sNation; // 民族
  private String sClass; // 专业班级
  private String sTel; // 联系方式
  private String sPolitic; // 政治面貌
  private Integer sState; // 学生状态

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sRegister; // 入学年份
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sApply; // 申请入党时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sActivist; // 确定积极分子时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sDevelop; // 确定发展对象时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sProbationer; // 确定预备入党时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sCommunist; // 确定为党员时间


}
