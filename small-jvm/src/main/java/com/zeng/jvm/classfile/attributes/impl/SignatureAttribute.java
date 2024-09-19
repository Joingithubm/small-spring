package com.zeng.jvm.classfile.attributes.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.ConstantPool;
import com.zeng.jvm.classfile.attributes.AttributeInfo;

/**
 * @Author: fanchao
 * @Date: 2024-09-13 21:39
 * @Description:
 **/
public class SignatureAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int signatureIdx;

    public SignatureAttribute(ConstantPool constantPool){
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.signatureIdx = reader.readUint16();
    }

    public String signature(){
        return this.constantPool.getUTF8(this.signatureIdx);
    }
}
