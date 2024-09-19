package com.zeng.jvm.classfile.constantpool.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.ConstantInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/15:49
 * @Description
 */
public class ConstantUtf8Info implements ConstantInfo {

    private String str;

    @Override
    public void readInfo(ClassReader reader) {
        int length = reader.readUint16();
        byte[] bytes = reader.readBytes(length);
        this.str = new String(bytes);
    }

    @Override
    public int tag() {
        return CONSTANT_TAG_UTF8;
    }

    public String str(){
        return this.str;
    }
}
