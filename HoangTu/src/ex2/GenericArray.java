package ex2;

/**
 * This class is an advanced (using generics) part of exercise number 2.
 *
 * @author Grizmo - Hoang Tuan Tu
 * @version 1.0
 * */

public class GenericArray<T> {
    private T[] array;
    private boolean canExtend = true;
    private int size = 0;

    public GenericArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
        canExtend = false;

    }

    public GenericArray(){
        this.array = (T[]) new Object[10];
    }

    public void set(int index, T value){
        array[index] = value;
    }

    public T get(int index){
        return array[index];
    }

    public void add(int index, T value){
        if(canExtend){
            if (size == array.length - 2){
                expand();
            }

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size ++;
        }else {
            System.out.println("Can not add!");
        }
    }

    public void add(T value){
        add(size, value);
    }

    public void remove(int index){
        if (canExtend){
            for (int i = index; i < size; i++){
                array[i] = array[i+1];
            }
        }else {
            System.out.println("Can not remove!");
        }
    }

    private void expand(){
        T[] temp = (T[])new Object[size * 2];
        if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++){
            result.append(array[i]);
            if (i != size - 1){
                result.append(", ");
            }else {
                result.append("]");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        GenericArray<Double> array = new GenericArray<Double>();
        for (double i = 1; i < 5; i+=0.5){
            array.add(i);
        }

        System.out.println("Array is: " + array);
    }
}
