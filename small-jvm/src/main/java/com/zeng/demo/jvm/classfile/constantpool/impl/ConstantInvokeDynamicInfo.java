package com.zeng.demo.jvm.classfile.constantpool.impl;

import com.zeng.demo.jvm.classfile.ClassReader;
import com.zeng.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:23
 * @Description
 */
public class ConstantInvokeDynamicInfo implements ConstantInfo {

    private int bootstrapMethodAttrIdx;
    private int nameAndTypeIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.bootstrapMethodAttrIdx = reader.readUint16();
        this.nameAndTypeIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_INVOKEDYNAMIC;
    }
}
