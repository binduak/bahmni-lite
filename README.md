- Setup Bahmni UI
* Clone bahmni-lite from `https://github.com/binduak/bahmni-lite.git` repo.
* Assuming that opnemrs, bahmniapps and bahmni_config are available at the below paths in Vagrant/Bahmni CentOS Server
   copy openmrs from `/opt/openmrs/openmrs` to `~/bahmni-lite/.`
   copy bahmniapps from `/opt/bahmni-web/etc/bahmniapps` to `~/bahmni-lite/.`
   copy bahmni_config from `/opt/bahmni-web/etc/bahmni_config` to `~/bahmni-lite/.`
* Create configuration dir in `~/bahmni-lite/openmrs`
   Eg: `mkdir /Users/tbindu/bahmni-lite/openmrs/configuration`
* Copy bahmnicore.properties, modules from relevent folders   
   copy bahmnicore.properties from `/opt/openmrs/bahmnicore.properties` to `~/bahmni-lite/openmrs/configuration/.`
   copy modules folder from `/opt/openmrs/modules` to `~/bahmni-lite/openmrs/configuration/.`
* Add the below mentioned key values in `~/bahmni-lite/openmrs/configuration/openmrs-runtime.properties`
 
 `auto_update_database=true`
 `connection.username=openmrs-user`
 `connection.password=password`
 `connection.url=jdbc:mysql://localhost:3306/openmrs?autoReconnect=true`
 `application_data_directory=/Users/tbindu/bahmni-code/lite/openmrs/configuration`
 `module.allow_web_admin=false`

* Create `.OpenMRS` directory in home directory. 
  Eg: `mkdir /Users/tbindu/.OpenMRS`
* Create sym links to `.OpenMRS` folder from  `~/bahmni-lite/openmrs/configurations/` folder
   `ln -s ~/bahmni-lite/openmrs/configuration/bahmnicore.properties bahmnicore.properties`
   `ln -s ~/bahmni-lite/openmrs/configuration/modules modules`
   `ln -s ~/bahmni-lite/openmrs/configuration/openmrs-runtime.properties openmrs-runtime.properties`

-  Setup OpenMRS Database
*  Install mysql and import openmrs database or connect to openmrs database in Vagrant
*  Update `connection.url` in `openmrs-runtime.properties` file accordingly.
* Build bahmni-lite project using the following command
   `./gradlew build`
*  Run bahmni-lite using the following command
   `cd build/libs`
   `java -jar bahmni-lite-1.0-SNAPSHOT.jar /Users/tbindu/bahmni-code/lite/openmrs/openmrs /Users/tbindu/bahmni-code/lite/bahmniapps /Users/tbindu/bahmni-code/lite/bahmni_config`

Bahmni Lite is up & running!!
