SUMMARY = "Robotframework package group"
DESCRIPTION = "Package group bringing in packages is needed to use robotframework and some other python tools"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    python3-robotframework \
    python3-wheel \
    python3-pyserial \
    python3-pyaudio \
    python3-numpy \
    python3-wheel \
    python3-pip \
    python3-django \
    python3-numpy \
    python3-flask \
    python3-tkinter \
"
#    not buildable python3-robotframework-requests use pip3 install robotframework-requests and  python3-robotframework-sshlibrary \ and python3-robotframework-dialogs \
#python-django-common (django-admin startproject myproject), ej bygbart.

#TODO
#    glibc
#    libstdc++
#    libatomic1
#    wget
#    curl
