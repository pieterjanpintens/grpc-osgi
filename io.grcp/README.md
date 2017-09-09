# GRPC Bundles #

This project has sub modules.
So far it wont work because the jars cannot work in OSGi due to.
https://github.com/grpc/grpc-java/issues/3273
Use the io.grpc.fat as work around.

## How to use ##

If we pretend the bug above did not exists. The grpc bundles would be usable.
GRPC uses a ServiceLoader mechanism to bind components together.
This mechanism does not work in OSGi unless you also deploy SPI FLY which implements a part of the OSGi spec to make this work.
Make sure SPI FLY is started before the io.grpc bundles (start it really early).

## Implementation details ##

### Work around split package for core and context jar ###
The core and context jar are merged. This is because they would export the same package. This results in the split package problem for OSGi. They can safely be merged.

### Work around Service.Load in core and netty jars ###
The core and netty bundles will set the correct headers so that SPI FLY can be used. This will make sure that classes that are to be loaded trough Service.load are put and consumed using the OSGi registry. In other words they are registered as a service. You can check this in your OSGi console to see if SPI FLY is working.


