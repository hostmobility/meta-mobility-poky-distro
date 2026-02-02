FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Remove Variscite's eigen patch
SRC_URI:remove = " file://0001-eigen-replace-Eigen-zip-download-with-Git-clone-to-a.patch"

SRC_URI:append = " \
    file://0001-fix-Variscites-Eigen-patch-to-onnxruntime-1.16.1.patch \
    file://0002-mlas-remove-fp16-cortex-a53.patch \
"

TARGET_CXXFLAGS:append = " -Wno-error=range-loop-construct"

# Use ONNX Runtime 1.16.1 from older branch
SRCBRANCH = "lf-6.1.55_2.2.0"
SRCREV = "1582e774d7c120a5dfbdbf6e11c8788e710ab93f"

# Fix version to match actual code
PV = "1.16.1"
