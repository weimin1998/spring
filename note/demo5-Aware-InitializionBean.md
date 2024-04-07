# spring

### Aware接口
> Aware接口用于注入一些与容器相关的bean<br>
> 1.BeanNameAware，注入bean自己的名字<br>
> 2.ApplicationContextAware，注入ApplicationContext<br>
> 3.BeanFactoryAware，注入BeanFactory<br>
> 4.EmbeddedValueResolverAware ${}


### InitializationBean

> aware接口提供了一种内置的注入手段，可以注入BeanFactory，ApplicationContext<br>
> InitializationBean 接口提供了一种内置的初始化手段<br>
> 内置的注入和初始化不受**扩展功能**的影响，总会被执行，因此Spring框架内部的类经常用它们<br>

> 扩展功能，比如@Autowired，需要BeanPostProcessor解析，这就属于扩展功能 
> 而Aware，InitializationBean, 是spring内置的功能，不需要添加任何扩展
> 
> **某些情况下，扩展功能会失效，但是内置功能不会失效**
> 注解需要配套后置处理器使用，而Aware则不需要
> 


### @Autowired失效场景
> 参考 [MyConfig.java](..%2Fdemo5-Aware-InitializionBean%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo5%2FMyConfig.java)
> 
> 