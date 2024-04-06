# spring

### 常见的几个BeanPostProcessor

> 1. AutowiredAnnotationBeanPostProcessor<br>
> 解析 @Autowired, @Value。 **参考Main2, Main3**
> [Main2.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2Fmains%2FMain2.java)
[Main3.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2Fmains%2FMain3.java)
> 2. CommonAnnotationBeanPostProcessor<br>
> 解析 @Resource, @PostConstruct, @PreDestroy。**参考Main4**
> [Main4.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2Fmains%2FMain4.java)
> 3. ConfigurationPropertiesBindingPostProcessor<br>
> 由springboot提供, 解析@ConfigurationProperties。 **参考Main5**
> [Main5.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2Fmains%2FMain5.java)



### AutowiredAnnotationBeanPostProcessor执行分析

> 参考 [DigInAutowired.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2FdigIn%2FDigInAutowired.java) <br>
> [DigInAutowired_1.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2FdigIn%2FDigInAutowired_1.java)<br>
> [DigInAutowired_2.java](..%2Fdemo3-BeanPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom.weimin.demo3%2FdigIn%2FDigInAutowired_2.java)
![InjectionMetadata.png](img%2FInjectionMetadata.png)