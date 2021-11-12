package com.bl.emplyeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    private List<EmployeePayRoll> employeePayrollDataList;


    public EmployeePayRollService(List<EmployeePayRoll> employeePayrollDataList) {
        this.employeePayrollDataList = employeePayrollDataList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayRoll> employeePayrollList = new ArrayList<EmployeePayRoll>();
        EmployeePayRollService employeePayrollService = new EmployeePayRollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    }

    //method to read data
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id:");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name:");
        consoleInputReader.nextLine();
        String name = consoleInputReader.nextLine();
        System.out.println("Enter Employee salary:");
        double salary = consoleInputReader.nextInt();
        employeePayrollDataList.add(new EmployeePayRoll(id, name, salary));
    }

    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\nWriting Employee Payroll Roaster To console::\n" + employeePayrollDataList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollDataList);
    }

    public long count(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }
    //method to print entries from a file
    public void printData(IOService ioService){
        if(ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }
}