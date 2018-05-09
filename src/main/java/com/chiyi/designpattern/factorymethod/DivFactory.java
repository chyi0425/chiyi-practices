package com.chiyi.designpattern.factorymethod;

import com.chiyi.designpattern.factory.Operation;
import com.chiyi.designpattern.factory.OperationAdd;
import com.chiyi.designpattern.factory.OperationDiv;

/**
 * Created by 溢
 */
public class DivFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
