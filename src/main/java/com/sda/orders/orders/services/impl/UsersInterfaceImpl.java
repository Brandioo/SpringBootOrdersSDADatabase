//package com.sda.orders.orders.services.impl;
//
//import com.sda.orders.orders.model.Users;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//@Service
//public class UsersInterfaceImpl implements UserDetails {
//    private final Users users;
//
//    public UsersInterfaceImpl(Users users) {
//        this.users = users;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return List.of(new SimpleGrantedAuthority(users.getRole()));
//
//        return Arrays.asList(new SimpleGrantedAuthority(users.getRole()));
//    }
//
//    @Override
//    public String getPassword() {
//        return users.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return users.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
