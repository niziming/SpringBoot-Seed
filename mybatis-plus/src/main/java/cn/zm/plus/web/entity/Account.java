package cn.zm.plus.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.zm.common.common.ObjectConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import cn.zm.plus.web.entity.vo.AccountVO;

@Data
@Accessors(chain = true)
@TableName("account")
@ApiModel(value="Account对象", description="")
public class Account extends ObjectConvert<AccountVO>{
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Double money;
}
