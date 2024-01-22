docker build -t servicesupply .
docker stop servicesupply || true
docker rm servicesupply || true
docker run -d -p 20289:8080 --name servicesupply -e SPRING_PROFILES_ACTIVE=prod --network servicesupply-network --restart unless-stopped servicesupply