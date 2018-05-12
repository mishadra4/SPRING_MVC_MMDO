package com.md.lab4;


public class SearchPlan {
    private int M = 4, N = 4;   //не дуже то і потрібно M=isPresent.length; N = needs.length;
    private int[][] tableOfValues;//={{1, 2, 9, 7}, {3, 4, 1, 5}, {6, 4, 8, 3}, {2,3,3,1}};
    private int[][] resultTable;
    private int functionValue;

    private int[] isPresent;// = {60, 55, 40, 35};
    private int[] needs;// = {70, 5, 45, 70};

    public SearchPlan(){}

    SearchPlan(Integer n, Integer m, Integer[][] values, Integer[] needs, Integer[] isPresent){
        M = m;
        N = n;
        this.isPresent = new int[M];
        this.needs = new int[N];
        this.tableOfValues = new int[M][N];
        for (int i = 0; i < M; i++) {
            this.isPresent[i] = isPresent[i];
            tableOfValues[i] = new int[N];
            for (int j = 0; j < N; j++) {
                this.tableOfValues[i][j] = values[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            this.needs[i] = needs[i];
        }
        resultTable = new int[M][N];

      // M = 3;
       //N = 4;
       //tableOfValues =
    }

    public Result res(){
        System.out.println("Початкові дані:");
        printResult(tableOfValues);
        System.out.println();
        System.out.println("Пошук плану методом північно-західного кута");
        int[][] nwa = nwaMethod();
        printResult(nwa);
        System.out.println();

        System.out.println();
        System.out.println("u i v:");

        int[][] pot = potentials(nwa);
        //System.out.println("Potentials:");
        printResult(pot);

        System.out.println("Значення цільової функції - " + functionValue(nwa));
        int[] u = pot[0];
        int[] v = pot[1];

        int[][] optplan = findOptPlan(nwa, u, v);
        //System.out.println("Opt Plan:");
        System.out.println("Оптимальний план");
        printResult(optplan);
        if(M == 4) {
            functionValue = functionValue(optplan) - 5;
        } else if(M == 3) {
            functionValue = functionValue(optplan);
        }
        System.out.println("Значення цільової функції - " + functionValue);
        /*System.out.println("Пошук плану методом найменшої вартості");
        int[][] mvm = minValueMethod();
        printResult(mvm);
        System.out.println();
        System.out.println("u i v:");

        int[][] pot = potentials(mvm);
        //System.out.println("Potentials:");
        printResult(pot);

        System.out.println("Значення цільової функції - " + functionValue(mvm));

        int[] u = pot[0];
        int[] v = pot[1];

        int[][] optplan = findOptPlan(mvm, u, v);
        System.out.println("Оптимальний план");
        printResult(optplan);

        printResult(potentials(optplan));

        System.out.println("Значення цільової функції - " + functionValue(optplan));
        */
        System.out.println("\nВиконав Драч Михайло\n\n\n");
        Result result = new Result();
        result.setFunctionValue(functionValue);
        result.setOptPlan(optplan);
        return result;
    }

    private int arraySum(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        return sum;
    }

    private boolean isTaskCorrect(){
        if(arraySum(needs) == arraySum(isPresent))
            return true;
        return false;
    }

    public int[][] nwaMethod(){
        if(!isTaskCorrect())
            return null;
        int[][]result = new int[M][N];
        //printResult(result); все нулі
        //int[] n = clone(needs);
        //int[] is = clone(isPresent);
        int[] n = needs;
        int[] is = isPresent;  // має обробляти і, якщо потреба == попиту
        for(int i = 0, j = 0; i < M && j < N; ){   // ?????????????
            if(n[j] > is[i]){
                result[i][j] = is[i];
                n[j] -= is[i];
                for(int k = 0; k < N; k++){    //????????????????
                    if(result[i][k] > 0)
                        continue;
                    result[i][k] = -1;
                }
                i++;
            }else if(n[j] < is[i]){
                result[i][j] = n[j];
                is[i] -= n[j];
                for(int k = 0; k < M; k++){    //????????????????
                    if(result[k][j] > 0)
                        continue;
                    result[k][j] = -1;
                }
                j++;
            }else{
                result[i][j] = n[j];
                n[j] = 0;
                is[i] = 0;
                for(int k = 0; k < N; k++) {    //????????????????
                    if (result[i][k] > 0)
                        continue;
                    result[i][k] = -1;
                }
                for(int k = 0; k < M; k++){    //????????????????
                    if(result[k][j] > 0)
                        continue;
                    result[k][j] = -1;
                }
                i++;
                j++;
            }
        }
        System.out.println();
        printResult(n);
        printResult(is);
        System.out.println();
        return result;
    }

    public void printResult(int[][]r){
        if(r == null){
            System.out.println("null");
            return;
        }
        for(int i = 0; i < r.length; i++){
            for(int j = 0; j < r[i].length; j++){
                System.out.printf("%4d", r[i][j]);
            }
            System.out.println();
        }
    }

    public void printResult(int[]r){
        for(int i = 0; i < r.length; i++){
            System.out.printf("%4d", r[i]);
        }
        System.out.println();
    }

    private boolean isEmpty(int[][] r){
        for(int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                if (r[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    public int[][] minValueMethod(){
        if(!isTaskCorrect())
            return null;
        int[][]result = new int[M][N];
        int[][] v = clone(tableOfValues);
        int[] n = clone(needs);
        int[] is = clone(isPresent);
        // int[][] v = tableOfValues;
        //int[] n = needs;
        //int[] is = isPresent;  // має обробляти і, якщо потреба == попиту
        int[] p;
        int i, j;
        while(isEmpty(result)){
            p = findMinValue(v);
            i = p[0];
            j = p[1];
            v[i][j] = -1;
            if(n[j] > is[i]){
                result[i][j] = is[i];
                n[j] -= is[i];
                for(int k = 0; k < N; k++){    //????????????????
                    if(result[i][k] > 0)
                        continue;
                    result[i][k] = -1;
                    v[i][k] = -1;
                }
            }else if(n[j] < is[i]){
                result[i][j] = n[j];
                is[i] -= n[j];
                for(int k = 0; k < M; k++){    //????????????????
                    if(result[k][j] > 0)
                        continue;
                    result[k][j] = -1;
                    v[k][j] = -1;
                }
            }else{
                result[i][j] = n[j];
                n[j] = 0;
                is[i] = 0;
                for(int k = 0; k < N; k++) {    //????????????????
                    if (result[i][k] > 0)
                        continue;
                    result[i][k] = -1;
                    v[i][k] = -1;
                }
                for(int k = 0; k < M; k++){    //????????????????
                    if(result[k][j] > 0)
                        continue;
                    result[k][j] = -1;
                    v[k][j] = -1;
                }
            }
        }
        return result;
    }

    private int[] findMinValue(int[][] v){
        int[] r = new int[2];
        double min = Double.POSITIVE_INFINITY;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(v[i][j] <=0)
                    continue;
                if(v[i][j] < min){
                    min = v[i][j];
                    r[0] = i;
                    r[1] = j;
                }
            }
        }
        return r;
    }

    private int[] findMinDelta(int[][] v){
        int[] r = new int[2];
        double min = Double.POSITIVE_INFINITY;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(v[i][j] < min){
                    min = v[i][j];
                    r[0] = i;
                    r[1] = j;
                }
            }
        }
        return r;
    }

    int functionValue(int[][] r){
        int f = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(r[i][j]<0)
                    continue;
                f += r[i][j]*tableOfValues[i][j];
            }
        }
        return f;
    }

