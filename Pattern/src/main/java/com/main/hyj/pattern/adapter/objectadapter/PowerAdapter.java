package com.main.hyj.pattern.adapter.objectadapter;

/**
 * create by flytohyj  2019/7/23
 **/
public class PowerAdapter implements DC5{

    private AC220 ac220;

    public PowerAdapter(AC220 ac220){
        this.ac220 =ac220;
    }


    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        //变压器...
        int adapterOutput = adapterInput/44;
        System.out.println("使用PowerAdapter 输入AC:"+adapterInput+"V"+"输出DC:"+adapterOutput+"V");
        return adapterOutput;
    }
}
