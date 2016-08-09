# java 设计模式

-----------------------------------------------------------------------------------------------------

![image](https://github.com/isoot/JavaCodeDesignMode/blob/master/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/picture/d63049eb1e3022afb95baee96a3b414d.jpeg)

其实我是一条咸鱼( ⊙ o ⊙ )  

学习来源参考地址(http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html) 作者是"maowang" 

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

#4、构建者模式
构造者模式：构造者模式是将一个复杂对象的构造过程和它的表现分离开来，是的同样的构建过程可以创建不同的表示。

#5、原型模式
原型模式就是将一个对象作为原型，对其进行复制、克隆，产生一个和源对象类似的新对象。通过clone()实现

public class Prototype implements Cloneable {  
  
    public Object clone() throws CloneNotSupportedException {  
        Prototype proto = (Prototype) super.clone();  
        return proto;  
    }  
}  

实现Cloneable接口，覆写clone方法，这里面的clone方法可以任意取名(Cloneable是一个空的接口)，你可以定义任意实现的方法名，重点是要写出super.clone()这个行代码，这行代码调用的是Object里面的clone()方法，clone()方法是native的。原型模式分两种浅复制和深复制。

浅复制：将一个对象复制后，类中的基本数据类型都会被重新创建，而引用类型，指向的还是原来的指向。

深复制：将一个对象复制后，无论是基本数据类型还是引用类型都会被重新创建，就像你这类中有个别的类引用那么这个别的类也会被重新创建。

public class Prototype implements Cloneable, Serializable {  
  
    private static final long serialVersionUID = 1L;  
    private String string;  
  
    private SerializableObject obj;  
  
    /* 浅复制 */  
    public Object clone() throws CloneNotSupportedException {  
        Prototype proto = (Prototype) super.clone();  
        return proto;  
    }  
  
    /* 深复制 */  
    public Object deepClone() throws IOException, ClassNotFoundException {  
  
        /* 写入当前对象的二进制流 */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  
    }  
  
    public String getString() {  
        return string;  
    }  
  
    public void setString(String string) {  
        this.string = string;  
    }  
  
    public SerializableObject getObj() {  
        return obj;  
    }  
  
    public void setObj(SerializableObject obj) {  
        this.obj = obj;  
    }  
  
}  
  
class SerializableObject implements Serializable {  
    private static final long serialVersionUID = 1L;  
}  

深复制采用的是流的形式读入当前二进制，在写出对用的对象数据。

#6、适配器模式
适配器模式将某个类的接口转换成客户期望的另外一个接口，目的是消除由于接口不匹配带来的兼容性问题。分三类：类的适配器模式，对象的适配器模式、接口的适配器模式。

###1、类的适配器模式
核心思想：有一个类，拥有一个方法，待适配，通过适配类是将这个方法适配到目标接口中

public class Source {  
  
    public void method1() {  
        System.out.println("this is original method!");  
    }  
}  

public interface Targetable {  
  
    /* 与原类中的方法相同 */  
    public void method1();  
  
    /* 新类的方法 */  
    public void method2();  
}  

public class Adapter extends Source implements Targetable {  
  
    @Override  
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
}  

public class AdapterTest {  
  
    public static void main(String[] args) {  
        Targetable target = new Adapter();  
        target.method1();  
        target.method2();  
    }  
}  

这样这个目标接口就实现了类里面的功能

#2、对象的适配器模式
和上面的类的适配器模式一样的思路，只是不再是通过继承的方式去实现接口中的方法，而是通过持有类的对象来实现。

public class Wrapper implements Targetable {  
  
    private Source source;  
      
    public Wrapper(Source source){  
        super();  
        this.source = source;  
    }  
    @Override  
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
  
    @Override  
    public void method1() {  
        source.method1();  
    }  
}  

public class AdapterTest {  
  
    public static void main(String[] args) {  
        Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2();  
    }  
}  

#6、接口的适配器模式
一个接口里面有很对抽象方法，在使用过程中我们只用到其中某些方法，又不想实现其他的方法，所有我们先定义一个抽象类来实现这个接口把里面的抽象方法覆写一遍，然后继承这个抽象类这样就不用实现其他不相关的方法了


#7、装饰模式
在原有对象上添加新的功能，而且是动态添加，要求是装饰类和被装饰类都要实现同一个接口，装饰类中持有被装饰类的对象实例。装饰模式应用场景，1、需要扩展类的功能，2、动态添加功能和动态撤销。

#8、代理模式
代理模式就是多一个代理类出来代理对象的操作，这样就很方便（比如你要买车不可能去找厂商而是去4s店）感觉就像是将一个类型的产品进行统一管理

#9、外观模式
外观模式是为了解决类和类之间的依赖关系，降低耦合性

public class CPU {  
      
    public void startup(){  
        System.out.println("cpu startup!");  
    }  
      
    public void shutdown(){  
        System.out.println("cpu shutdown!");  
    }  
}  

public class Memory {  
      
    public void startup(){  
        System.out.println("memory startup!");  
    }  
      
    public void shutdown(){  
        System.out.println("memory shutdown!");  
    }  
}  

public class Disk {  
      
    public void startup(){  
        System.out.println("disk startup!");  
    }  
      
    public void shutdown(){  
        System.out.println("disk shutdown!");  
    }  
}  

public class Computer {  
    private CPU cpu;  
    private Memory memory;  
    private Disk disk;  
      
    public Computer(){  
        cpu = new CPU();  
        memory = new Memory();  
        disk = new Disk();  
    }  
      
    public void startup(){  
        System.out.println("start the computer!");  
        cpu.startup();  
        memory.startup();  
        disk.startup();  
        System.out.println("start computer finished!");  
    }  
      
    public void shutdown(){  
        System.out.println("begin to close the computer!");  
        cpu.shutdown();  
        memory.shutdown();  
        disk.shutdown();  
        System.out.println("computer closed!");  
    }  
}  

public class User {  
  
    public static void main(String[] args) {  
        Computer computer = new Computer();  
        computer.startup();  
        computer.shutdown();  
    }  
}  

#10、桥接模式
桥接模式就是把事物和其他具体实现分开，他们可以独立开来，将抽象与实现解耦。

#11、组合模式
组合模式又是部分-整体模式，处理类似树形结构问题很nice

#12、享元模式
享元模式主要的目的是实现数据的共享，

	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		System.out.println(a == b);
	}
	
