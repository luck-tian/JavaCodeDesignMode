# java 设计模式

-----------------------------------------------------------------------------------------------------

![image](https://github.com/isoot/JavaCodeDesignMode/blob/master/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/picture/d63049eb1e3022afb95baee96a3b414d.jpeg)

其实我是一条咸鱼( ⊙ o ⊙ )  

学习来源参考地址(http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html)

Design Patterns

# 一、设计模式的分类
创建型模式：工厂方法模式、抽象工厂模式、单列模式、建造者模式、原型模式。
结构型模式：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
行为 模 式：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、访问者模式、中介者模式、解释器模式。

# 1.工厂模式
## 11.普通工厂
创建一个工厂，制造我们想要的类
![iamge](https://github.com/isoot/JavaCodeDesignMode/blob/master/java%25E8%25AE%25BE%25E8%25AE%25A1%25E6%25A8%25A1%25E5%25BC%258F/picture/java%E6%99%AE%E9%80%9A%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png)
MailSender和SmsSender创建是通过SenderFactory统一创建
UML做的不好如果有错误的地方请联系我(0`0)

##12.多个方法工厂模式
 就是把普通工厂同意创建我们想要的类分成多个方法创建、一个方法对应一个对象的创建
 ![image](https://github.com/isoot/JavaCodeDesignMode/blob/master/java%2525E8%2525AE%2525BE%2525E8%2525AE%2525A1%2525E6%2525A8%2525A1%2525E5%2525BC%25258F/picture/java2.png)
 
##13.静态工厂方法模式
不需要创建工厂类、直接调用里面的静态方法和属性，适用于频繁使用
![image](https://github.com/isoot/JavaCodeDesignMode/blob/master/java%2525E8%2525AE%2525BE%2525E8%2525AE%2525A1%2525E6%2525A8%2525A1%2525E5%2525BC%25258F/picture/java3.png)
