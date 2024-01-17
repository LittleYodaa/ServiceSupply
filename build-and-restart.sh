docker build -t servicesupply .
docker stop servicesupply || true
docker rm servicesupply || true
docker run -d -p 8080:8080 --name servicesupply servicesupply