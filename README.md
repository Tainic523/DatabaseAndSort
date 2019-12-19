概述：秋招常见算法题Java实现

### 1：annotation注解

使用annotation注解实现自动获取类信息，注解还可用于日志打印，切面等功能。

### 2：ConsumerAndProducer

实现了常见的并发题目，包括死锁，互斥示例，阻塞队列，生产者消费者等。

#### 2.1：AwaitSignalExample

使用java并发包里面的 ReentrantLock 和 Condition 实现了互斥示例。

#### 2.2： WaitNotifyCase

使用object对象自带的wait和notify方法实现了互斥。

#### 2.3 ：BlockingQueueExample

使用LinkedList 实现了带有 阻塞的put 和 take 方法的 阻塞队列BlockingQueueExample，这个类只能存放object的对象。默认队列大小为10，构造函数可以修改阻塞队列大小。

#### 2.4：BlockingQueueImpl

使用LinkedList 和泛型 实现了带有 阻塞的put 和 take 方法的 阻塞队列，默认队列大小为10，构造函数可以修改阻塞队列大小。

#### 2.5：ConsumerAndProducer

使用 BlockingQueueImpl 实现了生产者和消费者。这里生产者和消费者线程使用的是继承 Thread 类实现的。

#### 2.6：cyclicbarrierTest

java同步互斥工具类CyclicBarrier和CountDownLatch的测试，CyclicBarrier特点可以循环使用，CountDownLatch只可以使用一次。

#### 2.7：DeadLockTest

死锁示例，使用object对象自带的wait和notify实现死锁。

#### 2.8：ProducerAndConsumer

同样是使用 BlockingQueueImpl 实现了生产者和消费者，这里的线程是通过实现Runnable借口来完成的。

#### 2.9：Singleton

单例模式的实现，使用双重锁方式实现，线程安全。

### 3：DynamicProxy

JDK动态代理实现。

### 4：graph

图的相关算法，包括深度遍历，广度遍历，图使用邻接矩阵方式存储。

### 5：java_io

java读取文件操做

### 6：leetcode

#### 6.1：solution

计算回文子串的数目，例：abba 中回文子串数目为1

#### 6.2：Solution650

leetcode第650题的解答

### 7：LRUCache

#### 7.1：LRU

使用HashMap，泛型，实现LRU队列。常规方式

#### 7.2：LRUCache

使用LinkedHashMap 实现LRU队列。最简单的方式

#### 7.3：LRUImpl

使用LinkedHashMap ，List，泛型 实现LRU队列，最复杂方式。

### 8：model

使用mybaits进行数据库连接，需要mysql数据库支持。还有Redis的测试。

### 9：Sort

数字和字符串排序算法实现

#### 9.1：sorttest

常见数字排序算法实现，包括快排，希尔排序，插入排序，选择排序，堆排序等。

#### 9.2：StringSolution

常见字符串相关算法，包括字符串全排列，字符串的全组合，寻找最长公共子串，左旋n位字符串，最长回文子串，回文子串数目。

### 10：ThreadPool

多线程相关实现，包括线程池，信号量等。

#### 10.1：MultiThread

多线程示例。

#### 10.2：SemaphoreExample

信号量实现同步互斥，10个任务争夺3个资源。

#### 10.3：ThreadExcutor

自己实现的线程池。

#### 10.4：Threadimplrment

使用10.3实现的线程池跑任务的示例。

#### 10.5：ThreadPoolTest

线程池示例。

#### 10.6：ThreadTest

如何创建线程。

### 11：Tree

树相关算法，包括遍历，是否相似，求深度，广度，最短路径，镜像树，树的节点数目等。

#### 11.1：TreeNode

树的节点定义，以及树的相关算法。

#### 11.2：Serialize

树的序列化和反序列化

#### 11.3：Main

树的构造和算法测试。

