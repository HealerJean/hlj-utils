package com.hlj.util.Z005BiMap.redis实现压缩BitMap;

import lombok.Data;

import java.io.Serializable;

/**
 * CompressedBitInfo
 *
 * @author zhangyujin
 * @date 2024/9/14
 */
@Data
public class CompressedBitInfo implements Serializable {

    /**
     * 真实offset
     */
    private long sourceOffset;

    /**
     * 分桶的编号
     */
    private long bucketIndex;
    /**
     * 桶内的offset
     */
    private long bucketOffset;

}
