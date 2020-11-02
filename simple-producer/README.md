## 参考资料

https://github.com/heibaiying/BigData-Notes/blob/master/notes/Kafka%E7%94%9F%E4%BA%A7%E8%80%85%E8%AF%A6%E8%A7%A3.md

## 测试过程

vagrant ssh host1  

创建主题  
kafka-topics.sh --create --bootstrap-server host1:9092 --replication-factor 1 --partitions 1 --topic hello-kafka  

查看主题  
kafka-topics.sh --list --bootstrap-server host1:9092  

启动消费者  
kafka-console-consumer.sh --bootstrap-server host1:9092 --topic hello-kafka --from-beginning  

启动程序，查看消费者（不创建主题，启动程序也会自动创建主题）