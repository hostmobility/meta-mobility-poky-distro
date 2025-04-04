DESCRIPTION = "Systematic Testing And Robustness Validation Engine"
LICENSE = "CLOSED"

PV = "0.1.1"
GITLAB_PROJECT_ID = "67535839"
GITLAB_BUILD_JOB_ID = "9623409203"

python () {
    import os
    access_token = os.getenv("GITLAB_ACCESS_TOKEN", "")
    if not access_token:
        bb.fatal("GITLAB_ACCESS_TOKEN is not set in the environment. Fetching from GitLab will fail.")
    d.setVar("GITLAB_ACCESS_TOKEN", access_token)
}

SRC_URI = " \
    https://gitlab.com/api/v4/projects/${GITLAB_PROJECT_ID}/jobs/${GITLAB_BUILD_JOB_ID}/artifacts/starve_frontend-${PV}.tar.gz;name=starve_frontend;downloadfilename=starve_frontend-${PV}.tar.gz
"
SRC_URI[starve_frontend.md5sum] = "593271EF74B6B1D3C32CAAE568877CDA"
SRC_URI[starve_frontend.sha256sum] = "35A1AE194CFC4A7A9A45ABE562C5B38DB2DC924C54243D448EB94AC68C765009"

S = "${WORKDIR}"

do_fetch() {
    TOKEN="${GITLAB_ACCESS_TOKEN}"
    URL="https://gitlab.com/api/v4/projects/${GITLAB_PROJECT_ID}/jobs/${GITLAB_BUILD_JOB_ID}/artifacts/starve_frontend-${PV}.tar.gz"
    OUTPUT="${DL_DIR}/starve_frontend-${PV}.tar.gz"
    echo "Downloading artifact from: $URL"
    wget --header="PRIVATE-TOKEN: $TOKEN" "$URL" -O "$OUTPUT" || \
        bb.fatal "Failed to download artifact from $URL"
}

do_install() {
    install -d ${D}/www/pages
}