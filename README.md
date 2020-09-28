# Mobility OS

This repository contains the Yocto meta data for the Mobility OS,
which is used for the MX-5 product.

It is based on the Community Freescale BSP,

Setup the Yocto enviroment:

```
. sources/poky/oe-init-build-env
```

Start the build:

```
bitbake mobility-image
```
Without graphics
```
bitbake mobility-console-image
```

### Use the images

Output images:

- `tmp/deploy/images/mx5-pt/mobility-image-mx5-pt.wic.gz`:
  This image is used to provision a device

It assumed that you have a running U-Boot on your device, from which you can start
UMS by running:

```
mmc dev 2 && mmc partconf 2 1 0 0 && ums 0 mmc 2
```

This will expose a block device on your PC, and then you can run:

```
zcat tmp/deploy/images/mx5-pt/mobility-image-mx5-pt.wic.gz \
    | sudo dd of=/dev/<name of device> bs=4M conv=fsync status=progress
```
or use Balena Etcher application.

Restart your device once above command has completed and you should have a device
that boots.
