package com.chiyi.lambda;


import java.math.BigDecimal;
import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> predicate = x -> x >185;

        Student student = new Student("Alex",23,175);
        System.out.println("Alex的身高高于185吗？："+predicate.test(student.getStature()));

        // Consumer
        Consumer<String> consumer = System.out::println;
        consumer.accept("我命由我不由天");

        // Function
        Function<Student,String> function = Student::getName;
        String name = function.apply(student);
        consumer.accept(name);

        // Supplier
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        consumer.accept(supplier.get().toString());

        // UnaryOperator
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);

        // BinaryOperator
        BinaryOperator<Integer> operator = (x,y)->x*y;
        Integer integer = operator.apply(2,3);
        System.out.println(integer);

        test(()->"我是一个演示的函数式接口");
    }

    public static void test(Worker worker){
        String work = worker.work();
        System.out.println(work);
    }

    public interface Worker{
        String work();
    }
}
