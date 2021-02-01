package com.jvm.classloader;

import com.sun.jndi.ldap.spi.LdapDnsProvider;

/**
 * xiaog
 */
public class ClassLoader1 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        //System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(LdapDnsProvider.class.getClassLoader());
        System.out.println(ClassLoader1.class.getClassLoader());
        System.out.println("===");
        System.out.println(ClassLoader1.class.getClassLoader());
        System.out.println(ClassLoader1.class.getClassLoader().getParent());
        System.out.println(ClassLoader1.class.getClassLoader().getParent().getClass().getClassLoader());
    }
}
