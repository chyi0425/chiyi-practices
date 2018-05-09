package com.chiyi.designpattern.factorymethod;

import com.chiyi.designpattern.factory.Operation;
import com.chiyi.designpattern.factory.OperationAdd;

/**
 * Created by 溢
 */
public class AddFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
