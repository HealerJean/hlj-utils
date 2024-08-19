package com.hlj.util.z035_分页;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * java分页工具
 * @author zhangyujin
 * @date 2021/11/5  9:10 上午.
 */
@Slf4j
public class JavaPageUtils {


    public static void main(String[] args) {
        int pageNow = 5;
        int pageSize = 2;
        PageDto<String> page = toPageDto(Lists.newArrayList("1", "2", "3", "4", "5"), pageNow, pageSize);
        log.info("toPageDto:{}", page);
    }

    public static <T>  PageDto<T> toPageDto(List<T> list, Integer pageNow, Integer pageSize) {
        if  (list == null || list.isEmpty()){
            return new PageDto<>(null, pageNow, pageSize, 0, 0);
        }

        Integer totalCount = list.size();
        int pageCount;
        if (totalCount % pageSize == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }
        List<T> pageList = list.stream().skip((long) (pageNow - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return new PageDto<>(pageList, pageNow, pageSize, totalCount, pageCount);
    }
    @Data
    @Accessors(chain = true)
    public static class PageDto<T> {
        private List<T> datas;
        /**
         * 当前页码数
         */
        private Integer pageNow;
        /**
         * 每页显示的记录数
         */
        private Integer pageSize;
        /**
         * 总记录数
         */
        private Integer totalCount;
        /**
         * 一共多少页
         */
        private Integer pageCount;

        public PageDto(List<T> datas, Integer pageNow, Integer pageSize, Integer totalCount, Integer pageCount) {
            this.datas = datas;
            this.pageNow = pageNow;
            this.pageSize = pageSize;
            this.totalCount = totalCount;
            this.pageCount = pageCount;
        }

        private PageDto(List<T> datas) {
            this.datas = datas;
        }

        private PageDto() {
        }
    }

}
