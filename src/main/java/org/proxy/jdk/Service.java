package org.proxy.jdk;

/**
 * Created by Admin on 2017/5/4.
 * 该类是所有被代理类的接口，jdk实现的代理要求被代理类基于统一的接口
 */
public interface Service {

    /**
     * add方法
     */
    void add();

    /**
     * update方法
     */
    void update();
}
