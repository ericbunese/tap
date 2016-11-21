all:
	javac Main.java

run:
	javac Main.java
	java Main

exec:
	java Main

clean:
	rm *.class
	rm*.dat

cleancode:
	rm *.class

cleandb:
	rm *.dat
