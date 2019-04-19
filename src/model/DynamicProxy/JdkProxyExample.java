package model.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    private Object target=null;

    public Object bind(Object trget) {
        this.target=trget;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        System.out.println("before  invoke");
        Object obj=method.invoke(target,args);
        System.out.println("after invoke");
        return obj;
    }
}
