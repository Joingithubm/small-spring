package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.constantpool.ConstantInfo;
import com.zeng.jvm.classfile.constantpool.ConstantPool;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:21
 * @Description
 */
public class ConstantInterfaceMethodRefInfo extends ConstantMemberRefInfo{
    public ConstantInterfaceMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return ConstantInfo.CONSTANT_TAG_INTERFACEMETHODREF;
    }
}
