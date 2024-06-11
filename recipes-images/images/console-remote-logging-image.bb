DESCRIPTION = "A console-only image intended for remote logging over a modem connection."

LICENSE = "MIT"

require console-hostmobility-image.bb

IMAGE_INSTALL:remove = " \
     lrzsz \
     fbtest \
     make \
     openssl-engines \
"

IMAGE_INSTALL:append = " \
    zile \
    host-modem-m \
"

# Allow tty access and other necessary features
IMAGE_FEATURES:append = "debug-tweaks"

export IMAGE_BASENAME = "console-remote-logging-image"
