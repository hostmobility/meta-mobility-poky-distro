SUMMARY = "A remote I/O client for GNU/Linux"
HOMEPAGE = "https://hostmobility.com"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://git@github.com/hostmobility/host-insight-client.git;protocol=ssh;branch=main;name=client \
           gitsm://git@github.com/hostmobility/host-insight-proto.git;protocol=ssh;branch=main;destsuffix=git/proto;name=proto"

SRC_URI_client[md5sum] = "da0ebecd284d7f4afcfc226be2e648b6"
SRC_URI_client[sha256sum] = "0019f1ab11aa8364b17727a7b6916a8a07fad25aefe23c45d33d4d4db4f7b6f1"
SRCREV_client = "2ce907c8b4667d09aa419ab8990112b74b8c576a"

SRC_URI_proto[md5sum] = "da0ebecd284d7f4afcfc226be2e648b6"
SRC_URI_proto[sha256sum] = "0019f1ab11aa8364b17727a7b6916a8a07fad25aefe"
SRCREV_proto = "598ae5f292fa20d2d51edaf1ebd6e19547ba5b73"
SRCREV_FORMAT = "client_proto"

SRC_URI[anyhow-1.0.75.sha256sum] = "a4668cab20f66d8d020e1fbc0ebe47217433c1b6c8f2040faf858554e394ace6"
SRC_URI[async-channel-1.6.1.sha256sum] = "2114d64672151c0c5eaa5e131ec84a74f06e1e559830dabba01ca30605d66319"
SRC_URI[async-executor-1.4.1.sha256sum] = "871f9bb5e0a22eeb7e8cf16641feb87c9dc67032ccf8ff49e772eb9941d3a965"
SRC_URI[async-global-executor-2.1.0.sha256sum] = "fd8b508d585e01084059b60f06ade4cb7415cd2e4084b71dd1cb44e7d3fb9880"
SRC_URI[async-io-1.7.0.sha256sum] = "e5e18f61464ae81cde0a23e713ae8fd299580c54d697a35820cfd0625b8b0e07"
SRC_URI[async-lock-2.6.0.sha256sum] = "c8101efe8695a6c17e02911402145357e718ac92d3ff88ae8419e84b1707b685"
SRC_URI[async-std-1.12.0.sha256sum] = "62565bb4402e926b29953c785397c6dc0391b7b446e45008b0049eb43cec6f5d"
SRC_URI[async-stream-impl-0.3.3.sha256sum] = "10f203db73a71dfa2fb6dd22763990fa26f3d2625a6da2da900d23b87d26be27"
SRC_URI[async-stream-0.3.3.sha256sum] = "dad5c83079eae9969be7fadefe640a1c566901f05ff91ab221de4b6f68d9507e"
SRC_URI[async-task-4.2.0.sha256sum] = "30696a84d817107fc028e049980e09d5e140e8da8f1caeb17e8e950658a3cea9"
SRC_URI[async-trait-0.1.53.sha256sum] = "ed6aa3524a2dfcf9fe180c51eae2b58738348d819517ceadf95789c51fff7600"
SRC_URI[atomic-waker-1.0.0.sha256sum] = "065374052e7df7ee4047b1160cca5e1467a12351a40b3da123c870ba0b8eda2a"
SRC_URI[atty-0.2.14.sha256sum] = "d9b39be18770d11421cdb1b9947a45dd3f37e93092cbf377614828a319d5fee8"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[axum-core-0.2.9.sha256sum] = "37e5939e02c56fecd5c017c37df4238c0a839fa76b7f97acdd7efb804fd181cc"
SRC_URI[axum-0.5.17.sha256sum] = "acee9fd5073ab6b045a275b3e709c163dd36c90685219cb21804a147b58dba43"
SRC_URI[base64-0.13.0.sha256sum] = "904dfeac50f3cdaba28fc6f57fdcddb75f49ed61346676a78c4ffe55877802fd"
SRC_URI[bitflags-0.4.0.sha256sum] = "8dead7461c1127cf637931a1e50934eb6eee8bff2f74433ac7909e9afcee04a3"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[blocking-1.2.0.sha256sum] = "c6ccb65d468978a086b69884437ded69a90faab3bbe6e67f242173ea728acccc"
SRC_URI[bumpalo-3.10.0.sha256sum] = "37ccbd214614c6783386c1af30caf03192f17891059cecc394b4fb119e363de3"
SRC_URI[bytes-1.1.0.sha256sum] = "c4872d67bab6358e59559027aa3b9157c53d9358c51423c17554809a8858e0f8"
SRC_URI[cache-padded-1.2.0.sha256sum] = "c1db59621ec70f09c5e9b597b220c7a2b43611f4710dc03ceb8748637775692c"
SRC_URI[can-dbc-5.0.0.sha256sum] = "9c2d32f0a7f3754502f84cb68e493a6765ce0978348a59efcb1bccf2ee19c255"
SRC_URI[cc-1.0.73.sha256sum] = "2fff2a6927b3bb87f9595d67196a70493f627687a71d87a0d692242c33f58c11"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[clap-3.2.23.sha256sum] = "71655c45cb9845d3270c9d6df84ebe72b4dad3c2ba3f7023ad47c144e4e473a5"
SRC_URI[clap_lex-0.2.4.sha256sum] = "2850f2f5a82cbf437dd5af4d49848fbdfc27c157c3d010345776f952765261c5"
SRC_URI[codegen-0.2.0.sha256sum] = "ff61280aed771c3070e7dcc9e050c66f1eb1e3b96431ba66f9f74641d02fc41d"
SRC_URI[concurrent-queue-1.2.2.sha256sum] = "30ed07550be01594c6026cff2a1d7fe9c8f683caa798e12b68694ac9e88286a3"
SRC_URI[crossbeam-utils-0.8.8.sha256sum] = "0bf124c720b7686e3c2663cf54062ab0f68a88af2fb6a030e87e30bf721fcb38"
SRC_URI[ctor-0.1.22.sha256sum] = "f877be4f7c9f246b183111634f75baa039715e3f46ce860677d3b19a69fb229c"
SRC_URI[derive-getters-0.2.0.sha256sum] = "0c5905670fd9c320154f3a4a01c9e609733cd7b753f3c58777ab7d5ce26686b3"
SRC_URI[either-1.6.1.sha256sum] = "e78d4f1cc4ae33bbfc157ed5d5a5ef3bc29227303d595861deb238fcec4e9457"
SRC_URI[event-listener-2.5.2.sha256sum] = "77f3309417938f28bf8228fcff79a4a37103981e3e186d2ccd19c74b38f4eb71"
SRC_URI[fastrand-1.7.0.sha256sum] = "c3fcf0cee53519c866c09b5de1f6c56ff9d647101f81c1964fa632e148896cdf"
SRC_URI[fixedbitset-0.4.1.sha256sum] = "279fb028e20b3c4c320317955b77c5e0c9701f05a1d309905d6fc702cdc5053e"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[futures-channel-0.3.25.sha256sum] = "52ba265a92256105f45b719605a571ffe2d1f0fea3807304b522c1d778f79eed"
SRC_URI[futures-core-0.3.25.sha256sum] = "04909a7a7e4633ae6c4a9ab280aeb86da1236243a77b694a49eacd659a4bd3ac"
SRC_URI[futures-executor-0.3.25.sha256sum] = "7acc85df6714c176ab5edf386123fafe217be88c0840ec11f199441134a074e2"
SRC_URI[futures-io-0.3.25.sha256sum] = "00f5fb52a06bdcadeb54e8d3671f8888a39697dcb0b81b23b55174030427f4eb"
SRC_URI[futures-lite-1.12.0.sha256sum] = "7694489acd39452c77daa48516b894c153f192c3578d5a839b62c58099fcbf48"
SRC_URI[futures-macro-0.3.25.sha256sum] = "bdfb8ce053d86b91919aad980c220b1fb8401a9394410e1c289ed7e66b61835d"
SRC_URI[futures-sink-0.3.25.sha256sum] = "39c15cf1a4aa79df40f1bb462fb39676d0ad9e366c2a33b590d7c66f4f81fcf9"
SRC_URI[futures-task-0.3.25.sha256sum] = "2ffb393ac5d9a6eaa9d3fdf37ae2776656b706e200c8e16b1bdb227f5198e6ea"
SRC_URI[futures-util-0.3.25.sha256sum] = "197676987abd2f9cadff84926f410af1c183608d36641465df73ae8211dc65d6"
SRC_URI[futures-0.3.25.sha256sum] = "38390104763dc37a5145a53c29c63c1290b5d316d6086ec32c293f6736051bb0"
SRC_URI[getrandom-0.2.7.sha256sum] = "4eb1a864a501629691edf6c15a593b7a51eebaa1e8468e9ddc623de7c9b58ec6"
SRC_URI[gloo-timers-0.2.4.sha256sum] = "5fb7d06c1c8cc2a29bee7ec961009a0b2caa0793ee4900c2ffb348734ba1c8f9"
SRC_URI[gpio-cdev-0.5.1.sha256sum] = "409296415b8abc7b47e5b77096faae14595c53724972da227434fc8f4b05ec8b"
SRC_URI[h2-0.3.13.sha256sum] = "37a82c6d637fc9515a4694bbf1cb2457b79d81ce52b3108bdeea58b07dd34a57"
SRC_URI[hashbrown-0.12.3.sha256sum] = "8a9ee70c43aaf417c914396645a0fa852624801b24ebb7ae78fe8272889ac888"
SRC_URI[heck-0.4.0.sha256sum] = "2540771e65fc8cb83cd6e8a237f70c319bd5c29f78ed1084ba5d50eeac86f7f9"
SRC_URI[hermit-abi-0.1.19.sha256sum] = "62b467343b94ba476dcb2500d242dadbb39557df889310ac77c5d99100aaac33"
SRC_URI[hex-0.2.0.sha256sum] = "d6a22814455d41612f41161581c2883c0c6a1c41852729b17d5ed88f01e153aa"
SRC_URI[home-0.5.4.sha256sum] = "747309b4b440c06d57b0b25f2aee03ee9b5e5397d288c60e21fc709bb98a7408"
SRC_URI[http-body-0.4.5.sha256sum] = "d5f38f16d184e36f2408a55281cd658ecbd3ca05cce6d6510a176eca393e26d1"
SRC_URI[http-range-header-0.3.0.sha256sum] = "0bfe8eed0a9285ef776bb792479ea3834e8b94e13d615c2f66d03dd50a435a29"
SRC_URI[http-0.2.8.sha256sum] = "75f43d41e26995c17e71ee126451dd3941010b0514a81a9d11f3b341debc2399"
SRC_URI[httparse-1.7.1.sha256sum] = "496ce29bb5a52785b44e0f7ca2847ae0bb839c9bd28f69acac9b99d461c0c04c"
SRC_URI[httpdate-1.0.2.sha256sum] = "c4a1e36c821dbe04574f602848a19f742f4fb3c98d40449f11bcad18d6b17421"
SRC_URI[hyper-timeout-0.4.1.sha256sum] = "bbb958482e8c7be4bc3cf272a766a2b0bf1a6755e7a6ae777f017a31d11b13b1"
SRC_URI[hyper-0.14.19.sha256sum] = "42dc3c131584288d375f2d07f822b0cb012d8c6fb899a5b9fdb3cb7eb9b6004f"
SRC_URI[indexmap-1.9.1.sha256sum] = "10a35a97730320ffe8e2d410b5d3b69279b98d2c14bdb8b70ea89ecf7888d41e"
SRC_URI[instant-0.1.12.sha256sum] = "7a5bbe824c507c5da5956355e86a746d82e0e1464f65d862cc5e71da70e94b2c"
SRC_URI[itertools-0.10.3.sha256sum] = "a9a9d19fa1e79b6215ff29b9d6880b706147f16e9b1dbb1e4e5947b5b02bc5e3"
SRC_URI[itertools-0.4.19.sha256sum] = "c4a9b56eb56058f43dc66e58f40a214b2ccbc9f3df51861b63d51dec7b65bc3f"
SRC_URI[itoa-1.0.2.sha256sum] = "112c678d4050afce233f4f2852bb2eb519230b3cf12f33585275537d7e41578d"
SRC_URI[js-sys-0.3.58.sha256sum] = "c3fac17f7123a73ca62df411b1bf727ccc805daa070338fda671c86dac1bdc27"
SRC_URI[kv-log-macro-1.0.7.sha256sum] = "0de8b303297635ad57c9f5059fd9cee7a47f8e8daa09df0fcd07dd39fb22977f"
SRC_URI[lazy_static-1.4.0.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[libc-0.2.138.sha256sum] = "db6d7e329c562c5dfab7a46a2afabc8b987ab9a4834c9d1ca04dc54c1546cef8"
SRC_URI[log-0.4.17.sha256sum] = "abb12e687cfb44aa40f41fc3978ef76448f9b6038cad6aef4259d3c095a2382e"
SRC_URI[matchit-0.5.0.sha256sum] = "73cbba799671b762df5a175adf59ce145165747bb891505c43d09aefbbf38beb"
SRC_URI[memchr-2.5.0.sha256sum] = "2dffe52ecf27772e601905b7522cb4ef790d2cc203488bbd0e2fe85fcb74566d"
SRC_URI[memoffset-0.6.5.sha256sum] = "5aa361d4faea93603064a027415f07bd8e1d5c88c9fbf68bf56a285428fd79ce"
SRC_URI[memoffset-0.7.1.sha256sum] = "5de893c32cde5f383baa4c04c5d6dbdd735cfd4a794b0debdb2bb1b421da5ff4"
SRC_URI[mime-0.3.16.sha256sum] = "2a60c7ce501c71e03a9c9c0d35b861413ae925bd979cc7a4e30d060069aaac8d"
SRC_URI[minimal-lexical-0.2.1.sha256sum] = "68354c5c6bd36d73ff3feceb05efa59b6acb7626617f4962be322a825e61f79a"
SRC_URI[mio-0.8.4.sha256sum] = "57ee1c23c7c63b0c9250c339ffdc69255f110b298b901b9f6c82547b7b87caaf"
SRC_URI[multimap-0.8.3.sha256sum] = "e5ce46fe64a9d73be07dcbe690a38ce1b293be448fd8ce1e6c1b8062c9f72c6a"
SRC_URI[nix-0.23.1.sha256sum] = "9f866317acbd3a240710c63f065ffb1e4fd466259045ccb504130b7f668f35c6"
SRC_URI[nix-0.26.1.sha256sum] = "46a58d1d356c6597d08cde02c2f09d785b09e28711837b1ed667dc652c08a694"
SRC_URI[nix-0.5.1.sha256sum] = "bfb3ddedaa14746434a02041940495bf11325c22f6d36125d3bdd56090d50a79"
SRC_URI[nom-7.1.1.sha256sum] = "a8903e5a29a317527874d0402f867152a3d21c908bb0b933e416c65e301d4c36"
SRC_URI[num_cpus-1.13.1.sha256sum] = "19e64526ebdee182341572e50e9ad03965aa510cd94427a4549448f285e957a1"
SRC_URI[once_cell-1.12.0.sha256sum] = "7709cef83f0c1f58f666e746a08b21e0085f7440fa6a29cc194d68aac97a4225"
SRC_URI[os_str_bytes-6.4.1.sha256sum] = "9b7820b9daea5457c9f21c69448905d723fbd21136ccf521748f23fd49e723ee"
SRC_URI[parking-2.0.0.sha256sum] = "427c3892f9e783d91cc128285287e70a59e206ca452770ece88a76f7a3eddd72"
SRC_URI[percent-encoding-2.1.0.sha256sum] = "d4fd5641d01c8f18a23da7b6fe29298ff4b55afcccdf78973b24cf3175fee32e"
SRC_URI[petgraph-0.6.2.sha256sum] = "e6d5014253a1331579ce62aa67443b4a658c5e7dd03d4bc6d302b94474888143"
SRC_URI[pin-project-internal-1.0.12.sha256sum] = "069bdb1e05adc7a8990dce9cc75370895fbe4e3d58b9b73bf1aee56359344a55"
SRC_URI[pin-project-lite-0.2.9.sha256sum] = "e0a7ae3ac2f1173085d398531c705756c94a4c56843785df85a60c1a0afac116"
SRC_URI[pin-project-1.0.12.sha256sum] = "ad29a609b6bcd67fee905812e544992d216af9d755757c05ed2d0e15a74c6ecc"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[polling-2.2.0.sha256sum] = "685404d509889fade3e86fe3a5803bca2ec09b0c0778d5ada6ec8bf7a8de5259"
SRC_URI[ppv-lite86-0.2.16.sha256sum] = "eb9f9e6e233e5c4a35559a617bf40a4ec447db2e84c20b55a6f83167b7e57872"
SRC_URI[prettyplease-0.1.11.sha256sum] = "f28f53e8b192565862cf99343194579a022eb9c7dd3a8d03134734803c7b3125"
SRC_URI[proc-macro2-1.0.47.sha256sum] = "5ea3d908b0e36316caf9e9e2c4625cdde190a7e6f440d794667ed17a1855e725"
SRC_URI[prost-build-0.11.4.sha256sum] = "276470f7f281b0ed53d2ae42dd52b4a8d08853a3c70e7fe95882acbb98a6ae94"
SRC_URI[prost-derive-0.11.0.sha256sum] = "7345d5f0e08c0536d7ac7229952590239e77abf0a0100a1b1d890add6ea96364"
SRC_URI[prost-types-0.11.1.sha256sum] = "4dfaa718ad76a44b3415e6c4d53b17c8f99160dcb3a99b10470fce8ad43f6e3e"
SRC_URI[prost-0.11.3.sha256sum] = "c0b18e655c21ff5ac2084a5ad0611e827b3f92badf79f4910b5a5c58f4d87ff0"
SRC_URI[quote-1.0.18.sha256sum] = "a1feb54ed693b93a84e14094943b84b7c4eae204c512b7ccb95ab0c66d278ad1"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core-0.6.3.sha256sum] = "d34f1408f55294453790c48b2f1ebbb1c5b4b7563eb1f418bcfcfdbb06ebb4e7"
SRC_URI[redox_syscall-0.2.13.sha256sum] = "62f25bc4c7e55e0b0b7a1d43fb893f4fa1361d0abe38b9ce4f323c2adfe6ef42"
SRC_URI[regex-syntax-0.6.26.sha256sum] = "49b3de9ec5dc0a3417da371aab17d729997c15010e7fd24ff707773a33bddb64"
SRC_URI[regex-1.5.6.sha256sum] = "d83f127d94bdbcda4c8cc2e50f6f84f4b611f69c902699ca385a39c3a75f9ff1"
SRC_URI[remove_dir_all-0.5.3.sha256sum] = "3acd125665422973a33ac9d3dd2df85edad0f4ae9b00dafb1a05e43a9f5ef8e7"
SRC_URI[ring-0.16.20.sha256sum] = "3053cf52e236a3ed746dfc745aa9cacf1b791d846bdaf412f60a8d7d6e17c8fc"
SRC_URI[rustls-pemfile-1.0.0.sha256sum] = "e7522c9de787ff061458fe9a829dc790a3f5b22dc571694fc5883f448b94d9a9"
SRC_URI[rustls-0.20.6.sha256sum] = "5aab8ee6c7097ed6057f43c187a62418d0c05a4bd5f18b3571db50ee0f9ce033"
SRC_URI[sct-0.7.0.sha256sum] = "d53dcdb7c9f8158937a7981b48accfd39a43af418591a5d008c7b22b5e1b7ca4"
SRC_URI[serde-1.0.150.sha256sum] = "e326c9ec8042f1b5da33252c8a37e9ffbd2c9bef0155215b6e6c80c790e05f91"
SRC_URI[serde_derive-1.0.150.sha256sum] = "42a3df25b0713732468deadad63ab9da1f1fd75a48a15024b50363f128db627e"
SRC_URI[slab-0.4.6.sha256sum] = "eb703cfe953bccee95685111adeedb76fabe4e97549a58d16f03ea7b9367bb32"
SRC_URI[socket2-0.4.4.sha256sum] = "66d72b759436ae32898a2af0a14218dbf55efde3feeb170eb623637db85ee1e0"
SRC_URI[socketcan-1.7.0.sha256sum] = "3101efc6ef5af6f1c1a488241b469757b7a183baca63af958cd90e4696446c80"
SRC_URI[spin-0.5.2.sha256sum] = "6e63cff320ae2c57904679ba7cb63280a3dc4613885beafb148ee7bf9aa9042d"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[strsim-0.10.0.sha256sum] = "73473c0e59e6d5812c5dfe2a064a6444949f089e20eec9a2e5506596494e4623"
SRC_URI[syn-1.0.105.sha256sum] = "60b9b43d45702de4c839cb9b51d9f529c5dd26a4aff255b42b1ebc03e88ee908"
SRC_URI[sync_wrapper-0.1.1.sha256sum] = "20518fe4a4c9acf048008599e464deb21beeae3d3578418951a189c235a7a9a8"
SRC_URI[tempfile-3.3.0.sha256sum] = "5cdb1ef4eaeeaddc8fbd371e5017057064af0911902ef36b39801f67cc6d79e4"
SRC_URI[termcolor-1.1.3.sha256sum] = "bab24d30b911b2376f3a13cc2cd443142f0c81dda04c118693e35b3835757755"
SRC_URI[textwrap-0.16.0.sha256sum] = "222a222a5bfe1bba4a77b45ec488a741b3cb8872e5e499451fd7d0129c9c7c3d"
SRC_URI[thiserror-impl-1.0.34.sha256sum] = "e8f2591983642de85c921015f3f070c665a197ed69e417af436115e3a1407487"
SRC_URI[thiserror-1.0.34.sha256sum] = "8c1b05ca9d106ba7d2e31a9dab4a64e7be2cce415321966ea3132c49a656e252"
SRC_URI[tokio-io-timeout-1.2.0.sha256sum] = "30b74022ada614a1b4834de765f9bb43877f910cc8ce4be40e89042c9223a8bf"
SRC_URI[tokio-macros-1.7.0.sha256sum] = "b557f72f448c511a979e2564e55d74e6c4432fc96ff4f6241bc6bded342643b7"
SRC_URI[tokio-rustls-0.23.4.sha256sum] = "c43ee83903113e03984cb9e5cebe6c04a5116269e900e3ddba8f068a62adda59"
SRC_URI[tokio-socketcan-0.3.1.sha256sum] = "fd28e0f7192fbdb501e1146e42cd84d1884b7e9e4ee19edff5f70a35626d93be"
SRC_URI[tokio-stream-0.1.9.sha256sum] = "df54d54117d6fdc4e4fea40fe1e4e566b3505700e148a6827e59b34b0d2600d9"
SRC_URI[tokio-util-0.7.3.sha256sum] = "cc463cd8deddc3770d20f9852143d50bf6094e640b485cb2e189a2099085ff45"
SRC_URI[tokio-1.23.0.sha256sum] = "eab6d665857cc6ca78d6e80303a02cea7a7851e85dfbd77cbdc09bd129f1ef46"
SRC_URI[toml-0.5.9.sha256sum] = "8d82e1a7758622a465f8cee077614c73484dac5b836c02ff6a40d5d1010324d7"
SRC_URI[tonic-build-0.8.4.sha256sum] = "5bf5e9b9c0f7e0a7c027dcfaba7b2c60816c7049171f679d99ee2ff65d0de8c4"
SRC_URI[tonic-0.8.2.sha256sum] = "55b9af819e54b8f33d453655bef9b9acc171568fb49523078d0cc4e7484200ec"
SRC_URI[tower-http-0.3.4.sha256sum] = "3c530c8675c1dbf98facee631536fa116b5fb6382d7dd6dc1b118d970eafe3ba"
SRC_URI[tower-layer-0.3.2.sha256sum] = "c20c8dbed6283a09604c3e69b4b7eeb54e298b8a600d4d5ecb5ad39de609f1d0"
SRC_URI[tower-service-0.3.1.sha256sum] = "360dfd1d6d30e05fda32ace2c8c70e9c0a9da713275777f5a4dbb8a1893930c6"
SRC_URI[tower-0.4.13.sha256sum] = "b8fa9be0de6cf49e536ce1851f987bd21a43b771b09473c3549a6c853db37c1c"
SRC_URI[tracing-attributes-0.1.21.sha256sum] = "cc6b8ad3567499f98a1db7a752b07a7c8c7c7c34c332ec00effb2b0027974b7c"
SRC_URI[tracing-core-0.1.27.sha256sum] = "7709595b8878a4965ce5e87ebf880a7d39c9afc6837721b21a5a816a8117d921"
SRC_URI[tracing-futures-0.2.5.sha256sum] = "97d095ae15e245a057c8e8451bab9b3ee1e1f68e9ba2b4fbc18d0ac5237835f2"
SRC_URI[tracing-0.1.35.sha256sum] = "a400e31aa60b9d44a52a8ee0343b5b18566b03a8321e0d321f695cf56e940160"
SRC_URI[try-lock-0.2.3.sha256sum] = "59547bce71d9c38b83d9c0e92b6066c4253371f15005def0c30d9657f50c7642"
SRC_URI[try_from-0.2.2.sha256sum] = "923a7ee3e97dbfe8685261beb4511cc9620a1252405d02693d43169729570111"
SRC_URI[unicode-ident-1.0.0.sha256sum] = "d22af068fba1eb5edcb4aea19d382b2a3deb4c8f9d475c589b6ada9e0fd493ee"
SRC_URI[untrusted-0.7.1.sha256sum] = "a156c684c91ea7d62626509bce3cb4e1d9ed5c4d978f7b4352658f96a4c26b4a"
SRC_URI[value-bag-1.0.0-alpha.9.sha256sum] = "2209b78d1249f7e6f3293657c9779fe31ced465df091bbd433a1cf88e916ec55"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"
SRC_URI[waker-fn-1.1.0.sha256sum] = "9d5b2c62b4012a3e1eca5a7e077d13b3bf498c4073e33ccd58626607748ceeca"
SRC_URI[want-0.3.0.sha256sum] = "1ce8a968cb1cd110d136ff8b819a556d6fb6d919363c61534f6860c7eb172ba0"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[wasm-bindgen-backend-0.2.81.sha256sum] = "5491a68ab4500fa6b4d726bd67408630c3dbe9c4fe7bda16d5c82a1fd8c7340a"
SRC_URI[wasm-bindgen-futures-0.4.31.sha256sum] = "de9a9cec1733468a8c657e57fa2413d2ae2c0129b95e87c5b72b8ace4d13f31f"
SRC_URI[wasm-bindgen-macro-support-0.2.81.sha256sum] = "7d94ac45fcf608c1f45ef53e748d35660f168490c10b23704c7779ab8f5c3048"
SRC_URI[wasm-bindgen-macro-0.2.81.sha256sum] = "c441e177922bc58f1e12c022624b6216378e5febc2f0533e41ba443d505b80aa"
SRC_URI[wasm-bindgen-shared-0.2.81.sha256sum] = "6a89911bd99e5f3659ec4acf9c4d93b0a90fe4a2a11f15328472058edc5261be"
SRC_URI[wasm-bindgen-0.2.81.sha256sum] = "7c53b543413a17a202f4be280a7e5c62a1c69345f5de525ee64f8cfdbc954994"
SRC_URI[web-sys-0.3.57.sha256sum] = "7b17e741662c70c8bd24ac5c5b18de314a2c26c32bf8346ee1e6f53de919c283"
SRC_URI[webpki-0.22.0.sha256sum] = "f095d78192e208183081cc07bc5515ef55216397af48b873e5edcd72637fa1bd"
SRC_URI[wepoll-ffi-0.1.2.sha256sum] = "d743fdedc5c64377b5fc2bc036b01c7fd642205a0d96356034ae3404d49eb7fb"
SRC_URI[which-4.2.5.sha256sum] = "5c4fb54e6113b6a8772ee41c3404fb0301ac79604489467e0a9ce1f3e97c24ae"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.5.sha256sum] = "70ec6ce85bb158151cae5e5c87f95a8e97d2c0c4b001223f33a334e3ce5de178"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-sys-0.36.1.sha256sum] = "ea04155a16a59f9eab786fe12a4a450e75cdb175f9e0d80da1e17db09f55b8d2"
SRC_URI[windows-sys-0.42.0.sha256sum] = "5a3e1820f08b8513f676f7ab6c1f99ff312fb97b553d30ff4dd86f9f15728aa7"
SRC_URI[windows_aarch64_gnullvm-0.42.0.sha256sum] = "41d2aa71f6f0cbe00ae5167d90ef3cfe66527d6f613ca78ac8024c3ccab9a19e"
SRC_URI[windows_aarch64_msvc-0.36.1.sha256sum] = "9bb8c3fd39ade2d67e9874ac4f3db21f0d710bee00fe7cab16949ec184eeaa47"
SRC_URI[windows_aarch64_msvc-0.42.0.sha256sum] = "dd0f252f5a35cac83d6311b2e795981f5ee6e67eb1f9a7f64eb4500fbc4dcdb4"
SRC_URI[windows_i686_gnu-0.36.1.sha256sum] = "180e6ccf01daf4c426b846dfc66db1fc518f074baa793aa7d9b9aaeffad6a3b6"
SRC_URI[windows_i686_gnu-0.42.0.sha256sum] = "fbeae19f6716841636c28d695375df17562ca208b2b7d0dc47635a50ae6c5de7"
SRC_URI[windows_i686_msvc-0.36.1.sha256sum] = "e2e7917148b2812d1eeafaeb22a97e4813dfa60a3f8f78ebe204bcc88f12f024"
SRC_URI[windows_i686_msvc-0.42.0.sha256sum] = "84c12f65daa39dd2babe6e442988fc329d6243fdce47d7d2d155b8d874862246"
SRC_URI[windows_x86_64_gnu-0.36.1.sha256sum] = "4dcd171b8776c41b97521e5da127a2d86ad280114807d0b2ab1e462bc764d9e1"
SRC_URI[windows_x86_64_gnu-0.42.0.sha256sum] = "bf7b1b21b5362cbc318f686150e5bcea75ecedc74dd157d874d754a2ca44b0ed"
SRC_URI[windows_x86_64_gnullvm-0.42.0.sha256sum] = "09d525d2ba30eeb3297665bd434a54297e4170c7f1a44cad4ef58095b4cd2028"
SRC_URI[windows_x86_64_msvc-0.36.1.sha256sum] = "c811ca4a8c853ef420abd8592ba53ddbbac90410fab6903b3e79972a631f7680"
SRC_URI[windows_x86_64_msvc-0.42.0.sha256sum] = "f40009d85759725a34da6d89a94e63d7bdc50a862acf0dbc7c8e488f1edcb6f5"

