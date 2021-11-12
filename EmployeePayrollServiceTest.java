package com.bl.emplyeepayroll;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;

public class EmployeePayrollServiceTest {
    private Assertions Assert;
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries(){
        EmployeePayRoll[] arrayOfEmps = {
                new EmployeePayRoll(1,"Jeff Bezos",100000.0),
                new EmployeePayRoll(2,"Bill Gates",200000.0),
                new EmployeePayRoll(3,"Mark Zuckerberg",300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.count(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,entries, entries);
    }
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldPrintEmployeeEntries(){
        EmployeePayRoll[] arrayOfEmps = {
                new EmployeePayRoll(1,"Jeff Bezos",100000.0),
                new EmployeePayRoll(2,"Bill Gates",200000.0),
                new EmployeePayRoll(3,"Mark Zuckerberg",500000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.count(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,entries, entries);
    }

    @Test
    public void givenFile_onReadingFromFile_shouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(null);
        employeePayrollService.readDataFromFile(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.count(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3, entries, entries);
    }
}