FROM bellsoft/liberica-openjdk-alpine:latest
WORKDIR /app
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/ru/solarev/lesson1/SeaBattle.java
CMD java -cp ./out ru.solarev.lesson1.SeaBattle
