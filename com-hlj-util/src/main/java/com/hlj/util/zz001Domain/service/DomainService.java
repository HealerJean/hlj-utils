package com.hlj.util.zz001Domain.service;

import com.hlj.util.zz001Domain.data.response.RspIsRegDomainModel;

/**
 * @Description  域名的相关处理
 * @Author HealerJean
 * @Date   2019/2/6 下午6:44.
 */
public interface DomainService {

    /**
     *
     * 测试域名是否被注册
     * @param domain
     * @param type
     * @return
     */
    RspIsRegDomainModel isRegisterDomain(String domain , String type);



}
