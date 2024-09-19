package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.ConstantInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:20
 * @Description
 */
public class ConstantIntegerInfo implements ConstantInfo {

    private int val;
    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint32TInteger();
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_INTEGER;
    }

    public int value(){
        return this.val;
    }
}
