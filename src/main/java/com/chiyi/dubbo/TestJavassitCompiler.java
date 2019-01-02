package com.chiyi.dubbo;

import javassist.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chiyi
 * @date 2019/1/2.
 */
public class TestJavassitCompiler {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.chiyi.dubbo.Emp");
        // 添加属性
        CtField nameField = new CtField(pool.getCtClass("java.lang.String"), "name", ctClass);
        nameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(nameField);

        CtField accountField = new CtField(pool.getCtClass("int"), "account", ctClass);
        accountField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(accountField);

        // getter setter
        ctClass.addMethod(CtNewMethod.getter("getName", nameField));
        ctClass.addMethod(CtNewMethod.setter("setName", nameField));
        ctClass.addMethod(CtNewMethod.getter("getAccount", accountField));
        ctClass.addMethod(CtNewMethod.setter("setAccount", accountField));

        // constructor
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        String body = new StringBuilder("{this.account = 1;\n" +
                "        this.name = \"test\";\n}").toString();
        ctConstructor.setBody(body);
        ctClass.addConstructor(ctConstructor);

        CtMethod ctMethod = new CtMethod(CtClass.voidType,"commonMethod",new CtClass[]{},ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody(new StringBuilder("{\n System.out.println(\"haha\"); \n}").toString());
        ctClass.addMethod(ctMethod);

        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        obj.getClass().getMethod("commonMethod",new Class[]{}).invoke(obj,new Object[]{});

        byte[] codeByteArray = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("Emp.class"));
        fos.write(codeByteArray);
        fos.close();
    }
}
