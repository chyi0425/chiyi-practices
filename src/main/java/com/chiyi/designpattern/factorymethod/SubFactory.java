package com.chiyi.designpattern.factorymethod;

import com.chiyi.designpattern.factory.Operation;
import com.chiyi.designpattern.factory.OperationSub;

/**
 * Created by 溢
 */
public class SubFactory implements Factory{
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
