package slash.data;

/** A named key/value pair. */
public class Property {
  
  public final String key;
  public final Object val;
  
  public Property(String key, Object val) {
    this.key = key;
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Property)) return false;
    
    Property other = (Property) o;
    return this.key.equals(other.key)
        && this.val.equals(other.val); 
  }

  @Override
  public int hashCode() {
    return this.key.hashCode() * 31 + this.val.hashCode();
  }
}
