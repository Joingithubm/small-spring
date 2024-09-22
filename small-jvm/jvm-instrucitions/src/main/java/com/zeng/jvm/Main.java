package com.zeng.jvm;


import com.zeng.jvm.rtda.Frame;
import com.zeng.jvm.rtda.LocalVars;
import com.zeng.jvm.rtda.OperandStack;

/**
 * @Author: fanchao
 * @Date: 2024-09-12 21:02
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {

        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Frame frame = new Frame(100, 100);
        test_localVars(frame.localVars());
        test_operandStack(frame.operandStack());
    }

    private static void test_localVars(LocalVars vars){
        vars.setInt(0, 100);
        vars.setInt(1, -100);
        System.out.println(vars.getInt(0));
        System.out.println(vars.getInt(1));
    }

    private static void test_operandStack(OperandStack ops){
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popInt());
    }

}
