javac --release 8 --source-path ../../src/ -d ../cli-classes/ ../../src/CLI.java
jar cfm ../jars/build-headless.jar ../manifests/MANIFEST-HEADLESS.MF ../cli-classes/*