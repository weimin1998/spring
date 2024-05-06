首先要明白两个切面的概念：<br>
aspect，高级切面，由一个或多个（通知advice+切点pointcut）组成；<br>
advisor，更细粒度的切面，包含一个（通知+切点）；<br>

一般在开发的时候，会准备一个切面类，里面有各种通知方法，和切入点表达式，
这个切面类就是高级切面，spring会把**高级切面转换为更细粒度的切面**；


接下来手动模拟一下这个流程：<br>
[AspectToAdvisor.java](..%2Fdemo15-Aop-Aspect-to-Advisor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo15%2FAspectToAdvisor.java)



spring底层通过下面这个类来完成高级切面转换为更细粒度的切面：<br>
AnnotationAwareAspectJAutoProxyCreator

    这是一个BeanPostProcessor，主要作用：
    1.识别和切面有关的注解，找到容器中的切面；
    2.将高级切面Aspect转换为底层切面Advisor；
    3.创建代理对象；
    
    两个重要方法：
    findEligibleAdvisors：找到和目标类匹配的切面；
    
    wrapIfNecessary：为目标类创建代理对象；这个方法内部会调用findEligibleAdvisors；
    
    目标类想要创建代理类，一是要满足有匹配的切面，二是目标类不能是基础设施类型(Infrastructure)的；
    所谓基础设施：目标类不能是通知类型（Advice），不能是切点类型（PointCut），不能是切面类型（Advisor）


    







