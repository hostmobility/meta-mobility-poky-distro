DESCRIPTION = "A console-only image intended for remote logging over a modem connection using networkmanager and modemmanager."

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
    networkmanager \
    modemmanager \
"

# Allow tty access and other necessary features
IMAGE_FEATURES:append = "debug-tweaks"

export IMAGE_BASENAME = "console-remote-logging-nm-mm"
