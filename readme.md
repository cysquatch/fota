# MAN FOTA Coding Challenge
When installing software over-the-air in trucks, one of the most relevant tasks is to know which functionalities are compatible with the truck's configuration (software and hardware).

# Installation
To install fota we need to build it with maven.
This will also run the tests provided.

```bash
mvn clean install
```

We'll also need to have an instance of mongoDb running at 27017.
I recommend running it on a Docker container. 
You can get the image and start it by running:
```bash
docker run -p 27017:27017 --name mongodb -d mongo
```

Once installed, the following commands can be used to start the application.
NOTE: run this inside 'fota-application' folder
NOTE: specify the folder where the is supposed to search for the files with the trucks configurations

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--targetFolder=PATH
```

# Public API
After the application is running you can access 
``http://localhost:8080/swagger-ui.html?urls.primaryName=default#/``
to check the available endpoints.

There's pagination and sorting available (``ASC`` or ``DESC``).

# Loading Truck configurations
To loading truck, just drop the files in the folder specified at startup.
The file will be processed and archived in the ``PROCESSED`` folder. 
