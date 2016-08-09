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

#2、抽象工厂模式
 抽象工厂是在工厂方法的基础上进一步抽象化，所有的工厂类实现统一的接口，每一个工厂类对用一个对象的创建。如果想要添加新的对象就直接创建对应该对象的工厂类就ok了
 
 #3单例模式
 单例对象(Singleton)是一种常用的设计模式，在java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：
 ###1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 ###2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 ###3、有些类如 交易的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。
 
 public class Singleton {  
  
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
    private static Singleton instance = null;  
  
    /* 私有构造方法，防止被实例化 */  
    private Singleton() {  
    }  
  
    /* 静态工程方法，创建实例 */  
    public static Singleton getInstance() {  
        if (instance == null) {  
            instance = new Singleton();  
        }  
        return instance;  
    }  
  
}  
这个类可以满足基本需求，但是像这样毫无线程安全。如果我们把它放在多线程的环境里面，就会出现混乱的情况，对象的创建得不到统一，如何解决呢？ 我们可以在getInstance()方法加上锁(synchronized)

public static synchronized Singleton getInstance() {  
        if (instance == null) {  
            instance = new Singleton();  
        }  
        return instance;  
    }  
    
可是,synchronized能锁住这个对象获取，假如多个线程在同时使用这个单例就会出现排队的情况，我们理想中不是在获取这个类的时候加锁，而是在创建这个类的实例的时候加上锁，这样效率就比之前好一些。

public static Singleton getInstance() {  
        if (instance == null) {  
            synchronized (instance) {  
                if (instance == null) {  
                    instance = new Singleton();  
                }  
            }  
        }  
        return instance;  
    }  
 
这样是不是看起来之前的问题都解决了呢？这样效率又高又安全？其实这样还是有问题的，在java指令中创建对象和赋值是分开操作的，也就是说instance=new Singleton();这行代码是分两步执行的，JVM在执行过程中不能保证这两步的先后顺序，也就是说可能JVM会为新的SIngleton实例分配空间，然后直接赋值给instance成员，再去初始化Singleton实例。这样可能会出错，假设两个线程A 、 B,

a>A、B线程同时进入了第一个if判断

b>A首先进入synchronized块，由于instance为null，所以它执行instance=new Singleton();

c>由于JVM内部的优化机制，JVM先画出一些空白内存给Singleton实例，并赋值instance成员(此时JVM还没有初始化这个实例)，然后A离开了synchronized

d>B进入synchronized，由于instance此时不是null，因此它马上离开了synchronized并将结构返回给调用该方法的程序。

e>此时B线程打算使用Singleton实例，却发现它没有被初始化，出现异常
所有程序还是或出现错误，进一步优化

private static class SingletonFactory{           
        private static Singleton instance = new Singleton();           
    }           
    public static Singleton getInstance(){           
        return SingletonFactory.instance;           
    }   
 
实际情况是，单例模式使用内部类来维护单例，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。这样当我们第一次调用getInstace()的时候，JVM就能够保证instace只被创建一次，并且会保证把值赋值给in守塔侧的内存，这样我们就不用担心上面的问题了。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。完美

public class Singleton {  
  
    /* 私有构造方法，防止被实例化 */  
    private Singleton() {  
    }  
  
    /* 此处使用一个内部类来维护单例 */  
    private static class SingletonFactory {  
        private static Singleton instance = new Singleton();  
    }  
  
    /* 获取实例 */  
    public static Singleton getInstance() {  
        return SingletonFactory.instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance();  
    }  
}  

#4构建者模式
构造者模式：构造者模式是将一个复杂对象的构造过程和它的表现分离开来，是的同样的构建过程可以创建不同的表示。

#原型模式








