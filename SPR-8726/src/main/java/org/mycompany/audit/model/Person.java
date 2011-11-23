package org.mycompany.audit.model;

import java.util.HashSet;
import java.util.Set;

public class Person extends PrincipalImpl
{
  private Set<Person> aliases;

  public Person(String id, String name)
  {
    super();
    setId(id);
    setName(name);
  }

  public Person()
  {
    // no-arg
  }

  public Set<Person> getAliases()
  {
    if (aliases == null)
    {
      return new HashSet<Person>();
    }
    else
    {
      return aliases;
    }
  }

  public void setAliases(Set<Person> aliases)
  {
    this.aliases = aliases;
  }

  @Override
  public String toString()
  {
    return "Person [aliases=" + getAliases() + ", " + super.toString() + "]";
  }

}
