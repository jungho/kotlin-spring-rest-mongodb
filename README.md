# Spring RESTFul API with MongoDB in Kotlin #

This is a simple example of a RESTful API that is backed by a MongoDB collection using Spring Boot, Spring Repositories, implemented in Kotlin. 

[Kotlin](https://kotlinlang.org/) is a new language for the JVM created by the Jetbrains team - the creators of the best IDE for Java programmers, IntelliJ. It takes the best ideas from Scala, Groovy, C#, Python, Ruby, Clojure, and others.  The result is a language that is very concise, readable, safe (e.g. null safety, statically typed), performant and fully interoperable with Java.  As an example, here is how you would define a simple class with, three read-only properties.  It is one line.

```
class Post (val id: String, val categories: String, val content: String)

```

This conciseness, along with the expressiveness of the language through features such as extension functions, lambdas with receivers, infix function calls, etc, results in code that almost reads like English. This, in turn, results in greater productivity and more maintainable code.  That is good for engineers and for business.  We will be adopting Kotlin as the language for the JVM so it is important for people to start getting familiar with it.  

## Note ##

As the application uses OAuth2 authentication with Azure AD and uses Azure CosmoDB MongoDB service for the durable store, you will need to provision these services in your Azure subscription.  Once you do, update the [application-development.yml](./src/main/resources/application-development.yml) config file to update the necessary config.

## References ##

1. [Kotlin Language Reference](https://kotlinlang.org/docs/reference/)
2. [Kotlin Koans](https://kotlinlang.org/docs/tutorials/koans.html) - A set of unit tests that you make pass in order to learn and understand Kotlin language features.
3. [Kotlin Education Plugin](https://blog.jetbrains.com/kotlin/2016/03/kotlin-educational-plugin/) - The easiest and recommended way to learn the language directly within IntelliJ.
4. [Kotlin in Action](https://www.amazon.ca/Kotlin-Action-Dmitry-Jemerov/dp/1617293296/ref=sr_1_1?ie=UTF8&qid=1492439407&sr=8-1&keywords=Kotlin) - A good book authored by the creators of Kotlin.
5. [Idiomatic Kotlin](https://blog.philipphauer.de/idiomatic-kotlin-best-practices/)
6. [Exploring the Kotlin standard library](http://beust.com/weblog/2015/10/30/exploring-the-kotlin-standard-library/) - An excellent example of the power of Kotlin.
7. [Awesome Kotlin](https://github.com/KotlinBy/awesome-kotlin) - A curated list of awesome Kotlin related stuff inspired by awesome-java.