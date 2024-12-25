package com.hlj.util.Z005BiMap.模拟bitMap;

/**
 * CompressedBitmap
 *
 * @author zhangyujin
 * @date 2024/9/14
 */
public class CompressedBitmap {

    public static final char Y = 1;

    public static final char N = 0;
    public static final int ARRAY_CONTAINER_SIZE = 16;

    ArrayContainer[] containers;


    /**
     * 初始化容量（计算容器数量，当前按照一个容器16进行拆分）
     *
     * @param initialCapacity initialCapacity
     * @return {@link }
     */
    public CompressedBitmap(long initialCapacity) {
        int containersSize = (int) (initialCapacity / ARRAY_CONTAINER_SIZE);
        this.containers = new ArrayContainer[containersSize];
    }

    /**
     * bitMap添加数据
     *
     * @param offset offset
     */
    public void add(long offset) {

        // 1、根据偏移量定位容器所在分片
        int shardIndex = getShardIndex(offset);
        ArrayContainer container = containers[shardIndex];
        if (container == null) {
            container = new ArrayContainer(ARRAY_CONTAINER_SIZE);
        }

        // 2、根据偏移量定位容器内部位置
        int shardOffset = getShardOffset(offset);
        container.values[shardOffset] = Y;
        containers[shardIndex] = container;
    }


    /**
     * 获取偏移量数据
     *
     * @param offset offset
     * @return 获取值（1 || 0）
     */
    public int get(long offset) {
        int shardIndex = getShardIndex(offset);
        ArrayContainer container = containers[shardIndex];
        if (container == null) {
            return N;
        }

        int shardOffset = getShardOffset(offset);
        if (Y == container.values[shardOffset]) {
            return Y;
        }
        return N;
    }

    /**
     * 根据偏移量定位容器所在分片
     *
     * @param offset offset
     * @return {@link int}
     */
    public int getShardIndex(long offset) {
        return (int) ((offset - 1) / ARRAY_CONTAINER_SIZE);
    }

    /**
     * 根据偏移量定位容器内部位置
     *
     * @param offset offset
     * @return {@link int}
     */
    public int getShardOffset(long offset) {
        return (int) (offset % ARRAY_CONTAINER_SIZE);
    }


}
