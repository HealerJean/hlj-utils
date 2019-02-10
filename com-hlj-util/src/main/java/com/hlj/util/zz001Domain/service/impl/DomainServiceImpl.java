package com.hlj.util.zz001Domain.service.impl;

import com.hlj.util.zz001Domain.data.response.RspIsRegDomainModel;
import com.hlj.util.zz001Domain.service.DomainService;
import com.hlj.util.zz001Domain.utils.JsonUtils;
import com.hlj.util.zz001Domain.utils.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class DomainServiceImpl implements DomainService {

    /**
     *
     * 测试域名是否被注册
     * @param domain
     * @param type
     * @return
     */
    @Override
    public RspIsRegDomainModel isRegisterDomain(String domain, String type) {
        String reuestUrl = "http://panda.www.net.cn/cgi-bin/check.cgi?area_domain="+domain+type;
        try {
            Connection.Response response = Jsoup.connect(reuestUrl)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();
            String rspbody = response.body() ;
            log.info(rspbody);
            Map<String,String> map = XmlUtil.xmlToMap(rspbody);

            return JsonUtils.toObject(JsonUtils.toJson(map),RspIsRegDomainModel.class) ;
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    @Test
    public void testIsRegisterDomain(){

        String domain = "healerjean";
        String type = ".com" ;

        RspIsRegDomainModel model = isRegisterDomain(domain,type);
        System.out.println(model);


    }

}
