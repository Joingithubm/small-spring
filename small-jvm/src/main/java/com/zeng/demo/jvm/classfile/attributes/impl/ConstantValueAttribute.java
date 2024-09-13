package com.zeng.demo.jvm.classfile.attributes.impl;

import com.zeng.demo.jvm.classfile.ClassReader;
import com.zeng.demo.jvm.classfile.attributes.AttributeInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/16:27
 * @Description
 */
public class ConstantValueAttribute implements AttributeInfo {

    private int constantValueIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.constantValueIdx = reader.readUint16();
    }

    public int getConstantValueIdx(){
        return this.constantValueIdx;
    }
}
