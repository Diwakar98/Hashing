# Hashing
This project is all about the implementation of the concept of Hashing (Separate Chaining and Double Hashing).
Seperate Chaining uses Binary Search Tree to improve the complexity if we have very large data sets.
SCBST denotes Separate Chaining Binary Search Tree
DH denotes Double Hashing.
For the Double Hashing approach, the size of the hash table T is going to be a prime number greater than the size of the data set, typically around 1.5N to 2N. This ensures that double hashing approach covers all indices of the hash table.

To run the project run the following commands in terminal:

//For executing data sets using Separate Chaining

cd Hashing
javac *.java 
java Hashing 11 SCBST input.txt

OR

//For executing data sets using Double Hashing

javac *.java 
java Hashing 11 DH input.txt


The Hashing.java file should take as command line arguments the hash table size T, the hashing approach (DH for double hashing, and SCBST for separate chaining with binary search trees) and an input file. A sample invocation looks like this:
cd src 

javac *.java 
java Hashing 11 SCBST input.txt
The input file contains a new command in each line in the format commandname [commandargs]. A sample input file could look like this:
insert Ram Singh Nilgiri CS 6.5 
insert Lallan Singh Nilgiri CE 6.0 
insert Shyam Singh Satpura EE 8.2 
update Lallan Singh Nilgiri CE 5.0 
delete Ram Singh 
contains Ram Singh 
get Shyam Singh 
address Shyam Singh 
address Ram Singh
The corresponding output will to be printed on the console, the result of each query in a separate line. Suppose we are running for SCBST and the index of Lallan Singh turns out to be the same as that of Ram Singh, but is different from that of Shyam Singh. Thus, for the above input file, the output could be:
1 
2 
1 
2 
2 
F 
Shyam Singh Satpura EE 8.2 
1- 
E
Here, F signifies false (T signifies true) and E signifies that an error happened (because the requested record does not exist).
If the same input file is supplied to the double hashing approach, assuming that the index for Lallan Singh does not collide with that of Ram Singh, and index for Shyam Singh collides with first Ram Singh and then Lallan Singh and is finally 4, the expected output would be:
1 
1 
3 
1 
1 
F 
Shyam Singh Satpura EE 8.2 
4 
E


HASHING:
The performance of a hash table crucially depends on the choice of the hash function(s). Ideally, we would like to have hash functions that provide a uniform distribution of hash values to avoid unnecessary collisions but in practice we will be using hash functions that are fast to compute but possibly not perfectly uniform. (Note that hash tables don’t need many security properties provided by the slower cryptographic hash functions like md5/sha256 etc.) We will be using djb2 and sdbm hashing algorithms on the concatenation of the student’s first name and last name for hash functions h1 and h2 respectively.
import java.lang.Math; 
public static long djb2(String str, int hashtableSize) { 
    long hash = 5381; 
    for (int i = 0; i < str.length(); i++) { 
        hash = ((hash << 5) + hash) + str.charAt(i); 
    } 
    return Math.abs(hash) % hashtableSize; 
}
import java.lang.Math; 
public static long sdbm(String str, int hashtableSize) { 
    long hash = 0; 
    for (int i = 0; i < str.length(); i++) { 
        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
    } 
    return Math.abs(hash) % (hashtableSize - 1) + 1; 
}

For the double hashing approach, the size of the hash table T is going to be a prime number greater than the size of the data set, typically around 1.5N to 2N. This ensures that double hashing approach covers all indices of the hash table.
