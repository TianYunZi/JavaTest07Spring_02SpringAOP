package org.aop.test001;

/**
 * Created by Admin on 2017/5/4.
 */
public aspect TxAspect {

    void around():call(void Hello.sayHello()){
        System.out.println("开始事务......");
        proceed();
        System.out.println("结束事务......");
    }
}
