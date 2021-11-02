javac --release 8 --source-path ../../src/ -d ../gui-classes/ ../../src/GUI.java
jar cfm ../jars/build-graphical.jar ../manifests/MANIFEST-GRAPHICAL.MF ../gui-classes/*