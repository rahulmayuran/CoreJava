package com.metajava.JVM;

/*A dummy class to call the methods, class and fields from JVM's Class type*/
public class SampleClass {

    private int CPU;
    private int memory;

    public int getCPU() {
        return CPU;
    }

    public void setCPU(int CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "SampleClass{" +
                "CPU=" + CPU +
                ", memory=" + memory +
                '}';
    }
}
