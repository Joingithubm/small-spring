package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.ConstantInfo;
import com.zeng.jvm.classfile.constantpool.ConstantPool;

import java.util.Map;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:13
 * @Description
 */
public class ConstantMemberRefInfo implements ConstantInfo {

    protected ConstantPool constantPool;
    protected int classIdx;
    private int nameAndTypeIdx;

    public ConstantMemberRefInfo(ConstantPool constantPool){
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUint16();
        this.nameAndTypeIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return 0;
    }

    public String className(){
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> nameAndDescriptor(){
        return this.constantPool.getNameAndType(this.nameAndTypeIdx);
    }
}
