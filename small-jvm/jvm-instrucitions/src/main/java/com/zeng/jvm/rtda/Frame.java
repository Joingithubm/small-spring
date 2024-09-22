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

    private Thread thread;

    private int nextPC;

    public Frame(Thread thread, int maxLocals, int maxStack){
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars localVars() {
        return localVars;
    }

    public OperandStack operandStack() {
        return operandStack;
    }

    public Thread thead(){
        return this.thread;
    }

    public int nextPC(){
        return this.nextPC;
    }

    public void setNextPC(int nextPC){
        this.nextPC = nextPC;
    }
}
