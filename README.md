# Índice de equilibrio
# Clonación del repositorio 

git clone https://github.com/joaquin1997/indice-equlibrio.git

# Ejecución desde jar

cd ./indice-de-equilibrio

./mvnw clean package

cd ./target

java -jar ./indice-de-equilibrio-0.0.1-SNAPSHOT

# Ejecución del código

cd ./indice-de-equilibrio

./mvnw clean spring-boot:run

# Peticiones a la API

POST /indiceEquilibrio/calcularIndiceEquilibrio

curl --location --request POST 'http://localhost:8080/indiceEquilibrio/calcularIndiceEquilibrio' \\
--header 'Content-Type: application/json' \\
--data-raw '{
    "enteros":[-7, 1, 5, 2, -4, 3, 0 ]
}'

GET /indiceEquilibrio/getIndicesEquilibrio

curl --location --request GET 'http://localhost:8080/indiceEquilibrio/getIndicesEquilibrio'