#13、策略模式
策略模式定义了一系列算法，并且将每一个算法封装起来，使得他们可以相互调用和替换，而且算法的变化不会影响到算法的调用者。设计一个接口，为一系列的算法提供统一的接口。

#14、模板方法模式
一个抽象类中有一个主方法，在定义1...n个方法，可以抽象也可以实现的，在定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用。

#15、观察者模式
对象中的数据变化是会通知依赖该对象的对象会接收到通知

#16、迭代子模式
迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较熟悉的话，理解本模式会十分轻松。这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问。

#17、责任链模式
接下来我们将要谈谈责任链模式，有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求。但是发出者并不清楚到底最终那个对象会处理该请求，所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整。

#18、命令模式
命令模式很好理解，举个例子，司令员下令让士兵去干件事情，从整个事情的角度来考虑，司令员的作用是，发出口令，口令经过传递，传到了士兵耳朵里，士兵去执行。这个过程好在，三者相互解耦，任何一方都不用去依赖其他人，只需要做好自己的事儿就行，司令员要的是结果，不会去关注到底士兵是怎么实现的。

#19、备忘录模式
保存某个类的状态值，方便恢复该状态值

#20、状态模式
核心思想：对象的状态改变时，该类的行为状态都要改变

#21、访问者模式
访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。访问者模式适用于数据结构相对稳定算法又易变化的系统。因为访问者模式使得算法操作增加变得容易。若系统数据结构对象易于变化，经常有新的数据对象增加进来，则不适合使用访问者模式。访问者模式的优点是增加操作很容易，因为增加操作意味着增加新的访问者。访问者模式将有关行为集中到一个访问者对象中，其改变不影响系统数据结构。其缺点就是增加新的数据结构很困难。

#22、中介者模式
中介者模式也是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，因为只要修改一个对象，其它关联的对象都得进行修改。

#23、解释器模式
解释器模式是我们暂时的最后一讲，一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄。




























