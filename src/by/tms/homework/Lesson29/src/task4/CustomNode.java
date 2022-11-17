package task4;

import task2.utils.IdentityUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class CustomNode<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6826098762758216779L;
    private long id;
    private T value;
    private CustomNode<T> prev;
    private CustomNode<T> next;

    public CustomNode(T value,CustomNode<T> prev, CustomNode<T> next) {
        this.id = IdentityUtil.generateUserId();
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomNode<T> getPrev() {
        return prev;
    }

    public void setPrev(CustomNode<T> prev) {
        this.prev = prev;
    }

    public CustomNode<T> getNext() {
        return next;
    }

    public void setNext(CustomNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomNode)) return false;
        CustomNode<?> that = (CustomNode<?>) o;
        return id == that.id && Objects.equals(value, that.value) && Objects.equals(prev, that.prev) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, prev, next);
    }

    @Override
    public String toString() {
        return "CustomNode{" +
                "id=" + id +
                ", value=" + value +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
