package com.chiyi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

/**
 * @author chiyi
 * @date 2018/12/28.
 */
public class TestExtension {
    public static void main(String[] args) {
        ExtensionLoader<Protocol> loader = ExtensionLoader.getExtensionLoader(Protocol.class);
        /**
         * ExtensionLoader.getExtensionLoader(Protocol.class);
         *  new ExtensionLoader<T>(type)
         *      objectFactory = (type == ExtensionFactory.class ? null : ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension());
         *  当前创建的ExtensionLoader对象（我们取名为ExtensionLoader对象1）的type是com.alibaba.dubbo.rpc.Protocol，
         *  所以此时会执行：ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension()。
         *  ExtensionLoader.getExtensionLoader(ExtensionFactory.class)
         *  也会执行new ExtensionLoader<T>(type)创建另外一个ExtensionLoader对象,
         *  type是com.alibaba.dubbo.common.extension.ExtensionFactory，而objectFactory是null
         *  之后，这个ExtensionLoader对象2被放入EXTENSION_LOADERS缓存
         *  之后执行ExtensionLoader对象2的getAdaptiveExtension()方法
         *  会调用loadFile（
         *  1 加载dir目录下的指定type名称的文件(例如:dubbo-2.5.5.jar中的/META-INF/dubbo/internal/com.alibaba.dubbo.common.extension.ExtensionFactory)
         3      * 2 遍历该文件中的每一行
         4      * (1)获取实现类key和value, 例如 name=spi, line=com.alibaba.dubbo.common.extension.factory.SpiExtensionFactory
         5      * (2)根据line创建Class对象
         6      * (3)将具有@Adaptive注解的实现类的Class对象放在cachedAdaptiveClass缓存中, 注意该缓存只能存放一个具有@Adaptive注解的实现类的Class对象,如果有两个满足条件,则抛异常
         7      * 下面的都是对不含@Adaptive注解的实现类的Class对象:
         8      * (4)查看是否具有含有一个type入参的构造器, 如果有（就是wrapper类）, 将当前的Class对象放置到cachedWrapperClasses缓存中
         9      * (5)如果没有含有一个type入参的构造器, 获取无参构造器. 如果Class对象具有@Active注解, 将该对象以<实现类的key, active>存储起来
         10      * (6)最后,将<Class对象, 实现类的key>存入cachedNames缓存,并将这些Class存入extensionClasses中.）
         *  执行完之后
         *  cachedAdaptiveClass=class com.alibaba.dubbo.common.extension.factory.AdaptiveExtensionFactory
         extensionClasses=[{"spring","class com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory"}, {"spi", "class com.alibaba.dubbo.common.extension.factory.SpiExtensionFactory"}]，后续会这个集合存储在cachedClasses缓存中。
         AdaptiveExtensionFactory()
         这个装饰类只是实例化好了各个ExtensionFactory
         （这里是SpiExtensionFactory和SpringExtensionFactory），后续通过工厂获取实现类实例都是由具体工厂来完成。
         实例化代码的地方，即loader.getExtension(name)：
         从cachedInstances缓存中获取name对应的实例,如果没有,通过createExtension(name)创建,之后放入缓存
         从cachedClasses缓存中获取所有的实现类map,之后通过name获取到对应的实现类的Class对象
         从EXTENSION_INSTANCES缓存中获取对应的实现类的Class对象,如果没有,直接创建,之后放入缓存
        这里，就体现出来了dubbo-SPI比JDK-SPI的好处：dubbo-SPI不需要遍历所有的实现类来获取想要的实现类，可以直接通过name来获取。
         */
        /**
         *
         * ExtensionLoader<Protocol> loader = ExtensionLoader.getExtensionLoader(Protocol.class);
         * 最后来看一下整个代码的执行结果。
         * 类变量

         ConcurrentMap<Class<?>, ExtensionLoader<?>> EXTENSION_LOADERS
             "interface com.alibaba.dubbo.rpc.Protocol" -> "com.alibaba.dubbo.common.extension.ExtensionLoader[com.alibaba.dubbo.rpc.Protocol]"
             "interface com.alibaba.dubbo.common.extension.ExtensionFactory" -> "com.alibaba.dubbo.common.extension.ExtensionLoader[com.alibaba.dubbo.common.extension.ExtensionFactory]"
         ConcurrentMap<Class<?>, Object> EXTENSION_INSTANCES
             "class com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory" -> SpringExtensionFactory实例
             "class com.alibaba.dubbo.common.extension.factory.SpiExtensionFactory" -> SpiExtensionFactory实例
         ExtensionLoader<Protocol> loader的实例变量：
             Class<?> type = interface com.alibaba.dubbo.rpc.Protocol
             ExtensionFactory objectFactory = AdaptiveExtensionFactory（适配类）
                factories = [SpringExtensionFactory实例, SpiExtensionFactory实例]
         */
        final Protocol dubboProtocol = loader.getExtension("dubbo");
        final Protocol adaptiveExtension = loader.getAdaptiveExtension();
    }
}
