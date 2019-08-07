JCC = javac

JFLAGS = -g

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AVL.java \
	AVLNode.java \
	BST.java \
	BSTNode.java \
	BSTtest.java \
	DataExtractor.java \
	PowerAVLApp.java \
	PowerBSTApp.java \
	test.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
