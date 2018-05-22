package com.md.Lab7;

import ilog.concert.IloException;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Main {
    public static void main(String[] args) {
        try
        {
            IloCplex model = new IloCplex();
            model.importModel("D:/Problem.lp");

            /*IloNumVar x1 = model.numVar(0,Double.MAX_VALUE);
            IloNumVar x2 = model.numVar(0,Double.MAX_VALUE);


            model.addMaximize(model.diff(
                    272.,
                    model.prod(2,x1,x1),
                    model.prod(-32,x2),
                    model.prod(4,x2,x2),
                    model.prod(-48,x2)
            ));

            model.addLe(model.sum(model.prod(2,x1), model.prod(3,x2)),6);
            model.addLe(model.sum(x1,x2),7);
            model.addLe(model.sum(model.prod(11,x1),model.prod(5,x2)),55);
*/
            model.solve();
            System.out.println();
            System.out.println("Minimal integer value = " + model.getObjValue());
            model.end();
        }catch(IloException e){
            e.printStackTrace();
        }

    }
}
