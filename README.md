# Examarbetet Hongwei Han

This project aims to generate a demo by which users can check hotel information and book hotel.

![image1](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Examarbetet.png?raw=true)

## Prerequisites

- Alibaba Nacos

```docker run --name nacos-quick -e MODE=standalone -p 8848:8848 -p 9848:9848 -d nacos/nacos-server:v2.2.0```

- Mysql

```docker compose -f docker-compose-mariadb.yml up```

- Elastic search

```docker compose -f docker-compose-elasticsearch.yml up```

## Micoservices

- User Information Service

The program uses MyBatis to create, select, update, and delete user information in the MySQL table tb_userInfo. MyBatis automatically converts snake_case to camelCase. Data from the repository is updated in the service section and is exposed at the endpoint /user.

- Order Information Service

The program applies similar methods in the order information service. When users review order information, the program retrieves user information through the OpenFeign service.

- Elasticsearch Service

The program uses spring-boot-starter-data-elasticsearch to connect to Elasticsearch. It applies JPA to select hotel information.

- Authentication Service

Based on the user information database, the program generates and decodes tokens. The endpoint /auth/login generates tokens, while the endpoint /test/protected ensures the service functions correctly. Additionally, the program deciphers passwords using the JWTProvider method.

- Gateway Service

Users can access different services through the same address and port. The gateway service also handles load balancing. The endpoint /auth/login is directly exposed so users can visit it without a token. For other endpoints, users need to provide a token.

- OpenFeign Service

The program uses spring-cloud-starter-openfeign to configure OpenFeign. With OpenFeign, the user information service endpoint is internally exposed. Meanwhile, feign-httpclient delivers the endpoint to the order information service. This enables the order information service to display user information.

## Results

- Endpoints
![Endpoints](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-28%20at%2009.33.02.png?raw=true)

### With gateway and Oauth2

- Login in order to get token

![Login](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.52.02.png?raw=true)

- Without token the response is error
![Error](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.52.22.png?raw=true)

- With token, the program gets user information, `abc`.

![UserInfo](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.52.52.png?raw=true)

- With token the program gets order information in response to the user information

![OrderInfo_1](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.53.44.png?raw=true)

![OrderInfo_2](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.54.49.png?raw=true)

- Research the data from elastic search

![ES_1](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.54.23.png?raw=true)

![WS_2](https://github.com/niuniu268/ExamensarbeteBackend/blob/master/img/Screenshot%202024-05-27%20at%2010.40.15.png?raw=true)

## Limitation

- RabbitMQ
- Redis
- Deployment