package slash.schemas;

/** A {@link Schema} for numbers. We currently only support Integers. */
public class NumberSchema extends Schema {

  public NumberSchema() {
  }

  @Override
  public boolean matches(Object data) {
    return data instanceof Integer;
  }
}
