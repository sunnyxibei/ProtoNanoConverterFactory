# ProtoNanoConverterFactory
A Converter Factory for Protocol Buffer javanano 



> Protocol Buffers (a.k.a., protobuf) are Google's language-neutral, platform-neutral, extensible mechanism for serializing structured data.

Protocol Buffer （又名，protobuf）是 Google 提供的一种语言中立，平台中立，可扩展的序列化/结构化数据的机制。

> JavaNano is a special code generator and runtime library designed specially for resource-restricted systems, like Android. It is very resource-friendly in both the amount of code and the runtime overhead. 

JavaNano是专门为资源受限系统（如Android）设计的特殊代码生成器和运行时库。 代码量和运行时开销都非常资源友好。

工作中接手的项目中，使用了Protocol Buffer javanano。产看生成的java类，会发现，javanano相比普通版本做了很大程度上的阉割，去掉了getter/setter方法、builder模式、Parser解析器。直接解析并没有啥问题，而且很简单方便，但是，对于习惯了使用RxJava+Retrofit的我，使用工厂统一解析肯定是个硬性需求。所以问题来了，com.squareup.retrofit2:converter-protobuf:2.3.0普通版本的转换工厂是使用反射获取的Parser实例进行解析，javanano就使用不了，所以就有了这个自定义转换工厂。



### 使用简介

```java
 Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(ProtoNanoConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
```

和所有工厂类的使用一样简单。