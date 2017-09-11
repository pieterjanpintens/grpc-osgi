# demo repository #

The repository contains demo code to combine a bunch of technologies.

## OSGI / BNDTOOL ##

The repository is a bndtool repository.
Development is done in eclipse Oxygen with latest bndtool 3.4.0.

You can do a headless build using gradle.
In the root of the repository just execute grandle taks to see what you can do.

Most dependencies are comming from mvn central.
Some dependencies needed OSGi-ification these are included hard.
Currently part of eclipse equinox latest version is still included as it is not yet on mvn central.
This is in the local repository.

## GRCP ##

One of the technologies we wanted to test.
Note that the libraries are patched to work arround the service loader bug.
https://github.com/grpc/grpc-java/issues/3273

## Demo ##

This repo contains a GRPC server and client and a service that runs/is used by them.
The service itself is some sort of configuration store in which you can push configuration entries.
Each configuration entry has a level (int), a path(string) and a value.

The idea was to use a cassandra backend but that is not ready yet.
Currently you can test with the in memory store.
There are OSGi commands to set, unset and get config values.

A lot of things that are typically configurable are still hard coded but this is sufficient for the demo.
