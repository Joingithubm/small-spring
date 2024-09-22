package com.zeng.jvm.instructions.base;

import com.zeng.jvm.rtda.Frame;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 19:11
 * @Description:
 **/
public class InstructionIndex8 implements Instruction{

    public int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {

    }

    protected void _astore(Frame frame, int idx){
        Object ref = frame.operandStack().popRef();
        frame.localVars().setRef(idx, ref);
    }

    protected void _dstore(Frame frame, int idx){
        double val = frame.operandStack().popDouble();
        frame.localVars().setDouble(idx, val);
    }

    protected void _fstore(Frame frame, int idx){
        float val = frame.operandStack().popFloat();
        frame.localVars().setFloat(idx, val);
    }
}
