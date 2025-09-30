DESCRIPTION = "A console-only image with eIQ NXP Software framework support for Varisicte SoM modules"

LICENSE = "MIT"

require console-hostmobility-image.bb

COMPATIBLE_MACHINE = "(imx8mp-var-dart-hmx1-ml)"

IMAGE_INSTALL:append:imxgpu = " \
   opencv-apps \
   opencv-samples \
   python3-opencv \
"

IMAGE_INSTALL:append = " \
    packagegroup-imx-ml \
"