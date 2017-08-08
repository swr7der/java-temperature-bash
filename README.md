# java-temperature-bash
A Java approach to listen temperature in linux terminal of your location

## Prerequisites:
  
  1. [Gradle](https://gradle.org/install/)
  2. [Espeak](http://espeak.sourceforge.net/)
  
## How to install:
  1. After cloning the repository, extract it to your desired path.
  2. Run below commands:
  ```
  cd <PATH_TO_DIRECTORY>
  chmod +x temperature
  sudo cp temperature /usr/bin/
  ```
  3. To listen temperature of your location, simply run:
  ```
  cd <PATH_TO_DIRECTORY_WHERE_PROJECT_FILES_ARE>
  temperature
  ```
**NOTE:** Running command needs internet connection and running it first time would take more time as compared to running it other times. 
