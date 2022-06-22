package com.xxx.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author xqh
 * @date 2022/6/22  14:49:50
 * @apiNote
 */
public class MyProducer {
    public static void main(String[] args) throws InterruptedException {
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.4:9092");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.ACKS_CONFIG,"all");
        prop.put(ProducerConfig.RETRIES_CONFIG,3);
        prop.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);
        prop.put(ProducerConfig.LINGER_MS_CONFIG,300);
        prop.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

        int i = 0;
        while (true) {
            String msg = "kafka 3.2," + i;
            ProducerRecord<String, String> record = new ProducerRecord<>("firstTestTopic", msg);
            producer.send(record);
            System.out.println("send" +i);
            Thread.sleep(1 * 1000);
            i++;

        }


    }
}
