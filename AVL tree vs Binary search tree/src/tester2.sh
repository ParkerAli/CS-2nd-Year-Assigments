#!/bin/bash
javac test.java
for ((N=1; N<501; N++))
do
	java test "$N"
done