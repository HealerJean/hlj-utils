package com.hlj.util.z028_灰度工具;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * DuccBypassInsuranceConfiguration
 *
 * @author zhangyujin
 * @date 2022/9/21  21:21.
 */
@Slf4j
@Data
@Configuration
public class GrayConfiguration {

    /**
     * 灰度对象
     */
    @Value("${gray.business.demo}")
    private GrayBusinessDemoBO grayBusiness;


}
