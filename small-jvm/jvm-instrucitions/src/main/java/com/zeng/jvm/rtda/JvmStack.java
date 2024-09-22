package com.zeng.jvm.rtda;

/**
 * @Author fanchao
 * @Date 2024/09/19/9:32
 * @Description
 */
public class JvmStack {

    private int maxSize;
    private int size;
    private Frame _top;

    public JvmStack(int maxSize){
        this.maxSize = maxSize;
    }

    public void push(Frame frame){
        if (this.size > this.maxSize) {
            throw new StackOverflowError();
        }

        if (this._top != null) {
            frame.lower = this._top;
        }

        this._top = frame;
        this.size ++;
    }

    public Frame pop(){
        if (this._top == null){
            throw new RuntimeException("Jvm stack is empty!");
        }

        Frame top = this._top;
        this._top = top.lower;
        top.lower = null;
        size--;

        return top;
    }

    public Frame top(){
        if (this._top == null){
            throw new RuntimeException("Jvm stack is empty!");
        }
        return this._top;
    }
}
