package com.hlj.util.Z005BiMap.redis实现压缩BitMap;

/**
 * CompressedBitTookit
 *
 * @author zhangyujin
 * @date 2024/9/14
 */
public class CompressedBitTookit {

    /**
     * 通大小
     */
    public static final long DEFAULT_BUCKET_SIZE = 65536L;

    public static CompressedBitInfo getBitInfo(long sourceOffset, long bucketSize) {
        CompressedBitInfo bucketInfo = new CompressedBitInfo();
        bucketInfo.setSourceOffset(sourceOffset);

        long bucketIndex = sourceOffset / bucketSize;
        bucketInfo.setBucketIndex(bucketIndex);

        long bucketOffset = sourceOffset % bucketSize;
        bucketInfo.setBucketOffset(bucketOffset);
        return bucketInfo;
    }
    public static CompressedBitInfo getBitInfo(long sourceOffset) {
        return getBitInfo(sourceOffset, DEFAULT_BUCKET_SIZE);
    }

    public static long getSourceOffset(long bucketIndex, long bucketSize, long bucketOffset) {
        return bucketIndex * bucketSize + bucketOffset;
    }
    public static long getSourceOffset(long bucketIndex,  long bucketOffset) {
        return getSourceOffset(bucketIndex, DEFAULT_BUCKET_SIZE, bucketOffset);
    }

}
