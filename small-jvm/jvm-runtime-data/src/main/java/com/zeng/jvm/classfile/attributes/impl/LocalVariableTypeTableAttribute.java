package com.zeng.jvm.classfile.attributes.impl;

import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.attributes.AttributeInfo;

/**
 * @Author fanchao
 * @Date 2024/09/13/17:02
 * @Description
 */
public class LocalVariableTypeTableAttribute implements AttributeInfo {

    private LocalVariableTypeTableEntry[] localVariableTypeTable;


    @Override
    public void readInfo(ClassReader reader) {
        int localVariableTypeTableLength = reader.readUint16();
    }

    static class LocalVariableTypeTableEntry{
        private int startPC;
        private int length;
        private int nameIndex;
        private int signatureIndex;
        private int index;

        public LocalVariableTypeTableEntry(int startPC, int length, int nameIndex, int signatureIndex, int index) {
            this.startPC = startPC;
            this.length = length;
            this.nameIndex = nameIndex;
            this.signatureIndex = signatureIndex;
            this.index = index;
        }
    }
}
