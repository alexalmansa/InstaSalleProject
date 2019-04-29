package Structures;

import Model.Post;
import Model.User;
import javafx.geometry.Pos;

import javax.xml.bind.Element;

public class ArrayListt<E> {
    public Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayListt() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayListt(Object[] array) {
        this.array = array;
        this.size = array.length;

    }

    public int getSize() {
        return size;
    }

    public void addElement(E e) {
        if (size == array.length) {

            Object[] arraynou = new Object[size + 1];
            int i = 0;
            for (Object a : array) {
                arraynou[i] = a;
                i++;
            }
            arraynou[size] = e;

            array = arraynou;
        }
        //System.out.println(e.toString());
        array[size] = e;
        //System.out.println(array[size].toString());

        size++;
    }

    public void removeElement(int p) {


        Object[] arraynou = new Object[size - 1];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i != p) {
                arraynou[j] = array[i];
                j++;
            }
        }

        array = arraynou;

        size--;
    }

    public Object getElement(int i) {
        return array[i];
    }

    public Object searchElement(Object o) {
        int p = -1;
        for (int i = 0; i < size; i++) {
            if (o == array[i]) {
                p = i;
            }
        }
        if (p != -1) {
            return array[p];
        } else {
            return null;
        }
    }

    public Object searchUser(String s) {
        int p = -1;
        User a;
        for (int i = 0; i < size; i++) {
            a = (User) array[i];
            if (a.compareTo(s) == 1) {
                p = i;
            }
        }
        if (p != -1) {
            return array[p];
        } else {
            return null;
        }

    }

    public Object searchPost(int s) {
        int p = -1;
        for (int i = 0; i < size; i++) {
            Post post = (Post) array[i];

            if (post.compareTo(s) == 1) {
                p = i;
            }
        }
        if (p != -1) {
            return array[p];
        } else {
            return null;
        }

    }

    public Post[] getArray() {
        Post[] p = new Post[size];
        for (int i = 0 ; i< size; i++) {
            Post m = (Post) array[i];
            p[i] = m;
        }
        return p;

    }

    public Post[] searchPostPosition(int radi, int x, int y) {
        int p = -1;
        ArrayListt<Post> post = new ArrayListt();

        for (int i = 0; i < size; i++) {


            if (pointInside(radi, x, y, (Post) array[i]) == 0) {
                System.out.println("ENTRA");
                post.addElement((Post) array[i]);
                p = 0;
            }
        }
        if (p != -1) {
            return post.getArray();
        } else {
            return null;
        }

    }

    private int pointInside(int radi, int x, int y, Post post) {

        double distance = Math.sqrt(Math.abs((y - post.getLocation()[1]) * (y - post.getLocation()[1]) + (x - post.getLocation()[0]) * (x - post.getLocation()[0])));
        System.out.println("DISTANCE "+distance);
        return distance > radi ? 1 : 0;
    }


    public static void main(String[] args) {
        Post a = new Post();
        a.setId(1);
        Double[] f = {1.0,2.0};
        a.setLocation(f);

        Post b = new Post();
        b.setId(2);
        Double[] l = {10.0,10.0};
        b.setLocation(l);

        ArrayListt<Post> p = new ArrayListt<Post>();
        p.addElement(a);
        p.addElement(b);

        System.out.println("ID Pos 0 "+p.getElement(0)+ " 1 "+p.getElement(1));

        Post[] m =  new Post[3];
         m = p.searchPostPosition(13,1,1);

        System.out.println(m.length);


    }
}
