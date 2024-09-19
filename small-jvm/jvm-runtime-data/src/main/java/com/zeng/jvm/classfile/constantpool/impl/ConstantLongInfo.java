package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.ConstantInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:24
 * @Description
 */
public class ConstantLongInfo implements ConstantInfo {

    private long val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TLong();
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_LONG;
    }

    public long value(){
        return this.val;
    }
}
