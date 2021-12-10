package com.hlj.util.z031_泛型学习;
import com.hlj.util.z031_泛型学习.dto.Bean03DTO;
import com.hlj.util.z031_泛型学习.dto.Bean03OtherDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhangyujin
 * @date 2021/4/15  7:35 下午.
 * @description
 */
@Slf4j
public class TestMain {

    @Test
    public void test(){
        Bean03DTO<Integer, String> bean03DTO = new Bean03DTO<>();
        bean03DTO.setAge(11);
        bean03DTO.setName("HealerJean");
        log.info("invoke:{}", GenericService.invokeOne(bean03DTO));

        Bean03OtherDTO<String> bean03OtherDTO = new Bean03OtherDTO();
        bean03OtherDTO.setFriend("friend");
        log.info("invoke:{}", GenericService.invokeTwo(bean03DTO,bean03OtherDTO));

    }
}
