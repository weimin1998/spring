package com.weimin.demo2;

import java.util.ArrayList;
import java.util.List;

// 模板方法
// 固定不变的逻辑不要动，会变化的逻辑可以抽取成接口
// 扩展时，不需要改动getBean方法
public class TemplateMethod {
    public static void main(String[] args) {
        MyBeanFactory myBeanFactory = new MyBeanFactory();

        myBeanFactory.addBeanPostProcessor(bean -> System.out.println("模拟解析@Autowired"));
        myBeanFactory.addBeanPostProcessor(bean -> System.out.println("模拟解析@Resource"));

        System.out.println(myBeanFactory.getBean());
    }

    static class MyBeanFactory {

        private final List<BeanPostProcessor> postProcessors = new ArrayList<>();

        public void addBeanPostProcessor(BeanPostProcessor postProcessor){
            postProcessors.add(postProcessor);
        }
        public Object getBean() {
            Object bean = new Object();
            System.out.println("构造：" + bean);
            System.out.println("依赖注入：" + bean);

            // 在依赖注入阶段进行扩展
            for (BeanPostProcessor postProcessor : postProcessors) {
                postProcessor.inject(bean);
            }

            System.out.println("初始化：" + bean);
            return bean;
        }
    }

    static interface BeanPostProcessor{
        void inject(Object bean);
    }

}
