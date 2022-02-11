package stepic.t4s2;

import java.util.Comparator;
import java.util.Objects;

class LongRange {
    private final long left;
    private final long right;

    public static Comparator<LongRange> getComparator() {
        Comparator<LongRange>  lengthComparator = (r1, r2) -> (int)(r1.getRight() - r1.getLeft() - r2.getRight() + r1.getLeft());
        return lengthComparator.thenComparing(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}
