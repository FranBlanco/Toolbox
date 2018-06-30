
Compile with maven (mvn clean package)
Exercise1 - StringUtilities.class  cost log(n)
Exercise2 - kComplementery  cost n+log(n)
Exercise3 Package frequency.

External Libraries:
Used Junit for  testing pourposes
Used apache.commons.cli for parse arguments from commandLine

Next steps:
- (IMPLEMENTED) Include apache.commons.cli for parsing arguments
- (IMPLEMENTED) Replace System.out by logger
- (IMPLEMENTED) Add mockito dependency to test ServiceListener and thead logic

Assumption:
I'm not sure if td/idf is applied correctly: I got that
df = num Ocurrencies in file / num Total words
idf = log( ( num total files /  totalFilesWithOccurrence
Return df/idf

Coverage 
frequency	100% (4/4)	95% (19/20)	90% (90/99)
KComplementary	100% (1/1)	100% (2/2)	94% (16/17)
StringUtilities	100% (1/1)	100% (1/1)	80% (4/5)
Tuple	100% (1/1)	100% (5/5)	100% (14/14)

