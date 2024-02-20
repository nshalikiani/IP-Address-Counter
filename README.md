
## Task description

A simple text file with IPv4 addresses is given. One line is one address, something like this:

```
145.67.23.4
8.34.5.23
89.54.3.124
89.54.3.124
3.45.71.5
...
```
The file size is not limited and can occupy tens and hundreds of gigabytes.

It is necessary to calculate the number of unique IP addresses in this file, consuming as little memory and time as possible. There is a "naive" algorithm for solving this task (we read strings and put it in HashSet), it is desirable that your implementation is better than this simple, naive algorithm.


## Solution

My first and simplest idea was to create four dimensional byte array with fixes length of 256 on every dimension, 
where ip = 145.67.23.4 will be represented by uniqueIpAddresses [145] [67] [23] [4]

```
int dim = 256;

byte[][][][] uniqueIpAddresses = new byte[dim][dim][dim][dim];
```

This solution will be O(n), we can't have better time complexity because we have to read all the lines. 
In terms of memory this solution will take approximately 4gb heap memory, so in terms of memory it's not 
the best solution, using bits instead of bytes will reduce memory usage 8 times, so it will be 512 mb.

So I came up with the new solution with using two bitsets and tried to keep it simple. Since bitset can only store
Integer maximum value only, we need two of them. 
Two mark the ip addresses we need to hash them into unique int value.

```
String[] splitIp = ipAddress.split("[.]");

   for (String ipPart : splitIp) {

     result = (result << 8) | (Integer.valueOf(ipPart) & 255);

   }
```

## Build and Run

To build jar file:
```
mvn clean install  
```

To run the app with file path argument:
```
java -jar target/IP-Addr-Counter-1.0.jar file_path
```