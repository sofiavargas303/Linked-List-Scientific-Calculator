# Linked-List-Scientific-Calculator
This project implements arithmetic on arbitrarily large integers by representing numbers as linked lists instead of using Java’s built-in numeric types, which have size limits.
Overview

Standard Java integers cannot store very large values. To overcome this, this program represents each integer as a custom linked list with one digit per node (stored in reverse order to simplify calculations). Using this representation, the program performs addition, multiplication, and exponentiation on numbers of unlimited size.

Features

Custom linked list implementation (no use of Java’s LinkedList or BigInteger)

Supports operations:

+ Addition

* Multiplication

^ Exponentiation (using exponentiation by squaring for efficiency)

Reads arithmetic expressions from an input file

Handles irregular spacing in expressions

Outputs results in the same order with correct formatting

Removes leading zeros from computed values

How It Works

Addition: Performed digit-by-digit with carry, like manual addition.

Multiplication: Uses the traditional paper multiplication method with partial sums.

Exponentiation: Uses exponentiation by squaring to reduce the number of multiplications and improve performance.
