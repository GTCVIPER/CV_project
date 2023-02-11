package SSM.bean;

import lombok.Data;

// 返回给前端的数据接口
@Data
public class AjaxMessage {

    private String msg;
    private Object data;

}
