## Assignment 4 - CMPUT402/501 w19 - University of Alberta

[![Build Status](https://travis-ci.com/cmput402-w19/assignment4tdd-mkva.svg?branch=master)](https://travis-ci.com/cmput402-w19/assignment4tdd-mkva) [![codecov](https://codecov.io/gh/cmput402-w19/assignment4tdd-mkva/branch/master/graph/badge.svg)](https://codecov.io/gh/cmput402-w19/assignment4tdd-mkva)

# To build
1. Clone repository:
```
git clone https://github.com/cmput402-w19/assignment4tdd-mkva.git
```

2. Move to repo directory:
```
cd assignment4tdd-mkva/
```

3. Execute the following command:
```
mvn clean package assembly:single
```

# To run
1. Move to the target directory:
```
cd target/
```

2. Run the following command:
```
java -jar messageBoard-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

# Note that to run this project, a MySQL database is necessary. The sql script to create the database is: