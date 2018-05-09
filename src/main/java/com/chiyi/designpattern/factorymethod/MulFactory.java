package com.chiyi.designpattern.factorymethod;

import com.chiyi.designpattern.factory.Operation;
import com.chiyi.designpattern.factory.OperationAdd;
import com.chiyi.designpattern.factory.OperationMul;

/**
 * Created by 溢
 */
public class MulFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}
