package slash.schemas;

/** A {@link Schema} defines a set of properties for some given data. */
public abstract class Schema {
 
  /** 
   * Return whether the {@code data} conforms to the provided {@link Schema}.
   */
  public abstract boolean matches(Object data);
}
