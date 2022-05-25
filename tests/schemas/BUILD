load("@rules_java//java:defs.bzl", "java_test")

java_test(
  name = "StringSchemaTest",
  srcs = ["StringSchemaTest.java"],
  test_class = "slash.schemas.StringSchemaTest",
  deps = [
    "//schemas",
    "//third_party:junit4",
    "//third_party:truth"
  ]
)

java_test(
  name = "NumberSchemaTest",
  srcs = ["NumberSchemaTest.java"],
  test_class = "slash.schemas.NumberSchemaTest",
  deps = [
    "//schemas",
    "//third_party:junit4",
    "//third_party:truth"
  ]
)

java_test(
  name = "BooleanSchemaTest",
  srcs = ["BooleanSchemaTest.java"],
  test_class = "slash.schemas.BooleanSchemaTest",
  deps = [
    "//schemas",
    "//third_party:junit4",
    "//third_party:truth"
  ]
)

java_test(
  name = "ObjectSchemaTest",
  srcs = ["ObjectSchemaTest.java"],
  test_class = "slash.schemas.ObjectSchemaTest",
  deps = [
    "//data",
    "//schemas",
    "//third_party:junit4",
    "//third_party:truth"
  ]
)


