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



### Github search engine

To make our search request more convenient, we packaged some API for Java program using Github API



### Data persistence

We use two methods for data persistence

#### Database

We use cloud **Mysql** database and **Mybatis** ORM framework

.<img src="README.pictures/image-20220522220830677.png" alt="image-20220522220830677" style="zoom:80%;" />





 #### File

Besides the database, we also use files, which stores the json data



## Insights





