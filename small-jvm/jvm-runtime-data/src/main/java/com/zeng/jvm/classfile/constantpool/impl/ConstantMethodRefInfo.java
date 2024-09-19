package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.constantpool.ConstantPool;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:42
 * @Description
 */
public class ConstantMethodRefInfo extends ConstantMemberRefInfo{
    public ConstantMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_METHODREF;
    }
}
