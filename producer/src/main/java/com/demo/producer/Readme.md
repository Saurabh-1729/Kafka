docker run -d
 --name zookeeper
 -p 2181:2181
-e ZOOKEEPER_CLIENT_PORT=2181
-e ZOOKEEPER_TICK_TIME=2000
confluentinc/cp-zookeeper:7.5.0

docker run -d --name zookeeper -p 2181:2181 -e ZOOKEEPER_CLIENT_PORT=2181 -e ZOOKEEPER_TICK_TIME=2000 confluentinc/cp-zookeeper:7.5.0


docker run -d 
 --name kafka
-p 9092:9092
-e KAFKA_BROKER_ID=1
-e KAFAKA_ZOOKEEPER_CONNECT=zookeeper:2181
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1
--link zookeeper
confluentinc/cp-kafka:7.5.0

docker run -d --name kafka -p 9092:9092 -e KAFKA_BROKER_ID=1 -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 --link zookeeper confluentinc/cp-kafka:7.5.0


docker exec -it kafka bash
kafka-topics --list --bootstrap-server localhost:9092
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my-topic
kafka-console-consumer --bootstrap-server localhost:9092 --topic my-topic --from-beginning
kafka-console-producer --bootstrap-server localhost:9092 --topic my-topic


docker stop $(docker ps -q)
docker rm $(docker ps -aq)
docker network create <network_name>
docker network ls
docker network inspect my_network

