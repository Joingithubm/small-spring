package com.zeng.jvm;

import com.zeng.jvm.classfile.MemberInfo;
import com.zeng.jvm.classfile.attributes.impl.CodeAttribute;
import com.zeng.jvm.instructions.base.BytecodeReader;
import com.zeng.jvm.rtda.Frame;
import com.zeng.jvm.rtda.Thread;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 19:42
 * @Description: 指令集解释器
 **/
class Interpret {

    Interpret(MemberInfo m){
        CodeAttribute codeAttr = m.codeAttribute();
        int maxLocals = codeAttr.maxLocals();
        int maxStack = codeAttr.maxStack();
        byte[] byteCode = codeAttr.data();
        Thread thread = new Thread();
        Frame frame = thread.newFrame(maxLocals, maxStack);
        thread.pushFrame(frame);
        loop(thread, byteCode);
    }

    private void loop(Thread thread, byte[] byteCode) {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();

        while (true){
            // 循环
            int pc = frame.nextPC();
            thread.setPC(pc);
            // decode


        }
    }
}
