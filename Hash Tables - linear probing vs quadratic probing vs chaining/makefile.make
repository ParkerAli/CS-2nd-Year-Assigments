JCC = javac

JFLAGS = -g

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	HashBank.java \
	HashInsertTest.java \
	HashMain.java \
	HashSearchTest.java \
	HashTable.java \
	Implementation.java \
	InsertImp.java \
	Node.java \
	SearchImp.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
