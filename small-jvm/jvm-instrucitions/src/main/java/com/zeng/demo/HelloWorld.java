package com.zeng.demo;

/**
 * @Author fanchao
 * @Date 2024/09/13/10:50
 * @Description
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println(circumference(1.6f));
    }

    public static float circumference(float r){
        float pi = 3.14f;
        float area = 2 * pi * r;
        return area;
    }
}
