# kafka2.13_3.2

虚拟机：192.168.0.4
/home/app/kafka_2.13-3.2.0

使用Kraft 启动  不用zk

参考：https://blog.csdn.net/qq_47658874/article/details/122730520
一、基于KRaft启动
config/kraft/server.properties

启动
===============linux
1 用kafka-storage.sh 生成一个唯一的集群ID
./bin/kafka-storage.sh random-uuid

2 用kafka-storage.sh 格式化存储数据的目录
#每个节点都要执行

./bin/kafka-storage.sh format -t 6ZR7p7uLQ1-MKJkYeNIqJg  -c ./config/kraft/server.properties

--虚拟机注意修改 advertised.listeners=PLAINTEXT://192.168.0.4:9092

3 用bin/kafka-server-start.sh 启动Kafka Server
./bin/kafka-server-start.sh ./config/kraft/server.properties

4创建测试topic
./bin/kafka-topics.sh --bootstrap-server 192.168.0.4:9092 --create --topic firstTestTopic --replication-factor 1 --partitions 2  

