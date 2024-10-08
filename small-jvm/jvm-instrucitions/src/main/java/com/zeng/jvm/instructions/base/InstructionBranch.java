package com.zeng.jvm.instructions.base;

import com.zeng.jvm.rtda.Frame;
import com.zeng.jvm.rtda.OperandStack;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 19:08
 * @Description:
 **/
public class InstructionBranch implements Instruction{

    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }

    protected boolean _acmp(Frame frame){
        OperandStack stack = frame.operandStack();
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        return ref1.equals(ref2);
    }
}
