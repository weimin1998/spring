Spring bean的scope有5种：<br>
singleton，prototype，request，session，application<br>
后三种要配合web环境使用；

[MyController.java](..%2Fdemo7-Bean-Scope%2Fsrc%2Fmain%2Fjava%2Fcom%2Fweimin%2Fdemo7%2FMyController.java)<br>
打开浏览器访问这个controller的方法：
每次访问都是一个新的请求，因此scope为request的bean，在每次请求都会新创建一个，并且请求过后立刻销毁<br>
而session scope的bean，不同的会话不同，需要等到session过期后才销毁；<br>
application scope的bean，则要等到servlet context停止，也就是tomcat应用停止后才会销毁；
