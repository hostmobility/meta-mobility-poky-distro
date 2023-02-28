# Mobility OS

This repository contains the Yocto meta data for the Mobility OS,
which is used for following products

- MX-4 C61 (mx4-c61)
- MX-4 T30 (mx4-t30) (both T30 and T30FR)
- MX-V PT (mx5-pt)
- Hmx (imx8mp-var-dart-hmx1)

### Setup the Yocto environment:
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
- HMX only console
    



