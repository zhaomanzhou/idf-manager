# idf
backend service for idf






## For docker-compose

to start it, just run the following command in the floder where the docker-compose file located
which is Docker/deploy  
`docker-compose up`  
if you want run it background, run it with parameter `-d`
if you want Build images before starting containers.
run it with parameter `--build`

to stop the container
run the following command
`docker-compose down` 




## install and run it
Environment requirement
- jdk8+
- maven3.6+
- mysql5.7+
- docker
- redis  
#### To run it
1. modify the configuration in application.yaml to your
environment, 
2. init the databases with the sql file in Docker/deploy-server/mmall.sql
3. start mysql server, redis server
4. run `mvn install` in the root directory
5. run `mvn spring-boot:run` to execute the program



