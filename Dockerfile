FROM openjdk:8
EXPOSE 8080
ADD target/product-management-system.jar product-management-system.jar
ENTRYPOINT ["java","-jar","/product-management-system.jar"]