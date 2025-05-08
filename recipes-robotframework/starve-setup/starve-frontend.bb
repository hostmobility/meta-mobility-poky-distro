DESCRIPTION = "Systematic Testing And Robustness Validation Engine"
LICENSE = "CLOSED"

PV = "1.1.3"
GITLAB_PROJECT_ID = "67535839"
GITLAB_BUILD_JOB_ID = "9975597988"

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
SRC_URI[starve_frontend.md5sum] = "6ee8930c3f1a63910c14fef031d90471"
SRC_URI[starve_frontend.sha256sum] = "bac7859512b4d84c765a5e9e916e64707fbf8f29d68709d3635bbc812e9661ff"

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