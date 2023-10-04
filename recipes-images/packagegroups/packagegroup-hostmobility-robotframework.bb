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
    python3-numpy \
    python3-flask \
    python3-tkinter \
    python3-can \
    python3-pycups \
    python3-intelhex \
"
#    not buildable python3-robotframework-requests use pip3 install robotframework-requests and  python3-robotframework-sshlibrary and python3-robotframework-dialogs. Use ref_unit_setup.bash instead.

