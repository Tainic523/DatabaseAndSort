package DynamicProxy;

import java.lang.reflect.Proxy;

public class proxyTest {
    public static void main(String[] args) {
    Girl girl = new wangmeili();
    GirlProxy handler = new GirlProxy(girl);
    Girl mother = (Girl) handler.getProxyInstances();
        mother.date();
        mother.watchMovie();

    Girl father = (Girl) Proxy.newProxyInstance(girl.getClass().getClassLoader(),girl.getClass().getInterfaces(),handler);
    father.date();
    father.watchMovie();
    }
}
