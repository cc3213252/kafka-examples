package com.blueegg.simpleproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/*
 * Kafka生产者示例——异步发送消息
 */
public class ProducerWithPartitioner {

    public static void main(String[] args) {

        String topicName = "kafka-partitioner-test";

        Properties props = new Properties();
        props.put("bootstrap.servers", "host1:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        /*传递自定义分区器*/
        props.put("partitioner.class", "com.blueegg.simpleproducer.partitioners.CustomPartitioner");
        /*传递分区器所需的参数*/
        props.put("pass.line", 6);

        Producer<Integer, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i <= 10; i++) {
            String score = "score:" + i;
            ProducerRecord<Integer, String> record = new ProducerRecord<>(topicName, i, score);
            /*异步发送消息*/
            producer.send(record, (metadata, exception) ->
                    System.out.printf("%s, partition=%d, \n", score, metadata.partition()));
        }

        producer.close();
    }
}