package com.chiyi.designpattern.factory;

/**
 * Created by 溢
 */
public class OperationFactory {
    public  static Operation createOperation(String operator){
        Operation oper = null;
        switch (operator){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}
