# tba-apiv2-java

[![Build Status](https://travis-ci.org/phil-lopreiato/tba-apiv2-java.svg)](https://travis-ci.org/phil-lopreiato/tba-apiv2-java) [![Coverage Status](https://coveralls.io/repos/phil-lopreiato/tba-apiv2-java/badge.svg?branch=master)](https://coveralls.io/r/phil-lopreiato/tba-apiv2-java?branch=master)

A simple java implementation of The Blue Alliance APIv2 using Retrofit. Supports returning both synchronous data and rxjava Observables

## Downloading

### gradle

the [jcenter() shortcut requires at least gradle 1.7](http://www.gradle.org/docs/1.7/release-notes#jcenter-repository-support)

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.plnyyanks.thebluealliance:apiv2:+'
}
```

### maven

```xml
<repository>
    <id>jcenter</id>
    <url>https://jcenter.bintray.com/</url>
</repository>
```

```xml
<dependency>
    <groupId>com.plnyyanks.thebluealliance</groupId>
    <artifactId>apiv2</artifactId>
    <version>...</version>
</dependency>
```

## Examples

It's pretty straightforward. Check the [interface](https://github.com/phil-lopreiato/tba-apiv2-java/blob/master/apiv2/src/main/java/com/plnyyanks/tba/apiv2/interfaces/APIv2.java) to see what API calls are available. Make sure you set your App Id with `APIv2Helper.setAppId()`

```java
import com.plnyyanks.tba.apiv2.APIv2Helper;
import com.plnyyanks.tba.apiv2.interfaces.APIv2;
import com.plnyyanks.tba.apiv2.models.Team;

...
APIv2Helper.setAppId("plnyyanks:apitest:v0.1");
APIv2 api = APIv2Helper.getAPI();
Team uberbots = api.fetchTeam("frc1124", null); // Add 'If-Modified-Since' header (String) as the second parameter
System.out.println("Got team with key: "+team.getKey());
```

If you instead want to have an Observable returned, the syntax is very similar.
```java
import com.plnyyanks.tba.apiv2.APIv2Helper;
import com.plnyyanks.tba.apiv2.interfaces.ObservableAPIv2;
import com.plnyyanks.tba.apiv2.models.Team;

...
APIv2Helper.setAppId("plnyyanks:apitest:v0.1");
APIv2 api = APIv2Helper.getObservableAPI();
api.fetchTeamObservable("frc1124", null).subscribe(new Action1<Team>() {
            @Override
            public void call(Team team) {
                System.out.println("Got team with key: "+team.getKey());
            }
        });
```

## License

This library is released under the MIT License. See LICENSE.md for full details
