FROM bellsoft/liberica-openjdk-alpine:latest
WORKDIR /app1
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/App.java
CMD java -cp ./out App