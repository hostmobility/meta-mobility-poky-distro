DESCRIPTION = "Systematic Testing And Robustness Validation Engine"
LICENSE = "CLOSED"

PV = "1.1.2"
GITLAB_PROJECT_ID = "67535839"
GITLAB_BUILD_JOB_ID = "9943586319"

RDEPENDS:${PN} += "lighttpd"

python () {
    import os
    access_token = os.getenv("GITLAB_ACCESS_TOKEN", "")
    if not access_token:
        bb.fatal("GITLAB_ACCESS_TOKEN is not set in the environment. Fetching from GitLab will fail.")
    d.setVar("GITLAB_ACCESS_TOKEN", access_token)
}

SRC_URI = " \
    https://gitlab.com/api/v4/projects/${GITLAB_PROJECT_ID}/jobs/${GITLAB_BUILD_JOB_ID}/artifacts/starve_frontend-${PV}.tar.gz;name=starve_frontend;downloadfilename=starve_frontend-${PV}.tar.gz \
"
SRC_URI[starve_frontend.md5sum] = "bab69461e832cbdb2f557db575161b85"
SRC_URI[starve_frontend.sha256sum] = "2f10f5e528ffe2a7a187a30678f6c29fee0ad35d56a001c963fb04c94f868ffc"

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