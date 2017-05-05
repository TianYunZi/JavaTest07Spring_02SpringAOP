package org.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Admin on 2017/5/4.
 */
public class ProxyTeatJdk {

    public static void main(String[] args) {
        Service service = new AspectServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(service);
        // Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例
        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        serviceProxy.add();
        System.out.println();
        serviceProxy.update();
    }
}
