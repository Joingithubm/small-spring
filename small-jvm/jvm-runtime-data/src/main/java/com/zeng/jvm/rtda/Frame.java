package com.zeng.jvm.rtda;

/**
 * @Author fanchao
 * @Date 2024/09/19/9:31
 * @Description
 */
public class Frame {

    Frame lower;
    /**
     * 局部变量表
     */
    private LocalVars localVars;
    /**
     * 操作数栈
     */
    private OperandStack operandStack;

    public Frame(int maxLocals, int maxStack){
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars localVars() {
        return localVars;
    }

    public OperandStack operandStack() {
        return operandStack;
    }
}
