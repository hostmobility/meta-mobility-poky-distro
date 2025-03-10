# Copyright SETEK Systems AB
#
# SPDX-License-Identifier: MIT
#
# deploy-mobility.bbclass - Reference image deployment setup
#
# This class provides an additional deployment location by creating
# symbolic links to the default BitBake deploy directory.
#
# This will make the build more compatible with our "bygg" script from mobility-platform.
#
# Usage:
# - Add `INHERIT += "deploy-mobility"` to `local.conf`
#
# - Custom deployment directories can be modified by setting
#   `DEPLOY_DIR_EXTRA_IMAGE` in `local.conf`

DEPLOY_DIR_EXTRA_IMAGE = "${TOPDIR}/deploy-mobility/images"

do_deploy_mobility() {
    mkdir -p ${DEPLOY_DIR_EXTRA_IMAGE}
    ln -snf ${DEPLOY_DIR_IMAGE} ${DEPLOY_DIR_EXTRA_IMAGE}/
}

addtask do_deploy_mobility after do_deploy before do_build
