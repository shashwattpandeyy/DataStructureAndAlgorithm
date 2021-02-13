package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparatorr {
    private String Name;
    private int rollNO;
    private int Marks;

    public Comparatorr(String n, int r, int m) {
        this.Name = n;
        this.rollNO = r;
        this.Marks = m;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }

    public int getMarks() {
        return Marks;
    }

    public void setRollNO(int rollNO) {
        this.rollNO = rollNO;
    }

    public int getRollNO() {
        return rollNO;
    }

    @Override
    public String toString() {
        return "Comparator.Comparatorr{" + "Name='" + Name + '\'' + ", rollNO=" + rollNO + ", Marks=" + Marks + '}';
    }



    public static void main(String[] args) {
        ArrayList<Comparatorr> c = new ArrayList<Comparatorr> ();
        c.add ( new Comparatorr ( "Shashwat", 12, 45 ) );
        c.add ( new Comparatorr ( "aman", 45, 5 ) );
        c.add ( new Comparatorr ( "abhijeet", 2, 25 ) );
        c.add ( new Comparatorr ( "kushagra", 20, 15 ) );

        SortByComparator s = new SortByComparator ();
        c.forEach ( System.out::println );
        Collections.sort ( c, s);


        System.out.println ("After sorting: ");
        c.forEach ( System.out::println );
    }

    public static class SortByComparator implements Comparator<Comparatorr>{


        @Override
        public int compare(Comparatorr o1, Comparatorr o2) {
            if (o1.Marks < o2.Marks) return -1;
            if (o1.Marks > o2.Marks) return 1;
            return 0;
        }
        }
    }

