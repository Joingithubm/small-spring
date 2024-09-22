package com.zeng.jvm.instructions;

import com.zeng.jvm.instructions.base.Instruction;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 18:47
 * @Description:
 **/
public class Factory {

    public static Instruction newInstruction(byte opcode){
        switch (opcode){
            case 0x00:
                return null;
            default:
                return null;
        }
    }
}
