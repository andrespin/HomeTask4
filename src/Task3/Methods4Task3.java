package Task3;

public class Methods4Task3 {

    protected static boolean VertCheck(char symb, char [][] map, int size)
    {
        int i = 0;
        return VCheck(symb, i, map, size);
    }

    private static boolean VCheck(char symb, int i, char [][] map, int size)
    {
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

    protected static boolean HorizCheck(char symb, char [][] map, int size)
    {
        int j = 0;
        return HCheck(symb,j,map,size);
    }

    private static boolean HCheck(char symb, int j, char [][] map, int size)
    {
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

}

/*
Проверка:

0 1 2 3 4 5
1 • • • • •
2 • • • • •
3 • • • • •
4 • • • • •
5 • • • • •

Введите координаты в формате X Y
1 1
0 1 2 3 4 5
1 X • • • •
2 • • • • •
3 • • • • •
4 • • • • •
5 • • • • •

Компьютер походил в точку 5 5
0 1 2 3 4 5
1 X • • • •
2 • • • • •
3 • • • • •
4 • • • • •
5 • • • • O

Введите координаты в формате X Y
1 2
0 1 2 3 4 5
1 X • • • •
2 X • • • •
3 • • • • •
4 • • • • •
5 • • • • O

Компьютер походил в точку 1 4
0 1 2 3 4 5
1 X • • • •
2 X • • • •
3 • • • • •
4 O • • • •
5 • • • • O

Введите координаты в формате X Y
1 3
0 1 2 3 4 5
1 X • • • •
2 X • • • •
3 X • • • •
4 O • • • •
5 • • • • O

Вы победили
Конец игры

 */