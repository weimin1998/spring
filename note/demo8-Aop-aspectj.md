aop实现的方式不止代理模式<br>

但是最重要的还是代理模式 ,spring就是使用动态代理实现aop<br>

其他的方式了解一下即可<br>

本module是使用aspectj的编译器，在编译阶段修改class文件，将切面方法的代码写入目标方法。目标方法可以是final static的<br>

在pom加入aspectj的agent编译器，然后 **mvn clean compile编译**，不要直接运行。