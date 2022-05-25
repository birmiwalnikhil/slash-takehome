load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
  name = "Main",
  srcs = glob(["src/*.java"]),
  deps = [
    "//data",
    "//schemas"
  ]
)
