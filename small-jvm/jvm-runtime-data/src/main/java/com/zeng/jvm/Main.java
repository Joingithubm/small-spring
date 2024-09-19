package com.zeng.jvm;


import com.zeng.jvm.classfile.ClassFile;
import com.zeng.jvm.classfile.MemberInfo;
import com.zeng.jvm.classpath.Classpath;

import java.io.IOException;
import java.util.Arrays;

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
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath:%s class:%s args:%s\n", classpath, cmd.getMainClass(), cmd.getAppArgs());
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, classpath);
        assert classFile != null;
        printClassInfo(classFile);
    }

    private static ClassFile loadClass(String className, Classpath classpath){
        try {
            byte[] classData = classpath.readClass(className);
            return new ClassFile(classData);
        } catch (IOException e) {
            System.out.println("Could not find or load main class" + className);
            return null;
        }
    }

    private static void printClassInfo(ClassFile cf) {

        System.out.println("version: " + cf.majorVersion() + "." + cf.minorVersion());
        System.out.println("constants count: " + cf.constantPool().size());
        System.out.format("access flags: 0x%x\n", cf.accessFlags());
        System.out.println("this class: " + cf.className());
        System.out.println("super class: " + cf.superClassName());
        System.out.println("interfaces: " + Arrays.toString(cf.interfaceNames()));
        System.out.println("fields count: " + cf.fields().length);
        for (MemberInfo field : cf.fields()) {
            System.out.printf("%s \t\t %s \n", field.name(), field.descriptor());
        }

        System.out.printf("methods count: " + cf.methods().length);
        for (MemberInfo method : cf.methods()) {
            System.out.printf("%s \t\t %s\n", method.name(), method.descriptor());
        }

    }
}
