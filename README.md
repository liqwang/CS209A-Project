# CS209A Project Report

**Frontend: 宋一鸣 12011609**

**Backend: 王立全 12011619**

**Frontend & Backend: 方嘉玮 12110804**



## Overview

In this project, we make two main parts:

- Hot dependencies in pom.xml
- Tool used contribution in different countries

The project's architecture is **Vue + SpringBoot**, so the frontend and backend can split, and we use **Json** as data exchange format



## Frontend

File tree

```
│   .browserslistrc
│   .gitignore
│   babel.config.js
│   jsconfig.json
│   LICENSE
│   package-lock.json
│   package.json
│   postcss.config.js
│   preview.png
│   README.md
│   tailwind.config.js
│   vue.config.js
│   yarn.lock
│
├───public
│       .htaccess
│       favicon.ico
│       index.html
│       web.config
│       _redirects
│
└───src
    │   App.vue
    │   main.js
    │
    ├───assets
    │   │   animate.css
    │   │   logo.png
    │   │   tailwind.css
    │   │
    │   ├───img
    │   │       user.jpg
    │   │       user.png
    │   │       user1.png
    │   │       user2.png
    │   │       user3.png
    │   │       user4.png
    │   │       user5.png
    │   │
    │   └───sass
    │       │   app.windzo.scss
    │       │
    │       └───css
    │               windzo.css
    │               windzo.css.map
    │
    ├───components
    │       AppAccordion.vue
    │       Dropdown.vue
    │       Footer.vue
    │       Header.vue
    │       MenuAccordion.vue
    │       Sidebar.vue
    │
    ├───router
    │       index.js
    │
    └───views
        │   Dashboard.vue
        │
        └───components
                accordion.vue
                alert.vue
                badges.vue
                breadcumbs.vue
                button.vue
                card.vue
```





## Backend

File tree

```
├───java
│   └───edu
│       └───sustech
│           ├───backend
│           │   ├───controller
│           │   │   └───API
│           │   ├───dao
│           │   ├───dto
│           │   ├───entities
│           │   └───service
│           │       └───models
│           └───search
│               └───engine
│                   └───github
│                       ├───analyzer
│                       ├───API
│                       │   ├───rate
│                       │   └───search
│                       │       └───requests
│                       ├───models
│                       │   ├───code
│                       │   ├───commit
│                       │   ├───content
│                       │   ├───githubapp
│                       │   ├───issue
│                       │   ├───label
│                       │   ├───pullrequests
│                       │   ├───repository
│                       │   ├───topic
│                       │   └───user
│                       ├───parser
│                       └───transformer
└───resources
    └───dao
```

### Controller

#### getTopUsedDependencies

```java
@RequestMapping("data/top-used-dependencies")
public ResponseEntity<String> getTopUsedDependencies(
    @RequestParam(value = "group", required = false) String group,
    @RequestParam(value = "date", required = false) Date date,
    @RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
    return ResponseEntity.ok(backendService.getTopUsedDependencies(group, date, count));
}
```

This method returns the top used dependencies using specific param: **group、date、count**

The frontend can also set no search param to get the general result



#### getTopUsedVersions

```java
@RequestMapping("data/top-used-version")
public ResponseEntity<String> getTopUsedVersions(
    @RequestParam("group") String group,
    @RequestParam("arifact") String artifact,
    @RequestParam(value = "year", required = false) Integer year) {
    return ResponseEntity.ok(backendService.getTopUsedVersions(group, artifact, year));
}
```

This method returns the top used versions of specific **group**'s **artifact** in a specific **year(not neccessary)** to frontend



#### getGroups

```java
@RequestMapping("groups")
public String getGroups(){
    return backendService.getAvailableGroupSelections();
}
```

This method returns the group list that the user can select



#### update

```java
@RequestMapping("local/update-all")
public ResponseEntity<String> update() throws IOException, InterruptedException {
    if (status == UpdateStatus.NOT_INITIATED) {
        status = UpdateStatus.PROGRESS;
        updateData();
    } else {return ResponseEntity.badRequest().body("Failed. The update is initiated: " + status);}
    return ResponseEntity.ok("OK. Update status: " + status);
}
```

This method updates all the data for frontend by invoking the github search engine



### Github search engine

To make our search request more convenient, we packaged some API for Java program using Github API



### Data persistence

We use two methods for data persistence

#### Database

We use cloud **MySQL** database and **Mybatis** ORM framework

.<img src="README.pictures/image-20220522220830677.png" alt="image-20220522220830677" style="zoom:80%;" />

Here is an dto example

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Version {
	Integer id;
	String version;
	Integer count;
	Integer artifactId;
}
```

Here is an dao example, we use **Mybatis**

```java
public interface VersionDao {
	int insert(@Param("version") String version,@Param("artifactId") Integer artifactId);

	Version get(@Param("version") String version,@Param("artifactId") Integer artifactId);

	//count++
	void increment(@Param("id") Integer id,@Param("newCount") Integer newCount);
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="edu.sustech.backend.dao.VersionDao">
    <insert id="insert">
        insert into version(version, count, artifact_id) values (#{version},1,#{artifactId})
    </insert>

    <select id="get" resultType="Version">
        select * from version where version=#{version} and artifact_id=#{artifactId}
    </select>

    <update id="increment">
        update version set count=#{newCount} where id=#{id}
    </update>
</mapper>
```





 #### File

Besides the database, we also use files, which stores the json data



## Insights





