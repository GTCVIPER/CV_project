package SSM.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  分页操作的类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Page {

    // 页号
    private Integer page = 1;

    // 一页多少条数据
    private Integer limit;


}
