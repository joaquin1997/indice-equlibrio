    ____               __    _                            __                                       _     __    _     __              _        
   /  _/   ____   ____/ /   (_)  _____  ___          ____/ /  ___          ___   ____ _  __  __   (_)   / /   (_)   / /_    _____   (_)  ____ 
   / /    / __ \ / __  /   / /  / ___/ / _ \        / __  /  / _ \        / _ \ / __ `/ / / / /  / /   / /   / /   / __ \  / ___/  / /  / __ \
 _/ /    / / / // /_/ /   / /  / /__  /  __/       / /_/ /  /  __/       /  __// /_/ / / /_/ /  / /   / /   / /   / /_/ / / /     / /  / /_/ /
/___/   /_/ /_/ \__,_/   /_/   \___/  \___/        \__,_/   \___/        \___/ \__, /  \__,_/  /_/   /_/   /_/   /_.___/ /_/     /_/   \____/ 
                                                                                 /_/                                                          

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
