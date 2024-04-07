# spring

### 常见的几个BeanFactoryPostProcessor

> 1. ConfigurationClassPostProcessor<br>
> 解析 @ComponentScan @Bean @Import @ImportResource **参考Main1, Main2**
> [Main1.java](..%2Fdemo4-BeanFactoryPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo4%2Fmains%2FMain1.java)
[Main2.java](..%2Fdemo4-BeanFactoryPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo4%2Fmains%2FMain2.java)
> 2. MapperScannerConfigurer<br>
> 由mybatis提供，解析@Mapper。**参考Main3Mapper**
> [Main3Mapper.java](..%2Fdemo4-BeanFactoryPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo4%2Fmains%2FMain3Mapper.java)

### 模拟BeanFactoryPostProcessor
> [Main4DIY.java](..%2Fdemo4-BeanFactoryPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo4%2Fmains%2FMain4DIY.java) <br>
> [Main5DIY.java](..%2Fdemo4-BeanFactoryPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo4%2Fmains%2FMain5DIY.java) <br>
> [Main6DIY.java](..%2Fdemo4-BeanFactoryPostProcessor%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo4%2Fmains%2FMain6DIY.java) <br>

