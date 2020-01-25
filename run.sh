#!/bin/bash

docker run -d --name postgres-world_db  -p 5432:5432 ghusta/postgres-world-db:2.4

mvn clean install

docker build -f DockerFile -t docker-spring-boot .

docker run -p 8080:8080 docker-spring-boot
