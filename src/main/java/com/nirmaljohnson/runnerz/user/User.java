package com.nirmaljohnson.runnerz.user;

public record User(
        Integer id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}

record Address(
        String street,
        String suite,
        String city,
        String zipcode
){
}

record Company(
        String name,
        String catchPhrase,
        String bs
){}
