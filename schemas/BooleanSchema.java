package slash.schemas;

/** A {@link Schema} for booleans. */
public class BooleanSchema extends Schema {

  public BooleanSchema() {
  }

  @Override
  public boolean matches(Object data) {
    return data instanceof Boolean; 
  }
}
