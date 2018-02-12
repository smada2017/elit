import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * The Class SquareSet.
 * @version 2.0
 * @author Sai Mada (me)
 */
public class SquareSet implements Set<Square> {

    /** The square arr. */
    private Square[] squareArr;

    /**
     * Instantiates a new square set.
     */
    public SquareSet() {
        squareArr = new Square[0];
    }

    /**
     * Instantiates a new square set.
     *
     * @param c the c
     */
    public SquareSet(Collection<? extends Square> c) {
        squareArr = new Square[0];
        addAll(c);
    }

    /* (non-Javadoc)
     * @see java.util.Set#add(java.lang.Object)
     * @param inx
     */
     @Override
    public boolean add(Square inx) {
        String files = "abcdefgh";
        String ranks = "12345678";
        char file = inx.getFile();
        char rank = inx.getRank();
        if (!((files.indexOf(file) >= 0) && (ranks.indexOf(rank) >= 0))) {
            String name = "" + file + rank;
            throw new InvalidSquareException(name);
        }
        if (size() == 0) {
            Square[] arr = {inx};
            squareArr = arr;
            return true;
        } else if (contains(inx)) {
            return false;
        } else {
            Square[] temp = new Square[size() + 1];
            for (int i = 0; i < size(); i++) {
                temp[i] = squareArr[i];
            }
            temp[size()] = inx;
            squareArr = temp;
            return true;
        }
    }

    /* (non-Javadoc)
     * @see java.util.Set#addAll(java.util.Collection)
     */
     @Override
    public boolean addAll(Collection<? extends Square> collection) {
        Object[] additions = collection.toArray(new Object[0]);
        int addSize = additions.length;
        boolean whatToReturn = false;
        boolean finalReturn = false;
        for (int i = 0; i < addSize; i++) {
            whatToReturn = add((Square) additions[i]);
            if (whatToReturn) {
                finalReturn = true;
            }
        }
        return finalReturn;
    }

    /* (non-Javadoc)
     * @see java.util.Set#clear()
     */
     @Override
    public void clear() {
        Square[] arr = {};
        squareArr = arr;
    }

    /* (non-Javadoc)
     * @see java.util.Set#contains(java.lang.Object)
     */
     @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (squareArr[i].equals(o)) {
                return true;
            }
        }
        return false;

    }

    /* (non-Javadoc)
     * @see java.util.Set#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;

    }

    /* (non-Javadoc)
     * @see java.util.Set#iterator()
     */
    @Override
    public Iterator<Square> iterator() {
        return new NewIterator();
    }

    /**
     * The Class NewIterator.
     */
    public class NewIterator implements Iterator<Square> {

      /** The mover. */
        private int mover = 0;

      /**
       * Checks if the element has a next element.
       *
       * @return true, if successful
       */
        @Override
        public boolean hasNext() {
            return mover < size() && squareArr[mover] != null;
        }

      /**
       * Pulls the next elements.
       *
       * @return the square
       */
        @Override
        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return squareArr[mover++];
        }

    }

    /* (non-Javadoc)
     * @see java.util.Set#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object arg0) {
        if (!contains(arg0)) {
            return false;
        }
        Square[] temp = new Square[size() - 1];
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (!squareArr[i].equals(arg0)) {
                temp[count] = squareArr[i];
                count++;
            }
        }
        squareArr = temp;
        return true;
    }

    /* (non-Javadoc)
     * @see java.util.Set#removeAll(java.util.Collection)
     */
    @Override
    public boolean removeAll(Collection<?> arg0) {
        return false;
    }

    /* (non-Javadoc)
     * @see java.util.Set#retainAll(java.util.Collection)
     */
    @Override
    public boolean retainAll(Collection<?> arg0) {
        return false;
    }

    /* (non-Javadoc)
     * @see java.util.Set#size()
     */
    @Override
    public int size() {
        return squareArr.length;
    }

    /* (non-Javadoc)
     * @see java.util.Set#toArray()
     */
    @Override
    public Object[] toArray() {
        return squareArr;
    }

    /* (non-Javadoc)
     * @see java.util.Set#toArray(java.lang.Object[])
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            a = (T[]) new Object[squareArr.length];
        }
        int count = 0;
        for (Square x: squareArr) {
            a[count] = (T) x;
            count++;
        }
        return a;
    }

    /* (non-Javadoc)
     * @see java.util.Set#containsAll(java.util.Collection)
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        Object[] additions = collection.toArray(new Object[0]);
        int addSize = additions.length;
        boolean whatToReturn = true;
        for (int i = 0; i < addSize; i++) {
            whatToReturn = contains((Square) additions[i]);
            if (!whatToReturn) {
                return false;
            }
        }
        return whatToReturn;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int sum = 0;
        for (Square x: squareArr) {
            sum = sum + x.hashCode();
        }
        return sum;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object item) {
        if (item == null) {
            return false;
        } else if (item == this) {
            return true;
        } else if (!(item instanceof Set)) {
            return false;
        } else {
            Set check = (Set) item;
            if (check.size() == size()) {
                return containsAll(check);
            }
            return false;
        }
    }


}
