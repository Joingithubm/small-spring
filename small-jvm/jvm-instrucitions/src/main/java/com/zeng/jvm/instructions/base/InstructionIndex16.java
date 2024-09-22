package com.zeng.jvm.instructions.base;

import com.zeng.jvm.rtda.Frame;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 19:19
 * @Description:
 **/
public class InstructionIndex16 implements Instruction{

    protected int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }
}
