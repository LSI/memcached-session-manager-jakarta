# memcached session manager jakarta

`memcached-session-manager-jakarta` is a tomcat session manager forked from [memcache-sesson-manager](https://github.com/magro/memcached-session-manager) that keeps sessions in memcached or Redis, for highly available, scalable and fault tolerant web applications.

This version has been updated to support the jakarta servlet API and is NOT BACKWARD COMPATIBLE with Tomcat 9 or older.

Unit tests have not been updated and do not currently work. The rest of the claimed functionality in the original readme below may or may not function. It's working so far with my use case.
I may clean it up further on my own time but it's not what work's paying me for currently.

It supports both sticky and non-sticky configurations.

For sticky sessions session failover (tomcat crash) is supported, for non-sticky sessions this is the default (a session is served by default by different tomcats for different requests).
Also memcached failover (memcached crash) is supported via migration of sessions. There shall also be no single point of failure, so when a memcached fails
the session will not be lost (but either be available in tomcat or in another memcached).

## Installation and Configuration
Basically you must put the spymemcached jar and the memcached-session-manager jars into tomcat's lib folder.
If you want to use Redis instead of memcached, you need the jar of the Redis client "jedis" instead.
Additionally you must set the Manager class and add some configuration attributes. This is described in detail in the
[SetupAndConfiguration wiki page](https://github.com/magro/memcached-session-manager/wiki/SetupAndConfiguration).

## Where to get help
Checkout the [wiki](https://github.com/magro/memcached-session-manager/wiki) for documentation, contact the
[mailing list](http://groups.google.com/group/memcached-session-manager) or [submit an issue](https://github.com/magro/memcached-session-manager/issues).

## How to contribute
If you want to contribute to this project you can fork this project, make your changes and submit a [pull request](https://help.github.com/articles/using-pull-requests/).
Or you start on the [mailing list](http://groups.google.com/group/memcached-session-manager) and we'll see how we can work together.

## Samples
There's [sample webapp](https://github.com/magro/memcached-session-manager/tree/master/samples) that allows to run tomcat+msm in different configurations,
both sticky and non-sticky etc, just checkout the [README](https://github.com/magro/memcached-session-manager/tree/master/samples).

## License
The license is Apache 2.0, see LICENSE.txt.