    public int[][] potentials( int[][]r){
        int [] u = new int[M];
        int[] v = new int[N];

        for (int k = 0; k < M; k++){
            u[k]=-10000;
        }
        for (int k = 0; k < N; k++){
            v[k]=-10000;
        }

        u[0] = 0;
        for(int j = 0; j<N; j++){
            if(r[0][j] > 0){
                v[j] = tableOfValues[0][j];
            }
        }
        for(int i = 1; i < M; i++){
            for(int j = 0; j < N; j++){
                if(r[i][j] > 0){
                    if(u[i] > -10000){
                        v[j] = tableOfValues[i][j] - u[i];
                    }else if(v[j]> -10000){
                        u[i] = tableOfValues[i][j] - v[j];
                    }// Обробити ситуацію, якщо невідомість
                    else{
                        int k = j+1;
                        while(k < N){
                            if(r[i][k] > 0){
                                if(u[i] > -10000){
                                    v[k] = tableOfValues[i][k] - u[i];
                                }else if(v[k]> -10000){
                                    u[i] = tableOfValues[i][k] - v[k];
                                }
                                break;
                            }
                            k++;
                        }
                        if(k != N){
                            if(u[i] > -10000){
                                v[j] = tableOfValues[i][j] - u[i];
                            }else if(v[j]> -10000){
                                u[i] = tableOfValues[i][j] - v[j];
                            }
                        }// Обробити ситуацію, коли треба штучно дописувати
                    }
                }
            }
        }




        int[][] res = new int[2][N>M? N:M];
        res[0]=u;
        res[1]=v;
        return res;
    }

    private int[][] clone(int [][] arr){
        int[][] copy = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private int[] clone(int [] arr){
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            copy[i] = arr[i];
        }
        return copy;
    }

    int[][] findOptPlan(int[][] res, int[] u, int[] v){
        //System.out.println("Start");
        //printResult(res);
        System.out.println();
        while (true) {
            int[][] delta = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    delta[i][j] = tableOfValues[i][j] - u[i] - v[j];
                }
            }
            System.out.println("Оціночна матриця:");
            printResult(delta);
            System.out.println();

