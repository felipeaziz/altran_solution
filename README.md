About:
URL to call the Ajuntament Endpoint:
http://localhost:8080/result/{language}

Language: There are examples for "en", "es" and "ca". The default language is "ca" so if you don´t put any language or
put an invalid language, the endpoint will return the results in Catalan.

My considerations:
As I didn´t have much time to do, I left as simple as possible. I created two tests. One unit test and one integrated
test.
I tried to use Jakson to auto convert the json into my result object but the json the opendata-ajuntament is sending is
in a strange format, so I created a class to parse the Json, and a unit test to it.

How to test:
The project was implemented using IntelliJ.

Import the project in IntelliJ or Eclipse IDE and execute it.

Access the URL: http://localhost:8080/result/{language}
as explained above.