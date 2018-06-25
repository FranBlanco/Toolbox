
Compile with maven (mvn clean package)
Exercise1 - StringUtilities.class  cost log(n)
Exercise2 - kComplementery  cost n+log(n)
Exercise3 Package frequency.

External Libraries:
Used Junit for  testing pourposes
Used apache.commons.cli for parse arguments from commandLine

Next steps:
- (IMPLEMENTED) Include apache.commons.cli for parsing arguments
- Replace System.out by logger
- Add mockito dependency to test ServiceListener and thead logic

Assumption:
I'm not sure if td/idf is applied correctly: I got that
df = num Ocurrencies in file / num Total words
idf = log( ( num total files /  totalFilesWithOccurrence
Return df/idf




