package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by cwl on 2018/8/12.
 */
@Slf4j
@ThreadSafe
public class CountExample4 {
  private static AtomicReference<Integer> count = new AtomicReference<>(0);

  public static  void main(String[] args){
    count.compareAndSet(0, 2);//count等于0时候复制给2
    count.compareAndSet(0, 1);
    count.compareAndSet(1, 3);
    count.compareAndSet(2, 4);
    count.compareAndSet(3, 5);
    log.info("count {}", count.get());//最后输出为4
  }
}
