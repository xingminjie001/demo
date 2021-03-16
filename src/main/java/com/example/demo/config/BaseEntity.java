package com.example.demo.config;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 16:10
 */

@Data
@Accessors(chain = true)
public class BaseEntity {
  /**
   * 主键ID
   */
  @TableId(type = IdType.AUTO)
  public Long id;

  /**
   * 更新时间
   */
  @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
  public LocalDateTime updateTime;

  /**
   * 创建时间
   */
  @TableField(value = "create_time",fill = FieldFill.INSERT)
  public LocalDateTime createTime;

}
