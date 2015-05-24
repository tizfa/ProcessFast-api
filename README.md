# ProcessFast
ProcessFast is a Java framework for the development of concurrent and distributed applications. A description of the system 
can be found on this extended abstract paper (https://github.com/tizfa/processfast-api/raw/master/doc/IIR2015ExtendedAbstract.pdf)
and the related presentation (https://github.com/tizfa/processfast-api/raw/master/doc/ProcessFastOverviewIIR2015.pdf). This is an
ongoing work, so the current implementation is not complete and far to be bug-free. The software is released under the Apache License, Version 2.0.

This is the repository for ProcessFast API. A quite complete implementation of the processing API based on Groovy and GPars 
can be found at https://github.com/tizfa/processfast-gpars. A partial implementation of the storage API based on FoundationDB can
be found at https://github.com/tizfa/processfast-storage-foundationdb.
In the repository https://github.com/tizfa/processfast-comparison you can find a set of examples of usage of the system and a
comparison with other existing systems (e.g. Apache Hadoop, Apache Spark, etc.).

To compile the code, download the projects https://github.com/tizfa/processfast-api, https://github.com/tizfa/processfast-gpars
and https://github.com/tizfa/processfast-storage-foundationdb on your computer then compile them using Maven. From the root of
each project you can compile and install a Jar of the project locally by using the commands:
mvn clean
mvn install

While compiling the projects just remember to first compile processfast-api project because is a dependency of the other 2
projects.