SRCREV = "${SRCREV_client}"
PV = "0.5.1"
DEPENDS = "protobuf-native protobuf"
RDEPENDS:${PN} = "curl"
CARGO_SRC_DIR = ""

S = "${WORKDIR}/git"

inherit cargo systemd

SRC_URI += " \
    crate://crates.io/anyhow/1.0.75 \
    crate://crates.io/async-channel/1.6.1 \
    crate://crates.io/async-executor/1.4.1 \
    crate://crates.io/async-global-executor/2.1.0 \
    crate://crates.io/async-io/1.7.0 \
    crate://crates.io/async-lock/2.6.0 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-stream-impl/0.3.3 \
    crate://crates.io/async-stream/0.3.3 \
    crate://crates.io/async-task/4.2.0 \
    crate://crates.io/async-trait/0.1.53 \
    crate://crates.io/atomic-waker/1.0.0 \
    crate://crates.io/atty/0.2.14 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/axum-core/0.2.9 \
    crate://crates.io/axum/0.5.17 \
    crate://crates.io/base64/0.13.0 \
    crate://crates.io/bitflags/0.4.0 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/blocking/1.2.0 \
    crate://crates.io/bumpalo/3.10.0 \
    crate://crates.io/bytes/1.1.0 \
    crate://crates.io/cache-padded/1.2.0 \
    crate://crates.io/can-dbc/5.0.0 \
    crate://crates.io/cc/1.0.73 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/clap/3.2.23 \
    crate://crates.io/clap_lex/0.2.4 \
    crate://crates.io/codegen/0.2.0 \
    crate://crates.io/concurrent-queue/1.2.2 \
    crate://crates.io/crossbeam-utils/0.8.8 \
    crate://crates.io/ctor/0.1.22 \
    crate://crates.io/derive-getters/0.2.0 \
    crate://crates.io/either/1.6.1 \
    crate://crates.io/event-listener/2.5.2 \
    crate://crates.io/fastrand/1.7.0 \
    crate://crates.io/fixedbitset/0.4.1 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/futures-channel/0.3.25 \
    crate://crates.io/futures-core/0.3.25 \
    crate://crates.io/futures-executor/0.3.25 \
    crate://crates.io/futures-io/0.3.25 \
    crate://crates.io/futures-lite/1.12.0 \
    crate://crates.io/futures-macro/0.3.25 \
    crate://crates.io/futures-sink/0.3.25 \
    crate://crates.io/futures-task/0.3.25 \
    crate://crates.io/futures-util/0.3.25 \
    crate://crates.io/futures/0.3.25 \
    crate://crates.io/getrandom/0.2.7 \
    crate://crates.io/gloo-timers/0.2.4 \
    crate://crates.io/gpio-cdev/0.5.1 \
    crate://crates.io/h2/0.3.13 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/heck/0.4.0 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/hex/0.2.0 \
    crate://crates.io/home/0.5.4 \
    crate://crates.io/http-body/0.4.5 \
    crate://crates.io/http-range-header/0.3.0 \
    crate://crates.io/http/0.2.8 \
    crate://crates.io/httparse/1.7.1 \
    crate://crates.io/httpdate/1.0.2 \
    crate://crates.io/hyper-timeout/0.4.1 \
    crate://crates.io/hyper/0.14.19 \
    crate://crates.io/indexmap/1.9.1 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/itertools/0.10.3 \
    crate://crates.io/itertools/0.4.19 \
    crate://crates.io/itoa/1.0.2 \
    crate://crates.io/js-sys/0.3.58 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.138 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/matchit/0.5.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/mime/0.3.16 \
    crate://crates.io/minimal-lexical/0.2.1 \
    crate://crates.io/mio/0.8.4 \
    crate://crates.io/multimap/0.8.3 \
    crate://crates.io/nix/0.23.1 \
    crate://crates.io/nix/0.26.1 \
    crate://crates.io/nix/0.5.1 \
    crate://crates.io/nom/7.1.1 \
    crate://crates.io/num_cpus/1.13.1 \
    crate://crates.io/once_cell/1.12.0 \
    crate://crates.io/os_str_bytes/6.4.1 \
    crate://crates.io/parking/2.0.0 \
    crate://crates.io/percent-encoding/2.1.0 \
    crate://crates.io/petgraph/0.6.2 \
    crate://crates.io/pin-project-internal/1.0.12 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-project/1.0.12 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/polling/2.2.0 \
    crate://crates.io/ppv-lite86/0.2.16 \
    crate://crates.io/prettyplease/0.1.11 \
    crate://crates.io/proc-macro2/1.0.47 \
    crate://crates.io/prost-build/0.11.4 \
    crate://crates.io/prost-derive/0.11.0 \
    crate://crates.io/prost-types/0.11.1 \
    crate://crates.io/prost/0.11.3 \
    crate://crates.io/quote/1.0.18 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.3 \
    crate://crates.io/redox_syscall/0.2.13 \
    crate://crates.io/regex-syntax/0.6.26 \
    crate://crates.io/regex/1.5.6 \
    crate://crates.io/remove_dir_all/0.5.3 \
    crate://crates.io/ring/0.16.20 \
    crate://crates.io/rustls-pemfile/1.0.0 \
    crate://crates.io/rustls/0.20.6 \
    crate://crates.io/sct/0.7.0 \
    crate://crates.io/serde/1.0.150 \
    crate://crates.io/serde_derive/1.0.150 \
    crate://crates.io/slab/0.4.6 \
    crate://crates.io/socket2/0.4.4 \
    crate://crates.io/socketcan/1.7.0 \
    crate://crates.io/spin/0.5.2 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/syn/1.0.105 \
    crate://crates.io/sync_wrapper/0.1.1 \
    crate://crates.io/tempfile/3.3.0 \
    crate://crates.io/termcolor/1.1.3 \
    crate://crates.io/textwrap/0.16.0 \
    crate://crates.io/thiserror-impl/1.0.34 \
    crate://crates.io/thiserror/1.0.34 \
    crate://crates.io/tokio-io-timeout/1.2.0 \
    crate://crates.io/tokio-macros/1.7.0 \
    crate://crates.io/tokio-rustls/0.23.4 \
    crate://crates.io/tokio-socketcan/0.3.1 \
    crate://crates.io/tokio-stream/0.1.9 \
    crate://crates.io/tokio-util/0.7.3 \
    crate://crates.io/tokio/1.23.0 \
    crate://crates.io/toml/0.5.9 \
    crate://crates.io/tonic-build/0.8.4 \
    crate://crates.io/tonic/0.8.2 \
    crate://crates.io/tower-http/0.3.4 \
    crate://crates.io/tower-layer/0.3.2 \
    crate://crates.io/tower-service/0.3.1 \
    crate://crates.io/tower/0.4.13 \
    crate://crates.io/tracing-attributes/0.1.21 \
    crate://crates.io/tracing-core/0.1.27 \
    crate://crates.io/tracing-futures/0.2.5 \
    crate://crates.io/tracing/0.1.35 \
    crate://crates.io/try-lock/0.2.3 \
    crate://crates.io/try_from/0.2.2 \
    crate://crates.io/unicode-ident/1.0.0 \
    crate://crates.io/untrusted/0.7.1 \
    crate://crates.io/value-bag/1.0.0-alpha.9 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/want/0.3.0 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.81 \
    crate://crates.io/wasm-bindgen-futures/0.4.31 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.81 \
    crate://crates.io/wasm-bindgen-macro/0.2.81 \
    crate://crates.io/wasm-bindgen-shared/0.2.81 \
    crate://crates.io/wasm-bindgen/0.2.81 \
    crate://crates.io/web-sys/0.3.57 \
    crate://crates.io/webpki/0.22.0 \
    crate://crates.io/wepoll-ffi/0.1.2 \
    crate://crates.io/which/4.2.5 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.36.1 \
    crate://crates.io/windows-sys/0.42.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.0 \
    crate://crates.io/windows_aarch64_msvc/0.36.1 \
    crate://crates.io/windows_aarch64_msvc/0.42.0 \
    crate://crates.io/windows_i686_gnu/0.36.1 \
    crate://crates.io/windows_i686_gnu/0.42.0 \
    crate://crates.io/windows_i686_msvc/0.36.1 \
    crate://crates.io/windows_i686_msvc/0.42.0 \
    crate://crates.io/windows_x86_64_gnu/0.36.1 \
    crate://crates.io/windows_x86_64_gnu/0.42.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.0 \
    crate://crates.io/windows_x86_64_msvc/0.36.1 \
    crate://crates.io/windows_x86_64_msvc/0.42.0 \
"

