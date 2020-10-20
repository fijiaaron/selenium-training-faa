# Selenium Training

## Prerequisites

### Download and install Java JDK

from https://www.oracle.com/java/technologies/javase-downloads.html

(or download the openjdk)

  Windows https://download.java.net/java/GA/jdk15/779bf45e88a44cbd9ea6621d33e33db1/36/GPL/openjdk-15_windows-x64_bin.zip
  Mac https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL/openjdk-14.0.2_osx-x64_bin.tar.gz
  Linux https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL/openjdk-14.0.2_linux-x64_bin.tar.gz
  
#### Linux
  
  tar -xvzf openjdk-14.0.2_osx-x64_bin.tar.gz
  
### Download and install Eclipse IDE 

from https://www.eclipse.org/

  Windows https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL/openjdk-14.0.2_windows-x64_bin.zip
  Mac https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-09/R/eclipse-java-2020-09-R-macosx-cocoa-x86_64.dmg
  Linux https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-09/R/eclipse-java-2020-09-R-linux-gtk-x86_64.tar.gz


### Download and install Maven 

#### Windows

  Download Maven zipfile (Windows, Mac) https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
  
  unzip apache-maven-3.6.3-bin.zip
  mdkir c:\tools
  mv apache-maven-3.6.3 c:\tools\
  setx MVN_HOME c:\tools\apache-maven-3.6.3
  
#### Mac & Linux

  Download Maven tarball (Mac, Linux)  https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz

  tar -xvzf apache-maven-3.6.3-bin.tar.gz
    
### Download and Install TestNG

  TestNG Eclipse Plugin https://marketplace.eclipse.org/content/testng-eclipse
  TestNG library https://repo1.maven.org/maven2/org/testng/testng/6.14.3/testng-6.14.3.jar


### Set environment variables for Java

#### Windows

(I use the path C:\jdk-14.0.2 but if yours is different, change JAVA_HOME & MVN_HOME accordingly)

  setx JAVA_HOME C:\jdk-14.0.2
  setx MVN_HOME C:\tools\apache-maven-3.6.3
  setx PATH %PATH%;%JAVA_HOME%\bin;%MVN_HOME%/bin
  
#### Mac

(Java should already be in the path, but if it is not...)

  export JAVA_HOME=$(/usr/libexec/java_home)
  export MVN_HOME=~/apache-maven-3.6.3
  export PATH=$PATH:$JAVA_HOME/bin;$MVN_HOME/bin
  
#### Linux 
  
  export JAVA_HOME=~/jdk-14.0.2
  export MVN_HOME=~/apache-maven-3.6.3
  export PATH=$PATH:$JAVA_HOME/bin;$MVN_HOME/bin

### Download Selenium from https://www.selenium.dev/

  Selenium Java Client https://selenium-release.storage.googleapis.com/3.141/selenium-java-3.141.59.zip
  Selenium Server Grid https://selenium-release.storage.googleapis.com/3.141/selenium-server-standalone-3.141.59.jar
  
### Download Selenium Drivers

  ChromeDriver https://chromedriver.chromium.org/downloads
  FirefoxDriver https://github.com/mozilla/geckodriver/releases
  
#### Windows
  
  ChromeDriver https://chromedriver.storage.googleapis.com/86.0.4240.22/chromedriver_win32.zip
  FirefoxDriver https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-win64.zip
  EdgeDriver https://docs.microsoft.com/en-us/microsoft-edge/webdriver-chromium?tabs=c-sharp
  IEDriver https://selenium-release.storage.googleapis.com/3.150/IEDriverServer_Win32_3.150.1.zip

#### Mac

  ChromeDriver https://chromedriver.storage.googleapis.com/86.0.4240.22/chromedriver_mac64.zip
  FirefoxDriver https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-macos.tar.gz
  
  
