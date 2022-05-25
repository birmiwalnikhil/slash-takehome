# slash-takehome

The take-home project as provided from Slash. Implements
and tests a stripped-down OpenAPI Schema parser. Written in Java.

Assumptions:
  - The primary function is `validateSchema (Schema schema, Object data) -> boolean`.
  - We make the following assumptions about data: `Object`. 
    - `data` must be a String to satisfy the `StringSchema`.
    - `data` must be an Integer to satisfy the `NumberSchema` (i.e. we don't
      support floats/doubles/longs/etc).
    - `data` must be a Boolean to satisfy the `BooleanSchema`.
    - `data` must be a `PropertyMap` to satisfy the `ObjectSchema`.
    - `data` must be a list of the above types (and this one!) to satisfy the `ArraySchema`.

