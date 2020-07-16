# MAN FOTA Coding Challenge
* When installing software over-the-air in trucks, one of the most relevant tasks is to know which functionalities are compatible with the truck's configuration (software and hardware).

# Installation
Use maven to build the application. This will also run the tests provided.

```bash
mvn clean install
```

Have an instance of mongoDb running at 27017. I recommend running it on a Docker container. 
* You can get the image and start it by running:
```bash
docker run -p 27017:27017 --name mongodb -d mongo
```

Once installed, the following commands can be used to start the application.
* NOTE: run this command in the folder 'fota-application'
* NOTE: ``PATH`` is the folder where the application scans files with the truck configurations

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--targetFolder=PATH
```

# Public API
* After the application is running you can access 
``http://localhost:8080/swagger-ui.html?urls.primaryName=default#/``
to check the available endpoints.

* Pagination and sorting available (``ASC`` or ``DESC``).

# Loading Truck configurations
* To load Truck configurations, just drop the files in the folder specified at startup.
* The file will be processed and archived in the ``PROCESSED`` folder. 
