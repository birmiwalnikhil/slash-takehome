package slash.schemas;

/** A {@link Schema} for Arrays. */
public class ArraySchema extends Schema {

  /** An inner schema to match every element of the data. */
  private Schema schema;

  public ArraySchema(Schema schema) {
    this.schema = schema;
  }

  @Override
  public boolean matches(Object data) {
    if (!(data instanceof Object[])) return false;
  
    Object[] dataArray = (Object[]) data;
    for (Object o : dataArray) {
      if (!schema.matches(o)) {
        return false;
      }
    }

    return true;
  }
}
