package com.zeng.demo.jvm.classfile.constantpool.impl;

import com.zeng.demo.jvm.classfile.ClassReader;
import com.zeng.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:45
 * @Description
 */
public class ConstantNameAndTypeInfo implements ConstantInfo {

    public int nameIdx;
    public int descIdx;
    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUint16();
        this.descIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_NAMEANDTYPE;
    }
}
