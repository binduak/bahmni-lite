- Setup 
checkout from this repo.
Assuming that opnemrs, bahmniapps and bahmni_config are available at the below paths in Vagrant/Bahmni CentOS Server
  * copy openmrs from /opt/openmrs/openmrs to ~/bahmni-lite/.
  * copy bahmniapps from /opt/bahmni-web/etc/bahmniapps to ~/bahmni-lite/.
  * copy bahmni_config from /opt/bahmni-web/etc/bahmni_config to ~/bahmni-lite/.
Create a directory configuration in ~/bahmni-lite/openmrs
  * Example mkdir /Users/tbindu/bahmni-lite/openmrs/configuration
copy bahmnicore.properties, /opt/openmrs/modules from relevent folders   
  * cp /opt/openmrs/bahmnicore.properties ~/bahmni-lite/openmrs/configuration/.
  * cp /opt/openmrs/modules ~/bahmni-lite/openmrs/configuration/.
Add below openmrs-runtime.properties file in   ~/bahmni-lite/openmrs/configuration/.
   * add the contents of the file here

Create .OpenMRS directory in home directory. 
  example mkdir /Users/tbindu/.OpenMRS
Create sym links from  ~/bahmni-lite/openmrs/configurations/ folder
  * ln -s ~/bahmni-lite/openmrs/configuration/bahmnicore.properties bahmnicore.properties
  * ln -s ~/bahmni-lite/openmrs/configuration/modules modules
  * ln -s ~/bahmni-lite/openmrs/configuration/openmrs-runtime.properties openmrs-runtime.properties

-  Setup openMRS database
  Install mysql and import openmrs database or connect to openmrs database in Vagrant
  Update connection.url in openmrs-runtime.properties file accordingly.
- Build bahmni-lite project using the following command
./gradlew build
- Run bahmni-lite using the following command
cd build/libs 
java -jar bahmni-lite-1.0-SNAPSHOT.jar /Users/tbindu/bahmni-code/lite/openmrs/openmrs /Users/tbindu/bahmni-code/lite/bahmniapps /Users/tbindu/bahmni-code/lite/bahmni_config

Bahmni Lite is up & running!!
