package com.md;

import com.md.lab3.Simplex;

/**
 * Created by User on 12-Apr-18.
 */
public class Main {
    public static void main(String[] args) {
        Simplex simplex = new Simplex(3,2);
        double [][] matr = new double[][]{{-2.0,1.,0.},{2.,1.,8.},{1.,3.,6.},{3.,1.,3.}};
        simplex.fillTable(matr);
        simplex.print();
        System.out.println(simplex.compute());
    }
}
