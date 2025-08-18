package com.fr.eni.demo_rest.service;

import com.fr.eni.demo_rest.bo.Person;

import java.util.List;

public class ServiceResponse<T> {

    public String code;
    public T data;
}
