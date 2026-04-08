package entity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {

    private int size = 0; //逻辑长度
    private int capacity = 8; //容量
    private int[] array;  //初始化数组

    /**
     * 空参构造
     */
    public DynamicArray() {
        array = new int[capacity];
    }

    /**
     * 获取数组长度
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * 插入数据(尾插)
     *
     * @param e 要插入的数据
     */
    public void add(int e) {
        array[size++] = e;
    }

    /**
     * 插入数据(索引指定)
     *
     * @param e     要插入的数据
     * @param index 插入索引
     */
    public void add(int e, int index) {
        if (0 <= index && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = e;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * 遍历方式1 consumer
     *
     * @return void
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方式2 Iterator （即增强for）
     * @return Iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
    }

    /**
     * 遍历方式3 stream
     * @return IntStream
     */
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }

}
