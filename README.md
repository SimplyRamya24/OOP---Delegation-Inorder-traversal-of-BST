These solutions are part of the course : Fundamentals of Programming Languages(CSE505) offered in fall 2014 at UB.

OOP problem description is as below :

1. Delegation >> An important technique in the study of Design Patterns is the use of `delegation' to replace
`class inheritance'. Extend a systematic way for doing this transformation so that the inheritance of attributes and methods, and also method over-riding are handled. In the given problem we have four classes, C1, C11, C111, and C112, where the classes C111 and C112 extend C11 which in turn extends C1.
The result of the transformation should be four classes called D1, D11, D111, and D112 which correspond to C1, C11, C111, and C112 respectively, but do not make use of class inheritance. Make the classes D1, D11, D111, and D112 implement interfaces I1, I11, I111 and I112 respectively, where the interfaces I111 and I112 should inherit from I11 which in turn should inherit from I1. Define these interfaces suitably.


Problem 2 >> Define in Java an external iterator for inorder traversal of a generic binary search tree (BST),
and use this iterator to define the equality of two BSTs.
The external iterator should be generic and should support two public methods: a boolean function
done(), which tests whether the iterator has any more values to yield, and a function next(), which
returns the next value if the iterator is not yet done. It may contain other helper methods, which
should be declared private.
The equality test should repeatedly obtain one value from each tree, in alternating fashion, and
compare these values for equality. It should return false if the values are not equal (mismatch). If there
are no mismatches and the iterators are done at the same time, the equality test should return true.
