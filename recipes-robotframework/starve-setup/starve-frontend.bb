DESCRIPTION = "Systematic Testing And Robustness Validation Engine"
LICENSE = "CLOSED"

PV = "1.1.4"
GITLAB_PROJECT_ID = "67535839"
GITLAB_BUILD_JOB_ID = "10149985750"

RDEPENDS:${PN} += "lighttpd"

python () {
    import os
    access_token = os.getenv("GITLAB_ACCESS_TOKEN", "")
    if not access_token:
        raise bb.parse.SkipRecipe("GITLAB_ACCESS_TOKEN not available in the environment")
    d.setVar("GITLAB_ACCESS_TOKEN", access_token)
}

SRC_URI = " \
    https://gitlab.com/api/v4/projects/${GITLAB_PROJECT_ID}/jobs/${GITLAB_BUILD_JOB_ID}/artifacts/starve_frontend-${PV}.tar.gz;name=starve_frontend;downloadfilename=starve_frontend-${PV}.tar.gz \
"
SRC_URI[starve_frontend.md5sum] = "e3cfcedf9e1df6a9adcc90b397250b5c"
SRC_URI[starve_frontend.sha256sum] = "4850bf7a2d72bcf8dc069e60afc487dcb51808232d6a4852f65158793154990b"

do_fetch() {
    TOKEN="${GITLAB_ACCESS_TOKEN}"
    URL="https://gitlab.com/api/v4/projects/${GITLAB_PROJECT_ID}/jobs/${GITLAB_BUILD_JOB_ID}/artifacts/starve_frontend-${PV}.tar.gz"
    OUTPUT="${DL_DIR}/starve_frontend-${PV}.tar.gz"
    echo "Downloading artifact from: $URL"
    wget --header="PRIVATE-TOKEN: $TOKEN" "$URL" -O "$OUTPUT" || \
        bb.fatal "Failed to download artifact from $URL"
}

S = "${WORKDIR}/subdirectory"

do_unpack() {
    mkdir -p ${S}
    tar -xf ${DL_DIR}/starve_frontend-${PV}.tar.gz -C ${S}/
}

do_install() {
    install -d ${D}/www/pages
    cp -R --no-preserve=ownership ${S}/* ${D}/www/pages
    if [ -f ${D}/www/pages/index.html ]; then
        mv ${D}/www/pages/index.html ${D}/www/pages/starve-frontend.html
    fi
}

FILES:${PN} += "/www/pages/*"

pkg_postinst:${PN}() {
    # Forcefully override the index.html from lighttpd with starve-frontend
    cp -f $D/www/pages/starve-frontend.html $D/www/pages/index.html
    rm -f $D/www/pages/starve-frontend.html
}