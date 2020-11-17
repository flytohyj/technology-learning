## **HashMap源码思维导图**

<img src="D:\workspace\gitee\technology-learning\java源码解析\String源码思维导图.png" alt="String源码思维导图" style="zoom:200%;" />

## **常见面试题**

### == 和 equals 的区别

== 对于基本数据类型来说，是用于比较 “值”是否相等的；对于引用类型来说，是用于比较引用地址是否相同的。
参考Object中的equals方法源码如下：

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

其实比较的就是引用是否一致。
在String中重写了equals方法，进行比较两个字符串的值是否相等。

```java
public boolean equals(Object anObject) {
    //先比较引用 一致则直接返回true
    if (this == anObject) {
        return true;
    }
    //如果是字符串则比较字符串内容
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

### String设计为final 修饰的好处

- 安全性
- 效率

只有字符串是不可变时才能实现字符串常量池，字符串常量池可以为我们缓存字符串，提高程序的运行效率。

final修饰的String，代表了String的不可继承性，final修饰的char[]代表了被存储的数据不可更改性。
但是：虽然final代表了不可变，但仅仅是引用地址不可变，并不代表了数组本身不会变

### String 和 StringBuilder、StringBuffer 的区别

String 类型是不可变的，字符串拼接性能会很低。

StringBuilder 非线程安全，非并发操作的环境下可使用StringBuilder 来进行字符串拼接。
StringBuffer 采用synchronized 来保证线程安全，所以性能不是很高。
参考StringBuffer源码如下，注意前面使用synchronized修饰保证线程安全

```java
@Override
public synchronized StringBuffer append(Object obj) {
    toStringCache = null;
    super.append(String.valueOf(obj));
    return this;
}
@Override
public synchronized StringBuffer append(String str) {
    toStringCache = null;
    super.append(str);
    return this;
}
```

### String存储

new String() 的方式和直接赋值的方式区别：

- 直接赋值的方式会先去字符串常量池中查找是否已经有此值，如果有则把引用地址直接指向此值，否则会先在常量池中创建，然后再把引用指向此值；
- new String() 的方式一定会先在堆上创建一个字符串对象，然后再去常量池中查询此字符串的值是否已经存在，如果不存在会先在常量池中创建此字符串，然后把引用的值指向此字符串

```java
String s1 = new String("Hello World");
String s2 = s1.intern();
String s3 = "Hello World";
String s4 = "Hello " + "World";
System.out.println(s1 == s2);//false
System.out.println(s1==s3); //false
System.out.println(s2==s3);//true
System.out.println(s3==s4); //true
System.out.println(s2==s4); //true
```

