package com.holdbetter;

public class Bicycle
{
    private String name;
    private double maxSpeed;
    private double price;

    public Bicycle(String name, double maxSpeed, double price)
    {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
