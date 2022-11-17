package task4;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class CustomLinkedList<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 321998718136587839L;
    private int size = 0;
    private CustomNode<T> firstElement;
    private CustomNode<T> lastElement;

    public CustomLinkedList() {
        this.firstElement = null;
        this.lastElement = null;
    }

    public void add(T value) {
        if (lastElement == null) {
            CustomNode<T> newNode = new CustomNode<>(value, null , null);
            firstElement = newNode;
            lastElement = newNode;
        } else {
            CustomNode<T> newNode = new CustomNode<>(value, lastElement , null);
            lastElement.setNext(newNode);
            lastElement = newNode;
        }
        size++;
    }

    public void add(int index, T value) {
            CustomNode<T> foundNode = findNode(index);
            if (foundNode != null) {
                CustomNode<T> previousElement = foundNode.getPrev();
                CustomNode<T> elementForAdding = new CustomNode<>(value, previousElement, foundNode);
                previousElement.setNext(elementForAdding);
                foundNode.setPrev(elementForAdding);
                size++;
            }
    }

    public T get(int index) {
        CustomNode<T> foundElement = null;
        foundElement = findNode(index);
        return (foundElement != null)? foundElement.getValue() : null;
    }

    public void remove(int index) {
        CustomNode<T> foundElement = findNode(index);
        if (foundElement != null) {
            CustomNode<T> prevElement = foundElement.getPrev();
            CustomNode<T> nextElement = foundElement.getNext();
            prevElement.setNext(nextElement);
            nextElement.setPrev(prevElement);
            size--;
        }
    }

    public int getSize() {
        return size;
    }


    private CustomNode<T> findNode(int index) {
        CustomNode<T> foundNode = null;
        if (index >= 0 && index < size) {
            CustomNode<T> iteratingElement = firstElement;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    foundNode = iteratingElement;
                    break;
                }
                iteratingElement = iteratingElement.getNext();
            }
        }
        return foundNode;
    }

    private CustomNode<T> findNode(T element) {
        CustomNode<T> foundNode = null;
        CustomNode<T> iteratingElement = firstElement;

        do {
            if (iteratingElement.equals(element)) {
                foundNode = iteratingElement;
                break;
            }

            iteratingElement = iteratingElement.getNext();
        } while (iteratingElement.getNext() != null);

        return foundNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomLinkedList)) return false;
        CustomLinkedList<?> that = (CustomLinkedList<?>) o;
        return size == that.size && Objects.equals(firstElement, that.firstElement) && Objects.equals(lastElement, that.lastElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, firstElement, lastElement);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CustomNode<T> iteratingElement = firstElement;

        for (int i = 0; i < size; i++) {
            System.out.println("element: " + iteratingElement.getValue());
            stringBuilder.append(iteratingElement.getValue());
            iteratingElement = iteratingElement.getNext();
        }

        return stringBuilder.toString();
    }
}
