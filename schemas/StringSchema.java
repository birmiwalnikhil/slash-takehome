package slash.schemas;

import java.util.Set;
import java.util.HashSet;

/** A {@link Schema} for Strings. */
public class StringSchema extends Schema {

  /** 
   * A list of enums, if specified. If specified,
   * Any data data must be present in {@link #enums}.
   */ 
  private final Set<String> enums;

  public StringSchema(String... enums) {
    this.enums = new HashSet<>();
    for (String x : enums) {
      this.enums.add(x);
    }
  }

  @Override
  public boolean matches(Object data) {
    if (!(data instanceof String)) {
      return false;
    }

    if (!this.enums.isEmpty()) {
      return this.enums.contains((String) data);
    }

    return true;
  }

}
