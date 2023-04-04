package com.open.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    /**
     * 发送邮箱列表
     */

    private String to;

    /**
     * 主题
     */

    private String subject;

    /**
     * 内容
     */
    private String content;

}
