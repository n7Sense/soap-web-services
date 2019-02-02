package com.nsense.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="EMP_BANK_ACC", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "BANK_ACC_ID"))
    private Set<BankAccount> bankAccount;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private double salary;

    @Column(name = "COMMISSION_PCT")
    private float commission;

    @Column(name = "MANAGER_ID")
    private int managerId;

    @Column(name = "DEPARTMENT_ID")
    private int departmentId;

    public EmployeeDomain(){}

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Set<BankAccount> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Set<BankAccount> bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "EmployeeDomain{" +
                "employeeId=" + employeeId +
                ", bankAccount=" + bankAccount +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commission=" + commission +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }
}
