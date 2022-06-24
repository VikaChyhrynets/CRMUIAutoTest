package org.example;

public class TestRunner
{
    public static void main( String[] args )
    {
        CRMTests crmTests = new CRMTests();
        System.out.println(crmTests.authorizationTest());
        System.out.println(crmTests.orderingItemsTest());
        crmTests.closeChromeTab();
    }
}
