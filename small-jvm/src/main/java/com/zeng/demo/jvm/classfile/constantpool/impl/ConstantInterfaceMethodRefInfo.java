package com.zeng.demo.jvm.classfile.constantpool.impl;

import com.zeng.demo.jvm.classfile.constantpool.ConstantPool;

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
        return CONSTANT_TAG_INTERFACEMETHODREF;
    }
}
