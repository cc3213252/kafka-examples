## 参考资料

https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka%E6%B6%88%E8%B4%B9%E8%80%85%E8%AF%A6%E8%A7%A3.md

## 总结

同一个分区只能被同一个消费者群组里面的一个消费者读取  
自动提交偏移量可能会丢失数据  
手动同步提交偏移量可能会降低性能  
手动异步提交偏移量不能进行失败重试  
手动同步加异步提交兼顾性能和重试  
需要在批次消息中间提交偏移量，则需要使用提交特定偏移量，比如poll方法返回了一大批数据，为了避免因再均衡引起的重复处理批次消息等情况  
再均衡时需要处理未提交的偏移量、关闭连接，则需要监听该事件  
消费者退出时要调用close方法优雅地退出  

## 测试方法

消费组：
启动ConsumerGroup，再启动SimpleProducer  

StandaloneConsumer:
启动StandaloneConsumer，再启动ProducerWithPartitioner  

## 子工程说明

ConsumerGroup 自动提交偏移量  
ConsumerSyn 手动同步提交最大偏移量  
ConsumerASyn 手动异步提交最大偏移量  
ConsumerASynAndSyn 手动同步加异步提交最大偏移量  
ConsumerASynWithOffsets 手动异步提交特定偏移量  
RebalanceListener 监听分区再均衡  
ConsumerExit 优雅地退出消费者  
StandaloneConsumer 只读取特定分区数据  

## 问题

如何触发分区再均衡？  