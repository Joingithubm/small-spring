package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.ConstantInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:18
 * @Description
 */
public class ConstantFloatInfo implements ConstantInfo {

    private float val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TFloat();
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_FLOAT;
    }

    public float value(){
        return val;
    }
}
