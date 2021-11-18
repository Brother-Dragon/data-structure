package com.black.jvm;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author Citrus
 * @date 2021/11/17 15:58
 */
public class JvmTest {
    @Test
    public void testJvm()  {
        //# Running 64-bit HotSpot VM.                  ——表示使用64位的虚拟机
        //# Using compressed oop with 3-bit shift.      ——表示启用了普通对象指针压缩，即-XX:+UseCompressedOops。
        //# Using compressed klass with 3-bit shift.    ——表示启用了类型指针压缩，即-XX:+UseCompressedClassPointers开启参数。
        //# Objects are 8 bytes aligned.                ——对象的大小必须8bytes对齐。
        //# Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]  ——表示字段类型的指针长度
        //# Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]  ——表示数组类型的指针长度
        System.out.println(VM.current().details());
    }

    @Test
    public void testObj() throws Exception {
        //java.lang.Object object internals:        ——object对象的内部布局
        //OFFSET[对象内部的某个偏移量，作为某部分的起始位置]
        //SIZE[对应的组成部分的大小，单位是bytes]
        //TYPE DESCRIPTION[该部分的类型说明]
        //VALUE[字节的具体值]
        //也就是说Object这个对象有16bytes，12bytes的对象头和4bytes的对齐填充，对象头有8bytes的Mark Word，4bytes的class pointer
        // OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
        //      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
        //      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
        //      8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
        //     12     4        (loss due to the next object alignment)
        //Instance size: 16 bytes
        //Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }
}
