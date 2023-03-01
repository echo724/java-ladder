package techcourse.jcf.mission;

public class ArrayList implements SimpleList {
    
    private String[] array;
    
    public ArrayList() {
        this.array = new String[0];
    }
    
    @Override
    public boolean add(String value) {
        String[] newArray = new String[this.array.length + 1];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        newArray[this.array.length] = value;
        this.array = newArray;
        return true;
    }
    
    @Override
    public void add(int index, String value) {
        if (index < 0 || index > this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        String[] newArray = new String[this.array.length + 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        newArray[index] = value;
        if (newArray.length - (index + 1) >= 0) {
            System.arraycopy(this.array, index + 1 - 1, newArray, index + 1, newArray.length - (index + 1));
        }
        this.array = newArray;
    }
    
    @Override
    public String set(int index, String value) {
        if (index < 0 || index > this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        String oldValue = this.array[index];
        this.array[index] = value;
        return oldValue;
    }
    
    @Override
    public String get(int index) {
        if (index < 0 || index > this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }
    
    @Override
    public boolean contains(String value) {
        for (String s : this.array) {
            if (s.equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int indexOf(String value) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public int size() {
        return this.array.length;
    }
    
    @Override
    public boolean isEmpty() {
        return this.array.length == 0;
    }
    
    @Override
    public boolean remove(String value) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                String[] newArray = new String[this.array.length - 1];
                System.arraycopy(this.array, 0, newArray, 0, i);
                if (newArray.length - i >= 0) {
                    System.arraycopy(this.array, i + 1, newArray, i, newArray.length - i);
                }
                this.array = newArray;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String remove(int index) {
        if (index < 0 || index > this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        String removedElement = this.array[index];
        String[] newArray = new String[this.array.length - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        if (newArray.length - index >= 0) {
            System.arraycopy(this.array, index + 1, newArray, index, newArray.length - index);
        }
        this.array = newArray;
        return removedElement;
    }
    
    @Override
    public void clear() {
        this.array = new String[0];
    }
}
