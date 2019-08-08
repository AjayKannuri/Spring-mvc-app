package com.dbs.springmvcapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable, Comparable<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "emp_name")
    @NotBlank(message = "Name cannot be null")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "department_name")
    @NotBlank(message = "dept cannot be null")
    private String departmentName;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BankAccount> bankAccountSet = new HashSet<>();
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Dependant> dependantSet = new HashSet<>();


    public Set<Dependant> getDependantSet() {
		return dependantSet;
	}

	public void setDependantSet(Set<Dependant> dependantSet) {
		this.dependantSet = dependantSet;
	}

	public Employee() {
    }

    public Employee(String name, LocalDate dateOfBirth, String departmentName) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.departmentName = departmentName;
    }


    public Set<BankAccount> getBankAccountSet() {
        return bankAccountSet;
    }

    public void setBankAccountSet(Set<BankAccount> bankAccountSet) {
        this.bankAccountSet = bankAccountSet;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addBankAccount(BankAccount bankAccount){
        this.bankAccountSet.add(bankAccount);
        bankAccount.setEmployee(this);
    }
    
    public void addDependant(Dependant dependant)
    {
    	this.dependantSet.add(dependant);
    	dependant.setEmployee(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(dateOfBirth, employee.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth);
    }


    @Override
    public int compareTo(Employee employee) {
        return (int) (this.id - employee.id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}