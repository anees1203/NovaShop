package com.shop.ecom.shared.authentication.domain;


import com.shop.ecom.shared.error.domain.Assert;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public record Roles(Set<Role> roles) {

  public static final Roles EMPTY = new Roles(Collections.emptySet());

  public Roles(Set<Role> roles) {
    this.roles = Collections.unmodifiableSet(roles);
  }

  public boolean hasRole(){
    return !roles.isEmpty();
  }
  public boolean hasRole(Role role){
    Assert.notNull("role", role);
    return roles.contains(role);
  }
  public Stream<Role> stream(){
    return get().stream();
  }
  public Set<Role> get(){
    return roles();
  }
}
