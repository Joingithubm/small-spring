package com.zeng.jvm.rtda;

/**
 * @Author fanchao
 * @Date 2024/09/19/9:32
 * @Description
 */
public class Thread {

    /**
     * program Counter 寄存器
     */
    private int pc;

    private JvmStack stack;

    public Thread(){
        this.stack = new JvmStack(1024);
    }

    public int pc(){
        return this.pc;
    }

    public void setPC(int pc){
        this.pc = pc;
    }

    public void pushFrame(Frame frame){
        this.stack.push(frame);
    }

    public Frame popFrame(){
        return this.stack.pop();
    }

    public Frame currentFrame(){
        return this.stack.top();
    }

    public Frame newFrame(int maxLocals, int maxStack){
        return new Frame(this, maxLocals, maxStack);
    }
}
