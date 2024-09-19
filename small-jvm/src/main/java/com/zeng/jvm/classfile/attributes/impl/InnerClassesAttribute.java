package com.zeng.jvm.classfile.attributes.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.attributes.AttributeInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/16:33
 * @Description
 */
public class InnerClassesAttribute implements AttributeInfo {

    private InnerClassInfo[] classes;

    @Override
    public void readInfo(ClassReader reader) {
        int numberOfClasses = reader.readUint16();
        this.classes = new InnerClassInfo[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++) {
            classes[i] = new InnerClassInfo(reader.readUint16(), reader.readUint16(), reader.readUint16(), reader.readUint16());
        }
    }

    static class InnerClassInfo{

        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private int innerClassAccessFlags;

        public InnerClassInfo(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccessFlags) {
            this.innerClassInfoIndex = innerClassInfoIndex;
            this.outerClassInfoIndex = outerClassInfoIndex;
            this.innerNameIndex = innerNameIndex;
            this.innerClassAccessFlags = innerClassAccessFlags;
        }
    }
}
