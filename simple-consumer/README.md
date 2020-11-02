## 参考资料

https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka%E6%B6%88%E8%B4%B9%E8%80%85%E8%AF%A6%E8%A7%A3.md

## 总结

同一个分区只能被同一个消费者群组里面的一个消费者读取  
自动提交偏移量可能会丢失数据  
手动同步提交偏移量可能会降低性能  
手动异步提交偏移量不能进行失败重试  
手动同步加异步提交兼顾性能和重试  

## 测试方法

消费组：
启动ConsumerGroup，再启动SimpleProducer  


## 子工程说明

ConsumerGroup 自动提交偏移量  
ConsumerSyn 手动同步提交偏移量  