package com.zeng.jvm.instructions.base;

import com.zeng.jvm.rtda.Frame;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 18:49
 * @Description:
 **/
public interface Instruction {

    void fetchOperands(BytecodeReader reader);

    void execute(Frame frame);

    static void branch(Frame frame, int offset){
        int pc = frame.thead().pc();
        int nextPC = pc + offset;
        frame.setNextPC(nextPC);
    }
}
