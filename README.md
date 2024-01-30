# Encryption-Decryption (Java)
The Encryption-Decryption Project is a implementation of the encryption and decryption of data which is provided.

## Description

In this project if we provide the data (combination of all unocide characters) along with the operation (Encryption or Description) then it output the result accordingly. All the command are given at command line arguments while running the project.
Design Pattern which I have used in this project is `Factory Design Pattern`

Lets break it down

### Data
#### There are two ways in which we can give data:
- input data drectly
```
  -data "Welcome to hyperskill!"
```
- input the file name through which we have to access data
```
-in road_to_treasure.txt 
```
- If there is no -data and no -in the program should assume that the data is an empty string;
- If there are both -data and -in arguments, your program should prefer -data over -in.

### Operations
#### Either of the two operations can be provided:
- If we want to get the encription of provided data
```
  -mode enc
```
- If we want to get the decription of provided data
```
  -mode dec
```
If there is no -mode, the program should work in the enc mode;
### Key
Key is the value which define number of shifting which we have to do for characters in data.

For providing Key
```
-key 5
```
- If there is no -key, the program should consider that key is 0;


### Algorithm
There are two ways in which we can do encrytion and decryption of data provided. Either we can do shifting only on 26 alphabets or we can do shiting for all 95 unicode characters.

- If we want to do shifting on only 26 alphabets then arguments provide would be
```
  -alg shift
```
It shift alphabets between a to z within itself. Similarly for A to Z
For instance: if character = 'a' and key = 5
then it shift to 'f'

- If we want to do shifting on all 95 unicode characters
```
  -alg unicode
```

### Output Result
Data, key and operation are provided, now we also have to specify where we have to output result.

#### There are two ways to do

Either we can print the output or can save the output to some file.
For saving in the file we need the file name, which is prvided in this way
```
  -out protected.txt
```

-out is the argument and protected.txt is the parameter

- If there is no -out argument, the program must print data to the standard output;


## How to Use it

First compile the program
```
javac Encryption-Decryption (Java)
```

While running the program input the command line arguments as well.
Following is the format of giving arguments

` java file_name arg1 para1 arg2 para2 arg3 para3 ....`

#### arg1, arg2... can be following types

- -mode: it specify what operation we want to perform, it can be either encryption or decryption.
For Encrytion
```
  -mode enc
```
For Decryption
```
  -mode dec
```
- -in: it tells the file name from where we have to take input
```
  -in road_to_treasure.txt 
```
- out: it tells the name to file to which we have to paste the result
```
  -out road_to_treasure.txt 
```
- -data: It tells about the data
```
-data "Welcome to hyperskill!"
```
- -key: It specify the value of key
```
  -key 5
``` 
- -alg: It specifies which algorithm to select. Either shifting via 26 alphabets or via all 95 unicode characters.
```
  -alg shift
``` 
```
  -alg unicode
``` 

### Example 1
So at last while running code we can provide these arguments as mentioned below

Encryption with the unicode algorithm
```
  java file_name -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
```

Output:
```
  \jqhtrj%yt%m~ujwxpnqq&
```

### Example 2
Decryption with the unicode algorithm
```
  java file_name -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
```
Output:
```
  Welcome to hyperskill!
```

### Example 3
Encryption with the shift algorithm
```
  java file_name -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc
```

### Example 4
decryption with the shift algorithm
```
-key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec
```
Output:
Welcome to hyperskill!

## Link of project

 - [Encryption Decryption (Java) (Medium Level Project)](https://hyperskill.org/projects/46)

  - [Github](https://github.com/barnawalayush/Encryption-Decryption-Java-)
