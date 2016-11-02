/*
 * 文件名：Test.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年11月1日
 */
package com.westone.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class Test
{
    /**
     * 直接比对，但是无法适应需求变化的情况
     * 
     * @param invoices
     * @param amount
     * @return
     */
    public List<Invoice> findInvoicesGreaterThanAmount(List<Invoice> invoices, double amount)
    {
        List<Invoice> result = new ArrayList<Invoice>();
        for (Invoice inv : invoices)
        {
            if (inv.getAmount() > amount)
            {
                result.add(inv);
            }
        }
        return result;
    }
    
    /**
     * 增加一个Invoice对象解决需求变化带来的问题
     * 
     * @param invoices
     * @param p
     * @return
     */
    public List<Invoice> findInvoices(List<Invoice> invoices, InvoicePredicate p)
    {
        List<Invoice> result = new ArrayList<Invoice>();
        for (Invoice inv : invoices)
        {
            if (p.test(inv))
            {
                result.add(inv);
            }
        }
        return result;
    }
    
    public void xy()
    {
        List<Invoice> invoices = new ArrayList<Invoice>();
        List<Invoice> expensiveInvoicesFromOracle = findInvoices(invoices, new InvoicePredicate()
        {
            public boolean test(Invoice inv)
            {
                return inv.getAmount() > 10 && inv.getCustomer() == 0.01;
            }
        });
    }
    
    public void yy()
    {
        List<Invoice> invoices = new ArrayList<Invoice>();
        List<Invoice> expensiveInvoicesFromOracle =
            findInvoices(invoices, inv -> (inv.getAmount() > 10) && (inv.getCustomer() == 0.01));
    }
    
    public void zz()
    {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features)
        {
            System.out.println(feature);
        }
        
        // In Java 8:
        List<String> features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features1.forEach(n -> System.out.println(n));
        
        // Even better use Method reference feature of Java 8
        // method reference is denoted by :: (double colon) operator
        // looks similar to score resolution operator of C++
        features1.forEach(System.out::println);
    }
    
    public static void main(String[] args)
    {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        
        System.out.println("Languages which starts with J :");
        
        filter(languages, (str) -> ((String)str).startsWith("J"));
        
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> ((String)str).endsWith("a"));
        
        System.out.println("Print all languages :");
        filter(languages, (str) -> true);
        
        System.out.println("Print no language : ");
        filter(languages, (str) -> false);
        
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> ((String)str).length() > 4);
    }
    
    public static void filter(List<String> names, Predicate condition)
    {
        for (String name : names)
        {
            if (condition.test(name))
            {
                System.out.println(name + " ");
            }
        }
    }
    
}
