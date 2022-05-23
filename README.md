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

#### Structure

The whole frontend is based on ```NodeJs``` and ```Vue.js``` framework. The intention is to create a dynamic web application that allows user interaction from **web brosers** for an immersive user experience, and without the need to interact with the server API to change the web content. *In this project we used Windzo as a template* (See [sahrullahh/windzo: Free Open Source Template Dashboard Admin Vue Tailwind CSS (github.com)](https://github.com/sahrullahh/windzo)).

The frontend and the backend uses **Rest API** to communicate: The frontend uses ```get``` method to get the data from the backend server. When necessary, it also uses ```post```  method to post configurations and operations to the backend server for further actions.

```
Navigation
├───DashBoard
├───ComponentTest
│       ├───Accordion
│       ├───Alert
│       ├───Badges
│       ├───Breadcumbs
│       ├───Button
│       ├───Card
│       └───Badges
└───OnlineTest
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

This method updates all the data for frontend by invoking the GitHub Search Engine.



### GitHub Search Engine

To make the searching process more fluently, automatically and more robust, we introduce the GitHub Search Engine.

This GitHub Search Engine has iterated *several* times, been published to GitHub and has till now released several packages of different versions. You can check them on [IskXCr/GitHubSearchEngine: A GitHub search engine for backend application](https://github.com/IskXCr/GitHubSearchEngine). To load the GitHub Search Engine from GitHub Packages, you may need to configure your local ``.m2`` maven repository settings (which is typically under the user folder, if Windows is considered).

#### File Tree

```
edu.sustech
└───engine
    ├───github
    │   ├───analyzer
    │   │       Analyzer.java
    │   │
    │   ├───API
    │   │   │   ContentAPI.java
    │   │   │   FileAPI.java
    │   │   │   GitHubAPI.java
    │   │   │   RepositoryAPI.java
    │   │   │   RequestRateExceededException.java
    │   │   │   RestAPI.java
    │   │   │   SearchAPI.java
    │   │   │   UserAPI.java
    │   │   │
    │   │   ├───rate
    │   │   │       ActionsRunnerRegistration.java
    │   │   │       CodeScanningUpload.java
    │   │   │       Core.java
    │   │   │       Graphql.java
    │   │   │       IntegrationManifest.java
    │   │   │       Rate.java
    │   │   │       RateLimitResult.java
    │   │   │       Resources.java
    │   │   │       Scim.java
    │   │   │       Search.java
    │   │   │       SourceImport.java
    │   │   │
    │   │   ├───repository
    │   │   ├───search
    │   │   │   │   ETag.java
    │   │   │   │   InvalidResultException.java
    │   │   │   │
    │   │   │   └───requests
    │   │   │           CodeSearchRequest.java
    │   │   │           CommitSearchRequest.java
    │   │   │           IPRSearchRequest.java
    │   │   │           LabelSearchRequest.java
    │   │   │           RepoSearchRequest.java
    │   │   │           SearchRequest.java
    │   │   │           TopicSearchRequest.java
    │   │   │           UserSearchRequest.java
    │   │   │
    │   │   └───user
    │   ├───models
    │   │   │   Alias.java
    │   │   │   APIErrorMessage.java
    │   │   │   AppendableResult.java
    │   │   │   Author.java
    │   │   │   AuthorAssociation.java
    │   │   │   CodeOfConduct.java
    │   │   │   Dependency.java
    │   │   │   Entry.java
    │   │   │   License.java
    │   │   │   Match.java
    │   │   │   Milestone.java
    │   │   │   OAuthToken.java
    │   │   │   Owner.java
    │   │   │   Parent.java
    │   │   │   Permissions.java
    │   │   │   Reactions.java
    │   │   │   Related.java
    │   │   │   State.java
    │   │   │   TextMatch.java
    │   │   │
    │   │   ├───code
    │   │   │       CodeItem.java
    │   │   │       CodeResult.java
    │   │   │
    │   │   ├───commit
    │   │   │       Commit.java
    │   │   │       CommitItem.java
    │   │   │       CommitResult.java
    │   │   │       Tree.java
    │   │   │       Verification.java
    │   │   │
    │   │   ├───content
    │   │   │       ContentDirectory.java
    │   │   │       ContentFile.java
    │   │   │       Links.java
    │   │   │       RawContent.java
    │   │   │       SymlinkContent.java
    │   │   │
    │   │   ├───filetree
    │   │   ├───githubapp
    │   │   │       GitHubApp.java
    │   │   │       Permissions.java
    │   │   │
    │   │   ├───issue
    │   │   │       IPRResult.java
    │   │   │       Issue.java
    │   │   │
    │   │   ├───label
    │   │   │       Label.java
    │   │   │       LabelResult.java
    │   │   │
    │   │   ├───pullrequests
    │   │   │       PullRequest.java
    │   │   │       PullRequestResult.java
    │   │   │
    │   │   ├───repository
    │   │   │       Repository.java
    │   │   │       RepositoryResult.java
    │   │   │
    │   │   ├───topic
    │   │   │       Topic.java
    │   │   │       TopicRelation.java
    │   │   │       TopicResult.java
    │   │   │
    │   │   └───user
    │   │           User.java
    │   │           UserResult.java
    │   │
    │   ├───parser
    │   │       JsonSchemaParser.java
    │   │
    │   ├───test
    │   └───transformer
    │           Transformer.java
    │
    └───stackoverflow
```

#### Functionality

The engine has a ***fully functional implementation*** of the search function of the GitHub Rest API (```SearchAPI```) and provides Java abstractions for dealing with objects present in GitHub (for example, ``Repository``, ``User``, ``Issues``, ``Commits``, etc. Those existing models can be found inside the ```models``` directory in the source code). It also provides additional ***partially implemented*** APIs such as ```UserAPI```, ```RepositoryAPI``` and ```RateAPI``` for other needs such as tracing user locations and attain the information related to real-time GitHub rate limits.

An automatical loop for dealing with the common exceptions, including ```timeout```, ```RateLimitExceeded``` has been constructed to improve the user experience when in autonomous mode.

#### Basic Usage

##### Build a request

```java
	CodeSearchRequest req1 = CodeSearchRequest.newBuilder()
		.addSearchField(CodeSearchRequest.SearchBy.Filename, "pom.xml")
		.addLanguageOption("Maven POM")
		.build();
```

Similar searches can be done on ```Issues```, ```Pull Requests```, ```Commits```, ```Users```, ```Repositories```, ```RawFiles```

##### Search in GitHub

```
	CodeResult result1 = gitHubAPI.searchAPI.searchCode(req1, count, LOCAL_SEARCH_UPDATE_INTERVAL_MILLIS);
```

##### Query the results

```java
	for(CodeItem item: CodeResult){
        
        Repository repo = item.getRepository();
        System.out.println(repo.getFullName() + ", " + item.getName());
        
        //Get the list of contributors
        List<User> userList = gitHubAPI.repositoryAPI.getContributors(repo);
        
        //Sort users by their contributions in the specific repository 
		userList.sort(Comparator.comparingInt(User::getContributions).reversed());
        for(User user: userList){
            System.out.println(user.getLogin());
        }
    }
```

#### Abstractions

**All** items related to the **search** part of the GitHub RestAPI has been implemented. See the file tree above to get more info.

#### Implementation of the GitHub Search Engine (Partially)

###### 

#### Documentations

Documentations will later be generated in the format of JavaDoc directly from those JavaDoc embedded in the code. The code implements the basic methods all as generic, and users are expected to check the documents of those generic methods when encountering specific problems with the implementation of a specifc method (that is related to a certain abstraction, for example ``User``).

### Data Persistence

We use two methods for data persistence:

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

Besides the database, we also use files, which stores the json data.



## Insights