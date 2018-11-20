# micro-poc
Poc Microservicios


Para ejecutar se requiere adicionalmente Consul y Kafka

Se los puede obtener de las siguientes imagenes

  docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=localhost --env ADVERTISED_PORT=9092 spotify/kafka
  
  docker run -d --name=dev-consul --network="host" consul
