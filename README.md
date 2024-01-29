# Lab 05

## Group
This group is composed of 2 great minds known as :
* Adrien Mareel (PHP beast, King of JEE)
* Hugo Vanderhaegen (C# expert)
  
## Intro
Several goals for this homework:
* It is based on the previous practice (code + database)
* You will create a MVC architecture with Spring WebMVC
* You will write some logs

## DB
* Everything will be writter in a schema named `junia_lab05`
* We assume that your DB credentials are `root:root`. If it's not the case, you can change the credentials in `application.properties` files.

## Provided content

You have a code base with 2 provided Maven modules:
* **lab05-core** with the entities, the DAOs and the business services, no need to add anything in this module.
* **lab05-data** in which you will find some code that will help you to populate your database.
* **'resources' folder** where you will find files you will copy elsewhere in your code. Beware of the paths inside the files when you copy! Sometimes your IDE will try to update them, even if it is not necessary...

## Instructions
### Dependencies
Create a new Maven module called **lab05-web**. Even if you build a webapp, its packaging must be `jar`, the default one, because you are building a fatjar thanks to SpringBoot.

For this module, you have to declare, in the `pom.xml` file, the following dependencies.

| groupId                  | artifactId                    | version            | 
|--------------------------|-------------------------------|--------------------|
| ${project.groupId}       | lab05-core                    | ${project.version} |
| org.springframework.boot | spring-boot-starter-web       |              | 
| org.springframework.boot | spring-boot-starter-thymeleaf |              | 



### Initializer
In the `junia.lab05.web` package, create a class named `WebApplication`. If you need to know what to write inside, you have several tips:
- in the provided codebase
- in the SpringBoot demo made by the teacher previously
- in https://start.spring.io/ 

### WebConfig
In the `junia.lab05.web.config` package, create the `WebConfig` class.
- Annotate this class with `@Configuration`
- Add another annotation in order to load `CoreConfig.class` (tip in demo)


### SagasController
In the `junia.lab05.web.controller` package, create the `SagasController` class.
- Annotate this class with `@Controller`
- Annotate this class with `@RequestMapping("sagas")`
- Inject the `SagaService`
- Create a method `getListOfSagas`
    - it takes a parameter of type `ModelMap`
    - it returns a String
    - its implementation is quite simple, it loads all the sagas from the DB with `findAllWithPhasesAndMovies` method from the service, puts it in the modelMap with the key `sagas` then returns `"SagasList"` (it will load the provided template in `SagasList.html` that you must put in `src/main/resources/templates/`)
    - annotate this method in order to map this method with the current HTTP Request info:
        - path : `/list`
        - verb : GET

## Configuration
Don't forget to copy the `application.properties` from the "data" module to the "web module"

## Deployment
Start your app then guess which URL you have call :)

## SO UGLY!!!
Maybe we forgot to provide the static resources (css and fonts) to the browser... Check that : https://www.baeldung.com/spring-mvc-static-resources

## Let's continue
### MoviesController

In the `junia.lab05.web.controller` package, create the `MoviesController` class.
- Annotate this class with `@Controller`
- Annotate this class with `@RequestMapping("movies")`
- Inject 2 services:
  - MovieService
  - PhaseService

Create a `addMovieForm` method which returns a `String` and takes 2 parameters. The first one is a `ModelMap` and the second is a `long` that you will annotate with `@RequestParam("phase")`. Indeed, it is how you fetch the phase id in the URL after `?phase=`.
- create a new instance of `Movie` then stores it in the map (guess the key of this new entry of the model, the templates will give you some tips!).
- thanks to the phase id you have in parameter, use the `PhaseService` in order to put an instance of the correct phase inside the model
- return `"MovieForm"`
- add the correct annotation in order to map this method to the `/add` URL.

Create a `saveMovie` method
- it returns a `String`
- it takes a `Movie` parameter, annotated with `@ModelAttribute("movie")`
- it still takes a `phaseId` parameter with its annotation, because the action url of the form also ends with `?phase=`
- it saves the movie in the DB, use the `saveMovieInPhase` method of the `MovieService`
- it returns `"redirect:../sagas/list` (remember the "redirect after submit" pattern?)
- annotate this method in order to map this method with the current HTTP Request info:
  - path : `/save`
  - verb : POST



## Deployment
Run your app once again and check if you can save a new movie

## Let's continue
### MovieController
Because you are a smart student, read the HTML template of the "trash" button then implement the deletion of a movie, followed by a refresh of the list.

## Logs
Inside the `src/main/resources` directory of the web module, paste the `logback.xml` file then check how the logs are formatted. Do not hesitate to play with this config to understand the concept of logging. You can also add some logging in your code.


***Good luck!***
