You need Java installed.
This is an IntelliJ IDEA project and it should be compatible with Eclipse (but not tested).

Dependencies are located in libs/*.jar

Compile:
```bash
javac -cp "libs/*" \
 src/com/anti_captcha/*.java \
 src/com/anti_captcha/Api/*.java  \
 src/com/anti_captcha/ApiResponse/*.java \
 src/com/anti_captcha/Helper/*.java \
 src/com/anti_captcha/Http/HttpRequest.java \
 src/com/anti_captcha/Http/HttpResponse.java
```

Run:
```bash
$ java -cp "src:libs/*" com.anti_captcha.Main
```
