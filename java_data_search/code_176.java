package service;

import bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    void add(Customer customer);
    void edit(Customer customer);
    void delete (int id);
    List<Customer> search(String name);
    void deleteAll();

}