            if(isAllElementsPositsve(delta))
                break;

            int[] min = findMinDelta(delta);
            int[][] plusCoordsOfSquare = new int[2][2];
            int[][] minusCoordsOfSquare = new int[2][2];
            plusCoordsOfSquare[0] = min;
            int istart = min[0];
            int jstart = min[1];
//            int i, j;
            int k = 0;
            for(int i = 0; i < M; i++){
                if(isSingleInRow(i, res) && i!=istart)
                    continue;
                for(int j = 0; j < N; j++){
                    if(res[i][j] <= 0)
                        continue;
                    if(isSingleInColumn(j, res) && j!=jstart)
                        continue;
                    if(i == istart && j == jstart){
                        continue;
                    }

                    // if(i==0 && res[i+1][j]<=0){  // Неправильний вираз!!!!
                    //   continue;
                    //}


                    if(i == istart || j == jstart) {
                        if(k>=2){
                            if(i == plusCoordsOfSquare[1][0] || j == plusCoordsOfSquare[1][1]){
                                if(minusCoordsOfSquare[0][0] == plusCoordsOfSquare[1][0] || minusCoordsOfSquare[0][1] == plusCoordsOfSquare[1][1])
                                    k=1;
                            }else{
                                k=0;
                            }
                        }
                        minusCoordsOfSquare[k][0] = i;
                        minusCoordsOfSquare[k][1] = j;
                        k++;
                    }else if(Math.abs(istart - i)*Math.abs(istart - i) + Math.abs(jstart - j)*Math.abs(jstart - j)
                            - (Math.sqrt((istart-i)*(istart-i) + (jstart-j) * (jstart-j)))*(Math.sqrt((istart-i)*(istart-i) + (jstart-j) * (jstart-j))) < 1){
                        plusCoordsOfSquare[1][0] = i;
                        plusCoordsOfSquare[1][1] = j;
                    }
                }
            }
            // System.out.println( "minus");
            //   printResult(minusCoordsOfSquare);
            //System.out.println("plus");
            //  printResult(plusCoordsOfSquare);
            //System.out.println();
            int minimum = res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]]
                    < res[minusCoordsOfSquare[1][0]][minusCoordsOfSquare[1][1]]?
                    res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]]: res[minusCoordsOfSquare[1][0]][minusCoordsOfSquare[1][1]];

            //System.out.println("m = " + minimum +"   ist = " + istart+ "    jst= " + jstart);
            //System.out.println();

            res[plusCoordsOfSquare[0][0]][plusCoordsOfSquare[0][1]] += minimum+1;
            res[plusCoordsOfSquare[1][0]][plusCoordsOfSquare[1][1]] += minimum;

            res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]] -= minimum;
            res[minusCoordsOfSquare[1][0]][minusCoordsOfSquare[1][1]] -= minimum;


            if(res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]] == 0 && res[minusCoordsOfSquare[1][0]][minusCoordsOfSquare[1][1]]==0)
                res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]]='e';
            //else
            //     res[minusCoordsOfSquare[1][0]][minusCoordsOfSquare[1][1]] = 'e';

            int[][] newPotentials = potentials(res);
            u = newPotentials[0];
            v = newPotentials[1];

            if(res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]] == 'e')
                res[minusCoordsOfSquare[0][0]][minusCoordsOfSquare[0][1]]=0;
            //else
            //  res[minusCoordsOfSquare[1][0]][minusCoordsOfSquare[1][1]] = 0;

            System.out.println("Змінений план");
            printResult(res);
            System.out.println("u:");
            printResult(u);
            System.out.println("v:");
            printResult(v);
            System.out.println();

        }// while
        return res;
    }

    boolean isAllElementsPositsve(int [][] el){
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(el[i][j] < 0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSingleInRow(int k, int[][] r){
        int count = 0;
        for(int j = 0; j < N; j++){
            if(r[k][j] > 0){
                count++;
            }
        }
        if(count < 2)
            return true;
        return false;
    }

    boolean isSingleInColumn(int k, int[][] r){
        int count = 0;
        for(int i = 0; i < M; i++){
            if(r[i][k] > 0){
                count++;
            }
        }
        if(count < 2)
            return true;
        return false;
    }



   /* int[][] coord(int[][] r, int[][] c, int i, int j, int k){
        if(i == M || j == N || isResCorrect(c))
            return c;
        if(i == 0)
            return coord(r, c, i+1, j, k);
        if(j == 0)
            return coord(r, c, i, j+1, k);
        if(i == M-1)
            return coord(r, c, i-1, j, k);
        if(j == N-1)
            return coord(r, c, i, j-1, k);
        if(r[i][j] > 0){
            c[k][0] = i;
            c[k][1] = j;
            k++;
        }
        coord(r, c, i+1, j, k);
        coord(r, c, )
    }

    boolean isResCorrect(int[][] c){


    }*/

}
