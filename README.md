
# Spring Lorem

В репозитарии результат работы по целям

- обзорное исследование возможностей и архитектуры фрейворка java spring boot, 
и его составляющих, data, mvc, etc.

- написание минимального рабочего шаблона web REST приложения Java Spring + Angular/React

До этого момента я ни разу как либо серъезно не писал кода ни 
с применением Java JDK, ни тем более с применение Spring Boot.

Для слоя между SQL DBMS и Spring models/controllers я использовал 
только JdbcTemplate, так как итоговые цели использования этого шаблона
предусматривают использование специфичного SQL кода, плохо укладывающегося 
в рамки ORM библиотек.

## Сборка приложения

Собственно, итоговое приложение состоит из
- JAR bundle lorem-0.0.1.jar
- SQLite3 database lorem.db
- минимального стартового скрипта

    git clone https://github.com/sadsoldier/spring
    cd spring
    ./configure --prefix=/usr
    make install
    /usr/bin/lorem

## Doker file

    FROM debian:latest
    RUN apt-get -y update
    RUN apt-get install -y default-jre make git
    RUN apt-get install -y git daemon make automake autoconf
    RUN git clone https://github.com/sadsoldier/spring/ 
    RUN cd spring && ./configure --prefix=/usr 
    RUN cd spring && make install
    CMD daemon -- /usr/bin/java -jar /usr/lib/lorem/lorem-0.0.1.jar

## Bocker build and run

    docker build -t lorem .
    docker run -p 8080:8080 lorem

И далее варианты запуска по необходимости.

## Право использования

Прграммный код в репозитарии может использоваться 
для персональных образовательных и иследовательких целей.
Запрещается коммерческое использование прямо или косвенно, 
целиком или существенными частями.











