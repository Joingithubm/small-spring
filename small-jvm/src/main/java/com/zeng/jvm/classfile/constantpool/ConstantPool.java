package com.zeng.jvm.classfile.constantpool;

import com.zeng.jvm.classfile.constantpool.impl.ConstantNameAndTypeInfo;
import com.zeng.jvm.classfile.constantpool.impl.ConstantUtf8Info;
import com.zeng.jvm.classfile.ClassReader;
import com.zeng.jvm.classfile.constantpool.impl.ConstantClassInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fanchao
 * @Date 2024/09/13/11:00
 * @Description
 */
public class ConstantPool {

    private ConstantInfo[] constantInfos;
    private int size;

    public ConstantPool(ClassReader reader){
        size = reader.readUint16();
        constantInfos = new ConstantInfo[size];
        for (int i = 1; i < size; i++) {

            constantInfos[i] = ConstantInfo.readConstantInfo(reader, this);

            switch (constantInfos[i].tag()){
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                case ConstantInfo.CONSTANT_TAG_LONG:
                        i++;
                        break;
            }
        }
    }

    public Map<String, String> getNameAndType(int idx){
        ConstantNameAndTypeInfo constantInfo = (ConstantNameAndTypeInfo) this.constantInfos[idx];
        Map<String, String> map = new HashMap<>();
        map.put("name", this.getUTF8(constantInfo.nameIdx));
        map.put("_type", this.getUTF8(constantInfo.descIdx));
        return map;
    }

    public String getClassName(int idx){
        ConstantClassInfo classInfo = (ConstantClassInfo) this.constantInfos[idx];
        return this.getUTF8(classInfo.nameIdx);
    }

    public String getUTF8(int idx){
        ConstantUtf8Info utf8Info = (ConstantUtf8Info) this.constantInfos[idx];
        return utf8Info == null ? "" : utf8Info.str();
    }

    public ConstantInfo[] getConstantInfos(){
        return constantInfos;
    }

    public void setConstantInfos(ConstantInfo[] constantInfos){
        this.constantInfos = constantInfos;
    }

    public int size(){
        return size;
    }
}
