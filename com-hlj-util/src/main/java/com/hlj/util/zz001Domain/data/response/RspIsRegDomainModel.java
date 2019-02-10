package com.hlj.util.zz001Domain.data.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * - returncode=200 表示接口返回成功
 - key=*.com表示当前check的域名
 - original=210 : Domain name is available 表示域名可以注册
 - original=211 : Domain name is not available 表示域名已经注册
 - original=212 : Domain name is invalid 表示域名参数传输错误
 - original=213 : Time out 查询超时
 */
@ApiModel(description = "接口是否注册返回的对象")
@Data
@Accessors(chain = true)
public class RspIsRegDomainModel {


    private String original;
    private String returncode;
    private String key;
}
