# Mission Impossible

This application aims to solve the problem of traffic snarls of planet Lengaburu. After the recent Falicornian war, victorious King
Shan of Lengaburu wishes to tour his kingdom. But the traffic in Lengaburu is killing. King Shan wants to visit the suburb of Hallitharam, and has 2 possible orbits and 3 possible vehicles to choose from. By executing this application we can determine which orbit and vehicle King Shan should take to reach Hallitharam the fastest.

This application follows the factory design pattern, so that this application can be scaled to solve commute problems other than traveling by an orbit, and the end user or the client doesn't need to make any modifications on their end.

### Prerequisites

Java JDK(8 or later) and maven(latest or recent version).

### Getting Started

* Clone the repository to your desired location on your local machine.
* Unpack the zip file and cd to the repository.
* There's a input.txt file in the repository, you can use that or you can pass the file path to your own input file in the following steps.
* Input format: WEATHER ORBIT_1_TRAFFIC_SPEED ORBIT_2_TRAFFIC_SPEED
* Run the following command to compile and execute:
    ```
    mvn clean install -DskipTests -q assembly:single
    java -jar <path_to_the_target_folder_containing_jar>/geektrust.jar <absolute_path_to_input_file>
    ```
## Running Tests
* cd to the extracted repository.
* Run the following command to run the tests:
    ```
    mvn test
    ```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management.

## Authors

* **Kshitij Bharde**
