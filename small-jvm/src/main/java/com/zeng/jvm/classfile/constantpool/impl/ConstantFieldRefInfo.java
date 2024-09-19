package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.constantpool.ConstantPool;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:12
 * @Description
 */
public class ConstantFieldRefInfo extends ConstantMemberRefInfo{
    public ConstantFieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }
    @Override
    public int tag() {
        return this.CONSTANT_TAG_FIELDREF;
    }
}
