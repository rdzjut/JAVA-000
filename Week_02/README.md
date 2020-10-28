GC总结：
        串行 GC 
	-XX:+UseSerialGC 配置串行 GC
	对年轻代使用拷贝-复制，对老年代使用标记-清除-整理
	由于是单线程垃圾收集器，发生GC时，会暂停
	内存越小，GC次数越多
       并行 GC
	配置并行 GC
	     -XX:+UseParallelGC
	     -XX:+UseParallelOldGC
	     -XX:+UseParallelGC -XX:+UseParallelOldGC 
	对年轻代使用拷贝-复制，对老年代使用标记-清除-整理
	GC处理时，暂停业务处理，所有线程处理GC垃圾回收。平常运行时，所以线程都去处理业务。因此，吞吐量比较高。
	内存越小，GC次数越多
      CMS GC
	配置CMS GC
	     -XX:+UseConcMarkSweepGC 
	年轻代使用拷贝-复制，老年代使用标记-清除
	CMS默认GC线程数是1/4，并且老年代只清除，无整理。所以当GC发生时，吞吐量不如并行 GC
	CMS GC 6个阶段 
	     阶段 1: Initial Mark（初始标记） - 暂停GC
	     阶段 2: Concurrent Mark（并发标记）
	     阶段 3: Concurrent Preclean（并发预清理）
	     阶段 4: Final Remark（最终标记） - 暂停GC
	     阶段 5: Concurrent Sweep（并发清除）
	     阶段 6: Concurrent Reset（并发重置）
	因为无整理，并且CMS GC 六个阶段的暂停时间短，所以延迟比较低
	内存越小，GC次数越多
       G1 GC
	配置G1 GC
	      -XX:+UseG1GC -XX:MaxGCPauseMillis=50，使用 -XX:MaxGCPauseMills 参数可以控制 GC暂停时间
	不分代,使用 region(2048) 存储数据，分为： 
	      Eden区 （标记-复制 算法）
	      存活区
	      老年区 (标记-复制-整理 算法)
       	GC 3个阶段 
	      1.年轻代模式转移暂停（Evacuation Pause）
	      2.类似 CMS GC 的 并发标记 
		阶段 1: Initial Mark（初始标记）
		阶段 2: Root Region Scan（Root区扫描）
		阶段 3: Concurrent Mark（并发标记）
		阶段 4: Remark（再次标记）
		阶段 5: Cleanup（清理）
	     3.转移暂停: 混合模式（Evacuation Pause (mixed)）

	ParNewGC + CMS 适用于低延迟
	ParallelGC + ParllelGC Old 适用于高吞吐量
	G1 适用于 内存大于4G，并且GC时间可控制，超过 8G，非常推荐使用 G1 GC。