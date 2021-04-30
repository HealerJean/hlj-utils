package com.hlj.util.z031泛型学习;

import com.hlj.util.z031泛型学习.dto.Bean03DTO;
import com.hlj.util.z031泛型学习.dto.Bean03OtherDTO;
import com.hlj.util.z031泛型学习.dto.Bean31ParentDTO;
import com.hlj.util.z031泛型学习.dto.Bean31SonDTO;
import javafx.util.Pair;

/**
 * @author zhangyujin
 * @date 2021/4/15  7:36 下午.
 * @description
 */
public class GenericService {


    /**
     * 1、有多少泛型，前面放多少个
     */
    public static <A, N> A invokeOne(Bean03DTO<A, N> bean03DTO) {
        return bean03DTO.getAge();
    }

    /**
     * 2、有多少泛型，前面放多少个
     */
    public static <A, N, F>  Pair<Bean03DTO<A, N>, Bean03OtherDTO<F>> invokeTwo(Bean03DTO<A, N> dto, Bean03OtherDTO<F> other) {
        Pair<Bean03DTO<A, N>, Bean03OtherDTO<F>> pair = new Pair<>(dto, other);
        return pair;
    }


    /**
     * 3、继承中的泛型引用
     */
    public static <S extends Bean31ParentDTO<String>>  S invokeThree(Bean31SonDTO<S> bean31SonDTO){
        return bean31SonDTO.getSon();
    }

    /**
     * 3、继承中的泛型引用，前面放多少个
     */
    public static <S extends Bean31ParentDTO<String>, A, N>  S invokeThree(Bean31SonDTO<S> bean31SonDTO, Bean03DTO<A, N> bean03DTO){
        return bean31SonDTO.getSon();
    }

}