BBCLASSEXTEND = "native"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-insight-client.service"

do_configure:prepend() {
    cd ${WORKDIR}/git
    git submodule update --init --recursive
}

do_install() {
    install -d ${D}/opt/host-insight-client
    install -d 755 ${D}/${sysconfdir}/opt/host-insight-client
    install -d ${D}${systemd_unitdir}/system

    install -m 755 ${B}/target/aarch64-poky-linux-gnu/release/host-insight-client ${D}/opt/host-insight-client/host-insight-client
    install -m 755 ${S}/scripts/exit-handler.sh ${D}/opt/host-insight-client/exit-handler.sh
    install -m 644 ${S}/scripts/conf-fallback.toml ${D}/${sysconfdir}/opt/host-insight-client/conf-fallback.toml
    install -m 644 ${S}/scripts/host-insight-client.service ${D}/${systemd_unitdir}/system/host-insight-client.service
}


FILES:${PN} = "/opt/host-insight-client/host-insight-client \
               /opt/host-insight-client/exit-handler.sh \
               ${sysconfdir}/opt/host-insight-client \
               ${sysconfdir}/opt/host-insight-client/conf-fallback.toml \
               ${systemd_system_unitdir}/host-insight-client.service \
               ${sysconfdir}/opt/host-insight-client"