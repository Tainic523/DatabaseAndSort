package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GirlProxy implements InvocationHandler {
    private Girl girl;

    public GirlProxy(Girl girl) {
        super();
        this.girl = girl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object o = method.invoke(girl, args);
        doSomethingAfter();
        return o;
    }

    private void doSomethingAfter() {
        System.out.println("....after.....");
    }

    private void doSomethingBefore() {
        System.out.println(".....before......");
    }

    public Object getProxyInstances() {
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }
}
