package com.holdbetter;

public class Cycler
{
    private static int cyclersOnTourCount;
    private static Cycler[] cyclersOnTour = new Cycler[0];

    private String name;
    private String lastName;
    private String country;
    private int age;
    private Bicycle[] bicycles = new Bicycle[5]; // 0 1 2 3 4 = null
    private double speedAverage;
    private boolean onTrack = false;

    private Cycler()
    {
        // this.cyclers.length = 1
        // this.cyclers
        // 0 - cycler1

        // cyclersBuffer = cyclers
        //
        // cyclers = new Cyclers[cyclersBuffer.length + 1]
        // this.cyclers
        // 0 - null
        // 1 - null

        Cycler[] cyclersBuffer = cyclersOnTour;
        cyclersOnTour = new Cycler[cyclersBuffer.length + 1];
        for (int i = 0; i < cyclersBuffer.length; i++)
        {
            cyclersOnTour[i] = cyclersBuffer[i];
        }

        if (cyclersBuffer.length == 0)
        {
            cyclersOnTour = new Cycler[cyclersBuffer.length + 1];
            cyclersOnTour[0] = this;
        }
        else
        {
            cyclersOnTour[cyclersOnTour.length - 1] = this;
        }
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

        if (bicycles != null)
        {
            for (int i = 0; i < bicycles.length; i++)
            {
                if (i == 5)
                {
                    break;
                }
                this.bicycles[i] = bicycles[i];
            }
        }
    }

    public static int getCyclersOnTourCount()
    {
        return cyclersOnTourCount;
    }

    public static void getTourInfo()
    {
        for (Cycler cycler : cyclersOnTour)
        {
            cycler.printCyclerInfo();
        }
    }

    public int goIn()
    {
        int res = this.onTrack ? cyclersOnTourCount : ++cyclersOnTourCount; //тернарный оператор
        this.onTrack = true;
        return res;
    }

    public int goOut()
    {
        int res = onTrack ? --cyclersOnTourCount : cyclersOnTourCount; // если да, верни 1, иначе верни 2
        onTrack = false;
        return res;
    }

    public void addBicycle(Bicycle bicycle)
    {
        // this.bicycles.length = 2
        // this.bicycles
        // 0 - Navigator 500
        // 1 - Navigator 640

        // this.bicycles.length = 5
        // this.bicycles
        // 0 - Navigator 500
        // 1 - Navigator 640
        // 2 - Navigator 5000
        // 3 - null
        // 4 - null

        if (bicycle != null)
        {
            for (int i = 0; i < 5; i++)
            {
                if (this.bicycles[i] == null)
                {
                    this.bicycles[i] = bicycle;
                    return;
                }
            }
        }
    }

    public double finish()
    {
        return (10 / Math.pow(this.age, 2)) / (this.bicycles[0].getMaxSpeed() * this.speedAverage);
    }

    public String getName()
    {
        return name;
    }

    public Bicycle[] getBicycles()
    {
        return bicycles;
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

    public int getNonNullBicycleCount()
    {
        int count = 0;
        for (int i = 0; i < bicycles.length; i++)
        {
            if (bicycles[i] != null)
            {
                count++;
            }
        }
        return count;
    }

    private void printCyclerInfo()
    {
        System.out.printf("Name: %s Surname: %s ", this.name, this.lastName);
        System.out.printf("Age: %d ", this.age);
        System.out.printf("Country: %s ", this.country);
        System.out.print("Bicycles: ");
        for (Bicycle bicycle : this.bicycles)
        {
            if (bicycle != null)
            {
                System.out.print(bicycle.getName() + " ");
            }
        }
        System.out.println();
    }
}