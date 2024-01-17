docker build -t ServiceSupply .
docker stop ServiceSupply || true
docker rm ServiceSupply || true
docker run -d -p 8080:8080 -- name ServiceSupply ServiceSupply