package com.hlj.util.Z003ThreadLocal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author fengchuanbo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ContextHolder {

    /** 将openId保存到上下文 */
    private final static ThreadLocal<Long> userIdCcontainer = new ThreadLocal<>();

    /**
     * 把userId保存到上下文
     * @param userId
     */
    public static void setUserId(Long userId){
        userIdCcontainer.set(userId);
    }


    public static void setUserIdAndOid(Long userId, String openId){
        setUserId(userId);
    }

    /**
     * 获取用户ID
     * @return
     */
    public static Long getUserId(){
        return userIdCcontainer.get();
    }


    /**
     * 清空上下文
     */
    public static void clear(){
        userIdCcontainer.remove();
    }
}
