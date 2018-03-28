# Selenium-maven

## Requirement :
 1 - Browser : Firefox v53.0 since geckdodriver used is 1.0.18

 2 - Browser : Chrome v64.0
 
## Setup :
 1 - Download Java and setup Java to path variable
 
 2 - Download Maven and setup Maven to path variable
 
 3- Download IDE.
 
 4 - Download Jenkins war file.
 
 5 - Run Jenkins by issue command line : java -jar jenkins.war (--httpsPort=9090 if we want to run Jenkins on different ports)

 ![Alt text](http://i67.tinypic.com/2mn0why.jpg "jenkins-command")

 6 - Check result by accessing to address : http://localhost:8080/

 ![Alt text](http://i66.tinypic.com/2uegqio.png "jenkins-home")

 7 - Install Git if required.
 
 ![Alt text](http://i66.tinypic.com/2mdkswl.png "git-version")
 
 Please configure your credentials by issuing command line: `git config --global user.name = "your_name"` and
 `git config --global user.email = "example@yourmail.com"` 

 ## Run the test:
 
 ### With Maven:
 1 - Go to your preferred folder then issuing command line : `git pull https://github.com/hienhoangminh/selenium-maven.git`

 2 - Browse to project file folder then issuing command line : `mvn clean` to clean the target folder

 ![Alt text](http://i65.tinypic.com/2vct0u1.png "mvn-clean")
 
 3 - Issue command line `mvn compile` to compile project.
 ![Alt text](http://i63.tinypic.com/30igmkw.png "mvn-compile")

 4 - Finally run the test by issuing command line : `mvn test` to run all tests or `mvn test -Pprofile_name`. Actually my project
 have only 2 profiles : SanityTest and Regression, which serves for self-training purpose.
 ![Alt text](http://i68.tinypic.com/2ug2sdv.png "mvn-test-profile")

 ### Run the test with Jenkins: (on-going)
 
 
