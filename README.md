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
