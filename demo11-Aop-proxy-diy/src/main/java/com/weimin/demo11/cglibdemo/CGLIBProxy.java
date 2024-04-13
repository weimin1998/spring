package com.weimin.demo11.cglibdemo;

import com.weimin.demo11.cglibdemo.CGLIBDemo.*;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class CGLIBProxy extends Target {

    private MethodInterceptor methodInterceptor;

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    static Method save;
    static Method saveInt;
    static Method saveLong;

    static {
        try {
            save = Target.class.getMethod("save");
            saveInt = Target.class.getMethod("save", int.class);
            saveLong = Target.class.getMethod("save", long.class);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    @Override
    public void save() {
        try {
            methodInterceptor.intercept(this, save, new Object[0], saveSuperProxy);
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public void save(int i) {
        try {
            methodInterceptor.intercept(this, saveInt, new Object[]{i}, saveSuperIntProxy);
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public void save(long l) {
        try {
            methodInterceptor.intercept(this, saveLong, new Object[]{l}, saveSuperLongProxy);
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    static MethodProxy saveSuperProxy;
    static MethodProxy saveSuperIntProxy;
    static MethodProxy saveSuperLongProxy;

    static {
        saveSuperProxy = MethodProxy.create(Target.class, CGLIBProxy.class, "()V", "save", "saveSuper");
        saveSuperIntProxy = MethodProxy.create(Target.class, CGLIBProxy.class, "(I)V", "save", "saveSuper");
        saveSuperLongProxy = MethodProxy.create(Target.class, CGLIBProxy.class, "(J)V", "save", "saveSuper");
    }

    public void saveSuper() {
        super.save();
    }

    public void saveSuper(int i) {
        super.save(i);
    }

    public void saveSuper(long l) {
        super.save(l);
    }
}