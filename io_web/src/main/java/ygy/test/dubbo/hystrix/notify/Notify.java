package ygy.test.dubbo.hystrix.notify;

/**
 * Created by guoyao on 2017/11/22.
 */
public interface Notify<T> {
    public void onreturn(T t,Object... args);
    public void onthrow(Throwable ex);
}
