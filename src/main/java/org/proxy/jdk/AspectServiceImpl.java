package org.proxy.jdk;

/**
 * Created by Admin on 2017/5/4.
 * 被代理类，即目标类
 */
public class AspectServiceImpl implements Service {

    /**
     * (non-Javadoc)
     *
     * @see Service#add()
     */
    @Override
    public void add() {
        System.out.println("AspectServiceImpl add>>>>>>>>>>>>>>>>>>");
    }

    /**
     * (non-Javadoc)
     *
     * @see Service#update()
     */
    @Override
    public void update() {
        System.out.println("AspectServiceImpl update>>>>>>>>>>>>>>>");
    }
}
