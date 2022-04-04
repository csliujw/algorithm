package com.payphone.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程资源必须通过线程池提供，不允许在应用中自行显式创建线程
 * - 使用线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问题，如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题
 * 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险
 * - Executors 返回的线程池对象弊端如下：
 * - FixedThreadPool和SingleThreadPool：
 * ---- 运行的请求队列长度为：Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM
 * - CacheThreadPool 和 ScheduledThreadPool
 * ---- 运行的请求队列长度为：Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM
 */
class DefineThreadPool {
    static ThreadPoolExecutor threadPoolExecutor;
    static final Integer corePoolSize = 2;
    static final Integer maximumPoolSize = 5;
    static final long keepAliveTime = 1L;

    static {
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 手写线程池
     * 从上面我们知道，因为默认的 Executors 创建的线程池，底层都是使用 LinkBlockingQueue 作为阻塞队列的，
     * 而 LinkBlockingQueue 虽然是有界的，但是它的界限是 Integer.MAX_VALUE 大概有20多亿，
     * 相当于是无界的了，因此我们要使用 ThreadPoolExecutor 自己手动创建线程池，然后指定阻塞队列的大小
     * 下面我们创建了一个 核心线程数为2，最大线程数为5，并且阻塞队列数为3的线程池
     */
    public static void AbortPolicy() {
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        try {
            // maximumPoolSize +  LinkedBlockingQueue的大小 = 5+3 = 8； 运行的+阻塞的  最多8个任务。
            for (int i = 0; i < 15; i++) {
                final int tmp = i;
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tmp + " 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }

    public static void CallerRunsPolicy() {
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            // maximumPoolSize +  LinkedBlockingQueue的大小 = 5+3 = 8； 运行的+阻塞的  最多8个任务
            for (int i = 0; i < 150; i++) {
                final int tmp = i;
                // 我们发现，输出的结果里面出现了main线程，因为线程池出发了拒绝策略，把任务回退到main线程，然后main线程对任务进行处理
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tmp + " 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }

    // 直接丢弃任务，不报异常。
    public static void DiscardPolicy() {
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        try {
            // maximumPoolSize +  LinkedBlockingQueue的大小 = 5+3 = 8； 运行的+阻塞的  最多8个任务
            for (int i = 0; i < 150; i++) {
                final int tmp = i;
                // 我们发现，输出的结果里面出现了main线程，因为线程池出发了拒绝策略，把任务回退到main线程，然后main线程对任务进行处理
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tmp + " 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }

    /**
     * <div>线程池的合理参数</div>
     * 生产环境中如何配置 corePoolSize 和 maximumPoolSize <br>
     * 这个是根据具体业务来配置的，分为 CPU 密集型和 IO 密集型 <br>
     * - CPU 密集型 <br>
     * CPU 密集的意思是该任务需要大量的运算，而没有阻塞，CPU 一直全速运行 <br>
     * CPU 密集任务只有在真正的多核 CPU 上才可能得到加速（通过多线程） <br>
     * 而在单核 CPU 上，无论你开几个模拟的多线程该任务都不可能得到加速，因为 CPU 总的运算能力就那些 <br>
     * CPU密集型任务配置尽可能少的线程数量： <br>
     * 一般公式：CPU核数 + 1个线程数 <br>
     * - IO密集型 <br>
     * 由于IO密集型任务线程并不是一直在执行任务，则可能多的线程，如 CPU核数 * 2 <br>
     * IO密集型，即该任务需要大量的IO操作，即大量的阻塞 <br>
     * 在单线程上运行IO密集型的任务会导致浪费大量的CPU运算能力花费在等待上 <br>
     * 所以IO密集型任务中使用多线程可以大大的加速程序的运行，即使在单核CPU上，这种加速主要就是利用了被浪费掉的阻塞时间。 <br>
     * IO密集时，大部分线程都被阻塞，故需要多配置线程数： <br>
     * 参考公式：CPU核数 / (1 - 阻塞系数) 阻塞系数在0.8 ~ 0.9左右 <br>
     * 例如：8核CPU：8/ (1 - 0.9) = 80个线程数 <br>
     */
    public static void note() {
    }

    public static void main(String[] args) {
        DiscardPolicy();
    }
}