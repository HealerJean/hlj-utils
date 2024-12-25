package com.hlj.util.Z005BiMap.redis实现压缩BitMap;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/**
 * CompressedBitUtils
 *
 * @author zhangyujin
 * @date 2024/9/14
 */
@Slf4j
public class CompressedBitUtils {

    /**
     * 设置压缩位图在offset上的值,并且设置过期时间(秒)
     *
     * @param key    位图的KEY
     * @param offset 写入位图的偏移量
     */
    public void setCompressedBit(String key, long offset, boolean value, int expireSeconds) {
        CompressedBitInfo bitInfo = CompressedBitTookit.getBitInfo(offset);
        String bitKey = getBitKey(key, bitInfo.getBucketIndex());
        // redis.setBit(bitKey, bitInfo.getBucketOffset(),value);
        // redis.expire(bitKey, expireSeconds);
    }


    /**
     * 设置压缩位图在offset上的值
     *
     * @param key    位图的KEY
     * @param offset 写入位图的偏移量
     */
    public void setCompressedBit(String key, long offset, boolean value) {
        CompressedBitInfo bitInfo = CompressedBitTookit.getBitInfo(offset);
        String bitKey = getBitKey(key, bitInfo.getBucketIndex());
        // redis.setBit(bitKey, bitInfo.getBucketOffset(),value);
    }


    /**
     * 设置压缩位图在offset上的值(相当于设置为true)
     *
     * @param key    位图的KEY
     * @param offset 写入位图的偏移量
     */
    public void setCompressedBit(String key, long offset) {
        this.setCompressedBit(key, offset, true);
    }


    /**
     * 删除压缩位图在offset上的值(相当于设置为false)
     *
     * @param key    位图的KEY
     * @param offset 写入位图的偏移量
     */
    public void remCompressedBit(String key, long offset) {
        this.setCompressedBit(key, offset, false);
    }


    /**
     * 获取压缩位图在offset上的值
     *
     * @param key    位图的KEY
     * @param offset 写入位图的偏移量
     * @return
     */
    public Boolean getCompressedBit(String key, long offset) {
        CompressedBitInfo bitInfo = CompressedBitTookit.getBitInfo(offset);
        String bitKey = getBitKey(key, bitInfo.getBucketIndex());
        log.debug("getCompressedBit with key:{}, offset:{}", bitKey, bitInfo.getBucketOffset());
        // return redis.getBit(bitKey, bitInfo.getBucketOffset());
        return null;
    }


    /**
     * 获取压缩位图每个小桶的子key集合
     *
     * @param key       位图的KEY
     * @param maxOffset 最大的offset
     * @return
     */
    public List<String> getAllBucketKeys(String key, long maxOffset) {
        List<String> result = Lists.newArrayList();
        CompressedBitInfo bitInfo = CompressedBitTookit.getBitInfo(maxOffset);
        for (int i = 0; i < bitInfo.getBucketIndex(); i++) {
            String bitKey = getBitKey(key, i);
            result.add(bitKey);
        }
        return result;
    }

    /**
     * 删除所有桶里的的Bitmap
     *
     * @param key       位图的KEY
     * @param maxOffset 最大的offset
     */
    public void deleteAllCompressedBit(String key, long maxOffset) {
        CompressedBitInfo bitInfo = CompressedBitTookit.getBitInfo(maxOffset);
        for (int i = 0; i < bitInfo.getBucketIndex(); i++) {
            String bitKey = getBitKey(key, i);
            // redis.expire(bitKey, 0);
        }
    }


    private String getBitKey(String key, long bucketIndex) {
        return new StringBuffer(key).append("_").append(bucketIndex).toString();
    }

    /**
     * 将java中的bitmap转换为redis的字节数组
     *
     */
    private byte[] getByteArray(List<Long> bits) {
        Iterator<Long> iterator = bits.iterator();
        BitSet bitSet = new BitSet();
        while (iterator.hasNext()) {
            long offset = iterator.next();
            bitSet.set((int) offset);
        }
        byte[] targetBitmap = bitSet.toByteArray();
        convertJavaToRedisBitmap(targetBitmap);
        return targetBitmap;
    }

    /**
     * 将java中的字节数组转换为redis的bitmap数据形式
     *
     * @param bytes
     */
    private static void convertJavaToRedisBitmap(byte[] bytes) {
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            byte b1 = bytes[i];
            if (b1 == 0) {
                continue;
            }
            byte transByte = 0;
            for (byte j = 0; j < 8; j++) {
                transByte |= (b1 & (1 << j)) >> j << (7 - j);
            }
            bytes[i] = transByte;
        }
    }

}
