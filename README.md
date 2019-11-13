# backend-sandbox

## General info
> REST API for [ui-sandbox](https://github.com/My-Wine-Cellar/ui-sandbox)

## Quarkus
> This project is leveraging [Quarkus](https://github.com/quarkusio/quarkus) and was bootstrapped with their [code generator](https://github.com/quarkusio/quarkus)

## Docker
> You will need to have [Docker Engine](https://docs.docker.com/install/) installed before proceeding

```
$ docker run --name backend-sandbox -p 127.0.0.1:5432:5432 -d -e POSTGRES_USER=winecellar -e POSTGRES_PASSWORD=winecellar -e POSTGRES_DB=winecellar postgres
```
> This will pull down the latest PostgreSQL image and run the container with all necessary properties for connection. 

## Project Setup
```
$ git clone https://github.com/My-Wine-Cellar/backend-sandbox
$ cd backend-sandbox
$ ./mvnw compile quarkus:dev
```

## Contact
> Created by [Paul Pearson](mailto:paul.darlington.pearson@gmail.com), [Jesper Pedersen](https://github.com/jesperpedersen/), and [Dênis Mendes](https://github.com/dnsmnds/)

> Feel free to email us [mywinecellarinfo@gmail.com](mailto:mywinecellarinfo@gmail.com)