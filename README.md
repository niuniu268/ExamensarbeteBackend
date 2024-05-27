# Examarbetet Hongwei Han

![image1](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/Examarbetet.png?raw=true)

## Prerequisites

- Alibaba Nacos

```docker compose -f standalone-derby.yaml up```

- Mysql

```docker compose -f docker-compose-mariadb.yml up```

- Elastic search

```docker compose -f docker-compose-elasticsearch.yml up```

## Micoservices
- User information service

The program applies the Mybatis to create, select, update and delete user information in the Mysql table, tb_userInfo. Mybatis is able to convert the snake format to the camel format. Data from repository is updated in the service section and is exposed at endpoint /user.

- Order information service

The program applies similar methods in the order information service. When users review the order information, the program will receive users' information through openfeign service

- Elastic search service

The program uses `spring-boot-starter-data-elasticsearch` to connect to the elastic search. The program applies the JPA to select the hotel information.

- Authenication service

Based on the user information database, the program aims to generate token and decode the token. The endpoint, `/auth/login` generates the token. Meanwhile, the endpoint,`/test/protected` ensures the service works well. In addition, the program also decipher the password by `JWTprovider` method.

- Gateway service

Users can get access to different services through same address and port. Meanwhile, gateway service plays a role for the load balance. The endpoint `/auth/login` is directly exposed, so that users can visit the endpoint without token. Otherwise, users need to input token when they visit other endpoints.

- Openfeign service

The program use `spring-cloud-starter-openfeign` to configure the openfeign. Given openfeign service, the endpoint of user information service is internally exposed. Meanwhile, `feign-httpclient` attempts to deliver the endpoint to the order information service. With the help of the openfeign service, the order information service is able to show the user information.

## Results

### With gateway and Oauth2

## Limitation
- RabbitMQ
- Redis
- Deployment