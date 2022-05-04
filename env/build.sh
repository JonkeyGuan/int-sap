cd ../
mvn clean package -DskipTests

cd env
oc start-build int-sap --from-dir=../target/ -F
