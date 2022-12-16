# Mobility OS

This repository contains the Yocto meta data for the Mobility OS,
which is used for folowing products

- MX-4 C61 (mx4-c61)
- MX-4 T30 (mx4-t30) (both T30 and T30FR)
- MxV pt (mx5-pt)
- Hmx (soon to be introdused)

It is based on the Community Freescale BSP,

### Setup the Yocto enviroment:
check the readme from https://github.com/hostmobility/mobility-poky-platform

### Host Mobility targets are:
- console-hostmobility-image *console only*
- mobility-image *Graphics based console window and audio*
- mobility-image-desktop *Weston Wayland desktop*
- mobility-image-chromium *Weston Wayland desktop with chromium web browser*
- mobility-image-development *Development with graphics*
### Machine compatible
- mx5-pt *include graphic*
- mx4-c61 only console
- mx4-t30 only console
- HMX only console (comming soon)
    
### Use the images

Output images:

- `tmp/deploy/images/mx5-pt/mobility-image-mx5-pt.wic.gz`:
  This image is used to provision a device


