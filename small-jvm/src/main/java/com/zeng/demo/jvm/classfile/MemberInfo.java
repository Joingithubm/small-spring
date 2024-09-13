package com.zeng.demo.jvm.classfile;

import com.zeng.demo.jvm.classfile.attributes.AttributeInfo;
import com.zeng.demo.jvm.classfile.attributes.impl.CodeAttribute;
import com.zeng.demo.jvm.classfile.attributes.impl.ConstantValueAttribute;
import com.zeng.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @Author fanchao
 * @Date 2024/09/13/10:50
 * @Description
 */
public class MemberInfo {

    private ConstantPool constantPool;
    private int accessFlags;
    private int nameIdx;
    private int descriptorIdx;
    private AttributeInfo[] attributes;

    private MemberInfo(ClassReader reader, ConstantPool constantPool){
        this.constantPool = constantPool;
        this.accessFlags = reader.readUint16();
        this.nameIdx = reader.readUint16();
        this.descriptorIdx = reader.readUint16();
        this.attributes = AttributeInfo.readAttributes(reader, constantPool);
    }

    static MemberInfo[] readMembers(ClassReader reader, ConstantPool constantPool){
        int fieldCount = reader.readUint16();
        MemberInfo[] fields = new MemberInfo[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            fields[i] = new MemberInfo(reader, constantPool);
        }
        return fields;
    }

    public int accessFlags(){
        return this.accessFlags;
    }

    public String name(){
        return this.constantPool.getUTF8(this.nameIdx);
    }

    public String descriptor(){
        return this.constantPool.getUTF8(this.descriptorIdx);
    }

    public CodeAttribute codeAttribute(){
        for (AttributeInfo attribute : attributes) {
            if (attribute instanceof CodeAttribute) return (CodeAttribute) attribute;
        }
        return null;
    }

    public ConstantValueAttribute ConstantValueAttribute(){
        for (AttributeInfo attribute : attributes) {
            if (attribute instanceof ConstantValueAttribute) return (ConstantValueAttribute) attribute;
        }
        return null;
    }
}
