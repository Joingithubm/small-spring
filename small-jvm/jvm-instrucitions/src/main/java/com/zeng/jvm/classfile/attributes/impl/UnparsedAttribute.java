package com.zeng.jvm.classfile.attributes.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.attributes.AttributeInfo;

/**
 * @Author: fanchao
 * @Date: 2024-09-13 21:45
 * @Description:
 **/
public class UnparsedAttribute implements AttributeInfo {

    private String name;
    private int length;
    private byte[] info;


    public UnparsedAttribute(String attrName, int attrLen){
        this.name = attrName;
        this.length = attrLen;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.info = reader.readBytes(this.length);
    }

    public byte[] info(){
        return this.info;
    }
}
