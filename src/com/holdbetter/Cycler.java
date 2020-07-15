package com.holdbetter;

public class Cycler
{
    private String name;
    private String lastName;
    private String country;
    private int age;
    private Bicycle[] bicycles = new Bicycle[5];
    private double speedAverage;

    private static int cyclerOnTourCount;
    private static Cycler[] cyclersOnTour = new Cycler[0];

    private Cycler()
    {
        Cycler[] cyclersBuffer = cyclersOnTour;
        cyclersOnTour = new Cycler[cyclersBuffer.length + 1];
        for (int i = 0; i < cyclersBuffer.length; i++)
        {
            cyclersOnTour[i] = cyclersBuffer[i];
        }
        cyclersBuffer[cyclersBuffer.length - 1] = this;
    }

    private Cycler(String name, String lastName)
    {
        this();
        this.name = name;
        this.lastName = lastName;
    }

    private Cycler(String name, String lastName, String country, int age, double speedAverage)
    {
        this(name, lastName);
        this.country = country;
        this.age = age;
        this.speedAverage = speedAverage;
    }

    public Cycler(String name, String lastName, String country, int age, double speedAverage, Bicycle... bicycles)
    {
        this(name, lastName, country, age, speedAverage);

        if (bicycles.length <= 5)
        {
            this.bicycles = bicycles;
        }
        else
        {
            for (int i = 0; i < 5; i++)
            {
                this.bicycles[i] = bicycles[i];
            }
        }
    }

    public int goIn()
    {
        return ++cyclerOnTourCount;
    }

    public int goOut()
    {
        return --cyclerOnTourCount;
    }

    public void addBicycle(Bicycle bicycle)
    {
        for (int i = 0; i < this.bicycles.length; i++)
        {
            if (bicycles[i] == null)
            {
                bicycles[i] = bicycle;
            }
        }
    }

    public double finish()
    {
        return (10 / Math.pow(this.age, 2)) /
                (this.bicycles[0].getMaxSpeed() * this.speedAverage);
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public int getAge()
    {
        return age;
    }

    public double getSpeedAverage()
    {
        return speedAverage;
    }

    public void setSpeedAverage(double speedAverage)
    {
        this.speedAverage = speedAverage;
    }

    public static int getCyclerOnTourCount()
    {
        return cyclerOnTourCount;
    }

    public static void getTourInfo()
    {
        for (Cycler cycler : cyclersOnTour)
        {
            cycler.printCyclerInfo();
        }
    }

    private void printCyclerInfo()
    {
        System.out.printf("Имя: %s Фамилия: %s", this.name, this.lastName);
        System.out.printf("Возраст: %d", this.age);
        System.out.printf("Страна: %s", this.country);
        System.out.print("Велосипеды: ");
        for (Bicycle bicycle : this.bicycles)
        {
            System.out.print(bicycle.getName());
        }
        System.out.println();
    }
}