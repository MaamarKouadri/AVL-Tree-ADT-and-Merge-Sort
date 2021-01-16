# AVL-Tree-ADT-and-Merge-Sort

Tasks : 
IntelligentSIDC adapts to their usage and keep the balance between memory and runtime requirements. For instance, if an IntelligentSIDC contains only a small number of entries (e.g., few hundreds), it might use less memory overhead but slower (sorting) algorithms. On the other hand, if the number of contained entries is large (greater than 1000 or even in the range of tens of thousands of elements), it might have a higher memory requirement but faster (sorting) algorithms. IntelligentSIDC might be almost constant in size or might grow and/or shrink dynamically. Ideally, operations applicable to a single IntelligentSIDC entry should be O(1) but never worse than O(n). Operations applicable to a complete IntelligentSIDC should not exceed O(n2).
You have been asked to design and implement the IntelligentSIDC ADT, which automatically adapts to the dynamic content that it operates on. In other words, it accepts the size (total number of students, n, identified by their 8 digits SIDC number as a key) as a parameter and uses an appropriate (set of) data structure(s), or other data types, from the one(s) studied in class in order to perform the operations below efficiently1. You are NOT allowed however to use any of the built-in data types (that is, you must implement whatever you need, for instance, linked lists, expandable arrays, hash tables, etc. yourself).
The IntelligentSIDC must implement the following methods:

• SetSIDCThreshold (Size): where 100 ≤ Size ≤ ~500,000 is an integer number that defines the size of the list. This size is very important as it will determine what data types or data structures will be used (i.e. a Tree, Hash Table, AVL tree, binary tree, sequence, etc.);

• generate(): randomly generates new non-existing key of 8 digits;

• allKeys(IntelligentSIDC): return all keys in IntelligentSIDC as a sorted sequence;

• add(IntelligentSIDC,key,value2): add an entry for the given key and value;

• remove(IntelligentSIDC,key): remove the entry for the given key;

• getValues(IntelligentSIDC,key): return the values of the given key;

• nextKey(IntelligentSIDC,key): return the key for the successor of key;

• prevKey(IntelligentSIDC,key): return the key for the predecessor of key;

• rangeKey(key1, key2): returns the number of keys that are within the specified range of the two keys key1 and key2.

Explanations :


1. Array List with Merge-Sort

Under a certain treshold number of objects we decided to use an Array List with
the merge sort algorithm a sorting algoritm.

The reason we decided to use an Array List was because such data structure is very
easy to expand, to grow dynamically by either removing and-or adding data.

With an ArrayList we can also reach any Student with a given key in a O(1) time 
using the methods provided by the class ArrayList in order to just return them, 
set them or remove them by index.

However to find a particular object by value, it would take O(n). Thus it would
not be approriate to use the Array List for a very large number of Student objects.

For the sorting algorithm, we decided to use the merge sort algorithm. It is fairly
easy to understand and straightfowward. In terms of complexity, it is also better 
than other sorting algorithm like quicksort (O(n log n). However the merge sort 
might increase the space complexity by splitting our ArrayList into different 
sublists and by making copies of the Array List in each recursive call.

Therefore this lead us to implement the methods specified for IntelligentSIDC
for the ArrayList notably by using the methods provided with Arraylist.

2. AVL Tree

We decided to use an AVL tree for a very large number of Student objects. 
The reason being that we believed that such a structure could accomodate and 
allow to use access and manipulate large data. 

An AVL tree is very powerful as it is  self-balancing thanks to rotations,
therefore operations like insertions or deletions have a low time  complexity 
O(log n). Moreover for searching an AVL Tree has a time complexity of O(log n)
as we don't need to visit each node.
 
The balancing done after each insertion ensures that the time complexity of 
insertion is never affected too much. This gives  this data structure an edge over
a regular BST. However, the space complexity of O(n) in order to store each node.

In the end, what motivated us to use the AVL was its self-blancing ability, which
allows it to cope with large amount of data being used and modified with insertions
and deletions.
