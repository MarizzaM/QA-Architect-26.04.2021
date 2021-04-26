package com.company;

public class TripleCalculator implements ITripleCalculator{

    private int m_boomCount;

    @Override
    public int calc(int x) {
        if (x == 0)
            return 300;
        if (x % 7 == 0){
            m_boomCount++;
            System.out.println("Boom!");
            return 7;
        }
        return x * 3;
    }
}
