# CS209A Project Report

**Frontend: 宋一鸣 12011609**

**Backend: 王立全 12011619**

**Frontend & Backend: 方嘉玮 12110804**



We use **Vue** and **SpringBoot**, so the frontend and backend can split, and we use **Json** as data exchange format

## Frontend

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

```
├───java
│   └───edu
│       └───sustech
│           ├───backend
│           │   │   BackendApplication.java
│           │   │
│           │   ├───controller
│           │   │   │   DataImportController.java
│           │   │   │   TestController.java
│           │   │   │
│           │   │   └───API
│           │   │           APIController.java
│           │   │
│           │   ├───dao
│           │   │       ArtifactDao.java
│           │   │       GroupDao.java
│           │   │       VersionDao.java
│           │   │
│           │   ├───dto
│           │   │       Artifact.java
│           │   │       Group.java
│           │   │       Version.java
│           │   │
│           │   ├───entities
│           │   │       DependencyData.java
│           │   │
│           │   └───service
│           │       │   BackendService.java
│           │       │
│           │       └───models
│           │               BarChartItem.java
│           │
│           └───search
│               └───engine
│                   └───github
│                       ├───analyzer
│                       │       Analyzer.java
│                       │
│                       ├───API
│                       │   │   ContentAPI.java
│                       │   │   FileAPI.java
│                       │   │   GitHubAPI.java
│                       │   │   RepositoryAPI.java
│                       │   │   RequestRateExceededException.java
│                       │   │   RestAPI.java
│                       │   │   SearchAPI.java
│                       │   │   UserAPI.java
│                       │   │
│                       │   ├───rate
│                       │   │       ActionsRunnerRegistration.java
│                       │   │       CodeScanningUpload.java
│                       │   │       Core.java
│                       │   │       Graphql.java
│                       │   │       IntegrationManifest.java
│                       │   │       Rate.java
│                       │   │       RateLimitResult.java
│                       │   │       Resources.java
│                       │   │       Scim.java
│                       │   │       Search.java
│                       │   │       SourceImport.java
│                       │   │
│                       │   └───search
│                       │       │   ETag.java
│                       │       │   InvalidResultException.java
│                       │       │
│                       │       └───requests
│                       │               CodeSearchRequest.java
│                       │               CommitSearchRequest.java
│                       │               IPRSearchRequest.java
│                       │               LabelSearchRequest.java
│                       │               RepoSearchRequest.java
│                       │               SearchRequest.java
│                       │               TopicSearchRequest.java
│                       │               UserSearchRequest.java
│                       │
│                       ├───models
│                       │   │   Alias.java
│                       │   │   APIErrorMessage.java
│                       │   │   AppendableResult.java
│                       │   │   Author.java
│                       │   │   AuthorAssociation.java
│                       │   │   CodeOfConduct.java
│                       │   │   Dependency.java
│                       │   │   Entry.java
│                       │   │   License.java
│                       │   │   Match.java
│                       │   │   Milestone.java
│                       │   │   OAuthToken.java
│                       │   │   Owner.java
│                       │   │   Parent.java
│                       │   │   Permissions.java
│                       │   │   Reactions.java
│                       │   │   Related.java
│                       │   │   State.java
│                       │   │   TextMatch.java
│                       │   │
│                       │   ├───code
│                       │   │       CodeItem.java
│                       │   │       CodeResult.java
│                       │   │
│                       │   ├───commit
│                       │   │       Commit.java
│                       │   │       CommitItem.java
│                       │   │       CommitResult.java
│                       │   │       Tree.java
│                       │   │       Verification.java
│                       │   │
│                       │   ├───content
│                       │   │       ContentDirectory.java
│                       │   │       ContentFile.java
│                       │   │       Links.java
│                       │   │       RawContent.java
│                       │   │       SymlinkContent.java
│                       │   │
│                       │   ├───githubapp
│                       │   │       GitHubApp.java
│                       │   │       Permissions.java
│                       │   │
│                       │   ├───issue
│                       │   │       IPRResult.java
│                       │   │       Issue.java
│                       │   │
│                       │   ├───label
│                       │   │       Label.java
│                       │   │       LabelResult.java
│                       │   │
│                       │   ├───pullrequests
│                       │   │       PullRequest.java
│                       │   │       PullRequestResult.java
│                       │   │
│                       │   ├───repository
│                       │   │       Repository.java
│                       │   │       RepositoryResult.java
│                       │   │
│                       │   ├───topic
│                       │   │       Topic.java
│                       │   │       TopicRelation.java
│                       │   │       TopicResult.java
│                       │   │
│                       │   └───user
│                       │           User.java
│                       │           UserResult.java
│                       │
│                       ├───parser
│                       │       JsonSchemaParser.java
│                       │
│                       └───transformer
│                               Transformer.java
│
└───resources
    │   application.yml
    │   country.txt
    │   Dockerfile
    │   log4j.properties
    │   log4j2.xml
    │
    └───dao
            ArtifactDao.xml
            GroupDao.xml
            VersionDao.xml
```





### Github search engine

To make our search request more convenient, we packaged some API for Java program using Github API



### Data persistence

We use two methods for data persistence

#### Database

We use cloud **Mysql** database and **Mybatis** ORM framework

 #### File

Besides the database, we also use files, which stores the json data



