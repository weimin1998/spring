package com.weimin.demo3.mains;

import com.weimin.demo3.beans.Bean1;
import com.weimin.demo3.beans.Bean2;
import com.weimin.demo3.beans.Bean3;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        // GenericApplicationContext是一个【干净】的容器，没有任何的后处理器
        // 因此 bean1 中的注解都不会被解析
        // 后面的测试Main中，会逐个添加beanPostProcessor
        GenericApplicationContext context = new GenericApplicationContext();

        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);

        // 解析@Autowired, @Value
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        // 但是，无法解析${JAVA_HOME}，会报异常NoSuchBeanDefinitionException

        context.refresh();
        context.close();

    }
}
