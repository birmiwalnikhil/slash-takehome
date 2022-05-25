package slash.data;

import java.util.Set;
import java.util.HashSet;

/** An unordered collection of {@link Property}s. */
public class PropertyMap {
  
  /** A mapping from name -> Object. */
  public final Set<Property> properties;

  public PropertyMap() {
    this.properties = new HashSet<>();
  }

  /**
   * Add or replace a property.
   * @param name The name of the new property.
   * @param o The value of the new property.
   */
  public void addProperty(String name, Object o) {
    this.properties.add(new Property(name, o));
  }

  // VisibleForTesting
  protected boolean hasProperty(String name, Object o) {
    return properties.contains(new Property(name, o));
  }
}
