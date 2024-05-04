spring选择代理的方式<br>

> 如果proxyTargetClass = false，并且目标类实现了接口，则用jdk动态代理；<br>
> 如果proxyTargetClass = false，并且目标类没有实现接口，则用cglib动态代理；<br>
> 如果proxyTargetClass = true，不管目标类有没有实现接口，则总是用cglib动态代理；<br>
