package com.hlj.util.z032_大数据分批查询;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyujin
 * @date 2021/12/10  9:34 上午.
 * @description
 */
@Slf4j
public class BigDataQueryUtils {


    /**
     * 1、获取分段结果
     */
    @Test
    public void test(){
        int totalCount = 100;
        int intervalLength = 10;
        List<ImmutablePair<Integer, Integer>> result = intervalPairOfTotalCount(totalCount, intervalLength);
        log.info("totalCouont:{}, intervalLength:{}, result:{}", totalCount, intervalLength, result);
    }

    /**
     * 获取分段区间，索引从0开始
     * @param totalCount 总数量
     * @param pageSize 区间长度
     */
    public static List<ImmutablePair<Integer, Integer>> intervalPairOfTotalCount(Integer totalCount, Integer pageSize){
        List<ImmutablePair<Integer, Integer>> result = new ArrayList<>();

        Integer pageCount;
        if (totalCount % pageSize == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }

        Integer pageNow = 1;
        while (pageNow <= pageCount ){
            int startIndex = (pageNow - 1) * pageSize;
            ImmutablePair<Integer, Integer> pair = ImmutablePair.of(startIndex, pageSize);

            // 结束索引，看需要是否要取分段endIndex
            // int endIndex = pageNow != pageCount ? startIndex + pageSize : totalCount;
            // ImmutablePair<Integer, Integer> pair = ImmutablePair.of(startIndex, endIndex);

            pageNow++;
            result.add(pair);
        }
        return result;
    }

}
