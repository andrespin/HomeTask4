package Task4;

public class Methods4Task4 {

    protected static boolean VertCheck(char symb, char [][] map, int size)
    {
        int i = 0;
        return VCheck(symb, i, map, size);
    }

    private static boolean VCheck(char symb, int i, char [][] map, int size)
    {
        VCheckAI(map, i); // Элемент ИИ
        int symbol = 0;
        for (int j = 0; j < size; j++)
        {
            if (map[i][j] == symb)
            {
                symbol++;
            }
            else symbol = 0;
            if (symbol >= 3 ) return true;  // количество фишек
            if (j == size - 1 && j < 4)
            {
                i++;
                VCheck(symb, i, map,size);
            }
        }
        return false;
    }


    private static void VCheckAI(char [][] map, int i) {
        for (int j = 0; j < 5; j++)
        {
            if ((j - 1) > -1 && (j + 1) < 5) {
                if ((map[i][j - 1] == 'X') && (map[i][j] == '•') && map[i][j + 1] == 'X') {
                    map[i][j] = 'X';
                }

                if ((map[i][j - 1] == '•') && (map[i][j] == 'X') && map[i][j + 1] == 'X') {
                    map[i][j - 1] = 'X';
                }

                if ((map[i][j - 1] == 'X') && (map[i][j] == 'X') && map[i][j + 1] == '•') {
                    map[i][j + 1] = 'X';
                }
            }
        }
    }





    protected static boolean HorizCheck(char symb, char [][] map, int size)
    {
        int j = 0;
        return HCheck(symb,j,map,size);
    }

    private static boolean HCheck(char symb, int j, char [][] map, int size)
    {

        HCheckAI(map, j); // Элемент ИИ с If-ми
        int symbol = 0;
        for (int i = 0; i < size; i++)
        {
            if (map[i][j] == symb)
            {
                symbol++;
            }
            else symbol = 0;
            if (symbol >= 3 ) return true; // количество фишек
            if (i == size - 1 && j < 4)
            {
                j++;
                HCheck(symb, j, map,size);
            }
        }
        return false;
    }


    private static void HCheckAI(char [][] map, int j ) {

        for (int i = 0; i < 5; i++)
        {

        if ((i - 1) > -1 && (i + 1) < 5) {
            if ((map[i - 1][j] == 'X') && (map[i][j] == '•') && map[i + 1][j] == 'X') {
                map[i][j] = 'X';
            }

            if ((map[i - 1][j] == '•') && (map[i][j] == 'X') && map[i + 1][j] == 'X') {
                map[i - 1][j] = 'X';
            }

            if ((map[i - 1][j] == 'X') && (map[i][j] == 'X') && map[i + 1][j] == '•') {
                map[i + 1][j] = 'X';
            }
        }


        }
    }


    // начала координат для диагоналей слева-направо ↓
    private static int [] Li = {0,0,0,1,2}; // i-е координаты
    private static int [] Lj = {2,1,0,0,0}; // j-е координаты
    private static int [] Lq = {3,4,5,4,3}; // количество точек, через которые 5 диагоналей проходят, чтобы пересеч,
    // как минимум, 3 точки.

    protected static boolean LeftToRightDiagCheck(char symb, char [][] map, int size) {
        return LDiagCheck(symb, map);
    }

    private static boolean LDiagCheck(char symb, char [][] map)
    {
        LDiagCheckAI(map); // Элемент ИИ
        for (int time = 0; time < 5; time++)
        {
            boolean On = true;
            int I = Li[time], J = Lj[time];
            int t = 0, symbol = 0;
            while (On) {
                if (t >= Lq[time] - 1 ) On = false;

                //  System.out.println(I +" "+ J + "time" + time +" "+ t);
                if (map[I][J] == symb) {
                    symbol++;
                    if (symbol == 3) return true;
                }
                I++;
                J++;
                t++;
            }
        }
        return false;
    }

    private static void LDiagCheckAI(char [][] map)
    {
        for (int time = 0; time < 5; time++)
        {
            boolean On = true;
            int I = Li[time], J = Lj[time];
            int t = 0, symbol = 0;
            while (On) {
                if (t >= Lq[time] - 1 ) On = false;

              //  System.out.println(" I - 1 = " + (I - 1) + " J - 1 = " + (J - 1));
                if ( (I - 1) > -1 && (I + 1) < 5 &&  (J - 1) > -1 &&  (J + 1) < 5 ) {
                    if ((map[I - 1][J - 1] == 'X') && (map[I][J] == '•') && map[I + 1][J + 1] == 'X') {
                        map[I][J] = 'X';
                    }

                    if ((map[I - 1][J - 1] == '•') && (map[I][J] == 'X') && map[I + 1][J + 1] == 'X') {
                        map[I - 1][J - 1] = 'X';
                    }

                    if ((map[I - 1][J - 1] == 'X') && (map[I][J] == 'X') && map[I + 1][J + 1] == '•') {
                        map[I + 1][J + 1] = 'X';
                    }
                }
                I++;
                J++;
                t++;
            }
        }

    }

    // начала координат для диагоналей слево-направо ↑
    private static int [] Ri = {0,0,0,1,2}; // i-е координаты
    private static int [] Rj = {2,3,4,4,4}; // j-е координаты
    private static int [] Rq = {3,4,5,4,3}; // количество точек, через которые 5 диагоналей проходят, чтобы пересеч,
    // как минимум, 3 точки.

    protected static boolean RightToLeftDiagCheck(char symb, char [][] map, int size)
    {
        return RDiagCheck(symb, map);
    }

    private static boolean RDiagCheck(char symb, char [][] map)
    {
        for (int time = 0; time < 5; time++)
        {
            RDiagCheckAI(map); // Элемент ИИ
            boolean On = true;
            int I = Ri[time], J = Rj[time];
            int t = 0, symbol = 0;
            while (On) {
                if (t >= Rq[time] - 1) On = false;

                if (map[I][J] == symb) {
                    symbol++;
                    if (symbol == 3) return true;
                }
                I++;
                J--;
                t++;
            }
        }
        return false;
    }

    private static void RDiagCheckAI(char [][] map)
    {
        for (int time = 0; time < 5; time++)
        {
            boolean On = true;
            int I = Ri[time], J = Rj[time];
            int t = 0, symbol = 0;
            while (On) {
                if (t >= Rq[time] - 1) On = false;
                if ( (I - 1) > -1 && (I + 1) < 5 &&  (J - 1) > -1 &&  (J + 1) < 5 )
                {
                    if (map[I - 1][J + 1] == 'X' && map[I][J] == '•' && map[I + 1][J - 1] == 'X')
                    {
                        map[I][J] = 'X';
                    }

                    if (map[I - 1][J + 1] == '•' && map[I][J] == 'X' && map[I + 1][J - 1] == 'X')
                    {
                    map[I - 1][J + 1] = 'X';
                    }

                    if (map[I - 1][J + 1] == 'X' && map[I][J] == 'X' && map[I + 1][J - 1] == '•')
                    {
                        map[I + 1][J - 1] = 'X';
                    }
                }
                I++;
                J--;
                t++;
            }
        }
    }
}