package com.zeng.jvm.instructions.base;

/**
 * @Author: fanchao
 * @Date: 2024-09-21 18:55
 * @Description:
 **/
public class BytecodeReader {

    private byte[] codes;
    private int pc;

    public void reset(byte[] codes, int pc){
        this.codes = codes;
        this.pc = pc;
    }

    public int pc(){
        return this.pc;
    }

    // [go]int8 = [java]byte
    public byte readByte(){
        byte code = this.codes[this.pc];
        this.pc++;
        return code;
    }

    // [go]int16 = [java]short
    public short readShort(){
        byte byte1 = readByte();
        byte byte2 = readByte();
        return (short) ((byte1 << 8) | byte2);
    }

    public int readInt(){
        byte byte1 = this.readByte();
        byte byte2 = this.readByte();
        byte byte3 = this.readByte();
        byte byte4 = this.readByte();
        return (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
    }

    // used by lookupSwitch and tableSwitch
    public int[] readInts(int n){
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = this.readInt();
        }
        return ints;
    }

    // used by lookupSwitch and tableSwitch
    public void skipPadding(){
        while (this.pc % 4 != 0){
            this.readByte();
        }
    }
}
