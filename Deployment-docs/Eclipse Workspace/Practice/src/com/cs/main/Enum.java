package com.cs.main;

public class Enum {
  
  public static void main(String[] args)
  {
    
    Currency coin = Currency.PENNY;
    System.out.println(coin.getValue());
  }
  
}

enum Currency
{
  PENNY(1) {
    
    @Override
    public String color()
    {
      return null;
    }
  }, NICKLE(2) {
    
    @Override
    public String color()
    {
      return null;
    }
  }, DIME(3) {
    
    @Override
    public String color()
    {
      return null;
    }
  }, QUARTER(4){
    @Override
    public String color()
    {
      return null;
    }
  };

  public abstract String color();

  private int value;
  
  private Currency(int value)
  {
    this.value = value;
  }

  
  public int getValue()
  {
    return value;
  }

};